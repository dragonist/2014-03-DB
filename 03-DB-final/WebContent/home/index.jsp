<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="entity.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${not empty loginUser}">
		<a href="/MakeNewsServlet">뉴스 등록</a><br/>
		<a href="/LogoutServlet">로그아웃 하기 </a><br/>
		<br/>
	</c:when>
	<c:otherwise>
		<a href="/LoginServlet">로그인</a><br/>
		<a href="/RegisterServlet">회원가입</a><br/>
		<br/>
	</c:otherwise>
</c:choose>
<a href="/UpdateNewsServlet">뉴스 업데이트 하기</a><br />
<c:choose>
	<c:when test="${not empty newsList}">
		<!-- 뉴스내용 보여주기  -->
		<c:forEach items="${newsList}" var="news">
			<div>
				<a href="UpdateCommentServlet?newsId=${news.getNewsId()}">
					제목 : ${news.getTitle()}	<br />
					날짜 : ${news.getDate()} <br />
					내용 : ${news.getContent()} <br />
					기자 : ${news.getUserId()} <br />
					<br/>				
				</a>
			</div>
		</c:forEach>
	</c:when>
	<c:otherwise>
		
	</c:otherwise>
</c:choose>
</body>
</html>