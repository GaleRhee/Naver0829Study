<%@page import="personal.data.PersonalDto"%>
<%@page import="personal.data.PersonalDao"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="personal.data.ReviewsDto"%>
<%@page import="personal.data.ReviewsDao"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">

 <style>
     body * {
         font-family: 'Product Sans Black';
         
     }
     
     body{
		 background-color: #D9D9D9;
		 color: #E8E8E8;
	 }
	 
	 
	 
	 .c9-Nav{
		 z-index: 3;
		 height: 112px;
		 width: 100%;
		 position: fixed;
		 background: url("Personal_project/nav_bar_2.png") no-repeat;
		 background-size: 100% 100%;
		 box-shadow: 0px 7px 20px 0px rgba(0, 0, 0, 0.70);
	 }
	 
	
	
	 div.navbar .nav_logo{
		 
		 display: block;
		 margin-top: 16px;
  		 margin-left: 40.5%;
		 width: 320px;
		 flex-shrink: 0;
		 
		 filter: drop-shadow(5px 8px 20px rgba(0, 0, 0, 1));
	 }
	 
	 
	 div.navbar button.register{
		 float: right;
		 margin-top: 20px; 
		 font-family: 'Product Sans Medium';
		 font-style: normal;
		 font-weight: 500;
		 line-height: normal;
		 letter-spacing: 1px;
		 font-size: 16px;
		 color: #E8E8E8;
		 width: 120px;
		 height: 40px;
		 flex-shrink: 0;
		 border: none;
		 border-radius: 8px;
		 background: #202020;
		 box-shadow: 8px 8px 20px 0px rgba(0, 0, 0, 0.50);
	 }
	 
	 div.navbar button.signin{
		 margin-right: 48px;
	 }
	 
	 div.navbar button.signup{
		 margin-right: 20px; 
	 }
     
     div.uppercontent{
		 width: 100%;
		 height: 136px;
		 background-color: rgb(49, 47, 62);
	 }
	 
	 div.productinfo{
	 	position: absolute;
	 	top: 50%;
	 	left: 50%;
	 	transform: translate(-50%, -50%);
	 	padding:8px;
	 }
     
     span.day{
     	font-size: 14px;
     	color: gray;
     }
     
 </style>
 
 <script type="text/javascript">
 	$(function(){
		$("div.rlist").hide(); //처음에는 댓글 숨기기
		
		//댓글 보이기/숨기기
		$("h6.rcount").click(function(){
			$(this).next().slideToggle('fast');

		});
		
		//댓글 삭제
		$(document).on("click",".reviewdel",function(){
				let a=confirm("삭제하려면 [확인]을 눌러주세요");
			if(a){
				//태그에 넣어둔 idx, num 가져오기
				let idx=$(this).attr("idx");
				let num=$(this).attr("num");
				//댓글 삭제하는 파일로 이동
				location.href=`reviewdelete.jsp?idx=\${idx}&num=\${num}`;
			}
		});
		
		//signin 클릭 시 화면 이동
			$(document).on("click","button.signin",function(){
			window.location.href="./loginform.jsp";
			 
		});
 	});
	
 </script>
 
</head>
<%
	//num 읽기
	String num=request.getParameter("num");

	//dao 선언
	PersonalDao dao=new PersonalDao();
	
	//num 에 해당하는 dto 얻기
	PersonalDto dto=dao.getData(num);
	
	//날짜 출력 양식
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	//댓글 가져오기
	ReviewsDao rdao=new ReviewsDao();
	List<ReviewsDto> rlist=rdao.getReviews(num);
	
%>
<body>
<header class="c9-Nav">
	<nav aria-label="Global" class="c9-globalnav">
		<div class="navbar">
			<img src="./Personal_project/MAIN-LOGO_2.png" class="nav_logo">
			<div>
				<button type="button" class="signin register">Sign In</button>
				<button type="button" class="signup register">Sign Up</button>
			</div>
		</div>
	</nav>
</header>
<div>
	<div class="uppercontent">
	</div>
	<div class="productinfo" style="border-radius: 3px;background-color: #e8e8e8; width: 700px;margin-top: 160px;">
			<div>
				<img src="<%=dto.getPhoto() %>"
				style="width: 650px;border-radius: 5px;margin-left: 16px;margin-top: 16px;">
			</div>
			<div>
				<br>
				<b style="color: #202020;margin-left: 16px;font-size: 34px;"><%=dto.getName()%></b>
				<b style="color: #343434;float:right;font-size: 30px;margin-right: 16px;">￦ <%=dto.getPrice()%></b>
				<b style="color: gray;margin-left: 4px;font-size: 20px;">(<%=dto.getSize()%>)<br></b>
				<b style="color: gray;margin-left: 16px;"><%=sdf.format(dto.getAddday()) %><br></b>
				<b style="color: #202020;margin-left: 16px;"><%=dto.getContent() %></b>
				<br><br><br>
			</div>
			
			<div>
				<div>
					<h6 class="rcount" style="cursor: pointer;color: #202020;margin-left: 16px;">
					Comment <%=rlist.size() %></h6>
					<div class="rlist" style="margin-left: 20px; color: gray;">
					<%
						for(ReviewsDto rdto:rlist){%>
							<b><%=rdto.getWriter() %></b>
							: <span><%=rdto.getContent() %></span>
							&nbsp;
							<span class="day"><%=sdf.format(rdto.getWriteday()) %></span>
							<!-- 삭제 아이콘 -->
							&nbsp;&nbsp;
							<i class="bi bi-trash reviewdel" style="cursor: pointer;float: right;margin-right: 32px"
							idx="<%=rdto.getIdx() %>" num="<%=num %>"></i>
							<br>
						<%}
					%>
				</div>
			</div>
			<br>
			<div align="center">
				<div style="margin-bottom: 16px;">
					<form action="./reviewinsert.jsp" method="post">
						<input type="hidden" name="num" value="<%=num%>">
						<div class="input-group" style="width: 650px;">
							<input type="text" name="writer" class="form-control"
							style="margin-left: 5px;width: 320px;" placeholder="Writer">
							<input type="text" name="product" class="form-control"
							style="margin-left: 5px;width: 320px;" placeholder="Product">
							<input type="text" name="content" class="form-control"
							style="margin-left: 5px;margin-top:4px;width: 580px;" placeholder="Comment">
							
							<button type="submit" class="btn btn-sm" style="background-color: #2f2f2f; color: #e8e8e8;height: 35px;margin-top: 6px;
							box-shadow: -3px -3px 8px 0px rgb(255, 255, 255), 3px 3px 12px 0px rgba(0, 0, 0, 0.20);">Save</button>
						</div>
					</form>
				</div>
				<br><br>
				<button type="button" class="btn"
				style="width: 100px;background-color: #2f2f2f; color: #e8e8e8;margin-bottom: 40px;
				box-shadow: -3px -3px 8px 0px rgb(255, 255, 255), 3px 3px 12px 0px rgba(0, 0, 0, 0.20);" 
				onclick="location.href='main_page_2.html'">Home</button>
				
			</div>
	</div>
</div>
</body>
</html>

















