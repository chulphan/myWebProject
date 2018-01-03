package spring.mvc.myWebProject.product.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface ProductService {
	
	public void printInvenList(HttpServletRequest req, Model model);
	
	public void addInvenPro(HttpServletRequest req, Model model);
	
	public void delInvenPro(HttpServletRequest req, Model model);
	
	public void sltInvenPro(HttpServletRequest req, Model model);
	
	public void productView(HttpServletRequest req, Model model);
	/*
	public void udtInvenPro(HttpServletRequest req, HttpServletResponse res);
	*/
	
}
