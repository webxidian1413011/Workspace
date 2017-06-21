<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>regist</title>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <form action="regist.action" method="post" >
    用户注册
 <br>用户名：<input type="text" name="username">
 <br>密码：<input type="password" name="password">
 <br><input type="submit" value="注册">
 <input type="reset" value="重填">
 </form>
  <br><a href="viewBook">访问主页面</a>
  <s:debug></s:debug>
  </body>
</html>
