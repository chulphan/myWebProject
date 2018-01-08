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
	/*
	@Override
	public int calRefundAmount() {
		
		int refundAmount = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "SELECT SUM(RFD.REFUND_AMOUNT * PDT.PRODUCT_PRICE)" + 
					" FROM REFUND RFD, PRODUCT PDT" + 
					" WHERE RFD.PRODUCT_CODE=PDT.PRODUCT_CODE";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				refundAmount = rs.getInt(1);
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if (rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		
		return refundAmount;
	}

	@Override
	public ArrayList<String> getIdAndRfd(String refund_code) {

		ArrayList<String> idAndRfd = null;
		String id;
		String product_code;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "SELECT ID, PRODUCT_CODE"+
						 " FROM REFUND" +
						 " WHERE REFUND_CODE=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, refund_code);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				idAndRfd = new ArrayList<String>();
				
				id=rs.getString(1);
				product_code=rs.getString(2);
				
				idAndRfd.add(id);
				idAndRfd.add(product_code);
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		
		return idAndRfd;
	}

	@Override
	public int host_getNumOfRefund(String refund_code) {

		int numOfRefund = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "SELECT REFUND_AMOUNT"+
						 " FROM REFUND"+
						 " WHERE REFUND_CODE=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, refund_code);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				numOfRefund = rs.getInt(1);
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		
		return numOfRefund;
	}

	@Override
	public int updateRefundStatus(String refund_code) {
		
		int isUpdate = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "UPDATE REFUND SET REFUND_STATUS='È¯ºÒ½ÂÀÎ'"+
						 " WHERE REFUND_CODE=?";
			
			pstmt = conn.prepareStatement(sql);
			System.out.println(refund_code + "refund_code in updateRefundStatus");
			pstmt.setString(1, refund_code);
			
			isUpdate = pstmt.executeUpdate();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		
		return isUpdate;
	}
	
	*/

}
