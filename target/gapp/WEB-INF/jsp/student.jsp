<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>student</title>
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
	<h2>Applications List</h2>
	<h3><a href="create.html">Create Application</a></h3>
<table class="table">
 <thead>
 
 <tr>
 
 <th>Department</th>
 <th>Program</th>
 <th>Applied Term</th>
 <th>Date</th>
 <th>Status</th>
 <th>Operation</th>
 </tr>
 </thead>
 <tbody>
<tr>
 
<c:forEach items="${applications}" var="application">
 <tr>
 <td>${application.department.name}</td>
<td>${application.programs.name}</td>
 <td>${application.term}</td>
 <td>${application.applicationstatus.date}<br></td>
 <td>${application.applicationstatus.status}</td>
 <td><a href="appview.html?applicant_id=${application.applicant_id}">Applicant Detail</a></td>

 </tr>
 </c:forEach>
 </tbody>
 </table>
 </div>
<li><a href="/gapp/user/login.html">Home</a></li>
</body>
</html>