package spring.mvc.myWebProject.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.mvc.myWebProject.board.service.BoardService;

@Controller
public class SBoardFrontController {
	
	@Autowired
	BoardService bService;
	
	@RequestMapping(value="boardList", method=RequestMethod.GET)
	public String boardList(HttpServletRequest req, Model model) {
		
		bService.boardList(req, model);
		
		return "/board/boardList";
	}
	
	@RequestMapping(value="writeBoard", method=RequestMethod.GET)
	public String writeBoard(HttpServletRequest req, Model model) {
		
		int num = 0;
		int ref = 1;
		int ref_step = 0;
		int ref_level = 0;
		
		if (req.getParameter("num") != null) {
			num = Integer.parseInt(req.getParameter("num"));
			ref = Integer.parseInt(req.getParameter("ref"));
			ref_step = Integer.parseInt(req.getParameter("ref_step"));
			ref_level = Integer.parseInt(req.getParameter("ref_level"));
		}
		
		model.addAttribute("num", num);
		model.addAttribute("ref", ref);
		model.addAttribute("ref_step", ref_step);
		model.addAttribute("ref_level", ref_level);
		
		
		return "/board/writeBoard";
	}
	
	@RequestMapping(value="writeBoardPro", method=RequestMethod.GET)
	public String writeBoardPro(HttpServletRequest req, Model model) {
		
		bService.writeBoard(req, model);
		
		return "/board/writeBoardPro";
	}
	
	@RequestMapping(value="board_contentForm", method=RequestMethod.GET)
	public String board_contentForm(HttpServletRequest req, Model model) {
		
		bService.board_contentForm(req, model);
		
		return "/board/board_contentForm";
	}
	
	@RequestMapping(value="board_modifyForm", method=RequestMethod.GET)
	public String board_modifyForm(HttpServletRequest req, Model model) {
		
		bService.modifyForm(req, model);
		
		return "/board/board_modifyForm";
	}
	// 12.28 수정까지함.
	@RequestMapping(value="board_modifyPro", method=RequestMethod.POST)
	public String board_modifyPro(HttpServletRequest req, Model model) {
		
		bService.board_modifyPro(req, model);
		
		return "/board/board_modifyPro";
	}
	
	@RequestMapping(value="board_deleteForm", method=RequestMethod.GET)
	public String board_deleteForm(HttpServletRequest req, Model model) {
		
		model.addAttribute("num", req.getParameter("num"));
		model.addAttribute("pageNum", req.getParameter("pageNum"));
		
		return "/board/board_deleteForm";
	}
	
	@RequestMapping(value="board_deletePro", method=RequestMethod.POST)
	public String board_deletePro(HttpServletRequest req, Model model) {
		
		bService.deletePro(req, model);
		
		return "/board/board_deletePro";
	}
}
