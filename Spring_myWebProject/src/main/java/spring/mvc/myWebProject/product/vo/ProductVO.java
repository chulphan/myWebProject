package spring.mvc.myWebProject.product.vo;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {
	private int num;
	private String product_code;
	private String product_company;
	private String product_name;
	private int product_price;
	private int product_amount;
	private String img_name;
	
	private MultipartFile file;
	
	public ProductVO() {
		
	}
	
	public ProductVO(int num, String product_code, String product_company, String product_name, int product_price,
			int product_amount, String img_name, MultipartFile file) {
		super();
		this.num = num; // 지울까말까
		this.product_code = product_code;
		this.product_company = product_company;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_amount = product_amount;
		this.img_name = img_name;
		this.file = file;
	}
	
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	public MultipartFile getFile() {
		return file;
	}
	
	public String getImg_name() {
		return img_name;
	}
	
	
	public void setImg_name(String img_name) {
		this.img_name = img_name;
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


	public String getProduct_company() {
		return product_company;
	}


	public void setProduct_company(String product_company) {
		this.product_company = product_company;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public int getProduct_price() {
		return product_price;
	}


	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}


	public int getProduct_amount() {
		return product_amount;
	}


	public void setProduct_amount(int product_amount) {
		this.product_amount = product_amount;
	}
	
	
	
	
}
