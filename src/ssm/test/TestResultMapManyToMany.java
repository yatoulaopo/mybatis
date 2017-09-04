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
import ssm.mapper.UserMapper;
import ssm.po.Items;
import ssm.po.Orders;
import ssm.po.OrdersOneToOne;
import ssm.po.Ordersdetail;
import ssm.po.User;

/**
 * resultMap最复杂的案例：查询用户信息，关联查询订单，关联查询订单项，关联查询商品信息
 * @author Administrator
 *
 */
public class TestResultMapManyToMany {
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
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<User> list3 = userMapper.selectByResultMapManyToMany();
		for (User user : list3) {
			System.out.println(user.getUsername()+"..."+user.getCity());
			System.out.println("商品信息开始！");
			List<Orders> listOrders = user.getListOrders();
			for (Orders orders : listOrders) {
				List<Ordersdetail> listOrdersdetail = orders.getListOrdersdetail();
				for (Ordersdetail ordersdetail : listOrdersdetail) {
					Items items = ordersdetail.getItems();
					System.out.println(items.getName());
				}
			}
		}
		
		
	}
}
