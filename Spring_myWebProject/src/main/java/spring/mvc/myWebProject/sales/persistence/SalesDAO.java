package spring.mvc.myWebProject.sales.persistence;

import java.util.ArrayList;
import java.util.Map;

import spring.mvc.myWebProject.sales.vo.SalesVO;

public interface SalesDAO {
	public ArrayList<SalesVO> getArticleList(Map<String, Object> map);

	public int	getNumOfSale();
	
	public ArrayList<SalesVO> getOrderInfo(Map<String, Object> co);
	
	public int updateProductAmount(Map<String, Object> map);
	
	public int deleteOrder(String order_code);
	/*
	public SalesVO getSaleContent(String sales_code);
	*/
	
	public int approvalPayPro(SalesVO sVo);
	/*
	public int getFinalAccount();
	*/
	public int cust_getNumOfSale(Map<String, Object> mm);
	
	public ArrayList<SalesVO> cust_getArticleList(Map<String, Object> map);
	/*
	public ArrayList<String> getIdAndPdt(String sales_code);

	public int getRefundAmount(String sales_code);

	public int deleteSales(String sales_code);
	
	public int finalAccount();
	
	public int updateSalesStatus(String sales_code);
	
	public void updateFinalAccount(int finalAccount);

	public void insertFinalAccount(int finalAccount);
*/}
