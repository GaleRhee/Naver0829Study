
<%@page import="personal.data.ReviewsDao"%>
<%@page import="personal.data.ReviewsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//한글 인코딩
	request.setCharacterEncoding("utf-8");
	
	//answerdto 선언
	ReviewsDto dto=new ReviewsDto();
	
	//dao 선언
	ReviewsDao dao=new ReviewsDao();
	
	//데이터 읽어서 dto에 담기
	int num=Integer.parseInt(request.getParameter("num"));
	String writer=request.getParameter("writer");
	String product=request.getParameter("product");
	String content=request.getParameter("content");
	
	dto.setNum(num);
	dto.setWriter(writer);
	dto.setProduct(product);
	dto.setContent(content);
	
	//insert 메서드 호출
	dao.insertReview(dto);
	
	//content 로 이동 (num 을 필요로 한다)
	response.sendRedirect("productcontent.jsp?num="+num);

%>
    
    
    
    
    
    
    
    
    
    
    
    
    
    