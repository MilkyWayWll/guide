<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table border="1">
			<tr>
				<th>编号</th><th>品牌</th><th>修改&nbsp;删除</th>
			</tr>
			<!-- 用struts的iterator标签遍历集合 -->
			<s:iterator value="request.brands">
	          	<tr>
	          		<td><s:property value="id"/></td>
	          		<td><s:property value="name"/></td>
	          		<td><a href="manage/pages/brand-update.jsp?id=<s:property value="id"/>&name=<s:property value="name"/>" >修改</a>
	          			<a href="brand!delete.action?brand.id=<s:property value="id"/>">删除</a></td>
	        	</tr>
	        </s:iterator>
	        
		</table>
<a href="manage/pages/brand-add.jsp">添加品牌</a>

</body>
</html>