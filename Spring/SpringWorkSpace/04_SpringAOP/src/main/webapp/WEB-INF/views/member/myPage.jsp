<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나의 정보</title>
</head>
<body>

	<%-- ModelAndView view = new ModelAndView();객체에 담은것은 바로 key 값으로 사용됨
		ex) 	view.addObject("member", m);// 객체 넘기기
				view.setViewName("member/myPage");// 뷰 페이지 넘기기
		-> 사용시 ${member.name}
	 --%>
	<h1>마이페이지</h1>
	<form action="/mUpdate.do" method="post">
		ID : <input type="text" value="${member.userId}" name="userId" readonly /><br>
		PW : <input type="password" value="********" name="userPw" /><br>
		PW_RE : <input type="password" value="********"  /><br>
		이름 : <input type="text" value="${member.userName}"  name="userName" readonly/><br>
		폰  : <input type="text" value="${member.phone}"  name="phone"/><br>
		<input type="submit" value="회원정보변경"/>
	</form>
</body>
</html>