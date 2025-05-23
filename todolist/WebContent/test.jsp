<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.io.*"%>

<jsp:useBean id="todoList" class="java.util.ArrayList" scope="page" />
<jsp:useBean id="todoMap" class="java.util.HashMap" scope="page" />

<%
	request.setCharacterEncoding("UTF-8");
	
	// 할 일 항목 생성
	Map<String, String> item1 = new HashMap<>();
	item1.put("task", "리액트 공부하기");
	item1.put("status", "미완료");
	
	Map<String, String> item2 = new HashMap<>();
	item2.put("task", "useState 이해하기");
	item2.put("status", "완료");
	
	Map<String, String> item3 = new HashMap<>();
	item3.put("task", "투두리스트 만들기");
	item3.put("status", "미완료");
	
	todoList.add(item1);
	todoList.add(item2);
	todoList.add(item3);
	
	todoMap.put("todoList", todoList);
	todoMap.put("title", "To Do List");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title><%= todoMap.get("title") %></title>
		<Link rel="stylesheet" href="./css/index.css" type="text/css">
	</head>
	<body>
		<h1><%= todoMap.get("title") %></h1>
		<h2>할 일 목록</h2>
		<ul id="todoList">
		
<%
	    List<Map<String, String>> list = (List<Map<String, String>>) todoMap.get("todoList");

	    for (Map<String, String> task : list) {
	        String taskText = task.get("task");
	        String status = task.get("status");
	        String className = "완료".equals(status) ? "completed" : "";
%>
			<li class="<%= className %>">
				<span class="task"><%= taskText %></span>
				(<span class="status"><%= status %></span>)
			</li>
<%
	    }
%>
		</ul>
		<script src="./js/test.js"></script>
	</body>
</html>
