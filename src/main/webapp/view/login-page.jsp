<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">

.panel-info>.panel-heading {
    color: #fff;
	background-color: transparent; 
}


.panel {
    background-color: transparent;
}


body{
	background: #000000;  /* fallback for old browsers */
	background: -webkit-linear-gradient(to right, #434343, #000000);  /* Chrome 10-25, Safari 5.1-6 */
	background: linear-gradient(to right, #434343, #000000); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
}
.forgot{
	position: absolute;
    margin-left: 52px;
    margin-top: 9px;
}
.footer{
	border-top: 1px solid #fff;
	border-top: 1px solid #fff;
    padding: 3px 35px;
    margin-bottom: 65px;
}


</style>		 
</head>
<body>



	<div>
		
		<div id="loginbox" style="margin-top: 160px;margin-bottom: 50px;"
			class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
			
			<div class="panel panel-info">

				<div class="panel-heading">
					<div class="panel-title">Sign In</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<!-- Login Form -->
					<form:form action="${pageContext.request.contextPath}/authenticateTheUser" 
							   method="POST" class="form-horizontal">

					    <!-- Place for messages: error, alert etc ... -->
					    <div class="form-group">
					        <div class="col-xs-15">
					            <div>
										
								<!-- Check for login error -->
	
								<c:if test="${param.error != null}">
									<div class="alert alert-danger col-xs-offset-1 col-xs-10">
										Invalid username and password.
									</div>
								</c:if>
																	
								<c:if test="${param.logout != null}">
										<div class="alert alert-success col-xs-offset-1 col-xs-10">
											You have been logged out.
										</div>
								</c:if>
								
								<c:if test="${status != null}">
										<div class="alert alert-success col-xs-offset-1 col-xs-10">
											${status}
										</div>
								</c:if>
								
								<c:if test="${brokenLink != null}">
										<div class="alert alert-danger col-xs-offset-1 col-xs-10">
											${brokenLink}
										</div>
								</c:if>
							
					            </div>
					        </div>
					    </div>

						<!-- User name -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							
							<input type="text" name="username" placeholder="username" class="form-control">
						</div>

						<!-- Password -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							
							<input type="password" name="password" placeholder="password" class="form-control" >
						</div>
					</div>
						<!-- Login/Submit Button -->
						<div class="footer">
							<div style="margin-top: 10px" class="form-group">						
							<div class="col-sm-12 controls">
								<button type="submit" class="btn btn-success">Login</button>
								<a href="${pageContext.request.contextPath}/register/showRegistrationForm"
							 		class="btn btn-primary"role="button" aria-pressed="true">
								 	Register New User
								 </a>
								 <a href="${pageContext.request.contextPath}/forgot" class="forgot">Forget Password?</a>
							</div>
							
							</div>
					
						</div>
				
						

					</form:form>

				
				

			</div>

		</div>

	</div>




<%-- <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
	<p>Username : <input type="text" name="username"/></p>
	<p>Password : <input type="password" name="password"/></p>
	<input type="submit" value="Login">
</form:form> --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>