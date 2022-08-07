<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>글보기</title>


<%@include file="/resources/includes/link.jsp" %>
<script type="text/javascript" src="/resources/js/reply.js"></script>
</head>
<body>
	<script>
		console.log(replyService);
	</script>

<%@page import="java.util.*, com.korea.domain.*" %>

	<%
		BoardDTO board = (BoardDTO)request.getAttribute("board");
		// out.println("board : "+board);
		
	%>
	<div id="wrapper" class="container-md">
		<div id="top-header">
		</div>
		<div id="nav">
			<%@include file="/resources/includes/nav.jsp" %>
		</div>
		<div id="contents">
			<!-- 글보기 화면 처리  -->
			<h1>게시글 페이지</h1>
				<input class="form-control mt-2" name="title" placeholder="title" value="${board.title }">
				<textarea name="content" class="form-control mt-2">${board.content }</textarea>
				<input class="form-control mt-2" name="writer" placeholder="writer" value="${board.writer }">
				
				<input type="button" value="글수정" class="btn btn-dark mt-2"
				onclick="javasctript:location.href='/board/modify?bno=${board.bno }'">
				
				<input type="button" value="리스트 이동" class="btn btn-dark mt-2">
				
		</div>
		
		<form action="/board/list" method="get" name ="operform">
			<input type = "hidden" name = "bno" value =${board.bno}>
			<input type = "hidden" name = "pageNum" value =${cri.pageNum}>
			<input type = "hidden" name = "amount" value =${cri.amount}>
			<input type = "hidden" name ="type" value = ${cri.type}>
			<input type = "hidden" name ="keyword" value = ${cri.keyword}>
		</form>
		
		<script type="text/javascript">
			$(document).ready(function(){
				form = document.operform;
				$(".move").on("click",function(){
					form.submit();
				})
			})
		</script>
		
</div>
</body>
</html>