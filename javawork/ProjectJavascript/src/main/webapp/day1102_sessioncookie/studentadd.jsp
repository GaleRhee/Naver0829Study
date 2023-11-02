<%@page import="student.data.StudentDto"%>
<%@page import="student.data.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name=request.getParameter("name");
	String blood=request.getParameter("blood");
	String phone=request.getParameter("phone");
	
	//db에 저장/dao
	StudentDao dao=new StudentDao();

	//dto에 담기
	StudentDto dto=new StudentDto();
	dto.setName(name);
	dto.setBlood(blood);
	dto.setPhone(phone);

	
	//db 저장/insert
	dao.insertStudent(dto);
	
	//아무것도 반환을 안할 것이라 이따가 ajax에서 html을 주면 된다
%>
