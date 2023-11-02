<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">    
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
 <style>
     body * {
         font-family: 'Jua';
     }
 </style>
</head>

<%
	Cookie[] cookies=request.getCookies();
	boolean find=false;
	if(cookies!=null)
	{
		for(Cookie ck:cookies)
		{
			//저장된 쿠키의 이름을 얻기
			String name=ck.getName();
			if(name.equals("loginok")){
				find=true;//해당 쿠키가 존재하면 true
			}
		}
	}
%>
<body>
<%
	if(!find){%>
		<script type="text/javascript">
			alert("먼저 로그인을 해주세요")
			history.back();
		</script>
	<%}else{%>
		<pre style="width: 500px;">
방송인 전현무가 2일 서울 마포구 스탠포드호텔에서 진행된 채널A '성적을 부탁해 : 티처스' 
제작발표회에서 취재진을 향해 포즈를 취하고 있다.'성적을 부탁해 : 티처스'는 공부와 성적이 
고민인 중?고등학생에게 대한민국 최고의 강사진이 직접 코칭해 성적을 올려주는 에듀 솔루션 
프로그램으로 전현무, 한혜진, 장영란이 MC를 맡았으며 정승제, 조정식이 강사로 출연한다. 
		</pre>
		<br><br>
		<a href="loginmain.jsp">메인 페이지로 이동</a>
	<%}
%>
</body>
</html>














