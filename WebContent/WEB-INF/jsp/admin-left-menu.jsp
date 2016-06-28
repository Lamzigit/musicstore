<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
   <!--   <link rel="icon" href="http://v3.bootcss.com/favicon.ico">-->
    

    <title>控制台</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
     <link href="<%=request.getContextPath()%>/css/dashboard.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/common.css">
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="<%=request.getContextPath()%>/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
        <!--移动端显示-->
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="">控制台</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="/musicstore/admin/albumlist">歌曲列表</span></a></li>
            <li><a href="/musicstore/admin/userlist">用户列表</a></li>
            <li><a href="/musicstore/admin/getconsigneelist">地址列表</a></li>
            <li><a href="/musicstore/admin/getorderlist">订单列表</a></li>
            <li><a href="http://v3.bootcss.com/examples/dashboard/#">帮助</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="搜索...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
      <!--控制台左侧菜单开始-->
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <h2>歌库管理</h2>
            <li class="active"><a href="/musicstore/admin/albumlist">歌曲列表<span class="sr-only">(current)</span></a></li>
            <li class="active"><a href="/musicstore/admin/genrelist">歌曲类型<span class="sr-only">(current)</span></a></li>
            <!--<li class=""><a href="/musicstore/admin/albumlist">歌曲列表<span class="sr-only">(current)</span></a></li>  -->
          </ul>
          <ul class="nav nav-sidebar">
            <h2>用户管理</h2>
            <li><a href="/musicstore/admin/userlist">用户列表</a></li>
            <li><a href="/musicstore/admin/getconsigneelist">地址列表</a></li>
            <!--<li><a href="">项目二</a></li>
            <li><a href="">项目三</a></li>
            <li><a href="">项目四</a></li>  -->
          </ul>
          <ul class="nav nav-sidebar">
            <h2>订单管理</h2>
            <li><a href="/musicstore/admin/getdeliveriedorderlist">已发货订单列表</a></li>
            <li><a href="/musicstore/admin/getnotdeliveryorderlist">未发货订单列表</a></li>
            <li><a href=""></a></li>
          </ul>
        </div><!--控制台左侧菜单结束-->