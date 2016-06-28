<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ include file="admin-left-menu.jsp" %>
        <!--内容面板开始-->
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	          <h1 class="page-header">订单详情</h1>
	          <div class="row">
		          	<div class="col-md-7">
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
										                  <td>
										                  </td>
										                </tr>	
									             </c:forEach>
										</c:if>							              
									</tbody>
				            </table>
				         </div>
	         		 </div>
	         		 <div class="col-md-5 ">
		          			<div role="consignee-desc"   class="table-responsive">
		          					 <div class="consignee">
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
									  </div>
							</div>
		          	</div>
    		</div>
   			</div>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.12.4.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</body>
</html>