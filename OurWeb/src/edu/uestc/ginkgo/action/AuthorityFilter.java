package edu.uestc.ginkgo.action;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthorityFilter implements Filter {
private FilterConfig config;
	public void destroy() {
		this.config=null;

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
	  
	  HttpServletRequest requ=(HttpServletRequest) request;
	  HttpSession session=requ.getSession();
	  if(session.getAttribute("username")==null){
		  request.setAttribute("tip", "你还没有登录！");
		  request.getRequestDispatcher("/login.jsp").forward(request, response);
	  }
	  else{
		  chain.doFilter(request, response);
	  }
	}

	public void init(FilterConfig arg0) throws ServletException {
		this.config=arg0;

	}

}
