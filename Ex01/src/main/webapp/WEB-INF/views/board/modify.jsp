<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>글수정</title>

<%@include file="/resources/includes/link.jsp" %>
</head>
<body>
<%-- <%@page import="java.util.*, com.korea.domain.*" %>
	<%
		BoardVO board = (BoardVO)request.getAttribute("result");
		out.println("result : "+board);
		
	%> --%>
	<div id="wrapper" class="container-md">
		<div id="top-header">
		
		</div>
		<div id="nav">
			<%@include file="/resources/includes/nav.jsp" %>
		</div>
		<div id="contents">
			
			<h1>글 수정 페이지</h1>
			
			<script>
				$(document).ready(function(){
					$("input[type='submit']").on("click",function(e){
						e.preventDefault(); //기본 submit 기능 해제
						let operation = $(this).data("oper");
						if(operation==="remove"){
							$('form').attr("action","/board/remove");
							
						}else if(operation==="list"){
							self.location = "/board/list";
							
							return ;
						}
						$('form').submit();
					})
				})
			</script>
			<form role="form" action="/board/modify" method="post">
				<input class="form-control mt-2" name="title" placeholder="title" value="${board.title }">
				<textarea name="content" class="form-control mt-2">${board.content }</textarea>
				<input class="form-control mt-2" name="writer" placeholder="작성자" value="${board.writer }">
				<input type="submit" data-oper='modify' value="글수정" class="btn btn-dark mt-2">
				<input type="submit" data-oper='remove' value="글삭제" class="btn btn-dark mt-2">
				<input type="submit" data-oper='list' value="리스트" class="btn btn-dark mt-2">
				
				<input type="hidden" name="bno" value="${board.bno }">
				<input type="hidden" name="regDate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regdate }" />'>
				
			</form>
		</div>
		
</div>
</body>
</html>