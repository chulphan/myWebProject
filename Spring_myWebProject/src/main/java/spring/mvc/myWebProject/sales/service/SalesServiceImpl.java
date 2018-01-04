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
		cnt = sDao.getNumOfSale();
		
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
		
		if (currentPage % pageBlock == 0) startPage -= pageBlock; // [1][2][3] ������ ��� [1]��, [4][5][6] ������ ��� [4] �� ����.
		
		endPage = startPage + pageBlock - 1; 
		
		if (endPage > pageCount) endPage = pageCount;  // �̷� ���� ���� �߻��ϴ°���?
		
		req.setAttribute("cnt", cnt);
		req.setAttribute("number", number);
		req.setAttribute("pageNum", pageNum);
		
		if (cnt > 0) {
			req.setAttribute("startPage", startPage);
		
			// ������ ������
			req.setAttribute("endPage", endPage);
			// ����� ������ ����
			req.setAttribute("pageBlock", pageBlock);
			// ������ ����
			req.setAttribute("pageCount", pageCount);
			// ���� ������
			req.setAttribute("currentPage", currentPage);
		}
	}

	@Override
	public void host_approvalPay(HttpServletRequest req, HttpServletResponse res) {
		
		// �� ���̺��� DAO�� �����ϱ� ���� �۾�.
		OrderDAO oDao = OrderDAOImpl.getInstance();
		ProductDAO pDao = ProductDAOImpl.getInstance();
		SalesDAO sDao = SalesDAOImpl.getInstance();
		
		// ���� ���������� üũ�ڽ��� üũ �� �ֹ����� �ֹ��ڵ��� �迭.
		String[] checkedOrder = req.getParameterValues("checkOrder");
		
		
		SalesVO sVo = null;
		
		// isAdded == isUpdate == isDelete == checkedOrder.length(�� ���������� üũ�ڽ��� üũ�� ����) ������ ��� �۾��� ������ ��.
		
		// isAdded : SalesVO �� Insert ���� ������ Ƚ��.
		int isAdded = 0;
		
		// isUpdate : ProductVO �� product_amount�� Update ���� ������ Ƚ��.
		int isUpdate = 0;
		
		// isDelete : OrderVO �� �ش� order_code�� ������ ������ Ƚ��.
		int isDelete = 0;
		
		// üũ�ڽ��� üũ�� ���� �ϳ� �̻��϶� �Ʒ� �۾��� ����.
		if (checkedOrder != null) {
			for (int i = 0; i < checkedOrder.length; i++) {
				
				//SalesVO �ٱ��ϸ� ����.
				sVo = new SalesVO();
				
				// Sale_code�� ����.
				String sales_code = "S" + checkedOrder[i];
				
				// i��° order_code�� checkedOrder �迭���� �����´�.
				String order_code = checkedOrder[i];
				
				// orderDAO���� ���� order_code�� ���� �ֹ���(id)�� �ֹ�����(product_code)�� �����´�.
				ArrayList<String> idAndPdt = oDao.getIdAndPdtCode(order_code); 
				
				// salesVO �� �� ������ ����.
				String id = idAndPdt.get(0);
				String product_code = idAndPdt.get(1);
				Timestamp sales_date = new Timestamp(System.currentTimeMillis());
				int amount = oDao.getNeedAmount(order_code);
				String deliver_status = "in shipping";
				
				// SalesVO �� �����͸� �ִ� �۾�.
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
				
				// productVO �� product_amount�� update���� �����Ҷ�, �� �����ϱ� ���� �۾�.
				int currAmount = pDao.getProductAmount(product_code); 
				System.out.println(currAmount);
				System.out.println(amount);
				int productAmount = currAmount-amount;
				System.out.println(productAmount);
				
				// isAdded == 0 �� �ǹ̴� SalesVO�� Insert �۾��� ����� ���� ������.
				if (isAdded == 0) {
				  isAdded =	sDao.approvalPayPro(sVo);
				  isUpdate = pDao.updateProductAmount(product_code, productAmount);
				  isDelete = oDao.deleteOrder(order_code);
				}else {
					isAdded += sDao.approvalPayPro(sVo);
					isUpdate += pDao.updateProductAmount(product_code, productAmount);
					isDelete += oDao.deleteOrder(order_code);
				}
				
				// ���� �۾� ������� setAttribute ���ش�.
				// �̰͵��� ���ؼ� ���� view ���������� ���������� �������θ� ������ش�.
				req.setAttribute("isAdded", isAdded);  
				req.setAttribute("isUpdate", isUpdate);
				req.setAttribute("isDelete", isDelete);
				req.setAttribute("numOfOrder", checkedOrder.length);
			}	
		}else { // üũ�� ���� �ϳ��� ������. ������ �����ϱ� ���ؼ� �Ӽ��� null���� �־��ش�.
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
		cnt = sDao.getNumOfSale((String) req.getSession().getAttribute("curr_id"));
		
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
		
		if (currentPage % pageBlock == 0) startPage -= pageBlock; // [1][2][3] ������ ��� [1]��, [4][5][6] ������ ��� [4] �� ����.
		
		endPage = startPage + pageBlock - 1; 
		
		if (endPage > pageCount) endPage = pageCount;  // �̷� ���� ���� �߻��ϴ°���?
		
		req.setAttribute("cnt", cnt);
		req.setAttribute("number", number);
		req.setAttribute("pageNum", pageNum);
		
		if (cnt > 0) {
			req.setAttribute("startPage", startPage);
		
			// ������ ������
			req.setAttribute("endPage", endPage);
			// ����� ������ ����
			req.setAttribute("pageBlock", pageBlock);
			// ������ ����
			req.setAttribute("pageCount", pageCount);
			// ���� ������
			req.setAttribute("currentPage", currentPage);
		}
	}
}
