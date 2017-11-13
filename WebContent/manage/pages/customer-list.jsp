<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<link type="text/css" href="admin/manage/css/admin.css" rel="stylesheet">

</head>
<body>
	<table cellspacing=0 cellpadding=0 width="100%" align=center border=0>
		<tr height=28><td background="admin/manage/images/title_bg1.jpg">当前位置 &raquo; 顾客管理</td></tr>
		<tr><td bgcolor=#b1ceef height=1></td></tr>
		<tr height=20><td background="admin/manage/images/shadow_bg.jpg"></td></tr>
	</table>


		<table border="1">
			<tr>
				<th>编号</th><th>用户名</th><th>密码</th><th>电话</th><th>地址</th><th>邮箱</th><th>操作</th>
			</tr>
			<!-- 用struts的iterator标签遍历集合 -->
			<s:iterator value="#request.customers">
	          	<tr>
	          		<td><s:property value="id"/></td>
	          		<td><s:property value="username"/></td>
	          		<td><s:property value="password"/></td>
	          		<td><s:property value="phone"/></td>
	          		<td><s:property value="address"/></td>
	          		<td><s:property value="email"/></td>
	          		<td><a href="manage/pages/customer-update.jsp?id=<s:property value="id"/>&username=<s:property value="username"/>&password=<s:property value="password"/>&phone=<s:property value="phone"/>&address=<s:property value="address"/>&email=<s:property value="email"/>">修改</a>
	          			<a href="customer!remove.action?customer.id=<s:property value="id"/>">删除</a></td>
	        	</tr>
	        </s:iterator>
	        
		</table>
<a href="manage/pages/customer-add.jsp">添加顾客</a>
</body>
</html>