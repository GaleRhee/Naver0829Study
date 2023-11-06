<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">    
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
 <style>
     body * {
         font-family: 'Jua';
     }
 </style>
</head>
<%
	//Session 으로부터 저장된 아이디를 얻는다
	String signinid=(String)session.getAttribute("signinid");//없을 경우 null
	
%>

<body>
	<div class="input-group" style="width: 400px;margin: 30px 100px;">
		<h4><%=signinid %> is Signed In</h4>
		<button type="button" class="btn btn-danger"
		style="width: 100px;margin-left: 20px;"
		onclick="location.href='logoutaction.jsp'">Sign Out</button>
	</div>
</body>
</html>