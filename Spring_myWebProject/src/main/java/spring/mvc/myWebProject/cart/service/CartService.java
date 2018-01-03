package spring.mvc.myWebProject.cart.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface CartService {
	public void cartList(HttpServletRequest req, Model model);

	public void addWishList(HttpServletRequest req, Model model);
	
	public void delWishList(HttpServletRequest req, Model model);
}
