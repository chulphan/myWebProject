package spring.mvc.myWebProject.order.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface OrderService {
	
	public void orderList(HttpServletRequest req, Model model);
	/*
	public void buyProductPro(HttpServletRequest req, HttpServletResponse res);
	
	public void getCartProductDetail(HttpServletRequest req, HttpServletResponse res);
	
	public void buyWishProductPro(HttpServletRequest req, HttpServletResponse res);

	public void cust_orderList(HttpServletRequest req, HttpServletResponse res);*/
}
