package spring.mvc.myWebProject.cart.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.mvc.myWebProject.cart.service.CartService;

@Controller
public class SCartController {

	@Autowired
	CartService cService;

	@RequestMapping(value = "cust_wishlists", method = RequestMethod.GET)
	public String cust_wishlists(HttpServletRequest req, Model model) {

		cService.cartList(req, model);

		return "/cart/cust_wishlists";
	}

	@RequestMapping(value = "addWishList", method = RequestMethod.GET)
	public String addWishList(HttpServletRequest req, Model model) {

		cService.addWishList(req, model);

		return "/cart/addWishList";
	}

	@RequestMapping(value = "deleteWishList", method = RequestMethod.GET)
	public String delWishList(HttpServletRequest req, Model model) {

		cService.delWishList(req, model);

		return "/cart/delWishList";
	}

}
