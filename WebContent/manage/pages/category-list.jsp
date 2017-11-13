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
				<th>编号</th><th>类别</th><th>修改&nbsp;删除</th>
			</tr>
			<!-- 用struts的iterator标签遍历集合 -->
			<s:iterator value="request.categories">
	          	<tr>
	          		<td><s:property value="id"/></td>
	          		<td><s:property value="name"/></td>
	          		<td><a href="manage/pages/category-update.jsp?id=<s:property value="id"/>&name=<s:property value="name"/>" >修改</a>
	          			<a href="category!delete.action?category.id=<s:property value="id"/>">删除</a></td>
	        	</tr>
	        </s:iterator>
	        
		</table>
<a href="manage/pages/category-add.jsp">添加类别</a>

</body>
</html>