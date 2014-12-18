<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입 </h1>

<form action="/RegisterServlet" method="POST">
	아이디 : <input type="text" name="userId"> <br>
	패스워드 : <input type="password" name="userPw"> <br>
	이름 : <input type="text" name="userName"> <br>
	메일 : <input type="text" name="userMail"> <br>
	<input type="submit" name="registerSubmit" value="가입">
</form>

</body>
</html>