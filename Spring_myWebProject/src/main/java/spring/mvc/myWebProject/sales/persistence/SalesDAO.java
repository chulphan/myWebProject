package spring.mvc.myWebProject.sales.persistence;

import java.util.ArrayList;

import spring.mvc.myWebProject.sales.vo.SalesVO;

public interface SalesDAO {
	public ArrayList<SalesVO> getArticleList(int start, int end);

	public int	getNumOfSale();
	
	public SalesVO getSaleContent(String sales_code);

	public int approvalPayPro(SalesVO sVo);
	
	public int getFinalAccount();

	public int getNumOfSale(String curr_id);

	public ArrayList<SalesVO> getArticleList(String curr_id, int start, int end);

	public ArrayList<String> getIdAndPdt(String sales_code);

	public int getRefundAmount(String sales_code);

	public int deleteSales(String sales_code);
	
	public int finalAccount();
	
	public int updateSalesStatus(String sales_code);
	
	public void updateFinalAccount(int finalAccount);

	public void insertFinalAccount(int finalAccount);
}
