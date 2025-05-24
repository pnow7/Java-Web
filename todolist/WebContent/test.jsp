<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.io.*"%>

<jsp:useBean id="todoList" class="java.util.ArrayList" scope="page" />
<jsp:useBean id="todoMap" class="java.util.HashMap" scope="page" />

<%
	request.setCharacterEncoding("UTF-8");
	
	// 할 일 항목 생성
	Map<String, String> item1 = new HashMap<>();
	item1.put("todo", "리액트 공부하기");
	item1.put("status", "미완료");
	
	Map<String, String> item2 = new HashMap<>();
	item2.put("todo", "useState 이해하기");
	item2.put("status", "완료");
	
	Map<String, String> item3 = new HashMap<>();
	item3.put("todo", "투두리스트 만들기");
	item3.put("status", "미완료");
	
	todoList.add(item1);
	todoList.add(item2);
	todoList.add(item3);
	
	todoMap.put("todoList", todoList);
	todoMap.put("title", "To Do List");
	todoMap.put("subTitle", "할 일 목록");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title><%= todoMap.get("title") %></title>
		<link rel="stylesheet" href="./css/index.css" type="text/css">
	</head>
	<body>
		<h1><%= todoMap.get("title") %></h1>
		<h2><%= todoMap.get("subTitle") %></h2>
		
		<div class="App">		
		
			<form class="add-form" id="addTodoForm">
				<input type="text" placeholder="새 할 일 입력" id="newTodo">
				<button type="submit">추가</button>
			</form>
			
			<ul class="todo-list" id="todoList">
		
<%
	    List<Map<String, String>> list = (List<Map<String, String>>) todoMap.get("todoList");

	    for (Map<String, String> todo : list) {
	 
	        String todoText = todo.get("todo");
	        String status = todo.get("status");
	        
	        String className = "완료".equals(status) ? "completed" : "";
%>

				<li class="todo-item <%= className %>">
				
					<span class="todo">
						<%= todoText %>
					</span>
					
					(<span class="status">
						<%= status %>
					</span>)
					
				</li>
<%
	    }
%>
			</ul>
			
		</div>
			
		<script src="./js/test.js"></script>
		
	</body>
</html>
