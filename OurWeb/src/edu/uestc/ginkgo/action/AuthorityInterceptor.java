package edu.uestc.ginkgo.action;

import java.util.Map;

import org.hibernate.Session;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import edu.uestc.ginkgo.service.LeeService;

public class AuthorityInterceptor extends AbstractInterceptor {
    private String name;
    private LeeService leeService;
	public void setName(String name) {
		this.name = name;
	}
	
	
	public LeeService getLeeService() {
		return leeService;
	}
	public void setLeeService(LeeService leeService) {
		this.leeService = leeService;
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		ActionContext act=arg0.getInvocationContext();//取得请求相关的ActionContext实例
		Map session=act.getSession();
		String username=(String) session.get("username");
		if(username!=null) return arg0.invoke();
		else{act.put("tip","你还没有登录！");
		return Action.LOGIN;}
}
}