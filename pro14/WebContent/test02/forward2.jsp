<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="sec01.ex01.*" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	MemberBean member = new MemberBean("lee", "1234", "수", "LEE@LEE.com");
	request.setAttribute("member", member);
--%>

<html>
	<head>
		<meta charset="UTF-8">
		<title>forward2</title>
	</head>
	<body>	
		<jsp:forward page="member2.jsp" />
	</body>
</html>