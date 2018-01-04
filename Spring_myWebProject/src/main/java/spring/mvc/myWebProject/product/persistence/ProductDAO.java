package spring.mvc.myWebProject.product.persistence;

import java.util.ArrayList;
import java.util.Map;

import spring.mvc.myWebProject.product.vo.ProductVO;

public interface ProductDAO {
	
	// 글 갯수
	public int getNumOfProduct();
	
	// 게시글 정보들 가져오기
	public ArrayList<ProductVO> getProductList(Map<String, Object> map);
	
	// 재고삽입.
	/*public int insertProduct(ProductVO pVo);*/
	
	public int deleteProduct(String product_code);
	
	public ArrayList<ProductVO> searchProduct(Map<String, Object> map);
	
	public ProductVO detailProduct(String product_code);
	/*
	public int updateProduct(ProductVO pVo);
	
	public int updateProductAmount(String product_code, int product_amount);
	*/
	public int getProductAmount(String product_code);
	
	public int getProductPrice(String product_code);
	
	public ProductVO getProductInfo(String product_code);
	
}
