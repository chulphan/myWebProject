package spring.mvc.myWebProject.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mpj.board.service.BoardService;
import mpj.board.service.BoardServiceImpl;
import mpj.order.service.OrderService;
import mpj.order.service.OrderServiceImpl;


@WebServlet("*.board")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardFrontController() {
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
		
		
		// 12.27 boardList 까지함.
		if (url.equals("/boardList.board")) {
			System.out.println("/boardList.board");
			
			BoardService bService = new BoardServiceImpl();
			
			bService.boardList(req, res);
			
			viewPage = "/a/boardList.jsp";
		}else if(url.equals("/writeBoard.board")) {
			System.out.println("/writeBoard.board");
			
			int num = 0;
			int ref = 1;
			int ref_step = 0;
			int ref_level = 0;
			
			if (req.getParameter("num")!=null) {
				num = Integer.parseInt(req.getParameter("num"));
				ref = Integer.parseInt(req.getParameter("ref"));
				ref_step = Integer.parseInt(req.getParameter("ref_step"));
				ref_level = Integer.parseInt(req.getParameter("ref_level"));
			}
			
			req.setAttribute("num", num);
			req.setAttribute("ref", ref);
			req.setAttribute("ref_step", ref_step);
			req.setAttribute("ref_level", ref_level);
			
			viewPage = "/a/writeBoard.jsp";
			
		}else if(url.equals("/writeBoardPro.board")) {
			System.out.println("/writeBoardPro.board");
			
			BoardService bService = new BoardServiceImpl();
			
			bService.writeBoard(req, res);
			
			viewPage = "/a/writeBoardPro.jsp";
		}else if(url.equals("/board_contentForm.board")) {
			System.out.println("/board_contentForm.board");
			
			BoardService bService = new BoardServiceImpl();
			
			bService.board_contentForm(req, res);
			
			viewPage = "/a/board_contentForm.jsp";
		}else if(url.equals("/board_modifyForm.board")) {
			System.out.println("/board_modifyForm.board");
			
			BoardService bService = new BoardServiceImpl();
			
			bService.modifyForm(req, res);
			
			viewPage = "/a/board_modifyForm.jsp";
		}else if(url.equals("/board_modifyPro.board")) {
			System.out.println("/board_modifyPro.board");
			
			BoardService bService = new BoardServiceImpl();
			
			bService.board_modifyPro(req, res);
			
			viewPage = "/a/board_modifyPro.jsp";
		}else if(url.equals("/board_deleteForm.board")) {
			
			// 관리자 같은 경우에 이 곳을 탈 필요가 없게 해야함.
			// contentform 에서 버튼에 케이스를 나눠놔야할 듯.
			// 일단 여기서는 비밀번호를 입력 안받고 삭제하게 해야겠다.
			// 그럼 form 이 필요가 없으니까.. 여긴 거름
			
			viewPage = "/a/board_deleteForm.jsp";
		}else if(url.equals("/board_deletePro.board")) {
			System.out.println("/board_deletePro.board");
			
			BoardService bService = new BoardServiceImpl();
			
			bService.deletePro(req, res);
			
			viewPage = "/a/board_deletePro.jsp";
		}else if (url.equals("/plamodel_lists.board")) {
			
			BoardService bService = new BoardServiceImpl();
			
			bService.productList(req, res);
			
			viewPage = "/a/plamodel_lists.jsp";
		}
		
		RequestDispatcher dp = req.getRequestDispatcher(viewPage);
		dp.forward(req, res);
		
	}
}
