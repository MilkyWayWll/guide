<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow: hidden;
}
-->
</style>
<style>
.navPoint {
	COLOR: white;
	CURSOR: hand;
	FONT-FAMILY: Webdings;
	FONT-SIZE: 9pt
}
</style>
<script>
function switchSysBar(){ 
	var locate=location.href.replace('center.html','');
	var ssrc=document.all("img1").src.replace(locate,'');
	if (ssrc=="manage/images/main_18.gif"){ 
		document.all("img1").src="manage/images/main_18_1.gif";
		document.all("frmTitle").style.display="none" 
	} 
	else{ 
		document.all("img1").src="manage/images/main_18.gif";
		document.all("frmTitle").style.display="" 
	} 
} 

//根据角色不同 改变左侧菜单项
function changeLeft(){
	var value = document.getElementById("user_input").value;
	if(value=="管理员") {
		document.getElementById("frame_left").src="manage/left.jsp";
	}
	if(value=="维护员") {
		document.getElementById("frame_left").src="manage/left1.jsp";
	}
	if(value=="操作员") {
		document.getElementById("frame_left").src="manage/left2.jsp";
	}
}

</script>

</head>

<body onload="changeLeft()">
	<input type="hidden" id="user_input" value="${user.position.name}"/>
	<table width="100%" height="100%" border="0" cellpadding="0"
		cellspacing="0" style="table-layout: fixed;">
		<tr>
			<td width="173" id="frmTitle" noWrap align="center" valign="top" height="100%">
				<iframe src="manage/left.jsp" name="leftFrame" id="frame_left" height="700" width="180" frameborder="0" scrolling="no">
					浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe>
			</td>
			<td width="8" valign="middle" background="manage/images/main_12.gif" onclick="switchSysBar()">
				<span class="navPoint"><img src="manage/images/main_18.gif" name="img1" width="8" height="52" id="img1"></span>
			</td>
			<td align="center" valign="top">
				<iframe src="manage/right.jsp" name="rightFrame" height="450px" width="100%" frameborder="0">
					浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe>
			</td>
			<td width="4" align="center" valign="top" background="manage/images/main_20.gif">
			</td>
		</tr>
	</table>
</body>
</html>