package edu.uestc.ginkgo.dao;


import edu.uestc.ginkgo.user.User;

public interface UserDao {
	
	public Integer save(User user);
	public void update(User user);
	public User get(Integer id);
	public User findByName(String name);
	public User findUserByNameAndPass(String name,String password);
}
