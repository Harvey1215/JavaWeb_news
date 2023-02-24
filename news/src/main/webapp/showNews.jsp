<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.* " import="news.news"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

 <link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css"> 
 
<style type="text/css">
table {table { width:100%;
	margin: auto;
	border-spacing: 100px;
}

}
.title {
	font-size: 30px;
	align-content: center;
	margin: auto;
	line-height: 100px;
	text-align: center;
}

.text p {
	font-size: 15px;
}

.type {
	font-size: 5px;
}

.aut {
	font-size: 10px;
	float: right;
}

.other {
	font-size: 10px;
	float: left;
	margin-top: 100px;
	height: 200px;
	width: 100%;
}

.other a {
	ont-weight: bold;
	text-decoration-line: none;
	font-size: 20px;
}
.content{
width: 70%;
margin:auto;
height:1000px;
}
</style>
</head>
<body>
	<div class="head_top">
		<h1 class="text" style="color: white;">新闻网</h1>
	</div>
	<div class="banner">
	<a href="${pageContext.request.contextPath }/newsContent">所有新闻</a> 
		<a href="${pageContext.request.contextPath }/select.jsp">新闻搜索</a> 
		<a href="${pageContext.request.contextPath }/login.jsp">后台管理</a>
	</div>
	<div class="content">
		<h1 class="title">${n.getTitle()}</h1>
		<div class="text">
			<b class="type">类型：${n.getType()}</b>
			<p>${n.getContent()}</p>
			<div class="aut">
				<p>作者:${n.getAuthor()}</p>
			</div>
		</div>
		<div class="other">
			<h1>相关推荐：</h1>
			<c:forEach var="others" items="${others}">
				<a href="/news/showNewsServelt?id=${others.getId()}">${others.getTitle()}</a>
				<br>
			</c:forEach>
		</div>
	</div>

	<div class="footer">
		<p>关于我们 |联系我们 |意见建议 |帮助中心 |使用条款</p>
		<p>免责声明:本网站部分内容由用户自行上传，如权利人发现误传其作品情形，请及时与本站联系。</p>
	</div>
</body>
</html>