package spring.mvc.myWebProject.order.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.myWebProject.member.persistence.MemberPersistence;
import spring.mvc.myWebProject.member.vo.MemberVO;
import spring.mvc.myWebProject.order.persistence.OrderDAO;
import spring.mvc.myWebProject.order.persistence.OrderDAOImpl;
import spring.mvc.myWebProject.order.vo.OrderVO;
import spring.mvc.myWebProject.product.persistence.ProductDAO;
import spring.mvc.myWebProject.product.vo.ProductVO;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderDAO oDao;
	ProductDAO pDao;
	MemberPersistence mDao;
	
	@Override
	public void orderList(HttpServletRequest req, Model model) {
		
		ArrayList<OrderVO> oAry;
		ArrayList<Object> info = null;
		
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
		
		cnt = oDao.getNumOfOrder();
		
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
			
			oAry = oDao.getOrderList(map);
		
			
			
			ArrayList<MemberVO> memberInfo = new ArrayList<MemberVO>();
			ArrayList<ProductVO> productInfo = new ArrayList<ProductVO>();
			
			if (oAry!=null) {
				for (OrderVO o : oAry) {
					
					productInfo.add(pDao.getProductInfo(o.getProduct_code()));
					memberInfo.add(mDao.getCustInfo(o.getId()));
				}

				model.addAttribute("memberInfo", memberInfo);
				model.addAttribute("productInfo", productInfo);
				model.addAttribute("oAry", oAry);
			}
		}else {
			model.addAttribute("memberInfo", null);
			model.addAttribute("productInfo", null);
			model.addAttribute("oAry", null);
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

	/*@Override
	public void buyProductPro(HttpServletRequest req, HttpServletResponse res) {
		
		int tempCode = (int)(Math.random() * 20000000 + 10000000);
		
		String order_code = "O" + tempCode;
		String product_code = req.getParameter("product_code");
		int product_amount = Integer.parseInt(req.getParameter("product_amount"));
		String curr_id = (String)req.getSession().getAttribute("curr_id");
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		String order_status = "STANDBY";
		String seller_id = "host";
		int purchase_price = Integer.parseInt(req.getParameter("purchase_price"));
		
		OrderVO oVo = new OrderVO();
		
		oVo.setOrder_code(order_code);
		oVo.setProduct_code(product_code);
		oVo.setId(curr_id);
		oVo.setAmountOfPurchase(product_amount);
		oVo.setOrder_date(ts);
		oVo.setOrder_status(order_status);
		oVo.setSeller_id(seller_id);
		oVo.setPurchase_price(purchase_price);
		
		OrderDAO oDao = OrderDAOImpl.getInstance();
		
		int isOrder = oDao.insertIntoOrder(oVo);
		
		req.setAttribute("isOrder", isOrder);
		
	}

	@Override
	public void getCartProductDetail(HttpServletRequest req, HttpServletResponse res) {
		
		CartDAO cDao = CartDAOImpl.getInstance();
		OrderDAO oDao = OrderDAOImpl.getInstance();
		
		String[] checkedCart = req.getParameterValues("checkCart");
		
		
		String curr_id = (String)req.getSession().getAttribute("curr_id");
		
		CartVO cVo = null;
		MemberVO mVo = null;
		ProductVO pVo = null;
		
		ArrayList<Object> info = new ArrayList<Object>();
		ArrayList<MemberVO> memberInfo = new ArrayList<MemberVO>();
		ArrayList<ProductVO> productInfo = new ArrayList<ProductVO>();
		ArrayList<String> checkCart = new ArrayList<String>();
		
		if (checkedCart.length > 0) {
			for (int i = 0; i < checkedCart.length; i++) {
				
				cVo = cDao.getCartContent(checkedCart[i]);
				
				System.out.println(checkedCart[i] + "checkedCart[" + i + "]");
				
				info = oDao.getProductMember(cVo.getProduct_code(), curr_id, cVo.getAmount());
				
				mVo = (MemberVO) info.get(0);
				pVo = (ProductVO) info.get(1);
				
				memberInfo.add(mVo);
				productInfo.add(pVo);
				checkCart.add(checkedCart[i]);
			}
			req.setAttribute("checkedCart", checkedCart);
			req.setAttribute("memberInfo", memberInfo);
			req.setAttribute("productInfo", productInfo);
		}else {
			req.setAttribute("checkedCart", null);
			req.setAttribute("memberInfo", null);
			req.setAttribute("productInfo", null);
		}
	}

	@Override
	public void buyWishProductPro(HttpServletRequest req, HttpServletResponse res) {
		
		String[] checked = req.getParameterValues("checkedCarts");
		
		for (int i = 0; i < checked.length; i++) {
			System.out.println(checked[i]);
		}
		if (checked.length > 0) {
			
			ProductDAO pDao = ProductDAOImpl.getInstance();
			CartDAO cDao = CartDAOImpl.getInstance();
			OrderDAO oDao = OrderDAOImpl.getInstance();
			
			
			int isAdded = 0;
			int isDelete = 0;
			
			for (int i = 0; i < checked.length; i++) {
				
				OrderVO oVo = new OrderVO();
				CartVO cVo = new CartVO();
				
				cVo = cDao.getCartContent(checked[i]);
					
				int tempCode = (int)(Math.random() * 20000000 + 10000000);
				
				String order_code = "O" + tempCode;
				
				oVo.setOrder_code(order_code);
				oVo.setNum(cVo.getNum());
				oVo.setId(cVo.getId());
				oVo.setProduct_code(cVo.getProduct_code());
				oVo.setAmountOfPurchase(cVo.getAmount());
				oVo.setPurchase_price(pDao.getProductPrice(cVo.getProduct_code()));
				System.out.println(pDao.getProductPrice(cVo.getProduct_code()) + "   pDao.getProductPrice(cVo.getProduct_code())");
				oVo.setOrder_date(new Timestamp(System.currentTimeMillis()));
				oVo.setOrder_status("결제대기");
				oVo.setSeller_id("host");	
			
				if ((isAdded=oDao.insertIntoOrder(oVo)) == 1) {
					isDelete = cDao.delWishListPro(cVo.getId(), checked[i]);
					
					req.setAttribute("isAdded", isAdded);
					req.setAttribute("isDelete", isDelete);
				}else {
					req.setAttribute("isAdded", 0);
					req.setAttribute("isDelete", 0);
				}
			}
			
		}
	}

	@Override
	public void cust_orderList(HttpServletRequest req, HttpServletResponse res) {
		OrderDAO oDao = new OrderDAOImpl();
		
		String curr_id = (String) req.getSession().getAttribute("curr_id");
		
		ArrayList<OrderVO> oAry;
		ArrayList<Object> info = null;
		
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
		
		cnt = oDao.cust_getNumOfOrder(curr_id);
		
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
			
			
			
			oAry = oDao.cust_getOrderList(curr_id, start, end);
		
			
			MemberVO mVo = null;
			ProductVO pVo = null;
			
			ArrayList<MemberVO> memberInfo = new ArrayList<MemberVO>();
			ArrayList<ProductVO> productInfo = new ArrayList<ProductVO>();
			
			if (oAry!=null) {
				for (OrderVO o : oAry) {
					
					info = oDao.getProductMember(o.getProduct_code(), o.getId(), o.getAmountOfPurchase());
					
					mVo = (MemberVO) info.get(0);
					pVo = (ProductVO) info.get(1);
					
					
					memberInfo.add(mVo);
					productInfo.add(pVo);
					
				}
				
				req.setAttribute("memberInfo", memberInfo);
				req.setAttribute("productInfo", productInfo);
				req.setAttribute("oAry", oAry);
			}else {
				req.setAttribute("memberInfo", null);
				req.setAttribute("productInfo", null);
				req.setAttribute("oAry", null);
			}
		}
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		
		if (currentPage % pageBlock == 0) startPage -= pageBlock;
		
		endPage = startPage + pageBlock - 1;
		
		if (endPage > pageCount) endPage = pageCount;
		
		req.setAttribute("cnt", cnt);
		req.setAttribute("number", number);
		req.setAttribute("pageNum", pageNum);
		
		if (cnt > 0) {
			req.setAttribute("startPage", startPage);
			req.setAttribute("endPage", endPage);
			req.setAttribute("pageBlock", pageBlock);
			req.setAttribute("currentPage", currentPage);
		}
		
	}*/
}
