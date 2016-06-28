<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="user-header.jsp" %>
	<div role="main">
		<div class="container ">
			<div class="row">
				<div class="col-md-9">
					<h2  class="  nav-right"><span  style="font-size:30px" class="label label-default">${user.username}</span></h2>
					<div class="row"     style="border-top:1px solid #000;margin-top:50px;padding-top:10px"      role="userinfo">
						<div class="row  header">
								<div class="col-md-10">
										<h3>个人信息</h3>
								</div>
								<div class="col-md-2">
										<a class="btn btn-default  btn-lg" href="/musicstore/user/userinfomodify/${name }">修改信息</a>
								</div>
						</div>	
						<div  class="table-responsive">
		          					 <div class="consignee">
									        	<table  class="table table-striped">
									        		<tr>
									        			    <td>别名：</td>
															<td>${user.nickname}</td>
									        		</tr>
									        		<tr>
									        			    <td>电子邮件：</td>
															<td>${user.email}</td>
									        		</tr>
									        		<tr>
									        			    <td>地址：</td>
															<td>${user.address}</td>
									        		</tr>
									        		<tr>
									        			    <td>手机  ：</td>
															<td>${user.phone}</td>
									        		</tr>

									        	</table>
									  </div>
						</div>							
					</div>					
					<div class="row "  style="border-top:1px solid #000;margin-top:50px;padding-top:10px" role="orderlist">
						<h3>历史订单：</h3>
						<div class="table-responsive">
				            <table class="table table-striped">
				              <thead>
				                <tr>
				                  <th>订单编号</th>
				                  <th>用户名</th>
				                  <th>下单日期</th>
				                  <th>付款方式</th>
				                  <th>数量</th>    
				                  <th>总额</th> 
				                  <th>备注</th>           
				                </tr>
				              </thead>
				              		<tbody>
							              <c:if test="${!empty userorderlist }">
												<c:forEach items="${userorderlist }" var="userorder">
													<c:if test="${userorder.isPay == 1}">		              
										                <tr   id="${userorder.id}">
										                  <td>${userorder.id}</td>
										                  <td>${userorder.user.username}</td>
										                  <td>${userorder.getOrderDate()}</td>
										                  <td>
										                  	<c:choose>
										                  		<c:when test="${userorder.payMethod == 0}">
										                  			在线支付
										                  		</c:when>
										                  		<c:when test="${userorder.payMethod == 1}">
										                  			货到付款
										                  		</c:when>
										                  	</c:choose>
										                  </td>
										                  <td>${userorder.totalquantity}</td>
										                  <td>${userorder.totalpayment}</td>
										                  <td>${userorder.remark}</td>
										                  <td>
											                  <div class="btn-group" role="group" aria-label="...">
																  <a href="/musicstore/user/getconsigneedesc/${userorder.id}" type="button" class="btn btn-default">订单详情</a>
																</div>
										                  </td>
										                </tr>
										               </c:if>		
									             </c:forEach>
										</c:if>							              
									</tbody>
				            </table>
				        </div>
					</div>
					<div class="row "  style="border-top:1px solid #000;margin-top:50px;padding-top:10px"    role="consignee">
						<div class="row  header">
								<div class="col-md-10">
										<h3>地址列表</h3>
								</div>
								<div class="col-md-2">
										<a class="btn btn-default  btn-lg" href="/musicstore/user/addconsignee">添加地址</a>
								</div>
						</div>	
						<div role="consignee-desc"   class="table-responsive">
		          					 <div class="consignee">
									        	<table  class="table table-striped">
									        		<tr>
									        			    <td>用户名  ：</td>
									        			    <td>收件人  ：</td>
									        			    <td>配送地址  ：</td>
									        			    <td>手机  ：</td>
									        			    <td>联系电话   :</td>	
									        		</tr>
									        		<c:if test="${!empty consigneelist }">
															<c:forEach items="${consigneelist }" var="consignee">
													        		<tr>
													        			    <td>${consignee.username}</td>
																			<td>${consignee.consignee}</td>
																			<td>${consignee.deliverAddress}</td>
																			<td>${consignee.phone}</td>
																			<td>${consignee.tel}</td>
													        		</tr>
													        </c:forEach>
												    </c:if>	
									        	</table>
									  </div>
							</div>
					</div>
					<div class="row"       style="border-top:1px solid #000;margin-top:50px;padding-top:10px"    >
							<h3>购物车</h3>			
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
															<img src="<%=request.getContextPath()%>/img/${vm.getAlbumId()  }.jpg" />
														</a>
													</div>
													<div class="col-md-6">
														<div class="row">
															<div class="col-md-12">
																<a href="/musicstore/album/albumdesc/${vm.getAlbumId()  }"><h4>${vm.getAlbumName()  }</h4></a>
															</div>
															<div class="col-md-12">
																<a href="#"><h5 role ="artist">${vm.getArtist()  }</h5></a>
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
		
				</div><!-- col-md-9 -->
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