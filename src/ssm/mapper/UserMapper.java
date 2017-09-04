package ssm.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ssm.po.Orders;
import ssm.po.User;
import ssm.po.UserCustom;
import ssm.po.UserQueryVo;

public interface UserMapper {
	public User findUserById(int id)throws Exception;
	public void insertUser(User user)throws Exception;
	public void deleteUserById(int id)throws Exception;
	public void updateById(User user)throws Exception;
	
	//mybatis批量插入200条数据
	public void insertBatch(List<User> userList)throws Exception;
	//paremeterType是hashmap的情况
	public List<User> selectByHashMap(HashMap<String,String> map)throws Exception;
	//parameterType是UserQueryVo的综合擦汗寻
	public List<User> selectByUserQueryVo(UserQueryVo userQueryVo)throws Exception;
	//resultMap，针对select 查询的列名别名和对象属性不一致的情况
	public List<User> selectByUserQueryVo1(UserQueryVo userQueryVo)throws Exception;
	//where city="" adn country = "" sql片段引入，综合查询先判断条件是否为null或者""
	public User selectByDynamicSql(UserQueryVo userQueryVo)throws Exception;
	//<!-- sql片段   where id=1 or id=6 or id=16 -->
	public List<User> selectByIdList(UserQueryVo userQueryVo)throws Exception;
	//<!-- sql片段   where id in (1,6,16)
	public List<User> selectByIdList1(UserQueryVo userQueryVo)throws Exception;
	
	//多对多resultMap:根据用户查询订单，查询订单项，最后关联查询商品信息
	public List<User> selectByResultMapManyToMany()throws Exception;
	
	
}
