<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>뉴스 등록 하기</h1>

	<form action="/MakeNewsServlet" method="POST">
	제목 : <input type="text" name="newsTitle" value="제목을 입력해 주세요"> <br>
	소속사 : <input type="text" name="newsCompany" value="무소속"> <br>
	내용 : <textarea name="newsContent" >뉴스 내용을 입력해 주세요</textarea><br>
	<input type="submit" name="registerSubmit" value="뉴스 등록">
	</form>
</body>
</html>