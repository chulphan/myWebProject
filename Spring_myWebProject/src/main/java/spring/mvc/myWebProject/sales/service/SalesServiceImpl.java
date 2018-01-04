package spring.mvc.myWebProject.sales.service;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mpj.refund.persistence.RefundDAO;
import mpj.refund.persistence.RefundDAOImpl;
import spring.mvc.myWebProject.member.vo.MemberVO;
import spring.mvc.myWebProject.order.persistence.OrderDAO;
import spring.mvc.myWebProject.order.persistence.OrderDAOImpl;
import spring.mvc.myWebProject.product.persistence.ProductDAO;
import spring.mvc.myWebProject.product.persistence.ProductDAOImpl;
import spring.mvc.myWebProject.product.vo.ProductVO;
import spring.mvc.myWebProject.sales.persistence.SalesDAO;
import spring.mvc.myWebProject.sales.persistence.SalesDAOImpl;
import spring.mvc.myWebProject.sales.vo.SalesVO;

public class SalesServiceImpl implements SalesService{

	@Override
	public void salesList(HttpServletRequest req, HttpServletResponse res) {
		ArrayList<SalesVO> sVos;
		SalesDAO sDao = SalesDAOImpl.getInstance();

		
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
		cnt = sDao.getNumOfSale();
		
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
			
			OrderDAO oDao = OrderDAOImpl.getInstance();
			
			ArrayList<Object> info = null;
			
			sVos = sDao.getArticleList(start, end);
			
			
			MemberVO mVo = null;
			ProductVO pVo = null;
			
			ArrayList<MemberVO> memberInfo = new ArrayList<MemberVO>();
			ArrayList<ProductVO> productInfo = new ArrayList<ProductVO>();
			
			if (sVos!=null) {
				for (SalesVO s : sVos) {
					info = oDao.getProductMember(s.getProduct_code(), s.getId(), s.getAmount());
					
					mVo = (MemberVO) info.get(0);
					pVo = (ProductVO) info.get(1);
					
					
					memberInfo.add(mVo);
					productInfo.add(pVo);
					
				}
				
				req.setAttribute("memberInfo", memberInfo);
				req.setAttribute("productInfo", productInfo);
				req.setAttribute("sVos", sVos);
			}else {
				req.setAttribute("memberInfo", null);
				req.setAttribute("productInfo", null);
				req.setAttribute("sVos", null);
			}
			
		}
		
		startPage = (currentPage / pageBlock) * pageBlock + 1; 
		
		if (currentPage % pageBlock == 0) startPage -= pageBlock; // [1][2][3] 에서는 계속 [1]만, [4][5][6] 에서는 계속 [4] 만 나옴.
		
		endPage = startPage + pageBlock - 1; 
		
		if (endPage > pageCount) endPage = pageCount;  // 이런 경우는 언제 발생하는거지?
		
		req.setAttribute("cnt", cnt);
		req.setAttribute("number", number);
		req.setAttribute("pageNum", pageNum);
		
