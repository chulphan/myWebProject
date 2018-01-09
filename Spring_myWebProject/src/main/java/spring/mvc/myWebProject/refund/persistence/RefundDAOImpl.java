package spring.mvc.myWebProject.refund.persistence;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.myWebProject.refund.vo.RefundVO;

@Repository
public class RefundDAOImpl implements RefundDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	public RefundDAOImpl() {

	}
	
	@Override
	public int getNumOfRefund() {
		
		RefundDAO rDao = sqlSession.getMapper(RefundDAO.class);
		
		return rDao.getNumOfRefund();
			
	}

	@Override
	public RefundVO getRefundContent(String refund_code) {
		
		RefundDAO rDao = sqlSession.getMapper(RefundDAO.class);
		
		return rDao.getRefundContent(refund_code);
	}

	@Override
	public ArrayList<RefundVO> printRefundList(Map<String, Object> map) {
		
		RefundDAO rDao = sqlSession.getMapper(RefundDAO.class);
		
		return rDao.printRefundList(map);
	}

	@Override
	public ArrayList<RefundVO> getSalesInfo(Map<String, Object> map) {
		
		RefundDAO rDao = sqlSession.getMapper(RefundDAO.class);
		
		return rDao.getSalesInfo(map);
	}
	
	
	@Override
	public int insertIntoRefund(RefundVO rVo) {
		
		RefundDAO rDao = sqlSession.getMapper(RefundDAO.class);
		
		return rDao.insertIntoRefund(rVo);
	}
	
	@Override
	public int cust_getNumOfRefund(String curr_id) {
		
		RefundDAO rDao = sqlSession.getMapper(RefundDAO.class);
		
		return rDao.cust_getNumOfRefund(curr_id);
	}

	@Override
	public ArrayList<RefundVO> cust_printRefundList(Map<String, Object> map) {

		RefundDAO rDao = sqlSession.getMapper(RefundDAO.class);
		
		return rDao.cust_printRefundList(map);
	}

	@Override
	public ArrayList<RefundVO> getRefundInfo(Map<String, Object> map2) {

		RefundDAO rDao = sqlSession.getMapper(RefundDAO.class);
		
		return rDao.getRefundInfo(map2);
	}

	@Override
	public int updateProductAmount(Map<String, Object> map) {

		RefundDAO rDao = sqlSession.getMapper(RefundDAO.class);
		
		return rDao.updateProductAmount(map);
	}

	@Override
	public int updateRefundStatus(String refund_code) {

		RefundDAO rDao = sqlSession.getMapper(RefundDAO.class);
		
		return rDao.updateRefundStatus(refund_code);
	}

	@Override
	public int deleteSales(String deleteSalesCode) {

		RefundDAO rDao = sqlSession.getMapper(RefundDAO.class);
		
		return rDao.deleteSales(deleteSalesCode);
	}

	@Override
	public int updateFinalAccount(int refundAccount) {

		RefundDAO rDao = sqlSession.getMapper(RefundDAO.class);
		
		return rDao.updateFinalAccount(refundAccount);
	}

}
