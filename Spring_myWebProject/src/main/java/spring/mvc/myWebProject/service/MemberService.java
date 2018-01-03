package spring.mvc.myWebProject.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface MemberService {
	
	public void confirmId(HttpServletRequest req, Model model);
	
	public void inputPro(HttpServletRequest req, Model model);
	
	public void proLogin(HttpServletRequest req, Model model);
	
	public void deletePro(HttpServletRequest req, Model model);
	
	public void forCheck(HttpServletRequest req, Model model);
	
	public void updateViewPro(HttpServletRequest req, Model model);
	
	public void updatePro(HttpServletRequest req, Model model);
}
