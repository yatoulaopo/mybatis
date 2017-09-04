package ssm.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import ssm.mapper.OrdersMapper;
import ssm.mapper.OrdersOneToOneMapper;
import ssm.po.Orders;
import ssm.po.OrdersOneToOne;
import ssm.po.User;

/**
 * 一对一resultType实现：根据订单关联查询用户信息
 * @author Administrator
 *
 */
public class TestResultMap {
	private SqlSessionFactory sqlSessionFactory;
	/**
	 * junit测试，在测试方法执行前执行，作用：初始化SqlSessionFactory
	 * @throws Exception 
	 */
	@Before
	public void setup() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	@Test
	public void test() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);
		List<Orders> list = ordersMapper.selectByResultMap();
		for (Orders orders : list) {
			System.out.println("订单信息开始！");
			System.out.println(orders.getId()+"..."+orders.getCreateTime());
			System.out.println("用户信息开始！");
			User user = orders.getUser();
			System.out.println(user.getUsername()+"..."+user.getCity()+".."+user.getCountry());
		}
		
	}
}
