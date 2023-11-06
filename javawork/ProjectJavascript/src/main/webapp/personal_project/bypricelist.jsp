<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="personal.data.PersonalDto"%>
<%@page import="java.util.List"%>
<%@page import="personal.data.PersonalDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PersonalDao dao=new PersonalDao();
	List<PersonalDto> list=dao.getByPrice();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
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
		
		arr.add(ob);
	}
%>
<%=arr.toString()%>