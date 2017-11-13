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
   		<form action="front!query.action"><br>
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
	
		<div class="center_title_bar">详细信息</div>
    	<div class="prod_box_big">
        	<div class="top_prod_box_big"></div>
            <div class="center_prod_box_big">            
                <div class="product_img_big">
                	<div class="product_img">
                		<img src="${goods.photo}" height="100" width="100"/></div>
					<div class="thumbs">
						<img src="${goods.photo}" height="40" width="40"/>
						<img src="${goods.photo}" height="40" width="40"/>
						<img src="${goods.photo}" height="40" width="40"/>
					</div>
                </div>
				<div class="details_big_box">
					<div class="product_title_big">商品 : ${goods.name}</div><br>
					<div class="specifications">
						位置 : <span class="blue">${goods.place}</span><br />
						价格 : <span class="blue">${goods.price}</span><br />
						品牌 : <span class="blue">${goods.brand.name}</span><br />
						分类 : <span class="blue">${goods.category.name}</span><br />
						介绍 : <span class="blue">${goods.intro}</span><br />
					</div>
				</div>                        
            </div>
            <div class="bottom_prod_box_big"></div>                                
        </div>
    
   </div><!-- end of center content -->
   
    
</div><!-- end of main_content -->
   

<div class="footer"></div>                 


</div><!-- end of main_container -->

</body>
</html>