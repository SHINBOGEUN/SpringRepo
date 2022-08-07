<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="#">BOARD</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="#">Home</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#">Link</a>
		        </li>
		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            Dropdown
		          </a>
		          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
		            <li><a class="dropdown-item" href="#">Action</a></li>
		            <li><a class="dropdown-item" href="#">Another action</a></li>
		            <li><hr class="dropdown-divider"></li>
		            <li><a class="dropdown-item" href="#">Something else here</a></li>
		          </ul>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link disabled">Disabled</a>
		        </li>
		      </ul>
		      <form class="d-flex" action="/board/list" method =get id="searchForm">
		      	<select name ="type">
		      		<option value="T"<c:out value="${pageMaker.cri.type == 'T'? 'selected':''}" />>제목</option>
				    <option value="C"<c:out value="${pageMaker.cri.type == 'C'? 'selected':''}" />>내용</option>
				    <option value="W"<c:out value="${pageMaker.cri.type == 'W'? 'selected':''}" />>작성자</option>
		      	</select>
		        <input class="form-control me-2" type="search" placeholder="Search" name ="keyword" aria-label="Search">
		        <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
      			<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
		        <button class="btn btn-outline-success">Search</button>
		      </form>
		      <script>
			      var searchForm = $("#searchForm");
			      $("#searchForm button").on("click", function(){
			      	if(!searchForm.find("option:selected").val()){
			      		alert("검색종류를 선택하세요");
			      		return false;
			      	}
			      	
			      	if(!searchForm.find("input[name='keyword']").val()){
			      		alert("키워드를 입력하세요");
			      		return false;
			      	}
			      		
			      	searchForm.find("input[name='pageNum']").val("1");
			      	e.preventDefault();
			      	searchForm.submit();
			      });
		      </script>
		    </div>
		  </div>
		</nav>
		
		
