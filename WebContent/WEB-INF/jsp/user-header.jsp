<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ZH-cn">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>鸭子音乐（duck.com）</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/common.css">
</head>
<body>
	<header class="main-header ">
		<div role="header-img-roller">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h1>鸭子音乐即将发布</h1>
					</div>
					<div class="col-md-12">
						<a href="#" class="btn btn-default btn-doc">陈奕迅</a>
						<a href="#" class="btn btn-default btn-doc">陈奕迅</a>
						<a href="#" class="btn btn-default btn-doc">陈奕迅</a>
						<a href="#" class="btn btn-default btn-doc">陈奕迅</a>
						<a href="#" class="btn btn-default btn-doc">陈奕迅</a>
					</div>
				</div>
			</div>
		</div>
		<nav class="navbar navbar-default"  data-spy="affix-top" data-offset-top="0">
			<div class="container ">
			<!--移动端显示-->
				<div class="navbar-header">
			      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#header-collapse" aria-expanded="false">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <!--图标-->
			      <a class="navbar-brand" href="/musicstore/album/getalbumlist">鸭子音乐</a>
			    </div>
			<!--菜单-->
				<div class="collapse navbar-collapse" id="header-collapse"> 
					<ul class="nav navbar-nav">
						<li><a href="#">发现</a></li>
						<li><a href="/musicstore/order/gotocar?id=${userid }">购物车</a></li>
						<li><a href="/musicstore/user/getuserdesc/${name }">个人信息</a></li>
					</ul>
					<div class="navbar-form navbar-right btn-group" >								
				    <c:choose>
					    <c:when test="${!empty name}">
					        <a href="/musicstore/user/getuserdesc/${userid}" class="btn btn-default">${name }</a>
					        <a href="/musicstore/user/dologout" class="btn btn-default">注销</a>
					    </c:when>
					    <c:otherwise>
					        <a href="/musicstore/user/login" class="btn btn-default">登录</a>
						    <a href="/musicstore/user/register" class="btn btn-default">注册</a>
					    </c:otherwise>
					</c:choose>
					</div>
					<form class="navbar-form navbar-right" role="search" action="/musicstore/album/search "  method="get">
						<div class="input-group">
							<input name ="key" type="text" class="form-control" style="height: 33.5px"placeholder="搜索"></input>
							<span class="input-group-btn">
								<button type="submit" class="btn btn-default">搜</button>
							</span>
						</div>
					</form>
				</div><!--navbar-collapse-->		
			</div><!--container-->	
		</nav>
	</header>