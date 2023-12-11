<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="regform" method="post"> 
<h2>Please Register Yourself</h2>
  Name:<input type="text" name="name1" placeholder="Enter Your Name" required/><br/><br/>
  Email:<input type="email" name="email1" placeholder="Enter Your Email" required/><br/><br/>
  Create Password:<input type="password" name="pass1" placeholder="Create your Password" required/><br/><br/>
  Gender:<input type="radio" name="gender1" value="male">Male<input  type="radio" name="gender1" value="female">Female<br/><br/>
  City  :<select name="city1">
  <option>Delhi</option>
   <option>Mumbai</option>
    <option>Kolkata</option>
     <option>Chennai</option>
      <option>Pune</option>
       <option>Other</option>
  </select>
  <br/><br/>
  <input type="submit" value="register"/>&nbsp;&nbsp;&nbsp; <a href="login.jsp">Login Account</a>&nbsp;
&nbsp;
</form>

</body>
</html>