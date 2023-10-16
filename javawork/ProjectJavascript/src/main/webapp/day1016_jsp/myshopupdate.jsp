<%@page import="myshop.data.MyShopDao"%>
<%@page import="myshop.data.MyShopDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
	//한글 인코딩
	request.setCharacterEncoding("utf-8");

	//dao, dto  선언
	String num=request.getParameter("num");
	MyShopDao dao=new MyShopDao();
	MyShopDto dto=dao.getSangpum(num);
	
	//num 포함 모든 데이터 읽기
	String sangpum=request.getParameter("sangpum");
	String color=request.getParameter("color");
	String photo=request.getParameter("photo");
	int price=Integer.parseInt(request.getParameter("price"));
	
	//dto에 담기

	dto.setSangpum(sangpum);
	dto.setColor(color);
	dto.setPhoto(photo);
	dto.setPrice(price);
	
	//updateShop 메서드 호출
	dao.updateShop(sangpum, color, price, photo, num);
	
	//myshopdetail.jsp 로 이동하기 (? 로 num 넘겨야 함)
	response.sendRedirect("myshopdetail.jsp?num="+num);

%>