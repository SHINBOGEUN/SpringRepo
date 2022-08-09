<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>글등록</title>

<%@include file="/resources/includes/link.jsp" %>
</head>
<body>
	<div id="wrapper" class="container-md">
		<div id="top-header">
		
		</div>
		<div id="nav">
			<%@include file="/resources/includes/nav.jsp" %>
		</div>
		<div id="contents">
			<!-- 글등록 화면 처리  -->
			<h1>글 등록</h1>
			<form action="/board/register" method="post">
				<input class="form-control mt-2" name="title" placeholder="title">
				<textarea name="content" class="form-control mt-2"></textarea>
				<input class="form-control mt-2" name="writer" placeholder="writer">
				<input type="submit" value="글등록" class="btn btn-dark mt-2">
				<input type="reset" value="리셋" class="btn btn-dark mt-2">
				
			</form>
		</div>
		
</div>
</body>
</html>