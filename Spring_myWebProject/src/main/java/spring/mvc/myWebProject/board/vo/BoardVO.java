package spring.mvc.myWebProject.board.vo;

import java.sql.Timestamp;

public class BoardVO {
	private int num;
	private String writer;
	private String pwd;
	private String subject;
	private String content;
	private int readcnt;
	private int ref;
	private int ref_step;
	private int ref_level;
	private Timestamp reg_date;
	private String ip;
	
	public BoardVO() {
		
	}
	
	public BoardVO(int num, String writer, String pwd, String subject, String content, int readcnt, int ref,
			int ref_step, int ref_level, Timestamp reg_date, String ip) {
		this.num = num;
		this.writer = writer;
		this.pwd = pwd;
		this.subject = subject;
		this.content = content;
		this.readcnt = readcnt;
		this.ref = ref;
		this.ref_step = ref_step;
		this.ref_level = ref_level;
		this.reg_date = reg_date;
		this.ip = ip;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getRef_step() {
		return ref_step;
	}

	public void setRef_step(int ref_step) {
		this.ref_step = ref_step;
	}

	public int getRef_level() {
		return ref_level;
	}

	public void setRef_level(int ref_level) {
		this.ref_level = ref_level;
	}

	public Timestamp getReg_date() {
		return reg_date;
	}

	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
}
