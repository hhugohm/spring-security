<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  
 <title>Simple Form Validation</title> 
	  <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script> 
	  <script type="text/javascript" src="http://dev.jquery.com/view/trunk/plugins/validate/jquery.validate.js"></script> 
	  <script type="text/javascript"> 
	    $(document).ready(function() { 
	      $("#form1").validate({ 
	        rules: { 
	          j_username: "required",// simple rule, converted to {required:true} 
	          j_password: "required"// simple rule, converted to {required:true} 
	        
	       
	        }, 
	        messages: { 
	          j_username: "por favor introduzca su usuario." ,
	          j_password: "por favor introduzca su password." 
	        } 
	      }); 
	    }); 
	  </script> 
	  <style type="text/css"> 
	    * { font-family: Verdana; font-size: 11px; line-height: 14px; } 
	    .submit { margin-left: 125px; margin-top: 10px;} 
	    .label { display: block; float: left; width: 120px; text-align: right; margin-right: 5px; } 
	    .form-row { padding: 5px 0; clear: both; width: 700px; } 
	    label.error { width: 250px; display: block; float: left; color: red; padding-left: 10px; } 
	    input[type=text], textarea { width: 250px; float: left; } 
	    textarea { height: 50px; } 
	  </style> 
	  </head> 
	  <body> 
	    <form id="form1" method="post" action="<c:url value='/j_spring_security_check' />"> 
	      <div class="form-row"><span class="label">Name *</span><input type="text" name="j_username" /></div> 
	      <div class="form-row"><span class="label">E-Mail *</span><input type="password" name="j_password" /></div> 
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	      <div class="form-row"><input class="submit" type="submit" value="Submit"></div> 
	    </form> 
	  </body> 
	</html> 