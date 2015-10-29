<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Welcome</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1> ${greeting} </h1>
				<p> ${tagline} </p>
			</div>
		</div>
	</section>
	
	<br>
	
	<form  action="${pageContext.request.contextPath}/close" >
<table>
	<tr>
		<td>Cerrar tu session</td>
	</tr>
	<tr>
		<td><input type="submit"  value="cerrar" >  </td>
	</tr>
</table>
<br>
   <a href="<c:url value="close" />" > Logout</a>

</form>

<br>

<a href="<c:url value="j_spring_security_logout" />">Log Out-by spring</a>
</body>
</html>
