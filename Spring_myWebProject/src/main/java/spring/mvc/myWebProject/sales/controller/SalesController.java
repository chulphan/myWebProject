package spring.mvc.myWebProject.sales.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mpj.order.service.OrderService;
import mpj.order.service.OrderServiceImpl;
import mpj.sales.service.SalesService;
import mpj.sales.service.SalesServiceImpl;

/**
 * Servlet implementation class SalesController
 */
@WebServlet("*.sales")
public class SalesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SalesController() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doAction(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doAction(req, res);
	}
	
	public void doAction(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		
		req.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		
		String url = uri.substring(contextPath.length());
		
		if (url.equals("/host_approvalPay.sales")) {
			
			SalesService sService = new SalesServiceImpl();
			
			sService.host_approvalPay(req, res);
			
			viewPage = "/a/host_approvalPay.jsp";
		}else if(url.equals("/printSalesList.sales")) {
			
			SalesService sService = new SalesServiceImpl();
			
			sService.salesList(req, res);
			sService.finalAccountPro(req, res);
			
			viewPage = "/a/printSalesList.jsp";
		}else if(url.equals("/cust_printSales.sales")) {
			SalesService sService = new SalesServiceImpl();
			
			sService.cust_salesList(req, res);
			
			viewPage = "/a/cust_printSales.jsp";
		}
		
		RequestDispatcher dp = req.getRequestDispatcher(viewPage);
		dp.forward(req, res);
		
	}

}
