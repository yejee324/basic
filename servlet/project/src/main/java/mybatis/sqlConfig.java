package mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class sqlConfig {

	public static SqlSessionFactory sqlSession;
	// DB의 SQL 명령 실행 메소드를 가진 객체.
	static {
		String resource = "mybatis/config.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			// Configuration.xml을 읽는다.
			sqlSession = new SqlSessionFactoryBuilder().build(reader);
			// sqlSession 객체를 생성한다.
			reader.close();
		} catch (Exception e) {
			System.out.println("SqlMapConfig err"+e);
		}
	}
	public static SqlSessionFactory getSqlSession() {
		return sqlSession;
	}
}
