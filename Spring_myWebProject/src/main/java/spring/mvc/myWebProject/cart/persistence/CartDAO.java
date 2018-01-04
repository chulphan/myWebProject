package spring.mvc.myWebProject.cart.persistence;

import java.util.ArrayList;
import java.util.Map;

import spring.mvc.myWebProject.cart.vo.CartVO;
import spring.mvc.myWebProject.product.vo.ProductVO;

public interface CartDAO {
	
	public int getNumOfCart();
	
	public ArrayList<CartVO> getCartList(Map<String, Object> map);
	
	public CartVO getCartContent(String cart_id);
	
	public ProductVO detailProduct(String product_code);
	
	public int addWishListPro(CartVO cVo);
	
	public int delWishListPro(Map<String, Object> map);
	/*
	public ArrayList<Integer> getCartPrice(String cart_id);*/
}
