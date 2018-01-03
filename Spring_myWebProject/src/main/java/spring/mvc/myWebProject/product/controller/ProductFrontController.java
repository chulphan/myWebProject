package spring.mvc.myWebProject.product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mpj.product.service.ProductService;
import mpj.product.service.ProductServiceImpl;

@WebServlet("*.pdt")
public class ProductFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductFrontController() {
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
		
		
		if (url.equals("/host_myAccount.pdt")) {
			
			System.out.println("/host_myAccount.pdt");
			
			ProductService pService = new ProductServiceImpl();
			
			pService.printInvenList(req, res);
			
			
			viewPage = "/a/host_myAccount.jsp";
		}else if(url.equals("/host_addInven.pdt")) {
			System.out.println("/host_addInven.pdt");
			
			viewPage = "/a/host_addInven.jsp";
		}else if(url.equals("/host_addInvenPro.pdt")) {
			System.out.println("/host_addInvenPro.pdt");
			
			ProductService pService = new ProductServiceImpl();
			
			// input 처리 호출
			pService.addInvenPro(req, res);
			
			viewPage = "/a/host_addInvenPro.jsp";
		}else if(url.equals("/host_dltInven.pdt")) {
			System.out.println("/host_dltInven.pdt");
			
			viewPage = "/a/host_dltInven.jsp";
		}else if(url.equals("/host_delInvenPro.pdt")) {
			System.out.println("/host_delInvenPro.pdt");
			
			ProductService pService = new ProductServiceImpl();
			
			pService.delInvenPro(req, res);
			
			viewPage = "/a/host_delInvenPro.jsp";
			
		}else if(url.equals("/host_sltInven.pdt")) {
			System.out.println("/host_sltInven.pdt");
			
			//
			
			viewPage="/a/host_sltInven.jsp";
		}else if(url.equals("/host_sltInvenView.pdt")) {
			System.out.println("/host_sltInvenView.pdt");
			
			
			
			viewPage="/a/host_sltInvenView.jsp";
		}else if(url.equals("/host_sltInvenPro.pdt")) {
			
			System.out.println("/host_sltInvenPro.pdt");
			
			ProductService pService = new ProductServiceImpl();
			
			pService.sltInvenPro(req, res);
			
			viewPage="/a/host_sltInvenPro.jsp";
		}else if(url.equals("/host_udtInven.pdt")) {
			System.out.println("/host_udtInven.pdt");
			
			viewPage ="/a/host_udtInven.jsp";
		}else if(url.equals("/host_udtInvenView.pdt")) {
			System.out.println("/host_udtInvenView.pdt");
			
			ProductService pService = new ProductServiceImpl();
			
			pService.productView(req, res);
			
			viewPage = "/a/host_udtInvenView.jsp";
		}else if(url.equals("/host_udtInvenPro.pdt")) {
			System.out.println("/host_udtInvenPro.pdt");
			
			ProductService pService = new ProductServiceImpl();
			
			pService.udtInvenPro(req, res);
			
			viewPage = "/a/host_udtInvenPro.jsp";
		}
		
		RequestDispatcher dp = req.getRequestDispatcher(viewPage);
		dp.forward(req, res);
	}

}
