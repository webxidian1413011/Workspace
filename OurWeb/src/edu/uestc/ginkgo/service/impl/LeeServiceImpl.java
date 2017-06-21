package edu.uestc.ginkgo.service.impl;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import edu.uestc.ginkgo.dao.UserDao;
import edu.uestc.ginkgo.service.LeeService;
import edu.uestc.ginkgo.user.User;

public class LeeServiceImpl implements LeeService {
    private UserDao userDao;
    
	public void setuserDao(UserDao userDao) {
		this.userDao = userDao;
	}
    
	public UserDao getuserDao() {
		return userDao;
	}

	public boolean regist(String username, String password) {
		if(userDao.findByName(username)!=null) return false;
		int result=userDao.save(new User(username,password));
		if(result>0 ) return true;
		return false;
	}
	
	
	public int login(String username,String password){
		
		User user=userDao.findUserByNameAndPass(username, password);
		if(user!=null){
			return user.getId();
		}
		return -1;
	}
	
	
	public void update(String username,String password){
		Map session=ActionContext.getContext().getSession();
		username=(String)session.get("username");
		User user=userDao.findByName(username);
		user.setPassword(password);
		userDao.update(user);
		
	}
}
