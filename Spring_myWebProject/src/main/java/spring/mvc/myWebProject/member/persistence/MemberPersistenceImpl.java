package spring.mvc.myWebProject.member.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.myWebProject.member.vo.MemberVO;

@Repository
public class MemberPersistenceImpl implements MemberPersistence{
	
	@Autowired
	SqlSession sqlSession;
	
	public MemberPersistenceImpl() {

	}
	

	@Override
	public int checkDupl(String id) {
		
		int isDupl = 0;
		
		MemberPersistence mDao = sqlSession.getMapper(MemberPersistence.class);
		
		isDupl = mDao.checkDupl(id);
		
		return isDupl;
	}
	
	public int proJoinUser(MemberVO vo) {
		
		int isInsert = 0;
		
		MemberPersistence mDao = sqlSession.getMapper(MemberPersistence.class);
		
		isInsert = mDao.proJoinUser(vo);
			
		return isInsert;
	}
	
	
	@Override
	public int checkLogin(String id, String pw) {

		int isCheck = 0;
		int idIsExist = 0;
		String chkPwd = "";
		
		MemberPersistence mDao = sqlSession.getMapper(MemberPersistence.class);
		
		idIsExist = mDao.checkDupl(id);
		chkPwd = mDao.getPwd(id);
		
		if (idIsExist == 1) {
			if (chkPwd.equals(pw)) {
				isCheck = 1;
			}else {
				isCheck = -1;
			}
		}else {
			isCheck = -2;
		}
		
		return isCheck;
	}
	
	@Override
	public String getPwd(String id) {
		
		String pwd = "";
		
		MemberPersistence mDao = sqlSession.getMapper(MemberPersistence.class);
		
		pwd = mDao.getPwd(id);
		
		return pwd;
	}


	@Override
	public int proDropUser(String id) {
		
		int isDelete = 0;
		
		MemberPersistence mDao = sqlSession.getMapper(MemberPersistence.class);
		
		isDelete = mDao.proDropUser(id);
	
		return isDelete;
	}

	

	@Override
	public MemberVO getCustInfo(String id) {
		
		MemberVO vo = null;
		
		MemberPersistence mDao = sqlSession.getMapper(MemberPersistence.class);
		
		vo = mDao.getCustInfo(id);
		
		return vo;
	}
	
	@Override
	public int proUpdate(MemberVO vo) {
		
		int isUpdate = 0;
		
		
		MemberPersistence mDao = sqlSession.getMapper(MemberPersistence.class);
		
		isUpdate = mDao.proUpdate(vo);
		
		return isUpdate;
	}
}
