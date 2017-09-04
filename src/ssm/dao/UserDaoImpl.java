package ssm.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import ssm.po.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Override
	public User findUserById(int id) throws Exception {
		SqlSession session = this.getSqlSession();
		User user = session.selectOne("ssm.mapper.UserMapper.findUserById", 4);
		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
