<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>글보기</title>


<%@include file="/resources/includes/link.jsp"%>
<script type="text/javascript" src="/resources/js/reply.js"></script>
</head>
<body>
	<style>
			.chat::-webkit-scrollbar{
				display:none;
			}
			.r-header > .rdate{
				display:inline-block;
				width:90%;
				text-align: right;
			}
			
			li{
				border : 1px solid gray;
				list-style-type : none;
			}
			.header{
				display: flex;
				justify-content: space-between;
			}
		</style>
	<script type="text/javascript">

			console.log("==========");
			console.log("JS TEST");

			var bnoValue = '<c:out value="${board.bno}"/>';
			/* console.log("ssss" + bnoValue)
			replyService.getList({
				bno : bnoValue,
				page : 1
			}, function(list) {
				for (var i = 0, len = list.length || 0; i < len; i++) {
					console.log(list[i].reply);
				}
			}); */

			/* //삭제
			replyService.remove(4, function(count) {
				console.log(count);
				if (count === "success") {
					alert("REMOVED");
				}
			}, function(err) {
				alert("ERROR...");
			});

			// rno번  수정
			replyService.update({
				rno : 96,
				bno : bnoValue,
				reply : " Modified Reply..."
			}, function(result) {
				alert("수정 완료");
			}); */

			//조회
			/* replyService.get(6, function(data) {
				console.log(data);
			}) */

			//for replyService add test
			/* replyService.add({
				reply : "JS Test",
				replyer : "tester",
				bno : bnoValue
			}, function(result) {
				alert("RESULT: " + result);
			}); */
			
			//이벤트 처리
			$(document).ready(function(){
				var bnoValue= '<c:out value="${board.bno}"/>';
				var replyUL = $(".chat");
				
				
				showList(1);
				
				function showList(page){ 
					replyService.getList({bno:bnoValue, page: page||1 }, 
						function(replyPageDTO){
							var str = "";
							
							var replyCnt = replyPageDTO.replyCnt;
							var list = replyPageDTO.list;
							console.log(replyCnt);
							$("#rcnt").html(replyCnt);

					if(list == null || list.length == 0){
						replyUL.html("");
						return;
					}
					for(var i=0, len=list.length || 0; i<len; i++){
						str += "<li class='left clearfix' data-rno="+list[i].rno+">";
						str += "<div><div class='header'><strong class='primary-font'>["+list[i].rno+"] "+list[i].replyer+"</strong>";
						str += "<small class='pull-right text-muted'><a class='rupdatebtn' href='javascript:openupdateform("+list[i].rno +",\""+list[i].reply+"\",\""+list[i].replyer+"\")'>수정</a>&nbsp;" 
						str += "<a href='javascript:deletereply(" + list[i].rno +")'>삭제</a>&nbsp;"
						str += replyService.displayTime(list[i].replyDate) + " </small></div>";
						str += "<p>" + list[i].reply + "</p></div></li>";
					}
					replyUL.html(str);
				});
				}
				
			$("#replybtn").on("click", function(e) {
							var comment = $("#cmt").val();
							alert(comment);
							var reply = {
									reply : comment,
									replyer : 'anonymous',
									bno : bnoValue
							};
							replyService.add(reply,function(result) {
								//alert(result);
								$("#cmt").val("");
								showlist(1);
							})
						})
						
			/* 수정 처리 */
			$("#submitbtn").on("click",function(e){
				alert("수정");
				e.preventDefault();
				form = document.replyform;
				var reply = {
						rno : form[0].value,
						reply : form[1].value
				}
				replyService.update(reply,function(result){
					$("#staticBackdrop").modal('hide');
					showlist(1);
				})
			})
			
			});
			
			function deletereply(rno){
				replyService.remove(rno, function(result){})
				location.reload();
				
			}
			
			
			
			function openupdateform(rno, reply, replyer){
				form = document.replyform;
				form[0].value=rno;
				form[1].value=reply;
				form[2].value=replyer;
				$("#staticBackdrop").modal('show');
				
			}
			
	</script>

	<%@page import="java.util.*, com.korea.domain.*"%>

	<%
	BoardDTO board = (BoardDTO) request.getAttribute("board");
	// out.println("board : "+board);
	%>
		<div id="nav">
			<%@include file="/resources/includes/nav.jsp"%>
		</div>
	<div id="wrapper" class="container-md" style = "display:flex;">
		<div id="top-header"></div>
			<!-- 글보기 화면 처리  -->
		<div id="contents" class='w-50'>
			<h1>Board Read Page</h1>
			<input class="form-control mt-2" name="title" placeholder="title"
				value="${board.title }">
			<textarea name="content" class="form-control mt-2">${board.content }</textarea>
			<input class="form-control mt-2" name="writer" placeholder="writer"
				value="${board.writer }"> <input type="button" value="글수정"
				class="btn btn-dark mt-2"
				onclick="javasctript:location.href='/board/modify?bno=${board.bno }'">

			<input type="button" value="리스트 이동" class="btn btn-dark mt-2">

		</div>


		
		
		
		
		<!-- 댓글 처리 -->

		<div style = "width:600px; padding-left : 100px;">
			<br><br>
			COMMENT
			<div id= comment>
				<textarea class="from-control" id = cmt  placehoder = "댓글을 입력하세요" style="height:300px; width:100%;"></textarea>
			</div>
			<div>
				<a id = replybtn class="btn btn-primary mt-3" onClick="window.location.reload();">댓글 달기</a>
			</div>
			INFO
			<div class = "mt-3">
			댓글 수 : <span id="rcnt"></span>
			</div>
			
			<div class = "chat mt-3" style = "height:310px;overflow:auto;">
				<div class="unit from-control" data-rno="I">
					<!-- Unit -->
					<!-- <div class = "r-header">
						<strong class ="primary-font">USER00</strong>
						<small class = "rdate text-muted">2022-01-01 13:13</small>
					</div>
					<div class = "r-body">
						REPLY TEST
					</div> -->
				</div>
			</div>
		</div>
		<!-- modal -->
		<div class="modal fade" id ="staticBackdrop" data-bs-backdrop = "static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBack">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class= "modal-header">
						<h5 class="modal-title" id ="staticBackdropLabel" >댓글 수정</h5>
						<button type = "button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<form name ="replyform">
						<div class="modal-body">
							<input name = rno id = rno class ="from-control m-2" placeholder="rno" disabled>
							<input name = reply id = reply class ="from-control m-2">
							<input name = replyer id = replyer class ="from-control m-2"disabled>
						</div>
						<div class = "modal-footer">
							<button type = submit id = submitbtn class = "btn btn-primary" onClick="window.location.reload();">수정</button>
							<button type = "button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- Modal -->
				

		<form action="/board/list" method="get" name="operform">
			<input type="hidden" name="bno" value=${board.bno}> <input
				type="hidden" name="pageNum" value=${cri.pageNum}> <input
				type="hidden" name="amount" value=${cri.amount}> <input
				type="hidden" name="type" value=${cri.type}> <input
				type="hidden" name="keyword" value=${cri.keyword}>
		</form>

		<script type="text/javascript">
			$(document).ready(function() {
				form = document.operform;
				$(".move").on("click", function() {
					form.submit();
				})
			})
		</script>

	</div>
</body>
</html>