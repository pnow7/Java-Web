<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" isELIgnored="false"%>

<%-- core 태그 라이브러리를 사용하기 위해 반드시 선언(prefix="c" 사용해야 <c:set> 사용 가능) --%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<%-- <c:set> 태그를 이용해 변수 선언, value 속성에는 표현 언어를 사용해서 초기화할 수 있음 --%>
<c:set var="id" value="응" scope="page"></c:set>
<c:set var="pwd" value="1234" scope="page"></c:set>
<c:set var="name" value="${'응응응응'}" scope="page"></c:set>
<c:set var="age" value="${5678}" scope="page"></c:set>
<c:set var="height" value="${9101}" scope="page"></c:set>

<html>
	<head>
		<meta charset=”UTF-8">
		<title>회원 정보 출력창</title>
	</head>
	<body>
		<table align="center" border=1>
			<tr align="center" bgcolor="lightgreen">
				<td width="7%">
					<b>아이디</b>
				</td>
				<td width="7%">
					<b>비밀번호</b>
				</td>
				<td width="7%">
					<b>이름</b>
				</td>
				<td width="7%">
					<b>나이</b>
				</td>
				<td width="7%">
					<b>키</b>
				</td>				
			</tr>
						
			<tr align="center">
				<td>${ id }</td>
				<td>${ pwd }</td>
				<td>${ name }</td>
				<td>${ age }</td>
				<td>${ height }</td>
			</tr>		
		</table>	
	</body>	
</html>
