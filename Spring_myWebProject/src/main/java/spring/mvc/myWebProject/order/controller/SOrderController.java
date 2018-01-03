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
	
	@RequestMapping(value="cust_myAccount", method=RequestMethod.GET)
	public String cust_myAccount(HttpServletRequest req, Model model) {
		
		oService.orderList(req, model);
		
		return "/order/cust_myAccount";
	}
}
