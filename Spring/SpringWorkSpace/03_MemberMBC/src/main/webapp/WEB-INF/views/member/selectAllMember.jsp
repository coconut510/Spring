<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전체 회원 리스트</title>
<style>
	td,th{
		border:1px solid black;
	}
</style>
</head>
<body>
	<table style="border:1px solid black">
		<tr><th>아이디</th><th>이름</th><th>폰번호</th></tr>
		<c:forEach items="${allMember}" var="m">
			<tr><td>${m.userId} </td><td>${m.userName} </td><td>${m.phone} </td></tr>
		</c:forEach>
	</table>
</body>
</html>