<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome</title>
</head>
<body>
<form name="form2" action="welcome.do" method="post">
<table width="200"border="1">
<tr>
<td><%=(String) request.getAttribute("wel") %></td>
<td colspan="2"><input type="submit" name="submit" value="登陆"></td>
</tr>
</table>
</form>
</body>
</html>