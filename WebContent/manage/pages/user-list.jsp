<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
		<table border="1">
			<tr>
				<th>用户</th><th>密码</th><th>角色</th><th>修改&nbsp;删除</th>
			</tr>
			<!-- 用struts的iterator标签遍历集合 -->
			<s:iterator value="request.users">
	          	<tr>
	          		<td><s:property value="username"/></td>
	          		<td><s:property value="password"/></td>
	          		<td><s:property value="position.name"/></td>
	          		<td><a href="user!updatepage.action?user.id=<s:property value="id"/>" >修改</a>
	          			<a href="user!delete.action?user.id=<s:property value="id"/>">删除</a></td>
	        	</tr>
	        </s:iterator>
	        
		</table>
<a href="user!addpage.action">添加类别</a>

</body>
</html>