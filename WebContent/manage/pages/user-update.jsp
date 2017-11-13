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
</head>
<body>
		<form action="user!update.action" method="post">
					<input type="hidden" name="user.id" value="${user.id}">
			用户:<input type="text" name="user.username" value="${user.username}"/><br>
			密码:<input type="text" name="user.password" value="${user.password}"/><br>
			角色:<select name="user.position.id"  style="width:150px">
						<option value="${user.position.id}">${user.position.name}</option>
						<s:iterator value="request.positions">
							<option value="<s:property value="id"/>"><s:property value="name"/></option>
						</s:iterator>
					</select>
					<input type="submit" value="更新">
		</form>

</body>
</html>