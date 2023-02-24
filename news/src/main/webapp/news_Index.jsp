<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.* " import="news.news"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>首页</title>
<style type="text/css">
table {
	width: 100%;
	margin: auto;
	border-spacing: 15px;
}

table a {
	font-weight: bold;
	text-decoration-line: none;
}
.login{
float: right;
font-weight: bold;
	text-decoration-line: none;
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
		<a	href="${pageContext.request.contextPath }/select.jsp">新闻搜索</a>
		 <a	href="${pageContext.request.contextPath }/SYSTEM/manageServlet">后台管理</a>

	</div>
	<div class="user">
	<c:if test="${!empty sessionScope.name}" var="resultTest" >
	<p>用户名：${name}</p>   <a href="/news/out">退出登录</a>
	</c:if>
	</div>
	<div class="content">
		<table>
			<tr>
				<th>新闻标题</th>
				<th>新闻作者</th>
				<th>新闻分类</th>
				<th>发布时间</th>
			</tr>
			<c:forEach items="${list}" var="list">
				<tr>
					<th><a href="/news/showNewsServelt?id=${list.getId()}">${list.getTitle()}</a></th>
					<th>${list.getAuthor()}</th>
					<th>${list.getType()}</th>
					<th><fmt:formatDate value="${list.getTime()}"
							pattern="yyyy/MM/dd" /></th>
				</tr>
			</c:forEach>
		</table>
	</div>



	<div class="footer">
		<p>关于我们 |联系我们 |意见建议 |帮助中心 |使用条款</p>
		<p>免责声明:本网站部分内容由用户自行上传，如权利人发现误传其作品情形，请及时与本站联系。</p>
	</div>
</body>
</html>