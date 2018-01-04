package spring.mvc.myWebProject.order.persistence;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.myWebProject.cart.vo.CartVO;
import spring.mvc.myWebProject.member.vo.MemberVO;
import spring.mvc.myWebProject.order.vo.OrderVO;
import spring.mvc.myWebProject.product.vo.ProductVO;

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
	public ArrayList<OrderVO> getProductMember(Map<String, Object> map2) {
		
		ArrayList<OrderVO> info;
		
		OrderDAO oDao = sqlSession.getMapper(OrderDAO.class);
		
		info = oDao.getProductMember(map2);
		
		return info;
	}

	@Override
	public int insertIntoOrder(OrderVO oVo) {

		int isInsert = 0;

		OrderDAO oDao = sqlSession.getMapper(OrderDAO.class);
		
		isInsert = oDao.insertIntoOrder(oVo);
		
		return isInsert;
	}
	/*
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
	
	*/
	
	@Override
	public int cust_getNumOfOrder(String curr_id) {
		int numOfOrder = 0;
		
		OrderDAO oDao = sqlSession.getMapper(OrderDAO.class);
		
		numOfOrder = oDao.cust_getNumOfOrder(curr_id);
		
		return numOfOrder;	
	}

	@Override
	public ArrayList<OrderVO> cust_getOrderList(Map<String, Object> map) {

		ArrayList<OrderVO> oAry = null;
		
		OrderDAO oDao = sqlSession.getMapper(OrderDAO.class);
		
		oAry = oDao.cust_getOrderList(map);
		
		return oAry;
	}


	@Override
	public ProductVO getProduct(String product_code) {
		
		ProductVO pVo = null;
		
		OrderDAO oDao = sqlSession.getMapper(OrderDAO.class);
		
		pVo = oDao.getProduct(product_code);
		
		return pVo;
	}


	@Override
	public MemberVO getMemberInfo(String id) {
		
		MemberVO mVo = null;
		
		OrderDAO oDao = sqlSession.getMapper(OrderDAO.class);
		
		mVo = oDao.getMemberInfo(id);
		
		return mVo;
	}


	@Override
	public ArrayList<CartVO> getCartContent(String checkedCart) {

		ArrayList<CartVO> cVo = null;
		
		OrderDAO oDao = sqlSession.getMapper(OrderDAO.class);
		
		cVo = oDao.getCartContent(checkedCart);
		
		return cVo;
	}
}
