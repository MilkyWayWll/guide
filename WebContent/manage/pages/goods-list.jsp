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
				<th>图片</th><th>商品</th><th>价格</th><th>位置</th><th>类型</th><th>品牌</th><th>介绍</th><th>修改&nbsp;删除</th>
			</tr>
			<!-- 用struts的iterator标签遍历集合 -->
			<s:iterator value="request.goods">
	          	<tr>
	          		<td><img src="<s:property value="photo"/>" width="40" height="50"/></td>
	          		<td><s:property value="name"/></td>
	          		<td><s:property value="price"/></td>
	          		<td><s:property value="place"/></td>
	          		<td><s:property value="category.name"/></td>
	          		<td><s:property value="brand.name"/></td>
	          		<td><s:property value="intro"/></td>
	          		<td><a href="goods!updatepage.action?goods.id=<s:property value="id"/>" >修改</a>
	          			<a href="goods!delete.action?goods.id=<s:property value="id"/>">删除</a></td>
	        	</tr>
	        </s:iterator>
	        
		</table>
<a href="goods!addpage.action">添加商品</a>

</body>
</html>