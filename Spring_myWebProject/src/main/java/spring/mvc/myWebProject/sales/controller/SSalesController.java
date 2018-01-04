package spring.mvc.myWebProject.sales.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.myWebProject.sales.service.SalesService;

@Controller
public class SSalesController {
	
	@Autowired
	SalesService sService;
	
	@RequestMapping(value="printSalesList")
	public String printSalesList(HttpServletRequest req, Model model) {
		
		sService.salesList(req, model);
		
		return "/sales/printSalesList";
	}
	
	@RequestMapping(value="host_approvalPay")
	public String host_approvalPay(HttpServletRequest req, Model model) {
		
		sService.host_approvalPay(req, model);
		
		return "/sales/host_approvalPay";
	}
	
	@RequestMapping(value="cust_printSales")
	public String cust_printSales(HttpServletRequest req, Model model) {
		
		sService.cust_salesList(req, model);
		
		return "/sales/cust_printSales";
	}
}
