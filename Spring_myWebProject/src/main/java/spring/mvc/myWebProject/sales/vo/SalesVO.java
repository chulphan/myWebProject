package spring.mvc.myWebProject.sales.vo;

import java.sql.Timestamp;

import spring.mvc.myWebProject.member.vo.MemberVO;
import spring.mvc.myWebProject.order.vo.OrderVO;
import spring.mvc.myWebProject.product.vo.ProductVO;

public class SalesVO {

	 private String sales_code;
	 private int num;
	 private String id;
	 private String product_code;
	 private int amount;
	 private Timestamp sales_date;
	 private String deliver_status;
	 
	 private MemberVO member;
	 private ProductVO product;
	 private OrderVO order;
	 
	 public SalesVO() {
		 
	 }

	public SalesVO(String sales_code, int num, String id, String product_code, int amount, Timestamp sales_date,
			String deliver_status, MemberVO member, ProductVO product, OrderVO order) {
		super();
		this.sales_code = sales_code;
		this.num = num;
		this.id = id;
		this.product_code = product_code;
		this.amount = amount;
		this.sales_date = sales_date;
		this.deliver_status = deliver_status;
		this.member = member;
		this.product = product;
		this.order = order;
	}

	public String getSales_code() {
		return sales_code;
	}

	public void setSales_code(String sales_code) {
		this.sales_code = sales_code;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Timestamp getSales_date() {
		return sales_date;
	}

	public void setSales_date(Timestamp sales_date) {
		this.sales_date = sales_date;
	}

	public String getDeliver_status() {
		return deliver_status;
	}

	public void setDeliver_status(String deliver_status) {
		this.deliver_status = deliver_status;
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

	public OrderVO getOrder() {
		return order;
	}

	public void setOrder(OrderVO order) {
		this.order = order;
	}
	 
	
	 
}
