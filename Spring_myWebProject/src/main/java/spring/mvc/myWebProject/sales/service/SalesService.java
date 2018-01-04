package spring.mvc.myWebProject.sales.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SalesService {
	
	public void salesList(HttpServletRequest req, HttpServletResponse res);

	public void host_approvalPay(HttpServletRequest req, HttpServletResponse res);

	public void finalAccountPro(HttpServletRequest req, HttpServletResponse res);

	public void cust_salesList(HttpServletRequest req, HttpServletResponse res);
}
