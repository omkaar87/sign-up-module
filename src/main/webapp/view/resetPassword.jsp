<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reset Password</title>
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
	background: #1f4037;  /* fallback for old browsers */
	background: -webkit-linear-gradient(to right, #99f2c8, #1f4037);  /* Chrome 10-25, Safari 5.1-6 */
	background: linear-gradient(to right, #99f2c8, #1f4037); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
}
.alert-info{
	position: absolute;
	margin-top: 50px;
}
.alert-danger{
	position: absolute;
	margin-top: 50px;
}
.col-sm-12{
	padding-left: 0;
}

</style>

</head>
<body>

<div>
		
		<c:if test="${errorMessage != null}">
			<div class="alert alert-danger col-xs-offset-1 col-xs-5">
				${errorMessage}
			</div>
		</c:if>

		<c:if test="${errorMessage == null}">
			<div class="alert alert-info col-xs-offset-1 col-xs-5">
				Enter your new password.
			</div>
		</c:if>
		
		
		<div id="loginbox" style="margin-top: 160px;"
			class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
			
			
									
			
			<div class="panel panel-info">

				<div class="panel-heading">
					<div class="panel-title">Reset Password</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<!-- Reset Form -->
					<form action="${pageContext.request.contextPath}/processReset" method="post">
		
						<!-- User name -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							
							<input type="password" name="password" placeholder="New Password" class="form-control">
							<input type="hidden" value="${resetToken}" name="token" >
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						</div>

						<!-- Login/Submit Button -->
						<div style="margin-top: 10px" class="form-group">						
							<div class="col-sm-12 controls">
								<button type="submit" class="btn btn-success">Save</button>
							</div>
							
						</div>

					</form>

				</div>
				

			</div>

		</div>

	</div>
	




	<%-- <p>New Password : </p>
	<p>Confirm Password : <input type="password" name="password"></p>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<p><input type="submit" value="Save"></p>
		<c:if test="${errorMessage != null}">
			<p><c:out value="${errorMessage}"/></p>
		</c:if>
	</form> --%>
	
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
</body>
</html>