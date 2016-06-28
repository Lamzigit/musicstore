<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ include file="admin-left-menu.jsp" %>
        <!--内容面板开始-->
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">歌曲列表</h1>

          <!--<div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
              <img data-src="holder.js/200x200/auto/sky" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img data-src="holder.js/200x200/auto/vine" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img data-src="holder.js/200x200/auto/sky" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img data-src="holder.js/200x200/auto/vine" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
          </div>-->

          <a class="sub-header  btn btn-primary btn-lg" href="/musicstore/admin/addsong">添加歌曲</a>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>编号</th>
                  <th>歌名</th>
                  <th>歌手</th>
                  <th>价格</th>
                  <th>发布时间</th>                
                </tr>
              </thead>
              		<tbody>
			              <c:if test="${!empty albumlist }">
								<c:forEach items="${albumlist }" var="album">					              
						                <tr   id="${album.id}">
						                  <td>${album.id}</td>
						                  <td>${album.title}</td>
						                  <td>${album.artist}</td>
						                  <td>${album.price}</td>
						                  <td>${album.dateReleased}</td>
						                  <td>
							                  <div class="btn-group" role="group" aria-label="...">
												  <a id="${album.id}"  name="${album.title}" type="button" class="btn btn-default album-del" >删除</a>
												  <a type="button" class="btn btn-default" href="/musicstore/admin/editalbum/${album.id }">编辑</a>
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
	<script type="text/javascript">
		$(function(){
			function dele(i ,name){
				if(confirm("确定删除  "+name+"  嘛？")){
					$.get("/musicstore/admin/dodelete",{"albumid" : i},function (data,status){
						if(status == "success"){					
							$("#"+i).remove();
						};
					});
				}
			};
			
 			$(".album-del").on("click" ,function(e){
				var del = $(e.target);
				dele(del.attr("id"),del.attr("name"));
			});
			
			
		});
	</script>
</body></html>