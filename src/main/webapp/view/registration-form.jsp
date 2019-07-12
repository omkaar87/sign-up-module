<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">

<head>

	<title>Register New User Form</title>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Reference Bootstrap files -->
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<style type="text/css">
body{
	background: #0B486B;  /* fallback for old browsers */
	background: -webkit-linear-gradient(to right, #F56217, #0B486B);  /* Chrome 10-25, Safari 5.1-6 */
	background: linear-gradient(to right, #F56217, #0B486B); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
}

</style>

</head>

<body>

	<div>

		<div id="loginbox" style="margin-top: 160px;"
			class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<div class="panel-title">Register New User</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<!-- Registration Form -->
					<form:form action="${pageContext.request.contextPath}/register/processRegistrationForm"
						  	   modelAttribute="user"
						  	   class="form-horizontal">

					    <!-- Place for messages: error, alert etc ... -->
					    <div class="form-group">
					        <div class="col-xs-15">
					            <div>

									<!-- Check for registration error -->
									<c:if test="${registrationError != null}">

										<div class="alert alert-danger col-xs-offset-1 col-xs-10">
											${registrationError}
										</div>

									</c:if>

					            </div>
					        </div>
					    </div>

						<!-- User name -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

							<form:input path="userName" placeholder="username" class="form-control" />
						</div>

						<!-- Password -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>

							<form:password path="password" placeholder="password" class="form-control" />
						</div>

                        <div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-briefcase"></i></span>

							<form:select class="form-control" path="role">
                                <option>Select</option>
                                <form:option value="ROLE_ADMIN">Admin</form:option>
                                <form:option value="ROLE_STUDENT">Student</form:option>
                                <form:option value="ROLE_TEACHER">Teacher</form:option>
                            </form:select>
						</div>

						<!-- Register Button -->
						<div style="margin-top: 10px" class="form-group">
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-primary">Register</button>
                                <a type="button" href="${pageContext.request.contextPath}/loginPage" class="btn btn-danger">Cancel</a>
							</div>
						</div>

					</form:form>

				</div>

			</div>

		</div>

	</div>

</body>
</html>