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
         font-family: 'Product Sans Black';
         
     }
     
     body{
		 background-color: #D9D9D9;
		 color: #343434;
	 }
	 
	  div.signininput{
	 	position: absolute;
	 	top: 50%;
	 	left: 50%;
	 	transform: translate(-50%, -50%);
	 	padding:8px;
	 }
	 
	 button.btn{
	 	width: 120px;
	 	background-color: #2f2f2f; 
	 	color: #e8e8e8;
	 	margin-bottom: 40px;	
		box-shadow: -3px -3px 8px 0px rgb(255, 255, 255), 3px 3px 12px 0px rgba(0, 0, 0, 0.30);
	 }
	 
	 button.home{
	 	margin-left: 16px;
	 }
 </style>
</head>
<%
	//session으로부터 아이디와 체크 저장 값을 얻는다
	String signinid=(String)session.getAttribute("signinid");
	String savestatus=(String)session.getAttribute("savestatus");
	boolean bCheck;
	if(savestatus==null || savestatus.equals("no")){
		bCheck=false;//체크를 안 했을 경우
	}else{
		bCheck=true;//체크를 했을 경우
	}
		
	//체크를 안 했을 경우에는 아이디를 없앤다(이미 들어있는 상태였으니까)
	if(!bCheck) signinid="";
%>
<body>
<div style="margin: 30px 100px;">
<form action="loginaction.jsp" method="post">
	<div style="width: 340px;background-color: #e8e8e8;border-radius: 5px;" class="signininput">
		<caption>
			<h2 align="center">Sign In</h2><br>
			<label><input type="checkbox" name="saveid" style="margin-bottom: 16px;color: gray;"
			<%=bCheck?"checked":"" %>> Save Username</label>
		</caption>
		<div>
			<div width=150>
				<input type="text" class="form-control" 
				style="margin-bottom: 16px;" autofocus 
				required placeholder="Username" name="signinid" value="<%=signinid %>">
				
			</div>
		</div>
		<div width=150>
			<input type="password" class="form-control" 
			required placeholder="Password" name="signinpass">
		</div>
		
		<div style="width: 300px;" align="center">
		<br><br>
			<button type="submit" class="btn signin" style="margin-left: 22px;">Sign In</button>
			<button type="button" class="btn home" 
			onclick="history.back()">Home</button>
		</div>
	</div>
	
</form>
</div>
</body>
</html>



















