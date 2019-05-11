<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>

<html>
<head>
<base href="${pageContext.request.contextPath }/" />

<title>글 조회</title>

</head>
<body>
	<table>
        <tr>
            <td>작성일자 : </td><td>${read.udate}</td>
        </tr>
        <tr>
            <td>글번호 : </td><td>${read.articleId}</td>
        </tr>
        <tr><td>학  번 :</td><td>${read.userId}</td></tr>
        <tr><td>이  름 :</td><td>${read.name}</td></tr>
        <tr>
            <td>글제목 : </td><td>${read.title}</td>
        </tr>
        <tr>
            <td>글내용 : </td><td>${read.content}</td>
        </tr>
	</table>
		<a href="./app/list">[목  록]</a>
</body>
</html>