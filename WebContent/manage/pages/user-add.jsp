<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<form action="user!add.action" method="post">
			用户:<input type="text" name="user.username"/><br>
			密码:<input type="text" name="user.password"/><br>
			角色:<select name="user.position.id" style="width:150px">
						<s:iterator value="request.positions">
							<option value='<s:property value="id"/>'><s:property value="name"/></option>
						</s:iterator>
					</select><br>
					<input type="submit" value="添加"><font color="red">${msg}</font>
		</form>

</body>
</html>