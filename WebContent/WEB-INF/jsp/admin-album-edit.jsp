<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin-left-menu.jsp" %>
        <!--内容面板开始-->
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">编辑歌曲</h1>
          <form action="/musicstore/admin/doeditsong" method="post"   enctype="multipart/form-data">
            <div class="row">
              <div class="col-md-3">
                <fieldset>
                   <input name="id" type="hidden" class="form-control" id="id"  value="${album.id }">
                  <div class="form-group">
                    <label for="title">歌名</label>
                    <input name="title" type="text" class="form-control" id="title"  value="${album.title }">
                  </div>
                  <div class="form-group">
                    <label for="artist">歌手</label>
                    <input name="artist" type="text" class="form-control" id="artist"  value="${album.artist }">
                  </div>
                  <div class="form-group">
                    <label for="dateReleased">日期</label>
                    <input name="dateReleased" type="text" class="form-control" id="dateReleased" value="${album.dateReleased }">
                  </div>
                  <div class="form-group">
                    <label for="price">价格</label>
                    <input name="price" type="text" class="form-control" id="price" value="${album.price }">
                  </div>
                  <div class="form-group">
                    <label for="genreid" class="sr-only">歌曲类型</label>
                    <input name="genreid" type="hidden" class="form-control" id="genreid" placeholder="歌曲类型" value="2">
                  </div>
                  <div class="form-group">
	                  <label for="genreid" class="">歌曲类型</label>
	                  <select class="form-control"  name="genreid">
	                  	<c:if test="${!empty genrelist }">
									<c:forEach items="${genrelist }" var="genre" >
											<c:choose>
												<c:when test="${genre.id == album.genreid }">
														<option value ="${genre.id }"  selected>${genre.name}</option>
												</c:when>
												<c:otherwise>
														<option value ="${genre.id }">${genre.name}</option>	
												</c:otherwise>
											</c:choose>								
									</c:forEach>
							</c:if>
						</select>
						</div>
					<div class="form-group">
                    <label for="title" class="sr-only">歌名</label>
                   <input name="picPath" type="hidden" value="${album.picPath }"/>
                  </div>
                  <button type="submit" class="btn btn-default">保存</button>
                </fieldset>
              </div>
              <div class="col-md-3">
                <fieldset>
                  <div class="form-group">
                    <label for="album-cover">上传封面</label>
                    <div  class="input-upload">
                      <input name="file" type="file" id="album-cover">
                      <p class="help-block">允许上传jpg，png格式文件</p>
                    </div>
                  </div>
                  <div class="">
                    <a href="#" class="thumbnail">
                      <img src="${album.picPath }" alt="">
                    </a>
                  </div>
                   <!--<div class="form-group">
                    <label for="album-song">上传歌曲文件</label>
                    <div  class="input-upload">
                      <input type="file" id="album-song">
                      <p class="help-block">允许上传mp3格式文件</p>
                    </div>
                  </div> -->
                </fieldset>
              </div>
              <div class="col-md-5 ">
                <label for="desc">详情</label>
                <textarea name="description" class="form-control" id="desc" rows="20">
                	${album.description}
                </textarea>
              </div>
            </div>
            
          </form>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</body></html>