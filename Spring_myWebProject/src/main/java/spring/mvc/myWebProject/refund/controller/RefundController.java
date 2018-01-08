package spring.mvc.myWebProject.refund.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mpj.refund.service.RefundService;
import mpj.refund.service.RefundServiceImpl;

/**
 * Servlet implementation class RefundController
 */
@WebServlet("*.refund")
public class RefundController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RefundController() {
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
		
		if (url.equals("/cust_returns.refund")) {
			
			RefundService rService = new RefundServiceImpl();
			
			rService.curt_printRefundList(req, res);
			
			viewPage = "/a/cust_returns.jsp";
		}else if (url.equals("/printRefundList.refund")) {
			// 여기서 환불금액 계산 dao 호출 && 환불목록출력.
			
			RefundService rService = new RefundServiceImpl();
			
			rService.printRefundList(req, res);
			
			viewPage = "/a/printRefundList.jsp";
		}else if (url.equals("/cust_refundPro.refund")) {
			
			RefundService rService = new RefundServiceImpl();
			
			rService.cust_refundPro(req, res);
			
			viewPage = "/a/cust_refundPro.jsp";
		}else if(url.equals("/host_approvalRefundPro.refund")) {
			
			RefundService rService = new RefundServiceImpl();
			
			rService.host_approvalRefundPro(req, res);
			
			viewPage="/a/host_approvalRefundPro.jsp";
		}
		
		RequestDispatcher dp = req.getRequestDispatcher(viewPage);
		dp.forward(req,  res);
	}
}
