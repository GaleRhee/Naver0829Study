<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="student.data.StudentDto"%>
<%@page import="java.util.List"%>
<%@page import="student.data.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//search 읽기
	String search=request.getParameter("search");
	
	//dao 선언
	StudentDao dao=new StudentDao();
	
	//search 단어가 포함된 목록 얻기
	List<StudentDto> list=dao.getSearchName(search);
	
	//날짜 포멧 지정
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	//위의 리스트 목록을 JSONArray 로 배열 형태의 json 으로 구현	
	JSONArray arr=new JSONArray();
	for(StudentDto dto:list)
	{
		JSONObject ob=new JSONObject();
		ob.put("num",dto.getNum());
		ob.put("name",dto.getName());
		ob.put("blood",dto.getBlood());
		ob.put("phone",dto.getPhone());
		ob.put("writeday",sdf.format(dto.getWriteday()));
		
		//배열에 추가
		arr.add(ob);
	}
%>
<%=arr.toString()%>