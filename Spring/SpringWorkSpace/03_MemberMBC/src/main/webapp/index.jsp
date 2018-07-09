<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${sessionScope.member==null}">
		<form action="/login.do" method="post">
			ID : <input type="text" name="userId"/><br>
			PW : <input type="password" name="userPw"/><br>
			<input type="submit" value="로그인"/><br>
			<a href="/enrollPage.do">회원가입</a>
		</form>
	</c:if>
	<c:if test="${sessionScope.member!=null}">
		<h2>[${member.userName}]님 환영합니다.</h2>
		<br>
		<a href="/logout.do">로그아웃</a><br>
		<a href="/myInfo.do">마이정보 보기</a><br>
		<a href="/delete.do">회원 탈퇴</a><br>
		<c:if test="${sessionScope.member.userId=='admin'}">
			<a href="/selectAllMember.do">전체회원 보기 [관리자 전용]</a>
		</c:if>
	</c:if>

	
</body>
</html>