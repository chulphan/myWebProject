package spring.mvc.myWebProject.board.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BoardService {
	public void boardList(HttpServletRequest req, Model model);

	public void writeBoard(HttpServletRequest req, Model model);

	public void board_contentForm(HttpServletRequest req, Model model);
	
	public void modifyForm(HttpServletRequest req, Model model);
	
	public void board_modifyPro(HttpServletRequest req, Model model);
	
	public void deletePro(HttpServletRequest req, Model model);
	/*
	public void productList(HttpServletRequest req, HttpServletResponse res);*/
}
