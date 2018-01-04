package spring.mvc.myWebProject.order.persistence;

import java.util.ArrayList;
import java.util.Map;

import spring.mvc.myWebProject.cart.vo.CartVO;
import spring.mvc.myWebProject.member.vo.MemberVO;
import spring.mvc.myWebProject.order.vo.OrderVO;
import spring.mvc.myWebProject.product.vo.ProductVO;

public interface OrderDAO{
	
	public int getNumOfOrder();
	
	public OrderVO getOrderContent(String order_code);
	
	public ArrayList<OrderVO> getOrderList(Map<String, Object> map);
	
	public ArrayList<OrderVO> getProductMember(Map<String, Object> map2);

	public int insertIntoOrder(OrderVO oVo);
	/*
	public ArrayList<String> getIdAndPdtCode(String order_code);
	
	public int getNeedAmount(String order_code);
	
	public int deleteOrder(String order_code);
	*/
	
	public int cust_getNumOfOrder(String curr_id);

	public ArrayList<OrderVO> cust_getOrderList(Map<String, Object> map);
	
	public ProductVO getProduct(String product_code);
	
	public MemberVO getMemberInfo(String id);
	
	public ArrayList<CartVO> getCartContent(String checkedCart);
}
