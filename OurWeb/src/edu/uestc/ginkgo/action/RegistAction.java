package edu.uestc.ginkgo.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import edu.uestc.ginkgo.service.LeeService;

public class RegistAction implements Action {
//�������ڷ�װ�û��������������
	private String username;
	private String password;
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


	public String execute() throws Exception {
		if(leeService.regist(getUsername(), getPassword())){
			setTip("������ע��ɹ�");
			return "success";
		}
		else 
			return "error";
	}

	
}
