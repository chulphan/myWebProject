package spring.mvc.myWebProject.member.persistence;

import spring.mvc.myWebProject.member.vo.MemberVO;

public interface MemberPersistence {
	public int checkDupl(String id);
	
	public int proJoinUser(MemberVO vo);
	
	public int checkLogin(String id, String pw);
	
	public String getPwd(String id);

	public int proDropUser(String id);

	public MemberVO getCustInfo(String id);
	
	public int proUpdate(MemberVO vo);
}
