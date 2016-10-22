<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<style>
h1 {
	background-color: #6495ed;
}

th {
	background-color: #b0c4de;
}
</style>	
</head>
<body>
<div align="center">
		<h1>GAPP</h1>
	</div>
	<ol class="breadcrumb">
		<li><a href="/gapp/user/register.html">Registration</a></li>
	</ol>
	<div align="center">
		<div style="height: 500px; width: 900px;">
			<form:form modelAttribute="user" class="form-horizontal">
				<br />
				<div class="form-group">
					<label class="col-sm-3 control-label">Email:</label>
					<div class="col-sm-6">
						<form:input path="email" class="col-size-10 form-control" required="required"/>
					</div>
				</div>
				<form:errors path="email" />
				<div class="form-group">
					<label class="col-sm-3 control-label">Password :</label>
					<div class="col-sm-6">
						<form:input path="password" type="password" class="form-control" required="required" />
					</div>
				</div>
				<form:errors path="password" />
				<br />
				<input type="submit" value="Submit" class="btn btn-primary btn-lg"></input>
				<br />
			</form:form>
		</div>
	</div>
</body>
</html>