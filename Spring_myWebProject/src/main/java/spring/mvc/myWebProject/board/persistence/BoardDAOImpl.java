package spring.mvc.myWebProject.board.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.myWebProject.board.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSession sqlSession;

	public BoardDAOImpl() {

	}

	@Override
	public int getNumOfArticle() {

		int numOfArticle = 0;

		BoardDAO bDao = sqlSession.getMapper(BoardDAO.class);

		numOfArticle = bDao.getNumOfArticle();

		return numOfArticle;
	}

	@Override
	public ArrayList<BoardVO> getArticleList(Map<String, Object> map) {

		ArrayList<BoardVO> bVos = new ArrayList<BoardVO>();

		BoardDAO bDao = sqlSession.getMapper(BoardDAO.class);

		bVos = bDao.getArticleList(map);

		return bVos;
	}

	@Override
	public int insertWrite(BoardVO bVo) {

		int isInsert = 0;

		int num = bVo.getNum();
		int ref = bVo.getRef();
		int ref_level = bVo.getRef_level();
		int ref_step = bVo.getRef_step();

		// 답변글이 아닌 경우 (제목글인 경우)
		if (num == 0) {

			// 현재 게시글의 번호.
			int getMaxNum = getMaxNum();

			// MAX(NUM) + 1
			if (getMaxNum > 0) {
				ref = getMaxNum + 1;
			} else {
				ref = 1;
			}

			ref_step = 0;
			ref_level = 0;

			// 답변글일 경우.
		} else {

			// 삽입할 글보다 아래쪽 글들을 UPDATE

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("ref", ref);
			map.put("ref_step", ref_step);

			updateReplyToUp(map);

			ref_step++;
			ref_level++;
		}

		bVo.setRef(ref);
		bVo.setRef_level(ref_level);
		bVo.setRef_step(ref_step);

		isInsert = insertPost(bVo);

		return isInsert;
	}

	@Override
	public int getMaxNum() {

		int numOfMax = 0;

		BoardDAO bDao = sqlSession.getMapper(BoardDAO.class);

		numOfMax = bDao.getMaxNum();

		return numOfMax;
	}

	@Override
	public int updateReplyToUp(Map<String, Object> map) {

		int isUpdated = 0;

		BoardDAO bDao = sqlSession.getMapper(BoardDAO.class);

		isUpdated = bDao.updateReplyToUp(map);

		return isUpdated;
	}

	@Override
	public int insertPost(BoardVO bVo) {

		int isInsert = 0;

		BoardDAO bDao = sqlSession.getMapper(BoardDAO.class);

		isInsert = bDao.insertPost(bVo);

		return isInsert;
	}

	@Override
	public BoardVO getArticleContent(int num) {

		BoardDAO bDao = sqlSession.getMapper(BoardDAO.class);

		BoardVO bVo = bDao.getArticleContent(num);

		return bVo;
	}

	@Override
	public void addReadCnt(int num) {

		BoardDAO bDao = sqlSession.getMapper(BoardDAO.class);

		bDao.addReadCnt(num);

	}

	@Override
	public int modifyPro(BoardVO bVo) {

		int isModify = 0;

		BoardDAO bDao = sqlSession.getMapper(BoardDAO.class);

		isModify = bDao.modifyPro(bVo);

		return isModify;
	}

	@Override
	public int removeArticle(Map<String, Object> map) {

		int isDelete = 0;
		
		BoardDAO bDao = sqlSession.getMapper(BoardDAO.class);
		
		isDelete = bDao.removeArticle(map);
		
		return isDelete;
	}

}