<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ include file="user-header.jsp" %>
	<div role="main">
		<div class="container ">
			<div class="row">			
				<div class="col-md-12 car-list-title">
					<div class="col-md-4">商品信息</div>
					<div class="col-md-2">单价（元）</div>
					<div class="col-md-2">数量</div>
					<div class="col-md-2">金额（元）</div>
					<div class="col-md-2">操作</div>
				</div>
				<c:if test="${!empty viewmodel }">
						<c:forEach items="${viewmodel }" var="vm">
							<div class="col-md-12 car-list-post">
								<div class="col-md-4">
									<div class="row">
										<div class="col-md-6">
											<a href="/musicstore/album/albumdesc/${vm.getAlbumId()  }" class="thumbnail">
												<img src="${vm.picPath }" />
											</a>
										</div>
										<div class="col-md-6">
											<div class="row">
												<div class="col-md-12">
													<a href="/musicstore/album/albumdesc/${vm.getAlbumId()  }"><h1>${vm.getAlbumName()  }</h1></a>
												</div>
												<div class="col-md-12">
													<a href="#"><h2 role ="artist">${vm.getArtist()  }</h2></a>
												</div>
											</div>	
										</div>															
									</div>
								</div>
								<div class="col-md-2  "><p>${vm.getPrice()  }</p></div>
								<div class="col-md-2"><p>${vm.getQuantity() }</p></div>
								<div class="col-md-2"><p>${vm.getUnitPrice()}</p></div>
								<div class="col-md-2"><p><a href="/musicstore/order/deleteorder/${vm.getId() }">删除</a></p></div>
							</div>
						</c:forEach>
					</c:if>	
			<div class="col-md-12 car-list-counter">
				<div class="col-md-4">
					<h2>总计</h2>												
				</div>
				<div class="col-md-2  "><p></p></div>
				<div class="col-md-2"><p>${totalquantity }</p></div>
				<div class="col-md-2"><p>${totalPrice}</p></div>
				<div class="col-md-2"><p><a href="/musicstore/order/OrderConsignee/${totalquantity }/${totalPrice}/${name}">结算</a></p></div>
			</div>
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