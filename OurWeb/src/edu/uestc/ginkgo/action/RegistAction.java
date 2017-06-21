package edu.uestc.ginkgo.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import edu.uestc.ginkgo.service.LeeService;

public class RegistAction implements Action {
//下面用于封装用户请求的两个属性
	private String username;
	private String password;
//用于封装处理结果的属性
	private String tip;
//系统所需的业务逻辑组件
	private LeeService leeService;
//将业务逻辑组件注入给控制器组件
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
			setTip("哈哈，注册成功");
			return "success";
		}
		else 
			return "error";
	}

	
}
