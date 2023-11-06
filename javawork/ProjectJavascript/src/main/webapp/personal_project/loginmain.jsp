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
	//로그인 상태인지 session 값을 얻는다
	String signinok=(String)session.getAttribute("signinok");
%>

<body>
<div style="margin: 50px;">
	<%
	if(signinok==null){%>
		<jsp:include page="loginform.jsp"/>
		<br><br>
		<h3><b>Sign In to Write a Comment</b></h3>
	<%}else{%>
		<jsp:include page="logoutform.jsp"/>
		
	<%}
	%>
</div>
</body>
</html>