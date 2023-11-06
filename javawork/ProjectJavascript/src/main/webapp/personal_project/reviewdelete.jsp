
<%@page import="personal.data.ReviewsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//idx,num 읽기
	String idx=request.getParameter("idx");
	String num=request.getParameter("num");
	
	//adao 선언
	ReviewsDao adao=new ReviewsDao();
	
	//삭제 메서드 호출
	adao.deleteReview(idx);
	
	//content 로 이동 (num 필요함)
	response.sendRedirect("productcontent.jsp?num="+num);

%>
    
    