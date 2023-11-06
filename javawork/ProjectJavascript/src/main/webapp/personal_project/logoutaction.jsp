<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//signinok session 제거
	session.removeAttribute("signinok");
	//메인 페이지로 이동
	response.sendRedirect("loginmain.jsp");
%>