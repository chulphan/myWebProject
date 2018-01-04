package spring.mvc.myWebProject.cart.vo;

import spring.mvc.myWebProject.member.vo.MemberVO;
import spring.mvc.myWebProject.product.vo.ProductVO;

public class CartVO {
	private String cart_id;
	private int num;
	private String id;
	private String product_code;
	private int amount;
	
	private MemberVO member;
	private ProductVO product;
	
	public CartVO() {
		
	}
	
	public CartVO(String cart_id, int num, String id, String product_code, int amount,
					MemberVO member, ProductVO product) {
		this.cart_id = cart_id;
		this.num = num;
		this.id = id;
		this.product_code = product_code;
		this.amount = amount;
		this.member = member;
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCart_id() {
		return cart_id;
	}

	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public MemberVO getMember() {
		return member;
	}

	public void setMember(MemberVO member) {
		this.member = member;
	}

	public ProductVO getProduct() {
		return product;
	}

	public void setProduct(ProductVO product) {
		this.product = product;
	}
	
	
}
