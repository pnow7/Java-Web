<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	Map<String, String> map = new HashMap<>();
	map.put("1", "리액트 공부하기");
	map.put("2", "useState 이해하기 (완료)");
	map.put("3", "투두리스트 만들기 (미완료)");
	
	request.setAttribute("todos", map);
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ToDoList</title>
		<Link rel="stylesheet" href="./css/main.css" type="text/css">
	</head>
	<body>
		<h1>To Do List</h1>
		<h2>할 일 목록</h2>
		<nav>
			<c:forEach var="todo" items="${todos}">
				<li onclick="toggleComplete(this)">${todo.value}</li>
			</c:forEach>
		</nav>
		
		<script src="./js/toggle.js"></script>
	</body>
</html>