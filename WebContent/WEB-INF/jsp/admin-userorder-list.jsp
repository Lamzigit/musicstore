<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin-left-menu.jsp" %>
        <!--内容面板开始-->
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">订单列表</h1>
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
												  <a href="/musicstore/admin/getconsigneedesc/${userorder.id}" type="button" class="btn btn-default">订单详情</a>
												   <c:if test="${userorder.getIsDeliveried() == 0 }">
												  		<a href="/musicstore/admin/dodelivery/${userorder.id}" type="button" class="btn btn-default">发货</a>
												  	</c:if>	
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
      </div>
    </div>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.12.4.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</body></html>