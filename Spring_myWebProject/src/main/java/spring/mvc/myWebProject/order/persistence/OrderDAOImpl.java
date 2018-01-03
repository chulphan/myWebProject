package spring.mvc.myWebProject.order.persistence;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.myWebProject.order.vo.OrderVO;

@Repository
public class OrderDAOImpl  implements OrderDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	public OrderDAOImpl() {

	}
	
	
	@Override
	public int getNumOfOrder() {

		int numOfOrder = 0;
		
		OrderDAO oDao = sqlSession.getMapper(OrderDAO.class);
		
		numOfOrder = oDao.getNumOfOrder();
		
		return numOfOrder;
	}

	@Override
	public OrderVO getOrderContent(String order_code) {

		OrderVO oVo = null;
		
		OrderDAO oDao = sqlSession.getMapper(OrderDAO.class);
		
		oVo = oDao.getOrderContent(order_code);
		
		return oVo;
	}

	@Override
	public ArrayList<OrderVO> getOrderList(Map<String, Object> map) {

		ArrayList<OrderVO> oAry = null;
			
		OrderDAO oDao = sqlSession.getMapper(OrderDAO.class);
		
		oAry = oDao.getOrderList(map);
		
		return oAry;
	}

	@Override
	public ArrayList<Object> getProductMember(Map<String, Object> map2) {
		
		ArrayList<Object> info;
		
		OrderDAO oDao = sqlSession.getMapper(OrderDAO.class);
		
		info = oDao.getProductMember(map2);
		
		return info;
	}

	/*@Override
	public int insertIntoOrder(OrderVO oVo) {

		int isInsert = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "INSERT INTO ORDERS"+
						 " VALUES (?, ORDERS_SEQ.NEXTVAL, ?, ?, ?, ?, ?, 'manager', ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, oVo.getOrder_code());
			pstmt.setString(2, oVo.getProduct_code());
			pstmt.setString(3, oVo.getId());
			pstmt.setInt(4, oVo.getAmountOfPurchase());
			pstmt.setTimestamp(5, oVo.getOrder_date());
			pstmt.setString(6, oVo.getOrder_status());
			pstmt.setInt(7, oVo.getPurchase_price());
			
			isInsert = pstmt.executeUpdate();
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				
				if (pstmt!=null)pstmt.close();
				if (conn!=null)conn.close();
				
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		
		return isInsert;
	}

	@Override
	public ArrayList<String> getIdAndPdtCode(String order_code) {

		String id;
		String product_code;
		ArrayList<String> idAndPdt = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "SELECT ID, PRODUCT_CODE FROM ORDERS WHERE ORDER_CODE=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, order_code);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				idAndPdt = new ArrayList<String>();
				
				id = rs.getString(1);
				product_code = rs.getString(2);
				
				idAndPdt.add(id);
				idAndPdt.add(product_code);
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
		
		return idAndPdt;
	}

	@Override
	public int getNeedAmount(String order_code) {
		
		int needAmount = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "SELECT AMOUNTOFPURCHASE" + 
						 " FROM ORDERS"+
						 " WHERE ORDER_CODE=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, order_code);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				needAmount = rs.getInt(1);
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
		
		return needAmount;
	}

	@Override
	public int deleteOrder(String order_code) {

		int isDelete = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "DELETE FROM ORDERS"+
						 " WHERE ORDER_CODE=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, order_code);
			
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
	public int cust_getNumOfOrder(String curr_id) {
		int numOfOrder = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "SELECT COUNT(*) FROM ORDERS"+
						 " WHERE ID=?"	;
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, curr_id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				numOfOrder = rs.getInt(1);
			}
			
		}catch (SQLException se){
			se.printStackTrace();
		}finally {
			try {
				if (rs!=null)rs.close();
				if (pstmt!=null)pstmt.close();
				if (conn!=null)conn.close();
			}catch (SQLException se){
				se.printStackTrace();
			}
		}
		
		return numOfOrder;	
	}

	@Override
	public ArrayList<OrderVO> cust_getOrderList(String curr_id, int start, int end) {
		OrderVO oVo = null;
		ArrayList<OrderVO> oAry = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = datasource.getConnection();
			
			String sql = "SELECT *" + 
					" FROM (SELECT NUM, ORDER_CODE, PRODUCT_CODE, ID, AMOUNTOFPURCHASE, ORDER_DATE, ORDER_STATUS, PURCHASE_PRICE, ROWNUM NROWS " + 
					"      FROM (SELECT * " + 
					"            FROM ORDERS " + 
					"            ORDER BY NUM ASC" + 
					"        ))" + 
					" WHERE NROWS >= ? AND NROWS <= ?"+
					" AND ID=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			pstmt.setString(3, curr_id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				oAry = new ArrayList<OrderVO>();
				
				do {
					oVo = new OrderVO();
					
					oVo.setNum(rs.getInt(1));
					oVo.setOrder_code(rs.getString(2));
					oVo.setProduct_code(rs.getString(3));
					oVo.setId(rs.getString(4));
					oVo.setAmountOfPurchase(rs.getInt(5));
					oVo.setOrder_date(rs.getTimestamp(6));
					oVo.setOrder_status(rs.getString(7));
					oVo.setSeller_id(rs.getString(8));
					oVo.setPurchase_price(rs.getInt(9));
					
					oAry.add(oVo);
				}while (rs.next()); 
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
		
		return oAry;
	}*/
}
