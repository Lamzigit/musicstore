<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ZH-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>用户注册|(duck.com)</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/common.css">
</head>
<body>
	<div class="login">
		<div class="container">
	      <form class="form-signin" action="/musicstore/user/doregister" method="post"> 
	        <h2 class="form-signin-heading">注册</h2>

	        <label for="inputEmail" class="sr-only">电子邮件</label>
	        <input name="email" type="email" id="inputEmail" class="form-control" placeholder="电子邮件" required autofocus>
	        
	        <label for="inputUsername" class="sr-only">用户名</label>
	        <input name="username" type="text" id="inputUsername" class="form-control" placeholder="用户名" required autofocus>

	        <label for="inputPassword" class="sr-only">密码</label>
	        <input name="password" type="password" id="inputPassword" class="form-control" placeholder="密码" required>
	        
	         <label for="inputAddress" class="sr-only">地址</label>
	        <input name="address" type="text" id="inputAddress" class="form-control" placeholder="地址" required>
	        
	        <label for="inputPhone" class="sr-only">电话</label>
	        <input name="phone" type="phone" id="inputPhone" class="form-control" placeholder="电话" required>

			 <label for="inputName" class="sr-only">别名</label>
	         <input name="nickname" type="text" id="inputName" class="form-control" placeholder="别名" required>
	         
	         <input name="id"  type="hidden" id=""  value="0" />
	         
	         <!--  <input name="userroleid"  type="hidden" id=""  value="1">
	         <input name="isinuse" type="hidden" id=""  value="1">
	         
        	<label for="confirmPassword" class="sr-only">确认密码</label>
	        <input type="password" id="confirmPassword" class="form-control" placeholder="确认密码" required>-->

	        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
	      </form>
	    </div> <!-- /container -->
		</div>
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>