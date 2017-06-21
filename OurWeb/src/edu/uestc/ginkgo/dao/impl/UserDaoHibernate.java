package edu.uestc.ginkgo.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.uestc.ginkgo.dao.UserDao;
import edu.uestc.ginkgo.user.User;

public class UserDaoHibernate extends HibernateDaoSupport implements UserDao {

	public User findByName(String username) {
		List pp=  getHibernateTemplate().find("from User user where user.username like ?",username);
		if(pp!=null &&pp.size()>0) return (User) pp.get(0);
		return null;
		
	}

	public User get(Integer id) {
		return (User)getHibernateTemplate().get(User.class, id);
	}
//返回刚刚保存的User实例的标识属性值
	public Integer save(User user) {
		return (Integer) getHibernateTemplate().save(user);
	}

	public void update(User user) {
		getHibernateTemplate().update(user);
	}

	public User findUserByNameAndPass(String username, String password) {
		List pp=getHibernateTemplate().find("from User user where user.username=? and user.password=?",new String[]{username,password});
		if(pp!=null &&pp.size()>0) return (User) pp.get(0);
		return null;
	}

//	@Override
//	public User finduserByNameAndPass(String name, String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
