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
	<h1>Ticket Form</h1>
	<script>
	
		function requestBodyTest(){
			var info = {
					"tno" : $("#tno").val(),
					"owner" : $("#owner").val(),
					"grade" : $("#grade").val()
			};
			$.ajax({
				type : "POST",
				url : "/restsample/ticket",
				async : true,
				data : JSON.stringify(info),
				dataType : "json",
				contentType : "application/json;charset=UTF-8",
				success : function(data){
					alert(data.tno + " " + data.owner + " " + data.grade);
					
				},
				error : function(error){
					console.log(error);
				}
					
			});
		}
	</script>

	<input type = text name = tno id = tno>
	<input type = text name = owner id = owner>
	<input type = text name = grade id = grade>
	<button onclick="requestBodyTest()">전송</button>
	
	
</body>
</html>