<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC  "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link href="${pageContext.request.contextPath }/css/css.css"
	rel="stylesheet" type="text/css">
<title>Insert title here</title>
<style>
* {
	margin: 0;
	padding: 0;
}

html {
	height: 100%;
}

body {
	height: 100%;
}

.head_top {
	width: 100%;
	height: 100px;
	background-image: linear-gradient(#000000, #9198e5);
}

.text {
	margin-top: 10px;
	font-weight: bold;
	text-align: center;
	line-height: 100px;
	font-size: 60px;
}

.banner {
	width: 70%;
	height: 30px;
	margin: auto;
	border-style: dashed;
	border-width: 5px 0 5px 0;
}

.banner a {
	font-weight: bold;
	text-decoration-line: none;
	font-size: 20px;
	margin-left: 50px;
}

.footer {
	position: absolute;
	bottom: 0px;
	width: 100%;
	height: 80px;
	background: #8E8E8E;
	text-align: center;
	padding-top: 25px;
	color: #ccc;
	margin-top: 15px;
}

.footer p {
	line-height: 30px;
	font-size: 14px;
}

h1 {
	font-size: 35px;
	text-align: center;
}

table {
	width: 70%;
	margin: auto;
	border-spacing: 10px;
}

.td_01 {
	font-size: 20px;
}
.user{
float: right;
margin-right:10px;
width: 100%;
height: auto;
margin: auto;
}

.user a{
font-weight: bold;
	text-decoration-line: none;
	float: right;
	margin-right:5px;
	padding-right:0px
}
.user p{
float: right;
	margin-right:240px;
	padding-right:0px
}
</style>
<link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css">
</head>
<body>

	<div class="head_top">
		<h1 class="text" style="color: white;">新闻网</h1>
	</div>

	<div class="banner">
		<a href="${pageContext.request.contextPath }/newsContent">所有新闻</a> 
		<a href="${pageContext.request.contextPath }/select.jsp">新闻搜索</a> 
		<a href="${pageContext.request.contextPath }/insert.jsp">发布新闻</a>
	</div>
	
	<div class="user">
	<c:if test="${!empty sessionScope.name}" var="resultTest" >
	<p>用户名：${name}</p>  <a href="/news/out">退出登录</a>
	</c:if>
	</div>
	<h1>后台管理</h1>
	<table border="0" cellspacing="0" align="center">
		<tr>
			<th class="td_01">新闻编号</th>
			<th class="td_01">新闻标题</th>
			<th class="td_01">作 者</th>
			<th class="td_01">新闻时间</th>
			<th class="td_01">新闻类别</th>
			<th class="td_01">操 作</th>
		</tr>
		<c:forEach items="${articlesList}" var="article">
			<tr>

				<th>${article.id}</th>
				<th>${article.title}</th>
				<th>${article.author}</th>
				<th><fmt:formatDate value="${article.time}"
						pattern="yyyy/MM/dd" /></th>
				<th>${article.type}</th>
				<th><a href="${pageContext.request.contextPath }/delete?id=${article.getId()}">删除</a>&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath }/update.jsp?id=${article.getId()}">修改</a></th>

			</tr>
		</c:forEach>
	</table>

	<div class="footer">
		<p>关于我们 |联系我们 |意见建议 |帮助中心 |使用条款</p>
		<p>免责声明:本网站部分内容由用户自行上传，如权利人发现误传其作品情形，请及时与本站联系。</p>
	</div>
</body>
</html>