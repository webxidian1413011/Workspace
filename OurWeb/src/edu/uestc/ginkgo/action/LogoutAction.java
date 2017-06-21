package edu.uestc.ginkgo.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import edu.uestc.ginkgo.service.LeeService;

public class LogoutAction implements Action {
//ϵͳ�����ҵ���߼����
	private LeeService leeService;
//��ҵ���߼����ע������������
	public void setLeeService(LeeService leeService) {
		this.leeService = leeService;
	}


public String execute() throws Exception {
	Map session=ActionContext.getContext().getSession();
	session.clear();
	return "success";
}

}
