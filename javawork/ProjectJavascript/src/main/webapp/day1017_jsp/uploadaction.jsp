<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	//프로젝트의 save 폴더의 배포된 곳의 경로 구하기
	ServletContext context=getServletContext();
	String realPath=context.getRealPath("/save");
	//업로드할 파일의 크기 저장
	int uploadSize=1024*1024*3;//3mb
%>
<body>
	<h5>save 폴더의 경로 구하기<br><%=realPath %></h5>
	<%
		MultipartRequest multirequest=null;
		try{
			multirequest=new MultipartRequest(request,realPath,uploadSize,"utf-8",
					new DefaultFileRenamePolicy());//같은 이름으로 업로드 될 경우 파일명 뒤에 숫자를 붙여줌
			String title=multirequest.getParameter("title"); 
			String originalFileName=multirequest.getOriginalFileName("upload"); 
			String uploadName=multirequest.getFilesystemName("upload"); 
			%>
			<h4>
				제목 : <%=title %><br>
				오리지널 파일명 : <%=originalFileName %><br>
				실제 업로드된 파일명 : <%=uploadName %><br>
				실제 업로드된 이미지 <br> 
			</h4>
			<img src="../save/<%=uploadName%>" style="max-width: 400px;">
			
		<%}catch(Exception e){
			out.print("<h2>업로드 오류 발생 :"+e.getMessage()+"</h2>");
		}
	
	%>
</body>
</html>






















