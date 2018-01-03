package spring.mvc.myWebProject.board.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.myWebProject.board.persistence.BoardDAO;
import spring.mvc.myWebProject.board.persistence.BoardDAOImpl;
import spring.mvc.myWebProject.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAO bDao;
	
	@Override
	public void boardList(HttpServletRequest req, Model model) {
		ArrayList<BoardVO> bVos;
		
		int pageSize = 8; 		// �� �������� ����� �� ���� 
		int pageBlock = 4;		// �� ���� ������ ����
		
		int cnt = 0;			// �� ����
		int start = 0;			// ���� ������ ���۹�ȣ 1
		int end = 0;			// ���� �������� ������ �۹�ȣ
		int currentPage = 0;	// ���� ������
		int number = 0;			// ����� �� ��ȣ
		String pageNum = null; 	// ������ ��ȣ
		
		int pageCount = 0;		// ������ ����
		int startPage = 0;		// �ش� ������ ���� ���۹�ȣ. ex) [1] [2] [3] �� �ִٸ� ���۹�ȣ�� [1].
		int endPage = 0;		// �ش� ������ ���� ������ ��ȣ			ex) [1] [2] [3] �� �ִٸ� ������ �������� [3]
		
		// �� ���� ���ϱ�.
		cnt = bDao.getNumOfArticle();
		
		pageNum = req.getParameter("pageNum");
		
		if (pageNum == null) {
			pageNum = "1"; // ù �������� 1�� ����.
		}
		
		currentPage = Integer.parseInt(pageNum);
		
		pageCount = (cnt / pageSize) + ((cnt % pageSize == 0) ? 0 : 1);
	
		start = pageSize *  currentPage  - 7; // ���� ������ ���� ���� ���۹�ȣ
		
		end = pageSize * currentPage; // ���� ������ ����ȣ (<==> pageSize * currentPage)
		
		
		if (end > cnt) end = cnt; // �۵��� ���� �Ǿ����� end != cnt.
		
		number = cnt - (currentPage-1) * pageSize; // ����� �� ��ȣ
		
		
		if (cnt > 0) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("start", start);
			map.put("end", end);
			
			bVos = bDao.getArticleList(map);
			model.addAttribute("bVos", bVos);
		}
		
		startPage = (currentPage / pageBlock) * pageBlock + 1; 
		
		if (currentPage % pageBlock == 0) startPage -= pageBlock; // [1][2][3] ������ ��� [1]��, [4][5][6] ������ ��� [4] �� ����.
		
		endPage = startPage + pageBlock - 1; 
		
		if (endPage > pageCount) endPage = pageCount;  // �̷� ���� ���� �߻��ϴ°���?
		
		model.addAttribute("cnt", cnt);
		model.addAttribute("number", number);
		model.addAttribute("pageNum", pageNum);
		
		if (cnt > 0) {
			model.addAttribute("startPage", startPage);
		
			// ������ ������
			model.addAttribute("endPage", endPage);
			// ����� ������ ����
			model.addAttribute("pageBlock", pageBlock);
			// ������ ����
			model.addAttribute("pageCount", pageCount);
			// ���� ������
			model.addAttribute("currentPage", currentPage);
		}
	}

	@Override
	public void writeBoard(HttpServletRequest req,Model model) {
		int isInsert = 0;
		
		int num = Integer.parseInt(req.getParameter("num"));
		int ref = Integer.parseInt(req.getParameter("ref"));
		int ref_level = Integer.parseInt(req.getParameter("ref_level"));
		int ref_step = Integer.parseInt(req.getParameter("ref_step"));
		
		BoardVO bVo = new BoardVO();
		
		bVo.setNum(num);
		bVo.setWriter(req.getParameter("board_writer"));
		bVo.setSubject(req.getParameter("board_subject"));
		bVo.setContent(req.getParameter("board_content"));
		bVo.setPwd(req.getParameter("board_pwd"));
		bVo.setReadcnt(0);
		bVo.setRef(ref);
		bVo.setRef_level(ref_level);
		bVo.setRef_step(ref_step);
		bVo.setReg_date(new Timestamp(System.currentTimeMillis()));
		bVo.setIp(req.getRemoteAddr());
		
		isInsert = bDao.insertWrite(bVo);
		
		model.addAttribute("isInsert", isInsert);
		model.addAttribute("num", num);
		model.addAttribute("ref", ref);
		model.addAttribute("ref_level", ref_level);
		model.addAttribute("ref_step", ref_step);
	}
	
	
	@Override
	public void board_contentForm(HttpServletRequest req, Model model) {
		
		BoardVO bVo = new BoardVO();
		
		int num = Integer.parseInt(req.getParameter("num"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		int number = Integer.parseInt(req.getParameter("number"));
		
		bVo = bDao.getArticleContent(num);
		
		model.addAttribute("bVo", bVo);
		model.addAttribute("num", num);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("number", number);
	}
	
	
	//2017.12.28 ������� ��.
	@Override
	public void modifyForm(HttpServletRequest req, Model model) {
		
		BoardVO bVo = null;
		
		int num = Integer.parseInt(req.getParameter("num"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		
		bVo = bDao.getArticleContent(num);
		
		model.addAttribute("bVo", bVo);
		model.addAttribute("num", num);
		model.addAttribute("pageNum", pageNum);
		
	}
	
	
	@Override
	public void board_modifyPro(HttpServletRequest req, Model model) {
		int num = Integer.parseInt(req.getParameter("num"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		
		int isModify = 0;
		
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		BoardVO bVo = null;
		
		
		bVo = bDao.getArticleContent(num);
		
		bVo.setSubject(subject);
		bVo.setContent(content);
		
		isModify = bDao.modifyPro(bVo);
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("isModify", isModify);
	}
	
	@Override
	public void deletePro(HttpServletRequest req, Model model) {
		int num = Integer.parseInt(req.getParameter("num"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		int pwd = Integer.parseInt(req.getParameter("pwd"));
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		int isDelete = 0;
		
		if (bDao.getArticleContent(num) != null) {
			
			map.put("num", bDao.getArticleContent(num).getNum());
			map.put("pwd", pwd);
			isDelete = bDao.removeArticle(map);
		}
		model.addAttribute("isDelete", isDelete);
		model.addAttribute("num", num);
		model.addAttribute("pageNum", pageNum);
		
	}
	
	/*
	@Override
	public void productList(HttpServletRequest req, HttpServletResponse res) {
		
		ArrayList<ProductVO> pVos;
		
		int pageSize = 32; 		// �� �������� ����� �� ���� 
		int pageBlock = 10;		// �� ���� ������ ����
		
		int cnt = 0;			// �� ����
		int start = 0;			// ���� ������ ���۹�ȣ 1
		int end = 0;			// ���� �������� ������ �۹�ȣ
		int currentPage = 0;	// ���� ������
		int number = 0;			// ����� �� ��ȣ
		String pageNum = null; 	// ������ ��ȣ
		
		int pageCount = 0;		// ������ ����
		int startPage = 0;		// �ش� ������ ���� ���۹�ȣ. ex) [1] [2] [3] �� �ִٸ� ���۹�ȣ�� [1].
		int endPage = 0;		// �ش� ������ ���� ������ ��ȣ			ex) [1] [2] [3] �� �ִٸ� ������ �������� [3]
		
		BoardDAO bDao = BoardDAOImpl.getInstance();
		
		// �� ���� ���ϱ�.
		cnt = bDao.getNumOfArticle();
		
		pageNum = req.getParameter("pageNum");
		
		if (pageNum == null) {
			pageNum = "1"; // ù �������� 1�� ����.
		}
		
		currentPage = Integer.parseInt(pageNum);
		
		pageCount = (cnt / pageSize) + ((cnt % pageSize == 0) ? 0 : 1);
	
		start = pageSize *  currentPage  - 31; // ���� ������ ���� ���� ���۹�ȣ
		
		end = pageSize * currentPage; // ���� ������ ����ȣ (<==> pageSize * currentPage)
		
		
		if (end > cnt) end = cnt; // �۵��� ���� �Ǿ����� end != cnt.
		
		number = cnt - (currentPage-1) * pageSize; // ����� �� ��ȣ
		
		
		if (cnt > 0) {
			
			ProductDAO dao = new ProductDAOImpl();
			pVos = dao.getArticleList(start, end);
			req.setAttribute("pVos", pVos);
		}
		
		startPage = (currentPage / pageBlock) * pageBlock + 1; 
		
		if (currentPage % pageBlock == 0) startPage -= pageBlock; // [1][2][3] ������ ��� [1]��, [4][5][6] ������ ��� [4] �� ����.
		
		endPage = startPage + pageBlock - 1; 
		
		if (endPage > pageCount) endPage = pageCount;  // �̷� ���� ���� �߻��ϴ°���?
		
		req.setAttribute("cnt", cnt);
		req.setAttribute("number", number);
		req.setAttribute("pageNum", pageNum);
		
		if (cnt > 0) {
			req.setAttribute("startPage", startPage);
		
			// ������ ������
			req.setAttribute("endPage", endPage);
			// ����� ������ ����
			req.setAttribute("pageBlock", pageBlock);
			// ������ ����
			req.setAttribute("pageCount", pageCount);
			// ���� ������
			req.setAttribute("currentPage", currentPage);
		}
	}
*/
}
