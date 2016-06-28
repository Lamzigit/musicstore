<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="user-header.jsp" %>
	<div role="main">
		<div class="container ">
			<div class="row">
				<div class="col-md-9">
					<div class="row">
						<c:if test="${!empty albumlist }">
							<c:forEach items="${albumlist }" var="album">
								<div class="col-md-4">
									<a href="/musicstore/album/albumdesc/${album.id }" class="thumbnail">
										<img src="${album.picPath }" />
										<div class="caption">
											<h3>${album.title }</h3>
										</div>
									</a>
								</div>
							</c:forEach>
						</c:if>						
					</div>					
				</div>
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