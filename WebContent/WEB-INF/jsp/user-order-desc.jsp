<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="user-header.jsp" %>
<div role="main">
		<div class="container ">
				<div class="row">
						<div class="col-md-9">
								<h1 class="page-header">订单详情</h1>
								<div role="consignee" class="row">
										<div class="col-md-12 ">
									    		<div role="consignee-desc"   class="table-responsive">
													        	<table  class="table table-striped">
													        		<tr>
													        			    <td>用户名  ：</td>
																			<td>${consignee.username}</td>
													        		</tr>
													        		<tr>
													        			    <td>收件人  ：</td>
																			<td>${consignee.consignee}</td>
													        		</tr>
													        		<tr>
													        			    <td>配送地址  ：</td>
																			<td>${consignee.deliverAddress}</td>
													        		</tr>
													        		<tr>
													        			    <td>手机  ：</td>
																			<td>${consignee.phone}</td>
													        		</tr>
													        		<tr>
													        			    <td>联系电话</td>
																			<td>${consignee.tel}</td>
													        		</tr>
													        	</table>
								       			</div>	<!--consignee-desc -->									
										</div>
								</div>
								<div role="orderdetail" class="row">
										<div class="col-md-12">
												<div class="table-responsive">
														<table class="table table-striped">
												        <thead>
												        		<tr>
												                		<th>订单号</th>
												                  		<th>唱片</th>
																  		<th>歌手</th>
												                  		<th>数量</th>
												                  		<th>总价</th>
												                 		 <th>单价</th>                     
												                </tr>
												               </thead>
												               		<tbody>
															        		<c:if test="${!empty orderdesclist }">
																					<c:forEach items="${orderdesclist }" var="orderdesc">					              
																		             		<tr   id="${orderdesc.id}">
																		                  			<td>${orderdesc.id}</td>
																		                  			<td>${orderdesc.getAlbumName()}</td>
																		                  			<td>${orderdesc.getArtist()}</td>
																		                  			<td>${orderdesc.getQuantity()}</td>
																		                  			<td>${orderdesc.getUnitPrice()}</td>
																		                  			<td>${orderdesc.getPrice()}</td>
																		                   </tr>	
																	        		</c:forEach>
																			</c:if>							              
																	</tbody>
												            </table>
												</div>
										</div>
								</div>
									
						</div><!-- col-md-9 -->
						<%@ include file="user-aside.jsp" %>      
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
	</footer>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>