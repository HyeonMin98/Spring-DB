package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVO;

public class DeptDAO {
	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 부서 정보 조회
	public List<DeptVO> selectList() {
		
		List<DeptVO> list = sqlSession.selectList("dept.dept_list");
		return list;
	}

}
