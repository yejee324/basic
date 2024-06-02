package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.sqlConfig;
import vo.mberVo;

public class mberDao {

	private SqlSessionFactory factory = sqlConfig.getSqlSession();
	
	public List<mberVo> selectDataAll() throws Exception{
		SqlSession sqlSession = factory.openSession(); // 세션 열기(DB처리를 위한 작업단위)
		List<mberVo> list = sqlSession.selectList("listAll"); // DataMapper의 id를 가져온다.
		sqlSession.close();
		return list; // sql의 결과를 가진다.
	}
	
}
