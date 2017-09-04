package ssm.mapper;

import java.util.List;

import ssm.po.Ordersdetail;
/**
 * 测试延迟加载：查询订单，延迟加载订单项
 * <collection property="listOrdersDetail" ofType="" column="" select="">
 * @author Administrator
 *
 */
public interface OrdersDetailMapper {
	//在订单项表种，根据order_id来查找，可以查找出一个List<Orderdetail>
	public List<Ordersdetail> selectByOrderId(int order_id)throws Exception;
}
