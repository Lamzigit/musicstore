<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="user-header.jsp" %>
	<div role="main">
		<div class="container ">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-5">
						<div class="">
						      <form class="form-info-modify"  action="/musicstore/user/douserinfomodify/${name }" method="post"> 
						        <h2 class="form-signin-heading">修改用户信息</h2>
								<input name="id" type="hidden" id="inputid" class="form-control"  value="${user. id}"  required autofocus>
								
						        <label for="inputEmail" class="">电子邮件</label>
						        <input name="email" type="email" id="inputEmail" class="form-control"  value="${user. email}"  required autofocus>
						        
						        <label for="inputUsername" class="">用户名</label>
						        <input name="username" type="text" id="inputUsername" class="form-control"   value="${user. username}"  required autofocus>
					
						        <label for="inputPassword" class="">密码</label>
						        <input name="password" type="password" id="inputPassword" class="form-control"   value="${user. password}"  required>
						        
						         <label for="inputAddress" class="">地址</label>
						        <input name="address" type="text" id="inputAddress" class="form-control"  value="${user. address}"   required>
						        
						        <label for="inputPhone" class="">电话</label>
						        <input name="phone" type="phone" id="inputPhone" class="form-control"   value="${user. phone}"  电话" required>
					
								 <label for="inputName" class="">别名</label>
						         <input name="nickname" type="text" id="inputName" class="form-control"  value="${user. nickname}"  别名" required>
						         
						         <input name="id"  type="hidden" id=""  value="0" />				       
					
						        <button class="btn btn-lg btn-primary btn-block" type="submit">保存</button>
						      </form>
						</div>								
				</div>
				<div class="col-md-2"></div>
				<%@ include file="user-aside.jsp" %>
		</div>
	</div>
	<footer class="main-footer">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<ul>
						<h2>最新歌单</h2>
						<li><a href="#" class="">
							歌单名称
							<p class="date">2015年3月21日</p>
						</a></li>
						<li><a href="#" class="">
							歌单名称
							<p class="date">2015年3月21日</p>
						</a></li>
						<li><a href="#" class="">
							歌单名称
							<p class="date">2015年3月21日</p>
						</a></li>
					</ul>
				</div>
				<div class="col-md-4">
					<ul>
						<h2>最新歌单</h2>
						<li><a href="#" class="">
							歌单名称
							<p class="date">2015年3月21日</p>
						</a></li>
						<li><a href="#" class="">
							歌单名称
							<p class="date">2015年3月21日</p>
						</a></li>
						<li><a href="#" class="">
							歌单名称
							<p class="date">2015年3月21日</p>
						</a></li>
					</ul>
				</div>
				<div class="col-md-4">
					<ul>
						<h2>最新歌单</h2>
						<li><a href="#" class="">
							歌单名称
							<p class="date">2015年3月21日</p>
						</a></li>
						<li><a href="#" class="">
							歌单名称
							<p class="date">2015年3月21日</p>
						</a></li>
						<li><a href="#" class="">
							歌单名称
							<p class="date">2015年3月21日</p>
						</a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>