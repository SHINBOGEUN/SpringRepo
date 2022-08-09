<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
   <title>result</title>
</head>
<body>
<h1>
   Result Page
</h1>

<P>  The time on the server is ${serverTime}. </P>

<%@page import="java.util.*, com.korea.domain.*" %>
<%
   SampleDTO dto = (SampleDTO)request.getAttribute("dto");
   
%>

   DTO : <%=dto %> <br>
   DTO.name : <%=dto.getName() %> <br>
   DTO.age : <%=dto.getAge() %>
   
</body>
</html>