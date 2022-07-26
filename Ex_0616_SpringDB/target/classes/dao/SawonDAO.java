package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.SawonVO;

public class SawonDAO {
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 사원 정보 조회
	public List<SawonVO> selectList() {
		
		List<SawonVO> list = sqlSession.selectList("sawon.sawon_list");
		return list;
	}
	
	
}
