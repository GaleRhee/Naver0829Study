<%@page import="student.data.StudentDto"%>
<%@page import="student.data.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name=request.getParameter("name");
	String blood=request.getParameter("blood");
	String phone=request.getParameter("phone");
	
	//db에 저장
	StudentDao dao=new StudentDao();

	//dto에 담기
	StudentDto dto=new StudentDto();
	dto.setName(name);
	dto.setBlood(blood);
	dto.setPhone(phone);

	
	//db 저장
	dao.insertStudent(dto);
	
	//총 개수
	int total=dao.getAllNames().size();
%>
<data>
	<name><%=name %></name>
	<blood><%=blood %></blood>
	<phone><%=phone %></phone>
</data>