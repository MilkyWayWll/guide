<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="guide/css/style.css"/>
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
           
   
   
	<div class="center_content">

    	<div class="prod_box_big">
        	<div class="top_prod_box_big"></div>
			<div class="center_prod_box_big">            
			<div class="contact_form">
				<form action="user!login.action" method="post">	   
					<div class="form_row">
						<label class="contact"><strong>用户: </strong></label>
						<input type="text" name="user.username" class="contact_input" />
					</div>  
					<div class="form_row">
						<label class="contact"><strong>密码: </strong></label>
						<input type="text" name="user.password" class="contact_input" />
					</div>
					<div class="form_row">
						<input type="submit" value="登录"/>
					</div>      
				</form>	   
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