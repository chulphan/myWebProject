package spring.mvc.myWebProject.sales.persistence;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.myWebProject.sales.vo.SalesVO;

@Repository
public class SalesDAOImpl implements SalesDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	public SalesDAOImpl() {

	}
	
	@Override
	public ArrayList<SalesVO> getArticleList(Map<String, Object> map) {
		
		ArrayList<SalesVO> sVos = null;
		
		SalesDAO sDao = sqlSession.getMapper(SalesDAO.class);
		
		sVos = sDao.getArticleList(map);
			
		return sVos;
	}

	@Override
	public int getNumOfSale() {

		int numOfSale = 0;
		
		SalesDAO sDao = sqlSession.getMapper(SalesDAO.class);
		
		numOfSale = sDao.getNumOfSale();
		
		return numOfSale;
	}
/*
	@Override
	public SalesVO getSaleContent(String sales_code) {
		
		SalesVO sVo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "SELECT *"+
						 " FROM SALES"+
						 " WHERE SALES_CODE=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, sales_code);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				sVo = new SalesVO();
				
				sVo.setNum(rs.getInt(2));
				sVo.setSales_code(rs.getString(1));
				sVo.setId(rs.getString(3));
				sVo.setProduct_code(rs.getString(4));
				sVo.setAmount(rs.getInt(5));
				sVo.setSales_date(rs.getTimestamp(6));
				sVo.setDeliver_status(rs.getString(7));
			}
		}catch (SQLException se) {
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
		return sVo;
	}
	*/
	
	@Override
	public int approvalPayPro(SalesVO sVo) {
		
		SalesDAO sDao = sqlSession.getMapper(SalesDAO.class);
		
		return sDao.approvalPayPro(sVo);
	}
	
	/*
	@Override
	public int getFinalAccount() {
		
		int finalAccount = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "select sum (pdt.product_price * sls.amount)" + 
					" from product pdt, sales sls" + 
					" where pdt.product_code = sls.product_code"+
					" and sls.deliver_status=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "거래완료");
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				finalAccount = rs.getInt(1);
				System.out.println(finalAccount);
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
		
		return finalAccount;
	}
	*/
	
	@Override
	public int cust_getNumOfSale(Map<String, Object> mm) {

		SalesDAO sDao = sqlSession.getMapper(SalesDAO.class);
		
		return sDao.cust_getNumOfSale(mm);
	}
	
	
	@Override
	public ArrayList<SalesVO> cust_getArticleList(Map<String, Object> map) {
			
		SalesDAO sDao = sqlSession.getMapper(SalesDAO.class);
		
		return sDao.cust_getArticleList(map);
	}
	/*
	@Override
	public ArrayList<String> getIdAndPdt(String sales_code) {

		ArrayList<String> idAndPdt = null;
		String id;
		String product_code;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "SELECT id, product_code" + 
						 " FROM SALES"+
						 " WHERE SALES_CODE=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, sales_code);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				idAndPdt = new ArrayList<String>();
				
				id = rs.getString(1);
				product_code = rs.getString(2);
				
				idAndPdt.add(id);
				idAndPdt.add(product_code);
			}
			
		}catch(SQLException se) {
			
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		
		return idAndPdt;
	}

	@Override
	public int getRefundAmount(String sales_code) {
		int numOfRefund = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "SELECT AMOUNT"+
						 " FROM SALES"+
						 " WHERE SALES_CODE=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, sales_code);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				numOfRefund=rs.getInt(1);
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
	public int deleteSales(String sales_code) {

		int isDelete = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "DELETE FROM SALES"+
						 " WHERE SALES_CODE=?";
			
			pstmt = conn.prepareStatement(sql);
			System.out.println(sales_code + "sales_code in daleteSales");
			pstmt.setString(1, sales_code);
			
			isDelete = pstmt.executeUpdate();
			
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
		
		return isDelete;
	}

	@Override
	public int finalAccount() {

		int finalAccount = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "SELECT SUM(PDT.PRODUCT_PRICE * SLS.AMOUNT)"+
						 " FROM SALES SLS, PRODUCT PDT"+
						 " WHERE SLS.PRODUCT_CODE=PDT.PRODUCT_CODE"+
						 " AND SLS.DELIVER_STATUS=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "in shipping");
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				finalAccount = rs.getInt(1);
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
		
		return finalAccount;
	}

	@Override
	public void updateFinalAccount(int finalAccount) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "UPDATE FINAL_ACCOUNT"+
						 " SET FINALACCOUNT=?"+
						 " WHERE NUM=?";
		
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, finalAccount);
			pstmt.setInt(2, 1);
			
			pstmt.executeUpdate();
			
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
	}

	@Override
	public void insertFinalAccount(int finalAccount) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = datasource.getConnection();
			
			String sql = "INSERT INTO FINAL_ACCOUNT"+
						 " VALUES(1, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, finalAccount);
			
			pstmt.executeUpdate();
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
	}

	@Override
	public int updateSalesStatus(String sales_code) {
		
		int isUpdateStatus = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "UPDATE SALES"+
						 " SET SALES_STATUS=?"+
						 " WHERE SALES_CODE=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "환불완료");
			pstmt.setString(2, sales_code);
			
			isUpdateStatus = pstmt.executeUpdate();
			
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
				
		return isUpdateStatus;
	}

	*/

	@Override
	public ArrayList<SalesVO> getOrderInfo(Map<String, Object> cc) {
		
		SalesDAO sDao = sqlSession.getMapper(SalesDAO.class);
		
		return sDao.getOrderInfo(cc);
	}

	@Override
	public int updateProductAmount(Map<String, Object> map) {

		SalesDAO sDao = sqlSession.getMapper(SalesDAO.class);
		
		return sDao.updateProductAmount(map);
	}

	@Override
	public int deleteOrder(String order_code) {

		SalesDAO sDao = sqlSession.getMapper(SalesDAO.class);
		
		return sDao.deleteOrder(order_code);
	}
		
}
