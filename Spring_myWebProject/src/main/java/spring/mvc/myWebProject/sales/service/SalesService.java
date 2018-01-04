package spring.mvc.myWebProject.sales.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface SalesService {
	
	public void salesList(HttpServletRequest req, Model model);

	public void host_approvalPay(HttpServletRequest req, Model model);
	/*
	public void finalAccountPro(HttpServletRequest req, HttpServletResponse res);
	*/
	public void cust_salesList(HttpServletRequest req, Model model);
}
