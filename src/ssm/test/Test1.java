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
 * 测试mapper代理方式实现数据库的操作
 * @author Administrator
 *
 */
public class Test1 {
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
//	/**
//	 * 根据id查找
//	 * @throws Exception
//	 */
//	@Test
//	public void test1() throws Exception {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		User user = userMapper.findUserById(8);
//		System.out.println(user.getUsername()+"...."+user.getCountry());
//	}
	
//	/**
//	 * 插入一条记录，并把id返回到输入参数的user中去。测试是否有效
//	 */
//	
//	@Test
//	public void test2() throws Exception {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		User user = new User();
//		user.setUsername("丫头");
//		user.setCity("斯里兰卡");
//		user.setCountry("USA");
//		userMapper.insertUser(user);
//		sqlSession.commit();
//		sqlSession.close();
//	}
	
//	/**
//	 * 根据id删除1条记录
//	 */
//	
//	@Test
//	public void test3() throws Exception {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		userMapper.deleteUserById(1);
//		sqlSession.commit();
//	}
	
//	/**
//	 * update操作：要求输入参数的User对象必须有id，因为是根据id传值的
//	 */
//	
//	@Test
//	public void test4() throws Exception {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		User user = new User();
//		user.setCountry("爱斯基摩人");
//		user.setId(4);
//		userMapper.updateById(user);
//		sqlSession.commit();
//	}
	
//	/**
//	 * parameterType是hashmap结构的查询
//	 */
//	
//	@Test
//	public void test5() throws Exception {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("username","%三%");
//		List<User> list = userMapper.selectByHashMap(map);
//		for (User user2 : list) {
//			System.out.println(user2.getUsername()+"...."+user2.getCountry());
//		}
//		sqlSession.commit();
//	}
	
//	/**
//	 * parameterType是包装类结构的查询
//	 */
//	
//	@Test
//	public void test6() throws Exception {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		UserQueryVo userQueryVo = new UserQueryVo();
//		UserCustom userCustom = new UserCustom();
//		userCustom.setCountry("国");
//		userQueryVo.setUserCustom(userCustom);
//		List<User> list = userMapper.selectByUserQueryVo(userQueryVo);
//		for (User user3 : list) {
//			System.out.println(user3.getUsername()+"...."+user3.getCountry());
//		}
//		sqlSession.commit();
//	}
	
//	/**
//	 * resultMap
//	 */
//	
//	@Test
//	public void test7() throws Exception {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		UserQueryVo userQueryVo = new UserQueryVo();
//		UserCustom userCustom = new UserCustom();
//		userCustom.setCountry("德国");
//		userQueryVo.setUserCustom(userCustom);
//		List<User> list = userMapper.selectByUserQueryVo1(userQueryVo);
//		for (User user4 : list) {
//			System.out.println(user4.getUsername()+"...."+user4.getCountry());
//		}
//		sqlSession.commit();
//	}
	
	/**
	 * sql片段，引入，综合查询，须先判断判断条件是否为空
	 * where city= "" and country = ""
	 */
	
	@Test
	public void test8() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setCountry("法国");
		userCustom.setCity("戛纳");
		userQueryVo.setUserCustom(userCustom);
		User user = userMapper.selectByDynamicSql(userQueryVo);
		System.out.println(user.getUsername()+"...."+user.getId()+".."+user.getCity()+".."+user.getCountry());
		sqlSession.commit();
	}
	
//	/**
//	 * <!-- sql片段   where id=1 or id=6 or id=16 -->
//	 *
//	 */
//	
//	@Test
//	public void test9() throws Exception {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		UserQueryVo userQueryVo = new UserQueryVo();
//		Integer[] arr = {4,7,16};
//		List<Integer> list = Arrays.asList(arr);
//		userQueryVo.setListId(list);
//		List<User> list1 = userMapper.selectByIdList(userQueryVo);
//		for (User user2 : list1) {
//			System.out.println(user2.getUsername()+"...."+user2.getId()+".."+user2.getCity()+".."+user2.getCountry());
//		}
//		sqlSession.commit();
//	}
	
	/**
	 * <!-- sql片段   where id in(4,7,16) -->
	 *
	 */
	
	@Test
	public void test10() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		Integer[] arr = {4,7,16};
		List<Integer> list = Arrays.asList(arr);
		userQueryVo.setListId(list);
		List<User> list1 = userMapper.selectByIdList1(userQueryVo);
		for (User user2 : list1) {
			System.out.println(user2.getUsername()+"...."+user2.getId()+".."+user2.getCity()+".."+user2.getCountry());
		}
		sqlSession.commit();
	}
}
