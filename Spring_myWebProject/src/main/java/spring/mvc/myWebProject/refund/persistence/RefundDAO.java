package spring.mvc.myWebProject.refund.persistence;

import java.util.ArrayList;
import java.util.Map;

import spring.mvc.myWebProject.refund.vo.RefundVO;

public interface RefundDAO {
	
	public int getNumOfRefund();
	
	public RefundVO getRefundContent(String refund_code);
	
	public ArrayList<RefundVO> printRefundList(Map<String, Object> map);
	
	public ArrayList<RefundVO> getSalesInfo(Map<String, Object> map);
	
	public int insertIntoRefund(RefundVO rVo);
	
	public int cust_getNumOfRefund(String curr_id);

	public ArrayList<RefundVO> cust_printRefundList(Map<String, Object> map);
	
	public ArrayList<RefundVO> getRefundInfo(Map<String, Object> map2);
	
	public int updateProductAmount(Map<String, Object> map);
	
	public int updateRefundStatus(String refund_code);
	
	public int deleteSales(String deleteSalesCode);
	
	public int updateFinalAccount(int refundAccount);
}
