package ssm.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import ssm.mapper.UserMapper;
import ssm.po.User;
import ssm.po.UserCustom;
import ssm.po.UserQueryVo;

/**
 * 批量插入1000条数据
 * @author Administrator
 *
 */
public class TestBatch {
	private SqlSessionFactory sqlSessionFactory;
	/**
	 * @Before要另外导入jar包，代表在测试@Test方法之前执行
	 * @throws Exception
	 */
	@Before
	public void setup() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	
	@Test
	public void test10() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = new ArrayList<User>();
		for (int i = 0; i < 200; i++) {
			User user = new User();
			user.setUsername("红楼梦"+i*3);
			user.setCity("水帘洞"+i*7);
			user.setCountry("天宫"+i*13);
			userList.add(user);
		}
		userMapper.insertBatch(userList);
		sqlSession.commit();
	}
}
