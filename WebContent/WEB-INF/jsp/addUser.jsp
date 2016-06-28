<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function addUser(){
		var form = document.forms[0];
		form.action = "/spring/addUser";
		form.method="post";
		form.submit();
	}
</script>
</head>
<body>
	<h1>添加用户</h1>
	<form action="" name="userForm">
		姓名：<input type="text" name="userName">
		年龄：<input type="text" name="age">
		<input type="button" value="添加" onclick="addUser()">
	</form>
</body>
</html>l>