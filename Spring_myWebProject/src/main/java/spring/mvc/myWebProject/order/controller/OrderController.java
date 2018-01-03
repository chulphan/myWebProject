package spring.mvc.myWebProject.order.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spring.mvc.myWebProject.order.service.OrderService;
import spring.mvc.myWebProject.order.service.OrderServiceImpl;

@WebServlet("*.order")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderController() {
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
		
		if (url.equals("/cust_myAccount.order")) {
			
			// 출력 서비스
			OrderService oService = new OrderServiceImpl();
			oService.cust_orderList(req, res);
			
			viewPage = "/a/cust_myAccount.jsp";
		}else if(url.equals("/buyProductForm.order")) {
			
			OrderService oService = new OrderServiceImpl();
			
			String product_code = req.getParameter("product_code");
			int product_amount = Integer.parseInt(req.getParameter("qty"));
			
			req.setAttribute("product_code", product_code);
			req.setAttribute("product_amount", product_amount);
			
			oService.getProductDetail(req, res);
			
			viewPage = "/a/buyProductForm.jsp";
		}else if(url.equals("/buyProductPro.order")) {
			
			OrderService oService = new OrderServiceImpl();
			
			oService.buyProductPro(req, res);
			
			viewPage = "/a/buyProductPro.jsp";
		}else if(url.equals("/host_manageOrder.order")) {
			
			OrderService oService = new OrderServiceImpl();
			
			oService.orderList(req, res);
			
			viewPage = "/a/host_manageOrder.jsp";
		}else if(url.equals("/buyWishListForm.order")) {
			
			OrderService oService = new OrderServiceImpl();
			
			oService.getCartProductDetail(req, res);
			
			viewPage = "/a/buyWishListForm.jsp";
		}else if(url.equals("/buyWishListProductPro.order")) {
			
			OrderService oService = new OrderServiceImpl();
			
			oService.buyWishProductPro(req, res);
			
			viewPage = "/a/buyWishListProductPro.jsp";
		}
		
		RequestDispatcher dp = req.getRequestDispatcher(viewPage);
		dp.forward(req, res);
		
	}
	
	
}
