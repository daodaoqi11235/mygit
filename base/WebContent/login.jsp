<%-- <jsp:include page="/studentManagement.do"></jsp:include> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name="form1" action="login.do" method="post">
<table width="200"border="1">
<tr>
<td colspan="2">登录窗口</td>
<tr>
<td>用户名</td>
<td><input type="text" name="username" size="10"></td>
</tr>
<tr>
<td>密码</td>
<td><input type="password" name="password" size=10></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="submit" value="登陆">
<a href="register.do?method=init">注册新用户</a>
</td>
</tr>
<tr>
<td><%=(String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY) %></td>


<td><img src="kaptcha.do" width="80" height="20" id="kaptchaImage"  style="margin-bottom: -3px"/> 
    <script type="text/javascript">      
        $(function(){           
            $('#kaptchaImage').click(function () {//生成验证码  
             $(this).hide().attr('src', 'kaptcha.do?' + Math.floor(Math.random()*100) ).fadeIn(); });      
                  });   
        </script> 
        </td>
</tr>

</table>
</form>




</body>
</html>