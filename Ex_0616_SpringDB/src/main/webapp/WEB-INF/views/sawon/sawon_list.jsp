<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border = "1">
	
	<tr>
		<th>사번</th>
		<th>이름</th>
		<th>부서번호</th>
		<th>직종</th>
		<th>입사일</th>
	</tr>
	
	<c:forEach var = "i" items = "${list}">
		<tr>
			<td>${i.sabun}</td>
			<td>${i.saname}</td>
			<td>${i.deptno}</td>
			<td>${i.sajob}</td>
			<td>${i.sahire}</td>
		</tr>
		
		
	</c:forEach>
	
	</table>
	
	

</body>
</html>