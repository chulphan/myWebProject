package spring.mvc.myWebProject.refund.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.myWebProject.refund.persistence.RefundDAO;
import spring.mvc.myWebProject.refund.vo.RefundVO;

@Service
public class RefundServiceImpl implements RefundService{
	
	@Autowired
	RefundDAO rDao;
	
	@Override
	public void printRefundList(HttpServletRequest req, Model model) {
		
		ArrayList<RefundVO> rVos = null;
		
		int pageSize = 10;
		int pageBlock = 5;
		
		int cnt = 0;
		int start = 0;
		int end = 0;
		int currentPage = 0;
		int number = 0;
		String pageNum = null;
		
		int pageCount = 0;
		int startPage = 0;
		int endPage = 0;
		
		cnt = rDao.getNumOfRefund();
		
		if (pageNum == null) {
			pageNum = "1";
		}
		
		currentPage = Integer.parseInt(pageNum);
		
		pageCount = (cnt/pageSize) + ((cnt%pageSize == 0) ? 0 : 1);
		
		start = pageSize * currentPage - 9;
		
		end = pageSize * currentPage;
		
		if (end > cnt) end = cnt;
		
		number = cnt - (currentPage - 1) * pageSize;
		
		if (cnt > 0) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("start", start);
			map.put("end", end);
			
			rVos = rDao.printRefundList(map);
			
			model.addAttribute("rVos", rVos);
		}
		
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		
		if (currentPage % pageBlock == 0) startPage -= pageBlock;
		
		endPage = startPage + pageBlock - 1;
		
		if (endPage > pageCount) endPage = pageCount;
		
		model.addAttribute("cnt", cnt);
		model.addAttribute("number", number);
		model.addAttribute("pageNum", pageNum);
		
		if (cnt > 0) {
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("pageBlock", pageBlock);
			model.addAttribute("currentPage", currentPage);
		}
	}


	@Override
	public void curt_printRefundList(HttpServletRequest req, Model model) {
		
		ArrayList<RefundVO> rVos;
		
		String curr_id = (String) req.getSession().getAttribute("curr_id");

		int pageSize = 10;
		int pageBlock = 5;
		
		int cnt = 0;
		int start = 0;
		int end = 0;
		int currentPage = 0;
		int number = 0;
		String pageNum = null;
		
		int pageCount = 0;
		int startPage = 0;
		int endPage = 0;
		
		cnt = rDao.cust_getNumOfRefund(curr_id);
		
		if (pageNum == null) {
			pageNum = "1";
		}
		
		currentPage = Integer.parseInt(pageNum);
		
		pageCount = (cnt/pageSize) + ((cnt%pageSize == 0) ? 0 : 1);
		
		start = pageSize * currentPage - 9;
		
		end = pageSize * currentPage;
		
		if (end > cnt) end = cnt;
		
		number = cnt - (currentPage - 1) * pageSize;
		
		if (cnt > 0) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("curr_id", curr_id);
			map.put("start", start);
			map.put("end", end);
			
			rVos = rDao.cust_printRefundList(map);
			
			model.addAttribute("rVos", rVos);
		}
		
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		
		if (currentPage % pageBlock == 0) startPage -= pageBlock;
		
		endPage = startPage + pageBlock - 1;
		
		if (endPage > pageCount) endPage = pageCount;
		
		model.addAttribute("cnt", cnt);
		model.addAttribute("number", number);
		model.addAttribute("pageNum", pageNum);
		
		if (cnt > 0) {
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("pageBlock", pageBlock);
			model.addAttribute("currentPage", currentPage);
		}
	}
	

	@Override
	public void cust_refundPro(HttpServletRequest req, Model model) {
		// �� ���̺��� DAO�� �����ϱ� ���� �۾�.
		// ���� ���������� üũ�ڽ��� üũ �� �ֹ����� �ֹ��ڵ��� �迭.
		String[] checkedSales = req.getParameterValues("checkSales");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("checkedSales", checkedSales);
		
		ArrayList<RefundVO> rVos = rDao.getSalesInfo(map);
		
		// isAdded : RefundVO �� Insert ���� ������ Ƚ��.
		int isAdded = 0;
		
		// üũ�ڽ��� üũ�� ���� �ϳ� �̻��϶� �Ʒ� �۾��� ����.
		for (int i = 0; i < rVos.size(); i++) {
				
			//SalesVO �ٱ��ϸ� ����.
			RefundVO rVo = new RefundVO();
			
			// Refund_code�� ����.
			String refund_code = "R" + checkedSales[i];
			
			// salesDAO���� ���� sales_code�� ���� �ֹ���(id)�� �ֹ�����(product_code)�� �����´�.
			
			// refundVO �� �� ������ ����.
			String id = (String) req.getSession().getAttribute("curr_id");
			String product_code = rVos.get(i).getSale().getProduct_code();
			Timestamp refund_date = new Timestamp(System.currentTimeMillis());
			int amount = rVos.get(i).getSale().getAmount();
			String refund_status = "ó����";
			
			// SalesVO �� �����͸� �ִ� �۾�.
			rVo.setRefund_code(refund_code);
			rVo.setId(id);
			rVo.setProduct_code(product_code);
			rVo.setRefund_amount(amount);
			rVo.setRefund_date(refund_date);
			rVo.setRefund_status(refund_status);
			
			// productVO �� product_amount�� update���� �����Ҷ�, �� �����ϱ� ���� �۾�.
			
			// isAdded == 0 �� �ǹ̴� SalesVO�� Insert �۾��� ����� ���� ������.
			if (isAdded == 0) {
				isAdded =	rDao.insertIntoRefund(rVo);
			}else {
				isAdded += rDao.insertIntoRefund(rVo);
			}
			// ���� �۾� ������� setAttribute ���ش�.
			// �̰͵��� ���ؼ� ���� view ���������� ���������� �������θ� ������ش�.
			req.setAttribute("isAdded", isAdded);  
			req.setAttribute("numOfRefund", checkedSales.length);
		}	
	}

	
	@Override
	public void host_approvalRefundPro(HttpServletRequest req, Model model) {
		
		String[] checkedRefund = req.getParameterValues("checkRefund");
		
		int isDelete = 0;
		int isUpdateRefund = 0;
		int isUpdateProduct = 0;
		int isUpdateAccount = 0;
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		
		map2.put("checkedRefund", checkedRefund);
		
		ArrayList<RefundVO> rVos = rDao.getRefundInfo(map2);
		
		for (int i = 0; i < rVos.size(); i++) {
			
			String id = rVos.get(i).getId();
			String product_code = rVos.get(i).getProduct_code();
			int amount = rVos.get(i).getRefund_amount();
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("id", id);
			map.put("product_code", product_code);
			map.put("amount", amount);
			
			String deleteSalesCode = rVos.get(i).getRefund_code().substring(1);
			
			isDelete += rDao.deleteSales(deleteSalesCode);
			isUpdateProduct += rDao.updateProductAmount(map);
			isUpdateRefund += rDao.updateRefundStatus(checkedRefund[i]);
			isUpdateAccount += rDao.updateFinalAccount(rVos.get(i).getRefund_amount() * rVos.get(i).getProduct().getProduct_price());
		}
		
		model.addAttribute("isDelete", isDelete);
		model.addAttribute("numOfRefund", rVos.size());
		
	}
}
