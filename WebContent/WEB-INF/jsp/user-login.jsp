<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ZH-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>用户登录|(duck.com)</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/common.css">
</head>
<body>
	<div class="login">
		<div class="container">
	      <form class="form-signin" action="/musicstore/user/dologin">
	        <h2 class="form-signin-heading">登录</h2>
	        <label for="inputname" class="sr-only">用户名</label>
	        <input name="username" type="text" id="inputUsername" class="form-control" placeholder="用户名" required autofocus>
	        <label for="inputPassword" class="sr-only">密码</label>
	        <input name="password" type="password" id="inputPassword" class="form-control" placeholder="密码" required>
	        <div class="checkbox">
	          <label>
	            <input type="checkbox" value="remember-me"> 记住我
	          </label>
	        </div>
	        <button class="btn btn-lg btn-primary btn-block" type="submit">登入</button>
	      </form>
	    </div> <!-- /container -->
		</div>
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html><body>

</body>
</html>