package spring.mvc.myWebProject.order.vo;

import java.sql.Timestamp;

public class OrderVO {
	private String order_code;
	private int num;
	private String product_code;
	private String id;
	private int amountOfPurchase;
	private String order_status;
	private Timestamp order_date;
	private String seller_id;
	private int purchase_price;
	
	public OrderVO() {
		
	}

	public OrderVO(String order_code, int num, String product_code, String id, int amountOfPurchase,
			String order_status, Timestamp order_date, String seller_id, int purchase_price) {
		this.order_code = order_code;
		this.num = num;
		this.product_code = product_code;
		this.id = id;
		this.amountOfPurchase = amountOfPurchase;
		this.order_status = order_status;
		this.order_date = order_date;
		this.seller_id = seller_id;
		this.purchase_price = purchase_price;
	}



	public String getOrder_code() {
		return order_code;
	}
	
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAmountOfPurchase() {
		return amountOfPurchase;
	}
	
	public void setAmountOfPurchase(int amountOfPurchase) {
		this.amountOfPurchase = amountOfPurchase;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public Timestamp getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public int getPurchase_price() {
		return purchase_price;
	}

	public void setPurchase_price(int purchase_price) {
		this.purchase_price = purchase_price;
	}
	
	
}

