<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
   
   .home_img{
   	border-radius: 10px;
   	width: 300px;
   	hspace: 20px;
   }
  
</style>
</head>
<c:set var="root" value="<%=request.getContextPath()%>"/>

<body>
<h2>SM-Ninja Collection</h2>
<img src="${root}/res/photo/SM-ninja1.png" class="home_img">&nbsp;&nbsp;
<img src="${root}/res/photo/SM-ninja2.png" class="home_img">
<br><br>
<img src="${root}/res/photo/SM-ninja3.png" class="home_img">&nbsp;&nbsp;
<img src="${root}/res/photo/SM-ninja4.png" class="home_img">

</body>
</html>
