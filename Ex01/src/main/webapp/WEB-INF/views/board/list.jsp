<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>list</title>

<%@include file="/resources/includes/link.jsp"%>
</head>
<body>
	<%@page import="java.util.*, com.korea.domain.*"%>
	<%
	ArrayList<BoardDTO> list = (ArrayList<BoardDTO>) request.getAttribute("list");
	for (int i = 0; i < list.size(); i++) {
		//out.println(list);
	}
	%>

	<div id="wrapper" class="container-md">
		<div id="top-header"></div>
		<div id="nav">
			<%@include file="/resources/includes/nav.jsp"%>
		</div>
		<div id="contents">
			<!-- 글등록 버튼 추가 -->
			<div class=mt-3 style="text-align: right;">
				<a class="btn btn-secondary" href="/board/register">글등록</a>
			</div>
			<!-- 목록 화면 처리  -->
			<table class="table table-striped table-hover table-bordered mt-3">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>수정일</th>
				</tr>

				<c:forEach items="${list}" var="board">
					<tr>
						<td><c:out value="${board.bno }" /></td>
						<td><a class="move" href='<c:out value="${board.bno}"/>'><c:out value="${board.title }" /></a></td>
						<td><c:out value="${board.writer }" /></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd"
								value="${board.regdate }" /></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd"
								value="${board.updateDate }" /></td>
					</tr>
				</c:forEach>
			</table>
			<script>
				$(document).ready(
						function() {
							var result = '<c:out value="${result}" />'
							checkModal(result);

							//추가
							history.replaceState({}, null, null);

							function checkModal(result) {
								if (result === '' || history.state) {
									return;
								}
								if (parseInt(result) > 0) {
									$(".modal-body").html(
											"게시글 : " + parseInt(result)
													+ " 번이 등록되었습니다.");

								}
								$("#myModal").modal("show");
							}
						})
			</script>
			<!-- 페이지 액션처리 -->
				<form id ="actionForm" action ="/board/list" method ="get">
					<input type = "hidden" name ="pageNum" value = "${pageMaker.cri.pageNum}">
					<input type = "hidden" name ="amount" value = "${pageMaker.cri.amount}">
					<input type = "hidden" name ="keyword" value = "${pageMaker.cri.keyword}">
					<input type = "hidden" name ="type" value = "${pageMaker.cri.type}">
				</form>
						
			<!-- 페이징 처리 -->
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					
					<!-- PREV -->
					<c:if test="${pageMaker.prev}">
						<li class="page-item prev">
							<a class="page-link" href="#" aria-label="Previous"> 
								<span aria-hidden="true">&laquo;</span>
							</a>
						</li>
					</c:if>
					<!-- NUMBER -->
					<c:forEach var = "num" begin = "${pageMaker.startPage}" end ="${pageMaker.endPage}">
						<li class="page-item pageNumber"><a class="page-link" href="${num}">${num}</a></li>
					</c:forEach>
					
					
						
					<!-- NEXT -->
					<c:if test="${pageMaker.next}">
						<li class="page-item next"><a class="page-link" href="#"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
				</ul>
			</nav>
					<script>
							var actionForm = $("#actionForm");
							$(document).ready(function(){
								$(".pageNumber a").on("click", function(e){
									e.preventDefault();
									console.log("clicked");
									actionForm.find("input[name='pageNum']").val($(this).attr("href"));
									actionForm.submit();
								})
							})
							
							$(document).ready(function(){
								$(".move").on("click",function(e){
									e.preventDefault();
									actionForm.append("<input type ='hidden' name='bno' value = '"+ $(this).attr("href") +"'>");
									actionForm.attr("action","/board/get");
									actionForm.submit();
								})
							})
							$(".next a").on("click", function(e){
								e.preventDefault();
								PageNum = Math.ceil((${pageMaker.cri.pageNum} + 9) / 10 + 9)
								actionForm.find("input[name = 'pageNum']").val(PageNum);
								actionForm.submit();
							})
							$(".prev a").on("click", function(e){
								e.preventDefault();
								PageNum = Math.ceil((${pageMaker.cri.pageNum} - 9) / 10)
								actionForm.find("input[name = 'pageNum']").val(PageNum);
								actionForm.submit();
							})
						</script>
			<!-- 모달 시작 -->
			<!-- Modal -->
			<div class="modal" id="myModal" tabindex="-1">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">...</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary">Save
								changes</button>
						</div>
					</div>
				</div>
			</div>
			<!-- 모달 끝 -->
		</div>

	</div>
</body>
</html>