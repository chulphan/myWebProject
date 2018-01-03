package spring.mvc.myWebProject.cart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mpj.cart.service.CartService;
import mpj.cart.service.CartServiceImpl;

/**
 * Servlet implementation class CartController
 */
@WebServlet("*.cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartController() {
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
		
		if (url.equals("/cust_wishlists.cart")) {
			
			// call print service.
			CartService cService = new CartServiceImpl();
			cService.cartList(req, res);
			
			viewPage = "/a/cust_wishlists.jsp";
		}else if(url.equals("/addWishList.cart")) {
			
			CartService cService = new CartServiceImpl();
			
			cService.addWishList(req, res);
			
			viewPage = "/a/addWishList.jsp";
			
		}else if(url.equals("/deleteWishList.cart")) {
			CartService cService = new CartServiceImpl();
			
			cService.delWishList(req, res);
			
			viewPage = "/a/delWishList.jsp";
		}
		
		RequestDispatcher dp = req.getRequestDispatcher(viewPage);
		dp.forward(req, res);
		
	}
}
