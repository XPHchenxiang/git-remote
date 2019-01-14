<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到主页面</title>
</head>
<body>
<p>登录成功</p>

当前用户：${user.userName}<br/>

当前密码：${user.passWord}<br/>

<input type="submit" name="logout" value="退出" />
</body>
</html>