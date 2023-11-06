<%@page import="personal.data.PersonalDto"%>
<%@page import="personal.data.PersonalDao"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//search 읽기
	String search=request.getParameter("search");
	
	//dao 선언
	PersonalDao dao=new PersonalDao();
	
	//search 단어가 포함된 목록 얻기
	List<PersonalDto> list=dao.getSearchProduct(search);
	
	//날짜 포멧 지정
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	//위의 리스트 목록을 JSONArray 로 배열 형태의 json 으로 구현	
	JSONArray arr=new JSONArray();
	for(PersonalDto dto:list)
	{
		JSONObject ob=new JSONObject();
		ob.put("num",dto.getNum());
		ob.put("name",dto.getName());
		ob.put("photo",dto.getPhoto());
		ob.put("price",dto.getPrice());
		ob.put("content",dto.getContent());
		ob.put("size",dto.getSize());
		ob.put("addday",sdf.format(dto.getAddday()));
		
		//배열에 추가
		arr.add(ob);
	}
%>
<%=arr.toString()%>