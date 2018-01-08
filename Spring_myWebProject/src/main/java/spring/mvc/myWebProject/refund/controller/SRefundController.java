package spring.mvc.myWebProject.refund.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.myWebProject.refund.service.RefundService;

@Controller
public class SRefundController {
	
	@Autowired
	RefundService rService;
	
	@RequestMapping(value="printRefundList")
	public String printRefundList(HttpServletRequest req, Model model) {
		
		rService.printRefundList(req, model);
		
		return "/refund/printRefundList";
	}
	
	@RequestMapping(value="cust_refundPro")
	public String cust_refundPro(HttpServletRequest req, Model model) {
		
		rService.cust_refundPro(req, model);
		
		return "/refund/cust_refundPro";
	}
	
	@RequestMapping(value="cust_returns")
	public String cust_returns(HttpServletRequest req, Model model) {
		
		
		
		return "/refund/cust_returns";
	}
}
