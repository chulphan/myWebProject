package spring.mvc.myWebProject.cart.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.myWebProject.cart.vo.CartVO;

@Repository
public class CartDAOImpl implements CartDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	public CartDAOImpl() {

	}
	
	@Override
	public int getNumOfCart() {
		
		int numOfCart = 0;
		
		CartDAO cDao = sqlSession.getMapper(CartDAO.class);
		
		numOfCart = cDao.getNumOfCart();
		
		return numOfCart;
	}

	@Override
	public ArrayList<CartVO> getCartList(Map<String, Object> map) {
		
		ArrayList<CartVO> cVos = null;
		
		CartDAO cDao = sqlSession.getMapper(CartDAO.class);
		
		cVos = cDao.getCartList(map);
		
		return cVos;
	}

	@Override
	public CartVO getCartContent(String cart_id) {
		
		CartVO cVo = null;
		
		CartDAO cDao = sqlSession.getMapper(CartDAO.class);
		
		cVo = cDao.getCartContent(cart_id);
		
		return cVo;
	}
	
	
	@Override
	public int addWishListPro(CartVO cVo) {
		
		int isAdded = 0;
		
		CartDAO cDao = sqlSession.getMapper(CartDAO.class);
		
		isAdded = cDao.addWishListPro(cVo);
		
		return isAdded;
	}
	
	@Override
	public int delWishListPro(Map<String, Object> map) {
		
		int isDeleted = 0;
		
		CartDAO cDao = sqlSession.getMapper(CartDAO.class);
		
		isDeleted = cDao.delWishListPro(map);
		
		return isDeleted;
	}
	/*
	@Override
	public ArrayList<Integer> getCartPrice(String cart_id) {
		
		ArrayList<Integer> priceAndAmount = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "SELECT PRODUCT_PRICE, AMOUNT"+
						 " FROM CART"+
						 " WHERE CART_ID=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cart_id);
			
			if (rs.next()) {
				priceAndAmount = new ArrayList<Integer>();
				
				priceAndAmount.add(rs.getInt(1));
				priceAndAmount.add(rs.getInt(2));
			}
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		
		return priceAndAmount;
	}
	*/
}
