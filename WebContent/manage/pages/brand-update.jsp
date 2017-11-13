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
		<form action="brand!update.action" method="post">
					<input type="hidden" name="brand.id" value="${param.id}">
			品牌名:<input type="text" name="brand.name" value="<%=new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8")%>"/><br>
					<input type="submit" value="更新">
		</form>

</body>
</html>