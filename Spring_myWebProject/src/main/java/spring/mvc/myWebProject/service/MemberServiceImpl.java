package spring.mvc.myWebProject.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.myWebProject.member.persistence.MemberPersistence;
import spring.mvc.myWebProject.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberPersistence pers;
	
	@Override
	public void confirmId(HttpServletRequest req, Model model) {
		// curr_id : id input창에 쓴 아이디.
		String curr_id = req.getParameter("id");
		
		// isDupl == 1 -> 이미 아이디 있음
		// isDupl == 0 -> 아이디 없음  즉, 입력한 아이디로 회원가입 가능.
		int isDupl = pers.checkDupl(curr_id);
		
		/*req.setAttribute("isDupl", isDupl);
		req.setAttribute("curr_id", curr_id);*/
		
		model.addAttribute("isDupl", isDupl);
		model.addAttribute("curr_id", curr_id);
	}
	
	
	@Override
	public void inputPro(HttpServletRequest req, Model model) {
		
		MemberVO vo = new MemberVO();
		
		vo.setId(req.getParameter("juser_id"));
		vo.setPwd(req.getParameter("juser_pw"));
		vo.setName(req.getParameter("juser_name"));
		vo.setJumin(req.getParameter("juser_birth"));
		vo.setEmail(req.getParameter("juser_email"));
		vo.setAddress(req.getParameter("juser_address"));
		vo.setHp(req.getParameter("juser_phone"));
		vo.setReg_date(new Timestamp(System.currentTimeMillis()));
		
		int isInsert = pers.proJoinUser(vo);
		
		req.setAttribute("isInsert", isInsert);
	}

	
	@Override
	public void proLogin(HttpServletRequest req, Model model) {
		
		String curr_id = req.getParameter("login_id");
		String curr_pwd = req.getParameter("login_pw");
		
		int isCheck = pers.checkLogin(curr_id, curr_pwd);
		System.out.println("isCheck in proLogin" + isCheck);
		/*req.setAttribute("isCheck", isCheck);*/
		model.addAttribute("isCheck", isCheck);
		if (isCheck > 0) {
			req.getSession().setAttribute("curr_id", curr_id);
		}
	}

	
	@Override
	public void deletePro(HttpServletRequest req, Model model) {
		String curr_id = (String) req.getSession().getAttribute("curr_id");
		String curr_pw =  req.getParameter("suser_pw");
		
		
		int isDelete = 0;
		int isCheck = pers.checkLogin(curr_id, curr_pw);
		
		if (isCheck == 1) {
			isDelete = pers.proDropUser(curr_id);
		}
		
		req.setAttribute("isCheck", isCheck);
		req.setAttribute("isDelete", isDelete);
	}
	

	@Override
	public void forCheck(HttpServletRequest req, Model model) {
		String curr_id = (String) req.getSession().getAttribute("curr_id");
		String curr_pw = (String) req.getAttribute("pw");
		
		int isCheck = pers.checkLogin(curr_id, curr_pw);
		
		model.addAttribute("isCheck", isCheck);
	}

	
	@Override
	public void updateViewPro(HttpServletRequest req, Model model) {
		MemberVO curr_vo = null;
		String curr_id = (String) req.getSession().getAttribute("curr_id");
		
		curr_vo = pers.getCustInfo(curr_id);
		
		/*req.setAttribute("curr_vo", curr_vo);*/
		
		model.addAttribute("curr_vo", curr_vo);
	}

	
	@Override
	public void updatePro(HttpServletRequest req, Model model) {
		MemberVO curr_vo = null;
		String curr_id = (String) req.getSession().getAttribute("curr_id");
		
		curr_vo = pers.getCustInfo(curr_id);
		
		curr_vo.setPwd(req.getParameter("suser_pw"));
		curr_vo.setEmail(req.getParameter("suser_email"));
		curr_vo.setAddress(req.getParameter("suser_address"));
		curr_vo.setHp(req.getParameter("suser_phone"));
		
		int isUpdate = pers.proUpdate(curr_vo);
		
		req.setAttribute("isUpdate", isUpdate);
	}
}
