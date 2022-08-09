<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src ="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body>
	<h1>Reply Test Form</h1>
	
	<script>
		function requestreply(){
			var info = {
					"bno" : $("#bno").val(),
					"reply" : $("#reply").val(),
					"replyer" : $("#replyer").val()
			};
			$.ajax({
				type : "POST",
				url : "/replies/new",
				async : true,
				data : JSON.stringify(info),
				dataType : "json",
				contentType : "application/json;charset=UTF-8",
				success : function(data){
					;
				},
				error : function(error){
					console.log(error);
				}
					
			});
		}
	</script>
	
	
	<input type = text name = bno id = bno>
	<input type = text name = reply id = reply>
	<input type = text name = replyer id = replyer>
	<button onclick="requestreply()">전송</button>
</body>
</html>