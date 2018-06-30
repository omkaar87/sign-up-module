<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<h2>Welcome to the Spring Security App</h2>
	<hr>
	
	<!-- Display username and role -->
	<p>
		
		User : <security:authentication property="principal.username"/> 
	
		<br><br>
		
		Roles : <security:authentication property="principal.authorities"/>
	
	  </p>
	
	<security:authorize access="hasRole('TEACHER')">
		<!-- Add link to point to/leaders.. this is for the managers -->
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Teacher Meeting</a>
			(Only for Teacher peeps)
		</p>
	</security:authorize>
	<hr>
	
	<security:authorize access="hasRole('ADMIN')">
		<!-- Add link to point to/systems.. this is for the Admins -->
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT System Meeting</a>
			(Only for Admin peeps)
		</p>
	</security:authorize>
	
	
	
	
	<form:form action="${pageContext.request.contextPath}/logout" method="post">
		<input type="submit" value="Logout"/>
	</form:form>
	
</body>
</html>