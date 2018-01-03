package spring.mvc.myWebProject.product.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.myWebProject.product.persistence.ProductDAO;
import spring.mvc.myWebProject.product.vo.ProductVO;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDAO pDao;
	
	public ProductServiceImpl(){
		
	}
	

	@Override
	public void printInvenList(HttpServletRequest req, Model model) {
		
		ArrayList<ProductVO> pVo;
		
		int pageSize = 7;
		int pageBlock= 4;
		
		int cnt = 0;
		int start = 0;
		int end = 0;
		int currentPage = 0;
		int number = 0;
		String pageNum = null;
		
		int pageCount = 0;
		int startPage = 0;
		int endPage = 0;
		
		cnt = pDao.getNumOfProduct();
		System.out.println("cnt www" + cnt);
		pageNum = req.getParameter("pageNum");
		
		if (pageNum == null) {
			pageNum = "1";
		}
		
		currentPage = Integer.parseInt(pageNum);
		
		pageCount = (cnt / pageSize) + ((cnt%pageSize == 0) ? 0 : 1);
		
		start = pageSize * currentPage - 6;
		
		end = start + pageSize - 1;
		
		if (end > cnt) end = cnt;
		
		number = cnt - (currentPage - 1 ) * pageSize;
		
		if (cnt > 0) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("start", start);
			map.put("end", end);
			
			pVo = pDao.getProductList(map);
			model.addAttribute("pVo", pVo);
		}
		
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		
		if (currentPage % pageBlock == 0) startPage -= pageBlock;
		
		endPage = startPage + pageBlock - 1;
		
		if (endPage > pageCount) endPage = pageCount;
		
		model.addAttribute("cnt", cnt);
		model.addAttribute("number", number);
		model.addAttribute("pageNum", pageNum);
		
		if (cnt > 0) {
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("pageBlock", pageBlock);
			model.addAttribute("currentPage", currentPage);
		}
	}
	
	
	@Override
	public void sltInvenPro(HttpServletRequest req, Model model) {
		
		String searchOpt = req.getParameter("searchOpt");
		String searchCode = req.getParameter("searchCode");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("searchOpt", searchOpt);
		map.put("searchCode", searchCode);
		
		ArrayList<ProductVO> pVos = null;
		
		pVos = pDao.searchProduct(map);
		
		req.setAttribute("pVos", pVos);
	}
	
	
	@Override
	public void productView(HttpServletRequest req, Model model) {
		
		String product_code = req.getParameter("product_code");
		ProductVO pVo;
		
		pVo = pDao.detailProduct(product_code);
		
		model.addAttribute("pVo", pVo);
	}
	
	/*
	@Override
	public void udtInvenPro(HttpServletRequest req, HttpServletResponse res) {
		
		MultipartRequest mr = null;
		
		
		
		int maxSize = 10 * 1024 * 1024;
		
		String saveDir = req.getSession().getServletContext().getRealPath("/images/product2/");
		String realDir = "C:\\Dev\\workspace\\WebProject_jsp\\WebContent\\images\\best-sell-images\\afImages";
		
		System.out.println(realDir + "realDir++++++");
		
		String encType="UTF-8";
		
		try {
			
			mr = new MultipartRequest(req, "C:\\Dev\\workspace\\WebProject_jsp\\WebContent\\images\\best-sell-images\\afImages\\temp\\", maxSize, encType, new DefaultFileRenamePolicy());
			
			FileInputStream fis = new FileInputStream("C:\\Dev\\workspace\\WebProject_jsp\\WebContent\\images\\best-sell-images\\afImages\\temp" + mr.getFilesystemName("product_image"));
			FileOutputStream fos = new FileOutputStream(realDir + mr.getFilesystemName("product_image"));
		
			int data = 0;
			
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			
			fis.close();
			fos.close();
			
			ProductVO pVo = new ProductVO();
			
			int num = Integer.parseInt(mr.getParameter("num"));
			String product_code = mr.getParameter("product_code");
			String product_company = mr.getParameter("product_company");
			String product_name = mr.getParameter("product_name");
			int product_price = Integer.parseInt(mr.getParameter("product_price"));
			int product_amount = Integer.parseInt(mr.getParameter("product_amount"));
			String product_image = mr.getFilesystemName("product_image");
			
			pVo.setNum(num);
			pVo.setProduct_code(product_code);
			pVo.setProduct_company(product_company);
			pVo.setProduct_name(product_name);
			pVo.setProduct_price(product_price);
			pVo.setProduct_amount(product_amount);
			pVo.setImg_path(product_image);
			
			ProductDAO pDao = ProductDAOImpl.getInstance();
			
			int isUpdate = pDao.updateProduct(pVo);
			
			req.setAttribute("isUpdate", isUpdate);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	@Override
	public void addInvenPro(HttpServletRequest req, Model model) {
		ProductVO pVo = new ProductVO();
		
		/*MultipartRequest mr = null;
		
		int maxSize=10 * 1024 * 1024;
		String saveDir = req.getSession().getServletContext().getRealPath("/images/best-sell-images/afImages/");
		String realDir = "C:\\Users\\baboa\\Desktop\\Study\\java\\WebProject_jsp\\WebContent\\images\\best-sell-images\\afImages\\";
		*/
		
			
			/*String product_code = mr.getParameter("product_code");
			String product_company = mr.getParameter("product_company");
			String product_name = mr.getParameter("product_name");
			int product_price = Integer.parseInt(mr.getParameter("product_price"));
			int product_amount = Integer.parseInt(mr.getParameter("product_amount"));
			String img_path = mr.getFilesystemName("product_image");
			
			pVo.setProduct_code(product_code);
			pVo.setProduct_company(product_company);
			pVo.setProduct_name(product_name);
			pVo.setProduct_price(product_price);
			pVo.setProduct_amount(product_amount);
			pVo.setImg_path(img_path);
			System.out.println(pVo.getImg_path());
			
			ProductDAO pDao = ProductDAOImpl.getInstance();
			
			int isInsert = pDao.insertProduct(pVo);
			
			req.setAttribute("isInsert", isInsert);
			
		}catch(Exception e) {
			e.printStackTrace();
		}*/
	}
	
	
	@Override
	public void delInvenPro(HttpServletRequest req, Model model) {
		String product_code = req.getParameter("product_code");
		
		int isDelete = pDao.deleteProduct(product_code);
		
		req.setAttribute("isDelete", isDelete);
	}

}
