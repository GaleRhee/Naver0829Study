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
		
▲ 더마 스킨케어 브랜드 일소의 브랜드 모델로 발탁된 로운. 제공|일소



[스포티비뉴스=김원겸 기자]배우 로운이 스킨케어 브랜드 광고 모델로 발탁됐다.

로운은 최근 더마 스킨케어 브랜드 일소의 첫 번째 브랜드 모델로 발탁돼 새삼 높아진 인기를 실감케 했다. 브랜드 측은 지난달 31일 모델 발탁 소식과 함께 로운이 참여한 캠페인 영상을 공개했다.

공개된 영상에서 로운은 '매끄로운 코, 일소밖에'라는 슬로건에 걸맞은 매끄럽고 부드러운 피부를 자랑한다. 이번 캠페인 슬로건은 특별히 모델 '로운'의 이름과 브랜드명 일소를 조합해 시너지를 극대화했다.

브랜드 관계자는 "로운 특유의 자신감 있고 청량한 이미지가 브랜드와 시너지를 일으킬 것으로 기대된다. 로운과 함께한 새 광고 캠페인의 다양한 영상과 화보에도 많은 관심 부탁드린다"며 모델 발탁 이유를 밝히며 향후 공개될 콘텐츠에 대한 기대감을 내비쳤다.

로운은 현재 방영 중인 KBS2 월화드라마 ‘혼례대첩’에서 주인공 심정우 역을 맡아 활약을 펼치고 있다. 드라마뿐만 아니라 화보, 광고계에서도 끊임없는 러브콜로 뜨거운 인기를 이어가고 있는 로운의 행보에 기대가 쏠리고 있다.
		
		</pre>
		<br><br>
		<a href="loginmain.jsp">메인 페이지로 이동</a>
	<%}
%>
</body>
</html>














