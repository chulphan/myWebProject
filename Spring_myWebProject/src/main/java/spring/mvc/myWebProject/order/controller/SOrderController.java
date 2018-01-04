package spring.mvc.myWebProject.order.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.mvc.myWebProject.order.service.OrderService;

@Controller
public class SOrderController {
	
	@Autowired
	OrderService oService;
	
	@RequestMapping(value="host_manageOrder", method=RequestMethod.GET)
	public String host_managerOrder(HttpServletRequest req, Model model) {
		
		oService.orderList(req, model);
		
		return "/order/host_manageOrder";
	}
	
	@RequestMapping(value="cust_myAccount", method=RequestMethod.GET)
	public String cust_myAccount(HttpServletRequest req, Model model) {
		
		oService.cust_orderList(req, model);
		
		return "/order/cust_myAccount";
	}
	
	@RequestMapping(value="buyProductForm", method=RequestMethod.GET)
	public String buyProductForm(HttpServletRequest req, Model model) {
		
		oService.getProductDetail(req, model);
		
		return "/order/buyProductForm";
	}
	
	@RequestMapping(value="buyProductPro")
	public String buyProductPro(HttpServletRequest req, Model model) {
		
		oService.buyProductPro(req, model);
		
		return "/order/buyProductPro";
	}
	
	@RequestMapping(value="buyWishListForm")
	public String buyWishListForm(HttpServletRequest req, Model model) {
		
		oService.getCartProductDetail(req, model);
		
		return "/order/buyWishListForm";
	}
	
	@RequestMapping(value="buyWishListProductPro")
	public String buyWishListProductPro(HttpServletRequest req, Model model) {
		
		oService.buyWishProductPro(req, model);
		
		return "/order/buyWishListProductPro";
	}
}
