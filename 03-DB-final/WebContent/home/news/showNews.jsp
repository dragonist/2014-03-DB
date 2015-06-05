<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="entity.Comment"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
	<h1>뉴스 내용 입니다</h1> <br />
			제목 : ${news.getTitle()}	<br />
			날짜 : ${news.getDate()} <br />
			내용 : ${news.getContent()} <br />
			기자 : ${news.getUserId()} <br />
			<br/>				
	</div> 
	<h2>댓글 입니다.</h2> <br />
<ul>
<c:choose>
	<c:when test="${not empty commentList}">
		<!-- 뉴스내용 보여주기  -->
		<c:forEach items="${commentList}" var="comment">
			<li>
			<div>

					제목 : ${comment.getContent()}	<br />
					기자 : ${comment.getUserId()} <br />
					날짜 : ${comment.getDate()} <br /><br/>
					<button class="button">댓글달기</button>
			</div>
			</li>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<li>
		<div>
			댓글이 없습니다 댓글을 작성해 주세요 
		</div>
		</li>
	</c:otherwise>
</c:choose>
</ul>

<form action="/MakeNewsCommentServlet" method="POST">
	<div style = "display:none">
		<input type="radio" name="newsId" value ="${news.getNewsId()}" checked>
	</div>
	내용 : <input type="text" name="content"> <br>
	<input type="submit" name="registerSubmit" value="가입">
</form>

<!--     <script type="text/javascript">
        var button = document.getElementsByClassName('moreForm');
        button.forEach(v){
        	v.addEventListener('click', function(){
        		alert("dodododo");
        	})
        	} 
    </script>-->
</body>
</html>