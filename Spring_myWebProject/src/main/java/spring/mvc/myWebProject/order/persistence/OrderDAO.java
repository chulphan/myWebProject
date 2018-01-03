package spring.mvc.myWebProject.order.persistence;

import java.util.ArrayList;
import java.util.Map;

import spring.mvc.myWebProject.order.vo.OrderVO;

public interface OrderDAO{
	
	public int getNumOfOrder();
	
	public OrderVO getOrderContent(String order_code);
	
	public ArrayList<OrderVO> getOrderList(Map<String, Object> map);
	
	public ArrayList<Object> getProductMember(Map<String, Object> map2);

	/*public int insertIntoOrder(OrderVO oVo);

	public ArrayList<String> getIdAndPdtCode(String order_code);
	
	public int getNeedAmount(String order_code);
	
	public int deleteOrder(String order_code);

	public int cust_getNumOfOrder(String curr_id);

	public ArrayList<OrderVO> cust_getOrderList(String curr_id, int start, int end);*/
	
	
}
