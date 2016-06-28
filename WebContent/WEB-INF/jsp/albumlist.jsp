<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tbody>
			<tr>
				<th>专辑名称</th>
				<th>艺术家</th>
				<th>发行日期</th>
				<th>价格</th>
				<th>操作</th>
			</tr>
			<c:if test="${!empty albumlist }">
				<c:forEach items="${albumlist }" var="album">
					<tr>
						<td>${album.title }</td>
						<td>${album.artist }</td>
						<td>${album.dateReleased}</td>
						<td>${album.price }</td>
						<td>
							<a href="">编辑</a>
							<a href="'">删除</a>
						</td>
					</tr>				
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</body>
</html>