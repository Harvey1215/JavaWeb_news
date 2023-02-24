<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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

.container {
	height: 100%;
	background-image: linear-gradient(#000000, #9198e5);
}

.login {
	background-color: #ffffff;
	width: 400px;
	height: 550px;
	border-radius: 30px;
	padding: 0 40px;
	position: relative;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
}

.ti {
	font-size: 35px;
	font-weight: bold;
	text-align: center;
	line-height: 200px;
}

.inputs {
	display: block;
	width: 70%;
	margin-bottom: 20px;
	border: 0;
	padding: 10px;
	font-size: 20px;
	outline: none;
}

.bt {
	text-align: center;
	padding: 10px;
	width: 100%;
	margin-top: 40px;
	color: #fff;
	background-image: linear-gradient(#000000, #9198e5);
}

.enroll {
	text-align: center;
	line-height: 88px;
}

a {
	text-decoration-line: none;
	color: #abc1ee;
}
</style>
</head>
<body>
	<div class="container">
		<div class="login">
			<div class="ti">管理员登录</div>
			<form action="${pageContext.request.contextPath }/loginServlet"
				method="post">
				<input type="text" name="username" placeholder="请输入账号"
					class="inputs"> <input type="password" name="password"
					placeholder="请输入密码" class="inputs"> <input type="submit"
					value="登录" class="bt">
			</form>
			<div class="enroll">
				 <a href="/news/newsContent">返回首页</a>
			</div>
		</div>

	</div>
</body>
</html>