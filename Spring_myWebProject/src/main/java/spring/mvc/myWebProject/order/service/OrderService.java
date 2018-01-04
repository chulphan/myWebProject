package spring.mvc.myWebProject.order.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface OrderService {
	
	public void orderList(HttpServletRequest req, Model model);
	
	public void buyProductPro(HttpServletRequest req, Model model);
	
	public void getCartProductDetail(HttpServletRequest req, Model model);
	/*
	public void buyWishProductPro(HttpServletRequest req, HttpServletResponse res);
	*/
	
	public void getProductDetail(HttpServletRequest req, Model model);
	
	public void cust_orderList(HttpServletRequest req, Model model);
}
