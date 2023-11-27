<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
   
   span.day{
   		font-size: 13px;
   		color: gray;
   }
   
   span.ansday{
   		font-size: 12px;
   		color: gray;
   }
   
   .ansdel{
   		font-size: 16px;
   		color: gray;
   		float: right;
   		cursor: pointer;
   }
   
</style>
<script type="text/javascript">
$(function(){
	
	list();//처음 로딩 시 댓글 출력
	
	//댓글 카메라 클릭 시 파일 업로드 버튼 실행
	$(".uploadcamera").click(function(){
		$("#upload").trigger("click");
	});
	
	//사진 업로드
	$("#upload").change(function(){
		
		let formData=new FormData();
		formData.append("upload",$("#upload")[0].files[0]);
		$.ajax({
			type:"post",
			dataType:"json",
			url:"../answer/upload", 
			data: formData,
			processData:false,
			contentType:false,
			success:function(res){
				//업로드 후에 반환 받은 파일명을 댓글의 이미지에 넣어준다
				$("img.answerphoto").attr("src","../res/upload/"+res.photoname);
				
			}
		});
	});
	
	//댓글 추가 이벤트
	$("#btnansweradd").click(function(){
		let msg=$("#answermsg").val();
		let num=${dto.num};
		if(msg.length==0){
			alert("댓글 내용을 입력해주세요");
			return;
		}
		//alert(msg+":"+num);
		$.ajax({
			type:"post",
			dataType:"text",
			url:"../answer/insert", 
			data: {"num":num,"msg":msg},
			success:function(res){
				//db insert 성공 후 댓글 목록 다시 출력
				list();
				//입력창 초기화
				$("#answermsg").val("");
				
				//댓글 사진 초기화
				$("img.answerphoto").attr("src","../res/photo/noimage.png");
			}
		});
	});
	
	//댓글 삭제
	$(document).on("click",".ansdel",function(){
		let ansidx=$(this).attr("ansidx");
		$.ajax({
			type:"get",
			dataType:"text",
			url:"../answer/delete", 
			data: {"ansidx":ansidx},
			success:function(res){
				list();//삭제 후 목록 다시 출력
			}
		});
	});
	
});//close function

function list()
{
	let num=${dto.num};
	
	let loginok='${sessionScope.loginok}';
	let loginid='${sessionScope.myid}';
	//댓글 출력하는 함수
	$.ajax({
		type:"get",
		dataType:"json",
		url:"../answer/list", 
		data: {"num":num},
		success:function(res){
			//alert(res.length);
			$("#answercount").text("댓글 "+res.length);//댓글 개수 출력
			
			
			let s="";
			$.each(res,function(idx,item){
				s+=
					`
					\${item.ansname} (\${item.ansid})
					<span class="ansday">\${item.writeday}</span><br>
					`;
				if(item.ansphoto!=null){
					s+=
						`
						<img src="../res/upload/\${item.ansphoto}" width=60 height=60 hspace=20
						style="border-radius: 6px;border: 1px solid gray;">
						`;
				}
				
				s+=
					`
					<span style="margin-left: 8px;">\${item.ansmsg}</span>
					&nbsp;
					
					`;
				
				if(loginok!='' && item.ansid==loginid){
					s+=
						`<i class="bi bi-trash ansdel" ansidx="\${item.ansidx}"></i>`;
				}
					
					
				s+="<br><br>";
			});
			
			$("div.answerlist").html(s);
		}
	});
}

</script>
</head>
<body>
<div>
	<h3 style="text-align: left;"><b>${dto.subject}</b></h3>
	<br>
	<img src="../res/upload/${profile_photo}"
	 class="rounded-circle" border="1" hspace="10" align="left"
	 width="50" height="50" onerror="this.src='../res/photo/noimage.png'">
	 <div style="text-align: left;">
		<b>${dto.writer}</b><br>
		<span class="day">
			<fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm"/>
			&nbsp;&nbsp;
			조회 : ${dto.readcount}
		</span>
		<br><br>
		<pre style="font-size: 17px;">${dto.content}</pre>
		<br><br>
		<c:if test="${dto.photocount>0}">
			<c:forEach var="photo" items="${dto.photoNames}">
				<img src="../res/upload/${photo}" style="max-width: 400px;">
				<br><br>
			</c:forEach>
			<br><br>
		</c:if>
	</div>
	<div>
		<div id="answercount">댓글 0</div>
	    <div class="answerlist" style="margin-left: 10px;">
	    	댓글 목록이 나올 곳
	    </div>
	    <c:if test="${sessionScope.loginok!=null}">
	    	<div class="answerform input-group" style="width: 700px;">
	    		<input type="file" id="upload" style="display: none;">
	    		<i class="bi bi-camera uploadcamera" style="cursor: pointer; font-size: 26px;margin-right: 16px;margin-top: 8px;color: gray;"></i>
	    		<img src="" class="answerphoto" width="50" height="50" style="border: 0.5px solid gray;border-radius: 8px 0px 0px 8px;" 
	    		 onerror="this.src='../res/photo/noimage.png'">
	    		
	    		<input type="text" class="form-control" style="width: 300px;" placeholder="댓글 내용"
	    		 id="answermsg">
	    		<button type="button" class="btn btn-outline-success btn-sm" id="btnansweradd">저장</button>
	    	</div>
	    </c:if>
	    
	    <!-- 새 글: 파라미터를 아무것도 넘기지 않으므로, default로 처리 -->
	    <br>
		<button type="button" class="btn btn-outline-secondary btn-sm" style="width: 80px;"
		 onclick="location.href='./form'">글 쓰기</button>
		 
		<button type="button" class="btn btn-outline-secondary btn-sm" style="width: 80px;"
		 onclick="location.href='./form?num=${dto.num}&regroup=${dto.regroup}&restep=${dto.restep}&relevel=${dto.relevel}&currentPage=${currentPage}'">답글</button>
		 
		<button type="button" class="btn btn-outline-secondary btn-sm" style="width: 80px;"
		 onclick="location.href='./list?currentPage=${currentPage}'">목록</button>
		 
		<!-- 로그인한 사람이 쓴 글에만 수정, 삭제 버튼이 보이도록 한다 -->
		<c:if test="${sessionScope.loginok!=null and dto.myid==sessionScope.myid}">
			<button type="button" class="btn btn-outline-secondary btn-sm" style="width: 80px;"
		 	 onclick="location.href='./updateform?num=${dto.num}&currentPage=${currentPage}'">수정</button>
		 	 
			<button type="button" class="btn btn-outline-secondary btn-sm" style="width: 80px;"
		 	 onclick="location.href='./delete?num=${dto.num}&currentPage=${currentPage}'">삭제</button>
		</c:if>
	</div>
	<div id="answerend"></div>
</div>
</body>
</html>










