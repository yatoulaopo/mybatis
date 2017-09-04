package ssm.dao;

import ssm.po.User;

/**
 * 原始的dao开发方式
 * @author Administrator
 *
 */
public interface UserDao {
	//根据id查找一个User
	public User findUserById(int id)throws Exception;
	//插入一条数据
	public void insertUser(User user)throws Exception;
	//根据id删除一条记录
	public void deleteUser(int id)throws Exception;
	//更新一条记录，根据User对象的id
	public void update(User user)throws Exception;
}
