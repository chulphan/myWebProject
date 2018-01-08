package spring.mvc.myWebProject.refund.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface RefundService {
	public void printRefundList(HttpServletRequest req, Model model);
	
	public void curt_printRefundList(HttpServletRequest req, Model model);
	
	public void cust_refundPro(HttpServletRequest req, Model model);
	/*
	public void host_approvalRefundPro(HttpServletRequest req, HttpServletResponse res);*/
}
