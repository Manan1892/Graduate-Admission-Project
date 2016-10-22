<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
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
<div class="container">
	<h2>Department View List</h2>
	 <table class="table">
    <thead>
		<tr>
			<th>DepartmentName</th>
			<th>Program Name</th>
			<th>Additional Field</th>
		<tr>
		 </thead>
		 <tbody>
		 <tr>
			<td>${department.name}</td>
			<td><c:forEach items="${department.getProgram()}" var="program"> ${program.name} <br/></c:forEach></td>
		<td><c:forEach items="${department.getAdditionalfield()}" var="additional"> ${additional.requiredfield}</br></c:forEach></td>
		</tr>
		</tbody>
	</table>
	</div>
</body>

</html>