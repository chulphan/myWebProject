package spring.mvc.myWebProject.sales.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import spring.mvc.myWebProject.sales.vo.SalesVO;

public class SalesDAOImpl implements SalesDAO{
	
	private static SalesDAOImpl sales = new SalesDAOImpl();
	
	DataSource datasource;
	
	public SalesDAOImpl() {
		try {
			
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle12g");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SalesDAOImpl getInstance() {
		return sales;
	}
	
	
	
	@Override
	public ArrayList<SalesVO> getArticleList(int start, int end) {
		
		SalesVO sVo = null;
		ArrayList<SalesVO> sVos = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "SELECT *" +
						 " FROM (SELECT NROWS, NUM, SALES_CODE, ID, AMOUNT, PRODUCT_CODE, SALES_DATE, DELIVER_STATUS" +
						 " FROM (SELECT NUM, SALES_CODE, ID, AMOUNT, PRODUCT_CODE, SALES_DATE, DELIVER_STATUS, ROWNUM NROWS" +
						 "		 FROM SALES" +
						 "  	 ORDER BY NUM ASC" +
						 "	))" +
						 " WHERE NROWS >= ? AND NROWS <= ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				sVos = new ArrayList<SalesVO>();
				
				do {
					
					sVo = new SalesVO();
					
					sVo.setNum(rs.getInt(2));
					sVo.setSales_code(rs.getString(3));
					sVo.setId(rs.getString(4));
					sVo.setAmount(rs.getInt(5));
					sVo.setProduct_code(rs.getString(6));
					sVo.setSales_date(rs.getTimestamp(7));
					sVo.setDeliver_status(rs.getString(8));
					
					sVos.add(sVo);
				}while(rs.next());
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
		return sVos;
	}

	@Override
	public int getNumOfSale() {

		int numOfSale = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "SELECT COUNT(*) FROM SALES";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				numOfSale = rs.getInt(1);
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if (rs!=null)rs.close();
				if (pstmt!=null)pstmt.close();
				if (conn!=null)conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		
		return numOfSale;
	}

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

	@Override
	public int approvalPayPro(SalesVO sVo) {
		
		int isApproval = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "INSERT INTO SALES"+
						 " VALUES(?, SALES_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, sVo.getSales_code());
			pstmt.setString(2, sVo.getId());
			pstmt.setString(3, sVo.getProduct_code());
			pstmt.setInt(4, sVo.getAmount());
			pstmt.setTimestamp(5, sVo.getSales_date());
			pstmt.setString(6, sVo.getDeliver_status());
			
			isApproval = pstmt.executeUpdate();
			
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
		
		return isApproval;
	}

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

	@Override
	public int getNumOfSale(String curr_id) {
		int numOfSale = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "SELECT COUNT(*) FROM SALES"+
						 " WHERE ID=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, curr_id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				numOfSale = rs.getInt(1);
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if (rs!=null)rs.close();
				if (pstmt!=null)pstmt.close();
				if (conn!=null)conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		
		return numOfSale;
	}

	@Override
	public ArrayList<SalesVO> getArticleList(String curr_id, int start, int end) {
			
		SalesVO sVo = null;
		ArrayList<SalesVO> sVos = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "SELECT *" +
						 " FROM (SELECT NROWS, NUM, SALES_CODE, ID, AMOUNT, PRODUCT_CODE, SALES_DATE, DELIVER_STATUS" +
						 " FROM (SELECT NUM, SALES_CODE, ID, AMOUNT, PRODUCT_CODE, SALES_DATE, DELIVER_STATUS, ROWNUM NROWS" +
						 "		 FROM SALES" +
						 "  	 ORDER BY NUM ASC" +
						 "	))" +
						 " WHERE NROWS >= ? AND NROWS <= ?"+
						 " AND ID=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			pstmt.setString(3, curr_id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				sVos = new ArrayList<SalesVO>();
				
				do {
					
					sVo = new SalesVO();
					
					sVo.setNum(rs.getInt(2));
					sVo.setSales_code(rs.getString(3));
					sVo.setId(rs.getString(4));
					sVo.setAmount(rs.getInt(5));
					sVo.setProduct_code(rs.getString(6));
					sVo.setSales_date(rs.getTimestamp(7));
					sVo.setDeliver_status(rs.getString(8));
					
					sVos.add(sVo);
				}while(rs.next());
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
		return sVos;
	}

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

	
		
}