		if (cnt > 0) {
			req.setAttribute("startPage", startPage);
		
			// 마지막 페이지
			req.setAttribute("endPage", endPage);
			// 출력할 페이지 갯수
			req.setAttribute("pageBlock", pageBlock);
			// 페이지 갯수
			req.setAttribute("pageCount", pageCount);
			// 현재 페이지
			req.setAttribute("currentPage", currentPage);
		}
	}

	@Override
	public void host_approvalPay(HttpServletRequest req, HttpServletResponse res) {
		
		// 각 테이블의 DAO에 접근하기 위한 작업.
		OrderDAO oDao = OrderDAOImpl.getInstance();
		ProductDAO pDao = ProductDAOImpl.getInstance();
		SalesDAO sDao = SalesDAOImpl.getInstance();
		
		// 이전 페이지에서 체크박스에 체크 된 주문들의 주문코드의 배열.
		String[] checkedOrder = req.getParameterValues("checkOrder");
		
		
		SalesVO sVo = null;
		
		// isAdded == isUpdate == isDelete == checkedOrder.length(앞 페이지에서 체크박스에 체크된 갯수) 여야지 모든 작업이 성공한 것.
		
		// isAdded : SalesVO 에 Insert 문이 성공한 횟수.
		int isAdded = 0;
		
		// isUpdate : ProductVO 의 product_amount에 Update 문이 성공한 횟수.
		int isUpdate = 0;
		
		// isDelete : OrderVO 에 해당 order_code의 삭제가 성공한 횟수.
		int isDelete = 0;
		
		// 체크박스에 체크된 것이 하나 이상일때 아래 작업을 수행.
		if (checkedOrder != null) {
			for (int i = 0; i < checkedOrder.length; i++) {
				
				//SalesVO 바구니를 생성.
				sVo = new SalesVO();
				
				// Sale_code를 생성.
				String sales_code = "S" + checkedOrder[i];
				
				// i번째 order_code를 checkedOrder 배열에서 가져온다.
				String order_code = checkedOrder[i];
				
				// orderDAO에서 현재 order_code에 대한 주문자(id)와 주문내역(product_code)를 가져온다.
				ArrayList<String> idAndPdt = oDao.getIdAndPdtCode(order_code); 
				
				// salesVO 에 들어갈 데이터 셋팅.
				String id = idAndPdt.get(0);
				String product_code = idAndPdt.get(1);
				Timestamp sales_date = new Timestamp(System.currentTimeMillis());
				int amount = oDao.getNeedAmount(order_code);
				String deliver_status = "in shipping";
				
				// SalesVO 에 데이터를 넣는 작업.
				sVo.setSales_code(sales_code);
				sVo.setId(id);
				sVo.setProduct_code(product_code);
				sVo.setAmount(amount);
				sVo.setSales_date(sales_date);
				sVo.setDeliver_status(deliver_status);
				
				System.out.println(sales_code + "sales_code");
				System.out.println(id + "id");
				System.out.println(product_code + "product_code");
				System.out.println(amount + "amount");
				System.out.println(sales_date + "sales_date");
				System.out.println(deliver_status + "deliver_status");
				
				// productVO 의 product_amount에 update문을 실행할때, 좀 쉽게하기 위한 작업.
				int currAmount = pDao.getProductAmount(product_code); 
				System.out.println(currAmount);
				System.out.println(amount);
				int productAmount = currAmount-amount;
				System.out.println(productAmount);
				
				// isAdded == 0 의 의미는 SalesVO에 Insert 작업이 실행된 적이 없을때.
				if (isAdded == 0) {
				  isAdded =	sDao.approvalPayPro(sVo);
				  isUpdate = pDao.updateProductAmount(product_code, productAmount);
				  isDelete = oDao.deleteOrder(order_code);
				}else {
					isAdded += sDao.approvalPayPro(sVo);
					isUpdate += pDao.updateProductAmount(product_code, productAmount);
					isDelete += oDao.deleteOrder(order_code);
				}
				
				// 위의 작업 내용들을 setAttribute 해준다.
				// 이것들을 통해서 다음 view 페이지에서 결제승인의 성공여부를 출력해준다.
				req.setAttribute("isAdded", isAdded);  
				req.setAttribute("isUpdate", isUpdate);
				req.setAttribute("isDelete", isDelete);
				req.setAttribute("numOfOrder", checkedOrder.length);
			}	
		}else { // 체크된 것이 하나도 없을때. 오류를 방지하기 위해서 속성명에 null값을 넣어준다.
			req.setAttribute("isAdded", null);
			req.setAttribute("isUpdate", null);
			req.setAttribute("isDelete", null);
			req.setAttribute("numOfOrder", null);
		}
		
	}

	@Override
	public void finalAccountPro(HttpServletRequest req, HttpServletResponse res) {
		
		/*int finalAccount = 0;
		
		SalesDAO sDao = SalesDAOImpl.getInstance();
		RefundDAO rDao = RefundDAOImpl.getInstance();
		
		finalAccount = sDao.getFinalAccount() - rDao.calRefundAmount();
		
		req.setAttribute("finalAccount", finalAccount);*/
		
		SalesDAO sDao = SalesDAOImpl.getInstance();
		RefundDAO rDao = RefundDAOImpl.getInstance();
		
		int finalAccount = sDao.finalAccount();
		int RefundAccount = rDao.calRefundAmount();
		
		req.setAttribute("FinalAccount1", finalAccount);
		req.setAttribute("RefundAccount", RefundAccount);
		
	}

	@Override
	public void cust_salesList(HttpServletRequest req, HttpServletResponse res) {
		
		ArrayList<SalesVO> sVos;
		SalesDAO sDao = SalesDAOImpl.getInstance();

		
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
		cnt = sDao.getNumOfSale((String) req.getSession().getAttribute("curr_id"));
		
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
			
			OrderDAO oDao = OrderDAOImpl.getInstance();
			
			ArrayList<Object> info = null;
			
			sVos = sDao.getArticleList((String) req.getSession().getAttribute("curr_id"), start, end);
			
			
			MemberVO mVo = null;
			ProductVO pVo = null;
			
			ArrayList<MemberVO> memberInfo = new ArrayList<MemberVO>();
			ArrayList<ProductVO> productInfo = new ArrayList<ProductVO>();
			
			if (sVos!=null) {
				for (SalesVO s : sVos) {
					info = oDao.getProductMember(s.getProduct_code(), s.getId(), s.getAmount());
					
					mVo = (MemberVO) info.get(0);
					pVo = (ProductVO) info.get(1);
					
					
					memberInfo.add(mVo);
					productInfo.add(pVo);
					
				}
				
				req.setAttribute("memberInfo", memberInfo);
				req.setAttribute("productInfo", productInfo);
				req.setAttribute("sVos", sVos);
			}else {
				req.setAttribute("memberInfo", null);
				req.setAttribute("productInfo", null);
				req.setAttribute("sVos", null);
			}
			
		}
		
		startPage = (currentPage / pageBlock) * pageBlock + 1; 
		
		if (currentPage % pageBlock == 0) startPage -= pageBlock; // [1][2][3] 에서는 계속 [1]만, [4][5][6] 에서는 계속 [4] 만 나옴.
		
		endPage = startPage + pageBlock - 1; 
		
		if (endPage > pageCount) endPage = pageCount;  // 이런 경우는 언제 발생하는거지?
		
		req.setAttribute("cnt", cnt);
		req.setAttribute("number", number);
		req.setAttribute("pageNum", pageNum);
		
		if (cnt > 0) {
			req.setAttribute("startPage", startPage);
		
			// 마지막 페이지
			req.setAttribute("endPage", endPage);
			// 출력할 페이지 갯수
			req.setAttribute("pageBlock", pageBlock);
			// 페이지 갯수
			req.setAttribute("pageCount", pageCount);
			// 현재 페이지
			req.setAttribute("currentPage", currentPage);
		}
	}
}
