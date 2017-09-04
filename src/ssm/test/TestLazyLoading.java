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

import ssm.mapper.OrdersMapper;
import ssm.mapper.UserMapper;
import ssm.po.Orders;
import ssm.po.Ordersdetail;
import ssm.po.User;
import ssm.po.UserCustom;
import ssm.po.UserQueryVo;

/**
 * 测试延迟加载：订单表，延迟加载订单信息
 * @author Administrator
 *
 */
public class TestLazyLoading {
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
	public void test() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);
		List<Orders> list = ordersMapper.findOrdersLazyLoading();
		for (Orders orders : list) {
			System.out.println(orders.getCreateTime()+"..."+orders.getId());
			List<Ordersdetail> listOrdersDetail = orders.getListOrdersdetail();
			for (Ordersdetail ordersdetail : listOrdersDetail) {
				System.out.println(ordersdetail.getItemName()+".."+ordersdetail.getNum());
			}
		}
	}
}
