<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>新闻发布</title>
<link href="${pageContext.request.contextPath }/css/css.css"
	rel="stylesheet" type="text/css">
<style type="text/css">
.div_01 {
	margin: auto;
	font-size: 20px;
	text-align: center;;
}

.div_02 {
	margin: auto;
	text-align: center;;
	width: 50%;
}

.con {
	width: 100%;
	height: auto;
}

table {
	width: 45%;
	margin: auto;
	border-collapse: separate;
	border-spacing: 5px 20px;
}

table td {
	margin-left: 20px;
	float: left;
}

.form-control {
	width: 150px;
	font-size: 15px;
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
	<div class="user">
	<c:if test="${!empty sessionScope.name}" var="resultTest" >
	<p>用户名：${name}</p>   <a href="/news/out">退出登录</a>
	</c:if>
	</div>
	<div class="con">
		<div class="div_01">
			<h2>添加新闻</h2>
		</div>
		<form action="${pageContext.request.contextPath }/insertServlet"
			method="post">
			<table>
				<tr>
					<td>新闻标题</td>
	<td><input class="form-control" name="title" maxlength="50"required placeholder="不能超过在30个字"></td></tr>
				<tr><td>新闻类别</td>
					<td><select name="type" class=" form-control">
							<option value="军事">军事</option>
							<option value="科技">科技</option>
							<option value="娱乐">娱乐</option>
							<option value="财经">财经</option>
							<option value="体育">体育</option>
							<option value="游戏">游戏</option>
							<option value="教育">教育</option>
							<option value="健康">健康</option>
					</select></td>
				</tr>
				<tr>
					<td>新闻作者</td>
					<td><input class="form-control" name="author" maxlength="10"
						required placeholder="不能超过10个字"></td>
				</tr>
				<tr>
					<td>发布时间</td>
			<td><input type="date" class="form-control" name="time"required placeholder="不能超过10个字"></td></tr>
				<tr>
					<td colspan="2">新闻内容</td>
				</tr>
				<tr>
					<td colspan="2"><textarea name="centent" rows="10" cols="70"
							required placeholder="这是必填的"></textarea></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="发布文章"></td>

				</tr>

			</table>
		</form>

	</div>
	<div class="footer">
		<p>关于我们 |联系我们 |意见建议 |帮助中心 |使用条款</p>
		<p>免责声明:本网站部分内容由用户自行上传，如权利人发现误传其作品情形，请及时与本站联系。</p>
	</div>
</body>
</html>