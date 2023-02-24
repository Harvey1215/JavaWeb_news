<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*" import="news.news"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath }/css/css.css"
	rel="stylesheet" type="text/css">
<meta charset="utf-8">
<title>搜索</title>
<style type="text/css">
.selec {
	padding-top: 50px;
	width: 500px;
	height: 40px;
	margin: auto;
}

.sel {
	float: left;
	width: 400px;
	height: 37px;
	outline: none;
	border: solid #888888;
}

.sub {
	float: left;
	width: 92px;
	height: 42px;
	color: white;
	background: linear-gradient(#000000, #9198e5);;
	outline: none;
}

table {
	width: 100%;
	margin: auto;
	border-spacing: 50px;
}

table a {
	font-weight: bold;
	text-decoration-line: none;
}

.user {
	float: right;
	margin-right: 10px;
	width: 100%;
	height: auto;
	margin: auto;
}

.user a {
	font-weight: bold;
	text-decoration-line: none;
	float: right;
	margin-right: 5px;
	padding-right: 0px
}

.user p {
	float: right;
	margin-right: 240px;
	padding-right: 0px
}
</style>
</head>
<body>
	<div class="head_top">
		<h1 class="text" style="color: white;">新闻网</h1>
	</div>
	<div class="banner">
		<a href="${pageContext.request.contextPath }/newsContent">所有新闻</a> <a
			href="${pageContext.request.contextPath }/select.jsp">新闻搜索</a> <a
			href="${pageContext.request.contextPath }/SYSTEM/manageServlet">后台管理</a>
	</div>
	<div class="user">
		<c:if test="${!empty sessionScope.name}" var="resultTest">
			<p>用户名：${name}</p>
			<a href="#">退出登录</a>
		</c:if>
	</div>
	<div class="content">
		<div class="selec">
			<form action="${pageContext.request.contextPath }/selectServlet"
				method="post">
				<input type="text" name="select" class="sel" placeholder="请输入要搜索的内容">
				<input type="submit" class="sub" value="搜索">
			</form>
		</div>
		<div>
			<table>
				<c:forEach var="select" items="${select}">
					<tr>
						<th><a href="/news/showNewsServelt?id=${select.getId()}">${select.getTitle()}</a></th>
						<th>
						<th>${select.getAuthor()}</th>
						<th>${select.getType()}</th>
						<th><fmt:formatDate value="${select.getTime()}"
								pattern="yyyy/MM/dd" /></th>
				
					</tr>
				</c:forEach>


			</table>
		</div>
	</div>


	<div class="footer">
		<p>关于我们 |联系我们 |意见建议 |帮助中心 |使用条款</p>
		<p>免责声明:本网站部分内容由用户自行上传，如权利人发现误传其作品情形，请及时与本站联系。</p>
	</div>
</body>
</html>