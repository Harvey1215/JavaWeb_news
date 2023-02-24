<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="news.news"%>
<%@ page import="news.*"%>
<%@ page import="java.sql.*"%>
<%
String id = request.getParameter("id");
DBUtil DB = new DBUtil();
String sql = "select * from newsdetail where id = " + id;
DB.getConn();
Statement state = DB.getConn().createStatement();
ResultSet set = state.executeQuery(sql);
news n = new news();
while (set.next()) {
	n.setTitle(set.getString("title"));
	n.setContent(set.getString("content"));
	n.setAuthor(set.getString("author"));
	n.setTime(set.getDate("time"));
	n.setType(set.getString("type"));
}
set.close();
state.close();
DB.getConn().close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新</title>
<style>
.juzhon {
	font-size: 20px;
	text-align: center;
}

.te {
	weigth: 600px;
	height: 300px;
}

h1 {
	font-size: 35px;
	text-align: center;
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
input{
width:300px;
}
</style>
<link href="${pageContext.request.contextPath }/css/css.css"
	rel="stylesheet" type="text/css">
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
	<h1>编辑页面</h1>
	<br>
	<div class="juzhon">

		<form action="${pageContext.request.contextPath }/SYSTEM/updateServlet"
			method="post">
			<table>
				<tr>
					<td>新闻编号</td>
					<td><textarea readonly style="resize: none; width: 300px;" name="id"><%=id%></textarea></td>
				</tr>
				<tr>
					<td>新闻标题</td>
					<td><input type="text" name="title" value=<%=n.getTitle()%>></td>
				</tr>
				<tr>
					<td>新闻作者</td>
					<td><input type="text" name="author" value=<%=n.getAuthor()%>></td>
				</tr>
				
				<tr>
					<td>新闻类别</td>
					<td><select name="type" >
					<option value=<%=n.getType() %>><%=n.getType() %> </option>
						<option value='军事'>军事</option>
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
					<td colspan="2">新闻内容</td>
				</tr>
				<tr>
					<td colspan="2"><textarea name="centent" rows="10" cols="70" required
							placeholder="这是必填的"><%=n.getContent()%></textarea></td>
				</tr>
				<tr>
					<td><input type="submit" value="提交"></td>
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
