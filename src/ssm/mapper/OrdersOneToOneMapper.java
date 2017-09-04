package ssm.mapper;

import java.util.List;

import ssm.po.OrdersOneToOne;

/**
 * 一对一的resultType实现：根据订单关联查询用户
 * @author Administrator
 *
 */
public interface OrdersOneToOneMapper {
	public List<OrdersOneToOne> selectByResultType()throws Exception;
}
