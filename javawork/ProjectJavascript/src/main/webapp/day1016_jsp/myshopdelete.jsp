<%@page import="myshop.data.MyShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//num 읽기
	String num=request.getParameter("num");
	
	//dao 선언
	MyShopDao dao=new MyShopDao();
	
	//delete 메서드 호출
	dao.deleteShop(num);
	
	//myshop.jsp 로 redirect 이동
	response.sendRedirect("myshop.jsp");
%>