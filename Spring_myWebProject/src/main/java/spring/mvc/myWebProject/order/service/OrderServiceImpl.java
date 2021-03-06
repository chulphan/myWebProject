package spring.mvc.myWebProject.order.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.myWebProject.cart.vo.CartVO;
import spring.mvc.myWebProject.member.persistence.MemberPersistence;
import spring.mvc.myWebProject.member.vo.MemberVO;
import spring.mvc.myWebProject.order.persistence.OrderDAO;
import spring.mvc.myWebProject.order.vo.OrderVO;
import spring.mvc.myWebProject.product.persistence.ProductDAO;
import spring.mvc.myWebProject.product.vo.ProductVO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO oDao;
	ProductDAO pDao;
	MemberPersistence mDao;

	@Override
	public void orderList(HttpServletRequest req, Model model) {

		ArrayList<OrderVO> oAry = null;

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

		pageCount = (cnt / pageSize) + ((cnt % pageSize == 0) ? 0 : 1);

		start = pageSize * currentPage - 9;

		end = pageSize * currentPage;

		if (end > cnt)
			end = cnt;

		number = cnt - (currentPage - 1) * pageSize;

		if (cnt > 0) {

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("start", start);
			map.put("end", end);

			oAry = oDao.getOrderList(map);
		}

		startPage = (currentPage / pageBlock) * pageBlock + 1;

		if (currentPage % pageBlock == 0)
			startPage -= pageBlock;

		endPage = startPage + pageBlock - 1;

		if (endPage > pageCount)
			endPage = pageCount;

		model.addAttribute("cnt", cnt);
		model.addAttribute("number", number);
		model.addAttribute("pageNum", pageNum);

		if (cnt > 0) {
			model.addAttribute("oAry", oAry);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("pageBlock", pageBlock);
			model.addAttribute("currentPage", currentPage);
		}

	}

	@Override
	public void buyProductPro(HttpServletRequest req, Model model) {

		int tempCode = (int) (Math.random() * 20000000 + 10000000);

		String order_code = "O" + tempCode;
		String product_code = req.getParameter("product_code");
		int product_amount = Integer.parseInt(req.getParameter("product_amount"));
		String curr_id = (String) req.getSession().getAttribute("curr_id");
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

		int isOrder = oDao.insertIntoOrder(oVo);

		model.addAttribute("isOrder", isOrder);
		
	}
	
	@Override
	public void getCartProductDetail(HttpServletRequest req, Model model) {

		String[] checkedCart = req.getParameterValues("checkCart");
		
		String curr_id = (String) req.getSession().getAttribute("curr_id");
		
		ArrayList<CartVO> checkCart = new ArrayList<CartVO>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", curr_id);
		map.put("checkedCart", checkedCart);
		
		checkCart = oDao.getCartContent(map);
		
		model.addAttribute("checkedCart", checkCart);
		model.addAttribute("memberInfo", checkCart.get(0).getMember());
	}
	
	@Override
	public void buyWishProductPro(HttpServletRequest req, Model model) {

		String[] checked = req.getParameterValues("checkedCarts");
		
		String id = (String) req.getSession().getAttribute("curr_id");
		
		if (checked.length > 0) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("id", id);
			map.put("checkedCart", checked);
			
			int isAdded = 0;
			int isDelete = 0;
			
			OrderVO oVo = new OrderVO();
			ArrayList<CartVO> cVo = new ArrayList<CartVO>();

			cVo = oDao.getCartContent(map);
			
			for (int i = 0; i < cVo.size(); i++) {

				int tempCode = (int) (Math.random() * 20000000 + 10000000);

				String order_code = "O" + tempCode;

				oVo.setOrder_code(order_code);
				oVo.setNum(cVo.get(i).getNum());
				oVo.setId(cVo.get(i).getId());
				oVo.setProduct_code(cVo.get(i).getProduct_code());
				oVo.setAmountOfPurchase(cVo.get(i).getAmount());
				oVo.setPurchase_price(oDao.getProductPrice(cVo.get(i).getProduct_code()));
				oVo.setOrder_date(new Timestamp(System.currentTimeMillis()));
				oVo.setOrder_status("�������");
				oVo.setSeller_id("host");

				if ((isAdded = oDao.insertIntoOrder(oVo)) == 1) {
					
					Map<String, Object> map2 = new HashMap<String, Object>();
					
					map2.put("id", cVo.get(i).getId());
					map2.put("checked", cVo.get(i).getCart_id());
					
					isDelete = oDao.deleteWishListPro(map2);

					model.addAttribute("isAdded", isAdded);
					model.addAttribute("isDelete", isDelete);
				} else {
					model.addAttribute("isAdded", 0);
					model.addAttribute("isDelete", 0);
				}
			}

		}
	}
	
	@Override
	public void getProductDetail(HttpServletRequest req, Model model) {

		String product_code = req.getParameter("product_code");
		String curr_id = req.getParameter("user_id");
		int product_amount = Integer.parseInt(req.getParameter("qty"));

		MemberVO mVo = oDao.getMemberInfo(curr_id);
		ProductVO pVo = oDao.getProduct(product_code);

		model.addAttribute("mVo", mVo);
		model.addAttribute("pVo", pVo);

		model.addAttribute("product_code", product_code);
		model.addAttribute("curr_id", curr_id);
		model.addAttribute("product_amount", product_amount);
	}

	@Override
	public void cust_orderList(HttpServletRequest req, Model model) {

		String curr_id = (String) req.getSession().getAttribute("curr_id");

		ArrayList<OrderVO> oAry = null;

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

		pageCount = (cnt / pageSize) + ((cnt % pageSize == 0) ? 0 : 1);

		start = pageSize * currentPage - 9;

		end = pageSize * currentPage;

		if (end > cnt)
			end = cnt;

		number = cnt - (currentPage - 1) * pageSize;

		if (cnt > 0) {

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("curr_id", curr_id);
			map.put("start", start);
			map.put("end", end);

			oAry = oDao.cust_getOrderList(map);

		}
		startPage = (currentPage / pageBlock) * pageBlock + 1;

		if (currentPage % pageBlock == 0)
			startPage -= pageBlock;

		endPage = startPage + pageBlock - 1;

		if (endPage > pageCount)
			endPage = pageCount;

		System.out.println("cnt" + cnt);

		model.addAttribute("cnt", cnt);
		model.addAttribute("number", number);
		model.addAttribute("pageNum", pageNum);

		if (cnt > 0) {
			model.addAttribute("oAry", oAry);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("pageBlock", pageBlock);
			model.addAttribute("currentPage", currentPage);
		}

	}

}
