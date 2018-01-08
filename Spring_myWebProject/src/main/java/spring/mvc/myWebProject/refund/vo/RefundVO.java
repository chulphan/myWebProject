package spring.mvc.myWebProject.refund.vo;

import java.sql.Timestamp;

import spring.mvc.myWebProject.product.vo.ProductVO;
import spring.mvc.myWebProject.sales.vo.SalesVO;

public class RefundVO {
	private String refund_code;
	private int num;
	private String id;
	private String product_code;
	private int refund_amount;
	private Timestamp refund_date;
	private String refund_status;
	
	private ProductVO product;
	private SalesVO sale;
	
	public RefundVO() {
		
	}

	public RefundVO(String refund_code, int num, String id, String product_code, int refund_amount,
			Timestamp refund_date, String refund_status, ProductVO product, SalesVO sale) {
		super();
		this.refund_code = refund_code;
		this.num = num;
		this.id = id;
		this.product_code = product_code;
		this.refund_amount = refund_amount;
		this.refund_date = refund_date;
		this.refund_status = refund_status;
		this.product = product;
		this.sale = sale;
	}

	public String getRefund_code() {
		return refund_code;
	}

	public void setRefund_code(String refund_code) {
		this.refund_code = refund_code;
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

	public int getRefund_amount() {
		return refund_amount;
	}

	public void setRefund_amount(int refund_amount) {
		this.refund_amount = refund_amount;
	}

	public Timestamp getRefund_date() {
		return refund_date;
	}

	public void setRefund_date(Timestamp refund_date) {
		this.refund_date = refund_date;
	}

	public String getRefund_status() {
		return refund_status;
	}

	public void setRefund_status(String refund_status) {
		this.refund_status = refund_status;
	}

	public ProductVO getProduct() {
		return product;
	}

	public void setProduct(ProductVO product) {
		this.product = product;
	}

	public SalesVO getSale() {
		return sale;
	}

	public void setSale(SalesVO sale) {
		this.sale = sale;
	}
	
	
}
