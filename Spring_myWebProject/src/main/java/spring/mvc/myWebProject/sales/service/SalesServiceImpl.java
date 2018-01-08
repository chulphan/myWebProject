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

		int pageSize = 8; // �� �������� ����� �� ����
		int pageBlock = 4; // �� ���� ������ ����

		int cnt = 0; // �� ����
		int start = 0; // ���� ������ ���۹�ȣ 1
		int end = 0; // ���� �������� ������ �۹�ȣ
		int currentPage = 0; // ���� ������
		int number = 0; // ����� �� ��ȣ
		String pageNum = null; // ������ ��ȣ

		int pageCount = 0; // ������ ����
		int startPage = 0; // �ش� ������ ���� ���۹�ȣ. ex) [1] [2] [3] �� �ִٸ� ���۹�ȣ�� [1].
		int endPage = 0; // �ش� ������ ���� ������ ��ȣ ex) [1] [2] [3] �� �ִٸ� ������ �������� [3]

		// �� ���� ���ϱ�.
		cnt = sDao.getNumOfSale();

		pageNum = req.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1"; // ù �������� 1�� ����.
		}

		currentPage = Integer.parseInt(pageNum);

		pageCount = (cnt / pageSize) + ((cnt % pageSize == 0) ? 0 : 1);

		start = pageSize * currentPage - 7; // ���� ������ ���� ���� ���۹�ȣ

		end = pageSize * currentPage; // ���� ������ ����ȣ (<==> pageSize * currentPage)

		if (end > cnt)
			end = cnt; // �۵��� ���� �Ǿ����� end != cnt.

		number = cnt - (currentPage - 1) * pageSize; // ����� �� ��ȣ

		if (cnt > 0) {

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("start", start);
			map.put("end", end);

			sVos = sDao.getArticleList(map);

			model.addAttribute("sVos", sVos);
		}

		startPage = (currentPage / pageBlock) * pageBlock + 1;

		if (currentPage % pageBlock == 0)
			startPage -= pageBlock; // [1][2][3] ������ ��� [1]��, [4][5][6] ������ ��� [4] �� ����.

		endPage = startPage + pageBlock - 1;

		if (endPage > pageCount)
			endPage = pageCount; // �̷� ���� ���� �߻��ϴ°���?

		model.addAttribute("cnt", cnt);
		model.addAttribute("number", number);
		model.addAttribute("pageNum", pageNum);

		if (cnt > 0) {
			model.addAttribute("startPage", startPage);

			// ������ ������
			model.addAttribute("endPage", endPage);
			// ����� ������ ����
			model.addAttribute("pageBlock", pageBlock);
			// ������ ����
			model.addAttribute("pageCount", pageCount);
			// ���� ������
			model.addAttribute("currentPage", currentPage);
		}
	}

	@Override
	public void host_approvalPay(HttpServletRequest req, Model model) {

		// ���� ���������� üũ�ڽ��� üũ �� �ֹ����� �ֹ��ڵ��� �迭.
		String[] checkedOrder = req.getParameterValues("checkOrder");
		ArrayList<SalesVO> sVo = null;

		// isAdded == isUpdate == isDelete == checkedOrder.length(�� ���������� üũ�ڽ��� üũ�� ����)
		// ������ ��� �۾��� ������ ��.

		// isAdded : SalesVO �� Insert ���� ������ Ƚ��.
		int isAdded = 0;

		// isUpdate : ProductVO �� product_amount�� Update ���� ������ Ƚ��.
		int isUpdate = 0;

		// isDelete : OrderVO �� �ش� order_code�� ������ ������ Ƚ��.
		int isDelete = 0;

		Map<String, Object> co = new HashMap<String, Object>();

		co.put("checkedOrder", checkedOrder);

		sVo = sDao.getOrderInfo(co);

		// üũ�ڽ��� üũ�� ���� �ϳ� �̻��϶� �Ʒ� �۾��� ����.
		for (int i = 0; i < sVo.size(); i++) {

			// SalesVO �ٱ��ϸ� ����.
			SalesVO iSvo = new SalesVO();
			String order_code = sVo.get(i).getOrder().getOrder_code();
			// Sale_code�� ����.
			String sales_code = "S" + sVo.get(i).getOrder().getOrder_code();

			// orderDAO���� ���� order_code�� ���� �ֹ���(id)�� �ֹ�����(product_code)�� �����´�.

			// salesVO �� �� ������ ����.
			String id = sVo.get(i).getOrder().getId();
			System.out.println(id + "id+=asdf=sdf=sdf=");
			String product_code = sVo.get(i).getOrder().getProduct_code();
			Timestamp sales_date = new Timestamp(System.currentTimeMillis());
			int amount = sVo.get(i).getOrder().getAmountOfPurchase();
			String deliver_status = "�����";

			// SalesVO �� �����͸� �ִ� �۾�.
			iSvo.setSales_code(sales_code);
			iSvo.setId(id);
			iSvo.setProduct_code(product_code);
			iSvo.setAmount(amount);
			iSvo.setSales_date(sales_date);
			iSvo.setDeliver_status(deliver_status);

			// productVO �� product_amount�� update���� �����Ҷ�, �� �����ϱ� ���� �۾�.
			int currAmount = sVo.get(i).getProduct().getProduct_amount();
			int productAmount = currAmount - amount;

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("product_code", product_code);
			map.put("amount", amount);
			map.put("currAmount", currAmount);
			map.put("productAmount", productAmount);

			// isAdded == 0 �� �ǹ̴� SalesVO�� Insert �۾��� ����� ���� ������.
			if (isAdded == 0) {
				isAdded = sDao.approvalPayPro(iSvo);
				isUpdate = sDao.updateProductAmount(map);
				isDelete = sDao.deleteOrder(order_code);
			} else {
				isAdded += sDao.approvalPayPro(iSvo);
				isUpdate += sDao.updateProductAmount(map);
				isDelete += sDao.deleteOrder(order_code);
			}

			// ���� �۾� ������� setAttribute ���ش�.
			// �̰͵��� ���ؼ� ���� view ���������� ���������� �������θ� ������ش�.
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

		int pageSize = 8; 		// �� �������� ����� �� ���� 
		int pageBlock = 4;		// �� ���� ������ ����
		
		int cnt = 0;			// �� ����
		int start = 0;			// ���� ������ ���۹�ȣ 1
		int end = 0;			// ���� �������� ������ �۹�ȣ
		int currentPage = 0;	// ���� ������
		int number = 0;			// ����� �� ��ȣ
		String pageNum = null; 	// ������ ��ȣ
		
		int pageCount = 0;		// ������ ����
		int startPage = 0;		// �ش� ������ ���� ���۹�ȣ. ex) [1] [2] [3] �� �ִٸ� ���۹�ȣ�� [1].
		int endPage = 0;		// �ش� ������ ���� ������ ��ȣ			ex) [1] [2] [3] �� �ִٸ� ������ �������� [3]
		
		
		// �� ���� ���ϱ�.
		Map<String, Object> mm = new HashMap<String, Object>();
		mm.put("curr_id", (String) req.getSession().getAttribute("curr_id"));
		cnt = sDao.cust_getNumOfSale(mm);
		
		pageNum = req.getParameter("pageNum");
		
		if (pageNum == null) {
			pageNum = "1"; // ù �������� 1�� ����.
		}
		
		currentPage = Integer.parseInt(pageNum);
		
		pageCount = (cnt / pageSize) + ((cnt % pageSize == 0) ? 0 : 1);
	
		start = pageSize *  currentPage  - 7; // ���� ������ ���� ���� ���۹�ȣ
		
		end = pageSize * currentPage; // ���� ������ ����ȣ (<==> pageSize * currentPage)
		
		
		if (end > cnt) end = cnt; // �۵��� ���� �Ǿ����� end != cnt.
		
		number = cnt - (currentPage-1) * pageSize; // ����� �� ��ȣ
		
		
		if (cnt > 0) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("curr_id", (String) req.getSession().getAttribute("curr_id"));
			map.put("start", start);
			map.put("end", end);
			
			sVos = sDao.cust_getArticleList(map);
			
		}
		
		startPage = (currentPage / pageBlock) * pageBlock + 1; 
		
		if (currentPage % pageBlock == 0) startPage -= pageBlock; // [1][2][3] ������ ��� [1]��, [4][5][6] ������ ��� [4] �� ����.
		
		endPage = startPage + pageBlock - 1; 
		
		if (endPage > pageCount) endPage = pageCount;  // �̷� ���� ���� �߻��ϴ°���?
		
		model.addAttribute("sVos", sVos);
		model.addAttribute("cnt", cnt);
		model.addAttribute("number", number);
		model.addAttribute("pageNum", pageNum);
		
		if (cnt > 0) {
			model.addAttribute("startPage", startPage);
		
			// ������ ������
			model.addAttribute("endPage", endPage);
			// ����� ������ ����
			model.addAttribute("pageBlock", pageBlock);
			// ������ ����
			model.addAttribute("pageCount", pageCount);
			// ���� ������
			model.addAttribute("currentPage", currentPage);
		}
	}	 
}
