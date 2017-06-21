package edu.uestc.ginkgo.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import edu.uestc.ginkgo.service.LeeService;
import edu.uestc.ginkgo.user.User;

public class UpdateAction implements Action{
	//�������ڷ�װ�û��������������
	private String username;
	private String password;
	private String newpassword0;
	private String newpassword1;
//���ڷ�װ������������
	private String tip;
//ϵͳ�����ҵ���߼����
	private LeeService leeService;
//��ҵ���߼����ע������������
	public void setLeeService(LeeService leeService) {
		this.leeService = leeService;
	}

	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewpassword0() {
		return newpassword0;
	}

	public void setNewpassword0(String newpassword0) {
		this.newpassword0 = newpassword0;
	}

	public String getNewpassword1() {
		return newpassword1;
	}

	public void setNewpassword1(String newpassword1) {
		this.newpassword1 = newpassword1;
	}

	public String execute() throws Exception {
		Map session=ActionContext.getContext().getSession();
		String username=(String) session.get("username");
		int i=leeService.login(username, password);
		if(i>0){
	    	if(newpassword0.equals(newpassword1)){
	    		leeService.update(username, newpassword0);
	    		return "success";
	    	}
	        else {
	    	setTip("ǰ�������������벻ͬ������������");
	    	return "error";
	    }
	    }
		else {
			setTip("����Ȩ�޸����룡");
			return "error";
		}
}
}