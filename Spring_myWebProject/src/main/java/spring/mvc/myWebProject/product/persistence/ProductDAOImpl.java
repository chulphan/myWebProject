package spring.mvc.myWebProject.product.persistence;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.myWebProject.product.vo.ProductVO;

@Repository
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	SqlSession sqlSession;
	
		
	
	public ProductDAOImpl() {

	}
	
	

	@Override
	public int getNumOfProduct() {
		
		int numOfProduct = 0;
		
		ProductDAO pDao = sqlSession.getMapper(ProductDAO.class);
		
		numOfProduct = pDao.getNumOfProduct();
		
		return numOfProduct;
	}

	@Override
	public ArrayList<ProductVO> getProductList(Map<String, Object> map) {
		
		ArrayList<ProductVO> pVos = null;
		
		ProductDAO pDao = sqlSession.getMapper(ProductDAO.class);
		
		pVos = pDao.getProductList(map);
		
		return pVos;
	}

	@Override
	public ArrayList<ProductVO> searchProduct(Map<String, Object> map) {
		
		ArrayList<ProductVO> pVos = new ArrayList<ProductVO>();

		ProductDAO pDao = sqlSession.getMapper(ProductDAO.class);
		
		pVos = pDao.searchProduct(map);
		
		return pVos;
	}
	
	@Override
	public ProductVO detailProduct(String product_code) {
		
		ProductVO pVo = null;
		
		ProductDAO pDao = sqlSession.getMapper(ProductDAO.class);
		
		pVo = pDao.detailProduct(product_code);
		
		return pVo;
	}
	/*
	@Override
	public int updateProduct(ProductVO pVo) {
		
		int isUpdate = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = datasource.getConnection();
			
			String sql = "UPDATE PRODUCT SET PRODUCT_COMPANY=?, PRODUCT_NAME=?, PRODUCT_PRICE=?, PRODUCT_AMOUNT=?, IMG_PATH=? WHERE PRODUCT_CODE=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pVo.getProduct_company());
			pstmt.setString(2, pVo.getProduct_name());
			pstmt.setInt(3, pVo.getProduct_price());
			pstmt.setInt(4, pVo.getProduct_amount());
			pstmt.setString(5, pVo.getImg_path());
			pstmt.setString(6, pVo.getProduct_code());
			
			isUpdate = pstmt.executeUpdate();
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if (pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		
		return isUpdate;
	}

	@Override
	public int updateProductAmount(String product_code, int product_amount) {

		int isUpdate = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = datasource.getConnection();
			
			String sql = "UPDATE PRODUCT SET PRODUCT_AMOUNT=?"+
						 " WHERE PRODUCT_CODE=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, product_amount);
			pstmt.setString(2, product_code);
			
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
	
	@Override
	public int getProductAmount(String product_code) {
		
		int product_amount = 0;
		
		ProductDAO pDao = sqlSession.getMapper(ProductDAO.class);
		
		product_amount = pDao.getProductAmount(product_code);
		
		return product_amount;
	}
	
	@Override
	public int getProductPrice(String product_code) {

		int product_price = 0;
		
		ProductDAO pDao = sqlSession.getMapper(ProductDAO.class);
		
		product_price = pDao.getProductPrice(product_code);
		
		return product_price;
	}
	
	/*
	@Override
	public int insertProduct(ProductVO pVo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int isInsert = 0;
		
		try {
			conn = datasource.getConnection();
			
			String sql = "INSERT INTO PRODUCT VALUES(PRODUCT_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pVo.getNum());
			pstmt.setString(1, pVo.getProduct_code());
			pstmt.setString(2, pVo.getProduct_company());
			pstmt.setString(3, pVo.getProduct_name());
			pstmt.setInt(4, pVo.getProduct_price());
			pstmt.setInt(5, pVo.getProduct_amount());
			pstmt.setString(6, pVo.getImg_path());
			
			isInsert = pstmt.executeUpdate();
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if (pstmt!=null) pstmt.close();
				if (conn != null) conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		return isInsert;
	}
	*/
	@Override
	public int deleteProduct(String product_code) {
		
		int isDelete = 0;
		
		ProductDAO pDao = sqlSession.getMapper(ProductDAO.class);
		
		isDelete = pDao.deleteProduct(product_code);
		
		return isDelete;
	}



	@Override
	public ProductVO getProductInfo(String product_code) {
		
		ProductVO pVo = null;
		
		ProductDAO pDao = sqlSession.getMapper(ProductDAO.class);
		
		pVo = pDao.getProductInfo(product_code);
		
		return pVo;
	}

}
