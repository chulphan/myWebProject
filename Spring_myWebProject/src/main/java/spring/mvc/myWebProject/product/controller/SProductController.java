package spring.mvc.myWebProject.product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import spring.mvc.myWebProject.product.service.ProductService;
import spring.mvc.myWebProject.product.vo.ProductVO;

@Controller
public class SProductController {

	@Autowired
	ProductService pService;
	
	// 12.29 파일업로드 직전까지 함.
	// for File upload.
	@RequestMapping(value="upload", method=RequestMethod.POST)
	public String upload(ProductVO pVo, Model model) throws Exception{
		
		String msg = "";
		MultipartFile file = pVo.getFile();
		
		if (file != null) {
			String fileName = pVo.getImg_name();
			
			try {
				
				String path = "C:\\Users\\baboa\\Desktop\\Study\\java\\Spring_myWebProject\\src\\main\\webapp\\resources\\images";
				File file2 = new File(path + fileName + ".jpg");
				file.transferTo(file2);
				model.addAttribute("img_name", fileName);
				msg="file upload is successed";
			}catch(IOException e) {
				e.printStackTrace();
				msg = "file upload is failed";
			}
		}else {
			msg = "conncted is failed or not exist choose the file";
		}
		
		model.addAttribute("msg", msg);
		return "/product/upload";
	}
	
	@RequestMapping(value="host_myAccount", method=RequestMethod.GET)
	public String host_myAccount(HttpServletRequest req, Model model) {
		
		pService.printInvenList(req, model);
		
		return "/product/host_myAccount";
	}
	
	@RequestMapping(value="host_addInven", method=RequestMethod.GET)
	public String host_addInven(HttpServletRequest req, Model model) {
		
		return "/product/host_addInven";
	}
	
	@RequestMapping(value="host_addInvenPro", method=RequestMethod.POST)
	public String host_addInvenPro(HttpServletRequest req, Model model) {
		
		return "/product/host_addInvenPro";
	}
	
	@RequestMapping(value="host_dltInven", method=RequestMethod.GET)
	public String host_dltInven(HttpServletRequest req, Model model) {
		
		return "/product/host_dltInven";
	}
	
	@RequestMapping(value="host_delInvenPro", method=RequestMethod.POST)
	public String host_delInvenPro(HttpServletRequest req, Model model) {
		
		pService.delInvenPro(req, model);
		
		return "/product/host_delInvenPro";
	}
	
	@RequestMapping(value="host_sltInven", method=RequestMethod.GET)
	public String host_sltInven(HttpServletRequest req, Model model) {
		
		return "/product/host_sltInven";
	}
	
	@RequestMapping(value="host_sltInvenView", method=RequestMethod.GET)
	public String host_sltInvenView(HttpServletRequest req, Model model) {
		
		return "/product/host_sltInvenView";
	}
	
	@RequestMapping(value="host_sltInvenPro", method=RequestMethod.GET)
	public String host_sltInvenPro(HttpServletRequest req, Model model) {
		
		pService.sltInvenPro(req, model);
		
		return "/product/host_sltInvenPro";
	}
	
	@RequestMapping(value="host_udtInven", method=RequestMethod.GET)
	public String host_udtInven(HttpServletRequest req, Model model) {
		
		return "/product/host_udtInven";
	}
	
	@RequestMapping(value="host_udtInvenView", method=RequestMethod.POST)
	public String host_udtInvenView(HttpServletRequest req, Model model) {
		
		//pService.productView();
		
		return "/product/host_udtInvenView";
	}
	
	@RequestMapping(value="host_udtInvenPro", method=RequestMethod.POST)
	public String host_udtInvenPro(HttpServletRequest req, Model model) {
		
		//pService.udtInvenPro();
		
		return "/product/host_udtInvenPro";
	}
}
