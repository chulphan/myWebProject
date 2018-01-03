package spring.mvc.myWebProject.cart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.myWebProject.cart.persistence.CartDAO;
import spring.mvc.myWebProject.cart.vo.CartVO;
import spring.mvc.myWebProject.product.persistence.ProductDAO;
import spring.mvc.myWebProject.product.vo.ProductVO;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartDAO cDao;
	ProductDAO pDao;
	
	@Override
	public void cartList(HttpServletRequest req, Model model) {
		
		ArrayList<CartVO> cAry;
		
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
		
		cnt = cDao.getNumOfCart();
		
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
			
			String curr_id = (String) req.getSession().getAttribute("curr_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("curr_id", curr_id);
			map.put("start", start);
			map.put("end", end);
			
			cAry = cDao.getCartList(map);
		
			ProductVO pVo = null;
			
			ArrayList<ProductVO> productInfo = new ArrayList<ProductVO>();
			
			if (cAry != null) {
				for (CartVO o : cAry) {
					
					pVo = pDao.detailProduct(o.getProduct_code()); 
					
					productInfo.add(pVo);
				}
				model.addAttribute("productInfo", productInfo);
				model.addAttribute("cAry", cAry);
			}else {
				model.addAttribute("productInfo", null);
				model.addAttribute("cAry", null);
			}
			
			
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
	public void addWishList(HttpServletRequest req, Model model) {

		CartVO cVo = new CartVO();
		
		String cart_id = "C" + (int)(Math.random() * 200000 + 100000);
		String product_code = req.getParameter("product_code");
		String curr_id = req.getParameter("user_id");
		int amount = Integer.parseInt(req.getParameter("qty"));
		
		cVo.setCart_id(cart_id);
		cVo.setProduct_code(product_code);
		cVo.setId(curr_id);
		cVo.setAmount(amount);
		
		int isAdded = cDao.addWishListPro(cVo);
		
		model.addAttribute("isAdded", isAdded);
		model.addAttribute("cart_id", cart_id);
	}
	
	
	@Override
	public void delWishList(HttpServletRequest req, Model model) {
		
		String[] checkedCart = req.getParameterValues("checkCart");
		String curr_id = (String) req.getSession().getAttribute("curr_id");
		
		int len_checked = 0;
		int isDeleted = 0;
		
		for (; len_checked < checkedCart.length; len_checked++) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			if (isDeleted == 0) {
				map.put("curr_id", curr_id);
				map.put("checkedCart", checkedCart[len_checked]);
				isDeleted = cDao.delWishListPro(map);
			}else {
				map.put("curr_id", curr_id);
				map.put("checkedCart", checkedCart[len_checked]);
				isDeleted += cDao.delWishListPro(map);
			}
			
		}
		model.addAttribute("isDeleted", isDeleted);
		model.addAttribute("len_checked", checkedCart.length);
	}

}
