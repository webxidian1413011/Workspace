package edu.uestc.ginkgo.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import edu.uestc.ginkgo.service.LeeService;

public class LogoutAction implements Action {
//系统所需的业务逻辑组件
	private LeeService leeService;
//将业务逻辑组件注入给控制器组件
	public void setLeeService(LeeService leeService) {
		this.leeService = leeService;
	}


public String execute() throws Exception {
	Map session=ActionContext.getContext().getSession();
	session.clear();
	return "success";
}

}
