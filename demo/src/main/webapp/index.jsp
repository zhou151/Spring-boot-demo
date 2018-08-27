<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<script src="/demo/webjars/jquery/1.8.3/jquery.js"></script> 
<link href="img/favicon.ico" rel="SHORTCUT ICON" />
<!-- <script type="text/javascript" src="js/jquery-1.8.1.min.js"></script> -->
<style type="text/css">

#main {
	margin-top: 30px;
	font-size: 35px;
	color: red;
}

div {
	text-align: center;
}

#tab1 {
	width: 50%;
	text-align: left;
	margin: 0 auto;
	margin-top:20px;
}
#tab1 td{
	width: 50%;
}
</style>
</head>
<body>
	<div id="main">${message}</div>
	<br>
	<%
		out.print("<div>jsp 编译测试 : ok</div>");
	%>
	<table id="tab1" border="1" cellpadding="10" cellspacing="0">
		
	</table>
	<div style="margin-top: 20px;">
		<input type="button" id="btn1" value="上一页"> <input
			type="button" id="btn2" value="下一页">
	</div>
</body>
<script type="text/javascript" src="js/index.js"></script>
</html>