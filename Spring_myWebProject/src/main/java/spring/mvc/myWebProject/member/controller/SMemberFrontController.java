package spring.mvc.myWebProject.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.mvc.myWebProject.service.MemberService;

@Controller
public class SMemberFrontController {
	
	@Autowired
	MemberService mService;
	
	@RequestMapping(value="main", method=RequestMethod.GET)
	public String main(Model model) {
		
		model.addAttribute("cnt", 2);
		model.addAttribute("curr_id", null);
		
		return "/main/main";
	}
	
	@RequestMapping(value="common_myAccount", method=RequestMethod.GET)
	public String common_myAccount(Model model) {
		
		model.addAttribute("isCheck", 0);
		
		return "/member/common_myAccount";
	}
	
	@RequestMapping(value="joinUs", method=RequestMethod.GET)
	public String joinUs(Model model) {
		
		return "/member/joinUs";
	}
	
	@RequestMapping(value="joinUsPro", method=RequestMethod.POST)
	public String joinUsPro(HttpServletRequest req, Model model) {
		
		mService.inputPro(req, model);
		
		return "/member/joinUsPro";
	}
	
	@RequestMapping(value="confirmId", method=RequestMethod.GET)
	public String confirmId(HttpServletRequest req, Model model) {
		
		mService.confirmId(req, model);
		
		return "/member/confirmId";
	}
	
	@RequestMapping(value="mainSuccess", method=RequestMethod.GET)
	public String mainSuccess(Model model) {
		
		return "/main/main";
	}
	
	@RequestMapping(value="loginPro", method=RequestMethod.POST)
	public String loginPro(HttpServletRequest req, Model model) {
		
		mService.proLogin(req, model);
		
		return "/member/common_myAccount";
	}
	
	@RequestMapping(value="loginSuccess", method=RequestMethod.GET)
	public String loginSuccess(Model model) {
		
		return "/main/main";
	}
	
	/*@RequestMapping(value="host_myAccount", method=RequestMethod.GET)
	public String host_myAccount(Model model) {
		
		return "/product/host_myAccount";
	}*/
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest req, Model model) {
		
		req.getSession().invalidate();
		
		return "/main/main";
	}
	
	@RequestMapping(value="cust_beforeAccountSet", method=RequestMethod.GET)
	public String cust_beforeAccountSet(Model model) {
		
		return "/member/cust_beforeAccountSet";
	}
	
	@RequestMapping(value="cust_beforeAccountSetPro", method = RequestMethod.POST)
	public String cust_beforeAccountSetPro(HttpServletRequest req, Model model) {
		
		mService.forCheck(req, model);
		
		return "/member/cust_beforeAccountSetPro";
	}
	
	@RequestMapping(value="cust_accountSetting", method=RequestMethod.GET)
	public String cust_accountSetting(HttpServletRequest req, Model model) {
		
		mService.updateViewPro(req, model);
		
		return "/member/cust_accountSetting";
	}
	
	@RequestMapping(value="cust_completeUpdate", method=RequestMethod.POST)
	public String cust_completeUpdate(HttpServletRequest req, Model model) {
		
		mService.updatePro(req, model);
		
		return "/member/cust_completeUpdate";
	}
	
	@RequestMapping(value="cust_deletePro", method=RequestMethod.POST)
	public String cust_deletePro(HttpServletRequest req, Model model) {
		
		mService.deletePro(req, model);
		
		return "/member/cust_deletePro";
	}
}
