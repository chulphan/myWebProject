package spring.mvc.myWebProject.board.persistence;

import java.util.ArrayList;
import java.util.Map;

import spring.mvc.myWebProject.board.vo.BoardVO;

public interface BoardDAO {
	public int getNumOfArticle();
	
	public ArrayList<BoardVO> getArticleList(Map<String, Object> map);
	
	public int insertWrite(BoardVO bVo);
	
	public int getMaxNum();
	
	public int updateReplyToUp(Map<String, Object> map);
	
	public int insertPost(BoardVO bVo);
	
	
	public BoardVO getArticleContent(int num);
	
	public void addReadCnt(int num);
	
	
	public int modifyPro(BoardVO bVo);
	
	public int removeArticle(Map<String, Object> map);
}
