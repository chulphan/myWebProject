package spring.mvc.myWebProject.member.vo;

import java.sql.Timestamp;
import java.util.List;

import spring.mvc.myWebProject.product.vo.ProductVO;

public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String jumin;
	private String email;
	private String address;
	private String hp;
	private Timestamp reg_date;
	
	private List<ProductVO> products;
	
	public MemberVO() {
		
	}
	
	public MemberVO(String id, String pwd, String name, String jumin, String email, String address, String hp, Timestamp reg_date) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.jumin = jumin;
		this.email = email;
		this.address = address;
		this.hp = hp;
		this.reg_date = reg_date;
	}
	
	public void setProducts(List<ProductVO> products) {
		this.products=products;
	}
	
	public List<ProductVO> getProducts(){
		return products;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	
	public Timestamp getReg_date() {
		return reg_date;
	}

	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
}
