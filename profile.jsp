<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User_Profile</title>
</head>
<body>

<%
String name=(String) session.getAttribute("Db_name");
%>

<h2 style='color:lightgreen'>Welcome ${Db_name}</h2>

<br>
 <a href="logout"> Logout your Device </a>&nbsp;
&nbsp;

</body>
</html>