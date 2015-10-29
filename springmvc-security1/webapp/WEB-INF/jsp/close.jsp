<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Has Terminado tu session!!! <br>
<body>
<form  action="${pageContext.request.contextPath}/welcome" >
<table>
	<tr>
		<td>Entrar al sitio nuevamente</td>
	</tr>
	<tr>
		<td><input type="submit"  value="entrar" >  </td>
	</tr>
</table>
</form>
</body>
</html>