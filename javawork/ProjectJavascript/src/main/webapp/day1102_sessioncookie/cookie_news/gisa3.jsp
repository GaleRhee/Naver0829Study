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
		
제공 | 전북 현대

[스포츠서울 | 전주=강예진기자] “마음이 편해지고, 플레이에 자신감이 생겼다

전북 현대는 1일 전주월드컵경기장에서 열린 2023 하나원큐 대한축구협회(FA)컵
 
준결승에서 문선민과 백승호의 연속골, 박재용의 페널티킥 쐐기골에 힘입어 인천
 
유나이티드를 3-1로 꺾고 결승 무대에 안착했다.

1-1 상황에서 팀에 리드를 선물하는 골을 넣은 백승호는 “큰 목표 중 하나였던 FA컵 

결승에 갔다. 인천이 좋은 분위기였고, 쉽지 않겠다고 생각했는데 준비한대로 선수들이 

잘해줘서 다행이다”고 했다.

골 상황에 대해서는 “공간을 찾아 들어갔는데, (박)재용이가 잘 줬다. 운좋게 

가랑이 사이로 들어가면서 골이 됐다”면서 “경기를 하다보면 되는 날은 가랑이 사이로 

들어가거나 그런다. 원래는 수비벽에 막혔을 텐데, 방향만 꺾어놓자 했는데 다리 사이로 

들어가게 됐다”고 당시 상황을 설명했다.

백승호는 지난 2022 항저우 아시안게임서 금메달을 목에 걸었다. 당초 시즌이 끝나는 12월 

상무에 입대 예정이었지만, ‘군면제’ 혜택을 받은 것. 아시안게임 후 확실히 플레이에 

여유가 생긴 모이다.

그는 “확실한 건 두려운 것도 사라지고, 마음도 편해졌다. 플레이에 자신감이 생겼다. 

마음이 많이 편해졌다”면서 “가장 전성기라는 나이에 상무에 입대하는 상황이었는데, 

전북에서 더 활약할 수 있는 시간이 생겨 여유가 생겨 마음이 편해졌다”고 이야기했다.


제공 | 전북 현대

FA컵 결승은 당장 3일 뒤다. 단판제라는 부담감에 대해선 크게 걱정하지 않는 백승호는 

“팀에 결승 등 큰 무대를 경험한 선수가 많다. 우승도 해본 사람이 한다고 한다. 결승 

무대를 뛰었던 선수들이 있으니까 믿고 있다. 무엇보다 팀을 믿고 준비 잘해서 강한 믿음으로 

경기에 임하는 게 중요한 것 같다”고 다짐했다.

그러면서 “시즌이 얼마 안 남았으니까 힘든 생각보다는 남은 경기 최선 다하자는 생각이다. 

나뿐 아니라 모든 선수가 힘든 생각보다는 이겨내자는 마음으로 준비하고 있다”고 했다.

우승하게 된다면 K리그 통산 최다 우승팀이 된다. 백승호는 “당연히 그걸 목표로 초반부터 

달려왔다. 또 우승을 해야 ACL에 나갈 기회가 생긴다. 목표를 이루기까지 시간 얼마 안 

남았는데 잘 준비해서, 구단 위해서 역사 만들 수 있도록 하겠다”고 힘주어 말했다.
		</pre>
		<br><br>
		<a href="loginmain.jsp">메인 페이지로 이동</a>
	<%}
%>
</body>
</html>














