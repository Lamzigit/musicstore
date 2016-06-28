<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ include file="user-header.jsp" %>
	<div role="main">
			<diV class="row">
				<div class="col-md-4 col-md-offset-4">
					<form class="form-horizontal" action="/musicstore/user/doaddconsignee" methode="get">
						<h3>添加地址</h3>
						<div class="form-group">
							<label for="consignee" class="col-sm-2 control-label">收货人</label>
							<div class="col-sm-10">
								<input name="consignee" type="text" class="form-control" id="consignee" placeholder="收货人" value="${name }">
							</div>
						</div>
						<div class="form-group">
							<label for="delieveAddress" class="col-sm-2 control-label">收货地址</label>
							<div class="col-sm-10">
								<input name="deliverAddress" type="text" class="form-control" id="delieveAddress" placeholder="收货地址">
							</div>
						</div>
						<div class="form-group">
							<label for="phone" class="col-sm-2 control-label">手机</label>
							<div class="col-sm-10">
								<input name="phone"  type="text" class="form-control" id="phone" placeholder="手机">
							</div>
						</div>
						<div class="form-group">
							<label for="tel" class="col-sm-2 control-label">联系电话</label>
							<div class="col-sm-10">
								<input name="tel" type="text" class="form-control" id="tel" placeholder="联系电话">
							</div>
						</div>
					    <button type="submit" class="btn btn-default">保存地址</button>
					    <div class="form-group">
					    	<div class="col-sm-10">
					      		<input name="username"  type="hidden" class="form-control" id="username"  value="${name }">
					    	</div>
					    </div>							     
					</form>
				</div>	
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
		</div>
	</footer>
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>