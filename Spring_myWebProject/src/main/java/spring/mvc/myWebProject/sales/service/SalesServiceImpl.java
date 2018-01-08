package spring.mvc.myWebProject.sales.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.myWebProject.sales.persistence.SalesDAO;
import spring.mvc.myWebProject.sales.vo.SalesVO;

@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	SalesDAO sDao;

	@Override
	public void salesList(HttpServletRequest req, Model model) {

		ArrayList<SalesVO> sVos = null;

		int pageSize = 8; // 한 페이지당 출력할 글 갯수
		int pageBlock = 4; // 한 블럭당 페이지 갯수

		int cnt = 0; // 글 갯수
		int start = 0; // 현재 페이지 시작번호 1
		int end = 0; // 현재 페이지의 마지막 글번호
		int currentPage = 0; // 현재 페이지
		int number = 0; // 출력할 글 번호
		String pageNum = null; // 페이지 번호

		int pageCount = 0; // 페이지 갯수
		int startPage = 0; // 해당 페이지 블럭의 시작번호. ex) [1] [2] [3] 이 있다면 시작번호는 [1].
		int endPage = 0; // 해당 페이지 블럭의 마지막 번호 ex) [1] [2] [3] 이 있다면 마지막 페이지는 [3]

		// 글 갯수 구하기.
		cnt = sDao.getNumOfSale();

		pageNum = req.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1"; // 첫 페이지를 1로 설정.
		}

		currentPage = Integer.parseInt(pageNum);

		pageCount = (cnt / pageSize) + ((cnt % pageSize == 0) ? 0 : 1);

		start = pageSize * currentPage - 7; // 현재 페이지 내에 글의 시작번호

		end = pageSize * currentPage; // 현재 페이지 끝번호 (<==> pageSize * currentPage)

		if (end > cnt)
			end = cnt; // 글들이 삭제 되었을때 end != cnt.

		number = cnt - (currentPage - 1) * pageSize; // 출력할 글 번호

		if (cnt > 0) {

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("start", start);
			map.put("end", end);

			sVos = sDao.getArticleList(map);

			model.addAttribute("sVos", sVos);
		}

		startPage = (currentPage / pageBlock) * pageBlock + 1;

		if (currentPage % pageBlock == 0)
			startPage -= pageBlock; // [1][2][3] 에서는 계속 [1]만, [4][5][6] 에서는 계속 [4] 만 나옴.

		endPage = startPage + pageBlock - 1;

		if (endPage > pageCount)
			endPage = pageCount; // 이런 경우는 언제 발생하는거지?

		model.addAttribute("cnt", cnt);
		model.addAttribute("number", number);
		model.addAttribute("pageNum", pageNum);

		if (cnt > 0) {
			model.addAttribute("startPage", startPage);

			// 마지막 페이지
			model.addAttribute("endPage", endPage);
			// 출력할 페이지 갯수
			model.addAttribute("pageBlock", pageBlock);
			// 페이지 갯수
			model.addAttribute("pageCount", pageCount);
			// 현재 페이지
			model.addAttribute("currentPage", currentPage);
		}
	}

	@Override
	public void host_approvalPay(HttpServletRequest req, Model model) {

		// 이전 페이지에서 체크박스에 체크 된 주문들의 주문코드의 배열.
		String[] checkedOrder = req.getParameterValues("checkOrder");
		ArrayList<SalesVO> sVo = null;

		// isAdded == isUpdate == isDelete == checkedOrder.length(앞 페이지에서 체크박스에 체크된 갯수)
		// 여야지 모든 작업이 성공한 것.

		// isAdded : SalesVO 에 Insert 문이 성공한 횟수.
		int isAdded = 0;

		// isUpdate : ProductVO 의 product_amount에 Update 문이 성공한 횟수.
		int isUpdate = 0;

		// isDelete : OrderVO 에 해당 order_code의 삭제가 성공한 횟수.
		int isDelete = 0;

		Map<String, Object> co = new HashMap<String, Object>();

		co.put("checkedOrder", checkedOrder);

		sVo = sDao.getOrderInfo(co);

		// 체크박스에 체크된 것이 하나 이상일때 아래 작업을 수행.
		for (int i = 0; i < sVo.size(); i++) {

			// SalesVO 바구니를 생성.
			SalesVO iSvo = new SalesVO();
			String order_code = sVo.get(i).getOrder().getOrder_code();
			// Sale_code를 생성.
			String sales_code = "S" + sVo.get(i).getOrder().getOrder_code();

			// orderDAO에서 현재 order_code에 대한 주문자(id)와 주문내역(product_code)를 가져온다.

			// salesVO 에 들어갈 데이터 셋팅.
			String id = sVo.get(i).getOrder().getId();
			System.out.println(id + "id+=asdf=sdf=sdf=");
			String product_code = sVo.get(i).getOrder().getProduct_code();
			Timestamp sales_date = new Timestamp(System.currentTimeMillis());
			int amount = sVo.get(i).getOrder().getAmountOfPurchase();
			String deliver_status = "배송중";

			// SalesVO 에 데이터를 넣는 작업.
			iSvo.setSales_code(sales_code);
			iSvo.setId(id);
			iSvo.setProduct_code(product_code);
			iSvo.setAmount(amount);
			iSvo.setSales_date(sales_date);
			iSvo.setDeliver_status(deliver_status);

			// productVO 의 product_amount에 update문을 실행할때, 좀 쉽게하기 위한 작업.
			int currAmount = sVo.get(i).getProduct().getProduct_amount();
			int productAmount = currAmount - amount;

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("product_code", product_code);
			map.put("amount", amount);
			map.put("currAmount", currAmount);
			map.put("productAmount", productAmount);

			// isAdded == 0 의 의미는 SalesVO에 Insert 작업이 실행된 적이 없을때.
			if (isAdded == 0) {
				isAdded = sDao.approvalPayPro(iSvo);
				isUpdate = sDao.updateProductAmount(map);
				isDelete = sDao.deleteOrder(order_code);
			} else {
				isAdded += sDao.approvalPayPro(iSvo);
				isUpdate += sDao.updateProductAmount(map);
				isDelete += sDao.deleteOrder(order_code);
			}

			// 위의 작업 내용들을 setAttribute 해준다.
			// 이것들을 통해서 다음 view 페이지에서 결제승인의 성공여부를 출력해준다.
			model.addAttribute("isAdded", isAdded);
			model.addAttribute("isUpdate", isUpdate);
			model.addAttribute("isDelete", isDelete);
			model.addAttribute("numOfOrder", checkedOrder.length);
		}
	}
	/*
	 * @Override public void finalAccountPro(HttpServletRequest req,
	 * HttpServletResponse res) {
	 * 
	 * int finalAccount = 0;
	 * 
	 * SalesDAO sDao = SalesDAOImpl.getInstance(); RefundDAO rDao =
	 * RefundDAOImpl.getInstance();
	 * 
	 * finalAccount = sDao.getFinalAccount() - rDao.calRefundAmount();
	 * 
	 * req.setAttribute("finalAccount", finalAccount);
	 * 
	 * SalesDAO sDao = SalesDAOImpl.getInstance(); RefundDAO rDao =
	 * RefundDAOImpl.getInstance();
	 * 
	 * int finalAccount = sDao.finalAccount(); int RefundAccount =
	 * rDao.calRefundAmount();
	 * 
	 * req.setAttribute("FinalAccount1", finalAccount);
	 * req.setAttribute("RefundAccount", RefundAccount);
	 * 
	 * }
	 */

	@Override
	public void cust_salesList(HttpServletRequest req, Model model) {
		
		ArrayList<SalesVO> sVos = null;

		int pageSize = 8; 		// 한 페이지당 출력할 글 갯수 
		int pageBlock = 4;		// 한 블럭당 페이지 갯수
		
		int cnt = 0;			// 글 갯수
		int start = 0;			// 현재 페이지 시작번호 1
		int end = 0;			// 현재 페이지의 마지막 글번호
		int currentPage = 0;	// 현재 페이지
		int number = 0;			// 출력할 글 번호
		String pageNum = null; 	// 페이지 번호
		
		int pageCount = 0;		// 페이지 갯수
		int startPage = 0;		// 해당 페이지 블럭의 시작번호. ex) [1] [2] [3] 이 있다면 시작번호는 [1].
		int endPage = 0;		// 해당 페이지 블럭의 마지막 번호			ex) [1] [2] [3] 이 있다면 마지막 페이지는 [3]
		
		
		// 글 갯수 구하기.
		Map<String, Object> mm = new HashMap<String, Object>();
		mm.put("curr_id", (String) req.getSession().getAttribute("curr_id"));
		cnt = sDao.cust_getNumOfSale(mm);
		
		pageNum = req.getParameter("pageNum");
		
		if (pageNum == null) {
			pageNum = "1"; // 첫 페이지를 1로 설정.
		}
		
		currentPage = Integer.parseInt(pageNum);
		
		pageCount = (cnt / pageSize) + ((cnt % pageSize == 0) ? 0 : 1);
	
		start = pageSize *  currentPage  - 7; // 현재 페이지 내에 글의 시작번호
		
		end = pageSize * currentPage; // 현재 페이지 끝번호 (<==> pageSize * currentPage)
		
		
		if (end > cnt) end = cnt; // 글들이 삭제 되었을때 end != cnt.
		
		number = cnt - (currentPage-1) * pageSize; // 출력할 글 번호
		
		
		if (cnt > 0) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("curr_id", (String) req.getSession().getAttribute("curr_id"));
			map.put("start", start);
			map.put("end", end);
			
			sVos = sDao.cust_getArticleList(map);
			
		}
		
		startPage = (currentPage / pageBlock) * pageBlock + 1; 
		
		if (currentPage % pageBlock == 0) startPage -= pageBlock; // [1][2][3] 에서는 계속 [1]만, [4][5][6] 에서는 계속 [4] 만 나옴.
		
		endPage = startPage + pageBlock - 1; 
		
		if (endPage > pageCount) endPage = pageCount;  // 이런 경우는 언제 발생하는거지?
		
		model.addAttribute("sVos", sVos);
		model.addAttribute("cnt", cnt);
		model.addAttribute("number", number);
		model.addAttribute("pageNum", pageNum);
		
		if (cnt > 0) {
			model.addAttribute("startPage", startPage);
		
			// 마지막 페이지
			model.addAttribute("endPage", endPage);
			// 출력할 페이지 갯수
			model.addAttribute("pageBlock", pageBlock);
			// 페이지 갯수
			model.addAttribute("pageCount", pageCount);
			// 현재 페이지
			model.addAttribute("currentPage", currentPage);
		}
	}	 
}
