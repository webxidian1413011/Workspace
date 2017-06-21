package edu.uestc.ginkgo.service;

public interface LeeService {
public boolean regist(String sername,String password);
public int login(String username,String password);
public void update(String username, String password);

}
