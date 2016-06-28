<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin-left-menu.jsp" %>
        <!--内容面板开始-->
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">用户列表</h1>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>编号</th>
                  <th>用户名</th>
                  <th>电子邮件</th>
                  <th>别名</th>
                  <th>电话</th>                
                </tr>
              </thead>
              		<tbody>
			              <c:if test="${!empty userlist }">
								<c:forEach items="${userlist }" var="user">					              
						                <tr   id="${user.id}">
						                  <td>${user.id}</td>
						                  <td>${user.username}</td>
						                  <td>${user.email}</td>
						                  <td>${user.nickname}</td>
						                  <td>${user.phone}</td>
						                  <td>
							                  <div class="btn-group" role="group" aria-label="...">
												  <a href="/musicstore/admin/getuserorderlist/${user.id}" type="button" class="btn btn-default">订单记录</a>
												</div>
						                  </td>
						                </tr>	
					             </c:forEach>
						</c:if>							              
					</tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.12.4.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</body></html>