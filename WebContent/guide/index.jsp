<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="guide/css/style.css" />
<title>电子商城导购系统</title>
</head>
<body>

<div id="main_container">
    
<div id="main_content"> 
   
		<div id="menu_tab">
		
			<div class="left_menu_corner"></div>
			<ul class="menu">
				<li><a href="front!index.action" class="nav1">导航首页</a></li>
				<li class="divider"></li>
				<li><a href="guide/login.jsp" class="nav3">用户登录</a></li>
			</ul>
			<div class="right_menu_corner"></div>
		 
		</div><!-- end of menu tab -->
           
    
    
	<div class="left_content">
   
        <div class="title_box">商品查询</div>  
   		<form action="front!query.action" method="post"><br>
   			<input type="text" name="goodstr" size="10">
   			<input type="submit" value="查询">
   		</form><br>
   
		<div class="title_box">商品分类</div>
        <ul class="left_menu">
        	<s:iterator value="request.categories">
        		<li class="odd"><a href="front!category.action?category.id=<s:property value="id"/>"><s:property value="name"/></a></li>
        	</s:iterator>
        </ul><br>
        
		<div class="title_box">品牌分类</div>  
		<ul class="left_menu">
		    <s:iterator value="request.brands">
        		<li class="odd"><a href="front!brand.action?brand.id=<s:property value="id"/>"><s:property value="name"/></a></li>
        	</s:iterator>
        </ul><br>   
        
	</div><!-- end of left content -->
   
   
	<div class="center_content">

 
		<div class="center_title_bar">商品列表</div>
 
		<s:iterator value="request.goods">
       		<div class="prod_box">
	        	<div class="top_prod_box"></div>
	            <div class="center_prod_box">            
	                 <div class="product_title"><a href="front!intro.action?goods.id=<s:property value="id"/>">
	                 		<s:property value="name"/></a></div>
	                 <div class="product_img"><a href="front!intro.action?goods.id=<s:property value="id"/>">
	                 		<img src="<s:property value="photo"/>" height="100" width="100" border="0" /></a></div>
	                 <div class="prod_price"><span class="price">￥<s:property value="price"/></span></div>                        
	            </div>
	            <div class="bottom_prod_box"></div>             
	            <div class="prod_details_tab">
					<img src="guide/images/favorites.gif" border="0" class="left_bt"/>   
					<img src="guide/images/favs.gif" border="0" class="left_bt"/>
					<img src="guide/images/checked.png" border="0" class="left_bt"/>
					<a href="front!intro.action?goods.id=<s:property value="id"/>" class="prod_details">详细信息</a>            
	            </div>                     
	        </div>
       	</s:iterator>
   
 
   </div><!-- end of center content -->
   
    
</div><!-- end of main_content -->
   

<div class="footer"></div>                 


</div><!-- end of main_container -->

</body>
</html>