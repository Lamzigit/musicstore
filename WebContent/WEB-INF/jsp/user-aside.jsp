<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-3">
					<ul class="aside-classify">
						<h2>音乐类别</h2>
						<c:if test="${!empty genrelist }">
								<c:forEach items="${genrelist }" var="genre" >
										<li><a class="btn btn-default btn-block" href="/musicstore/album/getalbumlistbygenre/${genre.id }">${genre. name}</a></li>				
								</c:forEach>
						</c:if>
					</ul>
					<ul class="aside-classify">
						<h2>最新歌单</h2>
						<li><a class="btn btn-default btn-block" href="#">歌单名称</a></li>
						<li><a class="btn btn-default btn-block" href="#">歌单名称</a></li>
						<li><a class="btn btn-default btn-block" href="#">歌单名称</a></li>
						<li><a class="btn btn-default btn-block" href="#">歌单名称</a></li>
						<li><a class="btn btn-default btn-block" href="#">歌单名称</a></li>
						<li><a class="btn btn-default btn-block" href="#">歌单名称</a></li>
					</ul>
				</div>
			</div>