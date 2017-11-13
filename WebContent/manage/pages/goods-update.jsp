<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<form action="goods!update.action" method="post" enctype="multipart/form-data">
		<input type="hidden" name="goods.id" value="${goods.id}">
		商品:<input type="text" name="goods.name" value="${goods.name}" /><br> 
		价格:<input type="text" name="goods.price" value="${goods.price}" /><br> 
		位置:<input type="text" name="goods.place" value="${goods.place}" /><br> 
		图片:<img src="${goods.photo}" width="100" height="100"/>
		<input type="hidden" name="goods.photo" value="${goods.photo}" /><br> 
		更换<input type="file" name="photo" size="12" /><br> 
		类型:<select name="goods.category.id" style="width: 150px">
				<option value="${goods.category.id}">${goods.category.name}</option>
			<s:iterator value="request.categories">
				<option value="<s:property value="id"/>"><s:property value="name" /></option>
			</s:iterator>
		</select><br> 
		品牌:<select name="goods.brand.id" style="width: 150px">
		<option value="${goods.brand.id}">${goods.brand.name}</option>
			<s:iterator value="request.brands">
				<option value="<s:property value="id"/>">
					<s:property value="name" />
				</option>
			</s:iterator>
		</select><br> 
		介绍:<textarea name="goods.intro" rows="1" cols="15">${goods.intro}</textarea><br><br>
		<input type="submit" value="更新">
	</form>
</body>
</html>