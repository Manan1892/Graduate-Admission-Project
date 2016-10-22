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
	<h2>Applicant Details</h2>
	 <table class="table">
    <thead>
    <tr>
		<th>D.Name</th>
		<th>P.Name</th>
		<th>Term</th>
		<th>F.Name</th>
		<th>L.Name</th>
		<th>Email</th>
		<th>Gender</th>
        <th>D.O.B</th>
         <th>Transcript</th>
         <th>Degree</th>
         <th>Additional</th>
         <th>Operations</th>
         <!-- 
         <td>GPA</td>
         <td>AddFld</td>
          -->
      </tr>
      </thead>
      <tbody>
      <tr>
      <td>${application.department.name}</td>
      <td>${application.programs.name}</td>
      <td>${application.term}</td>
      <td>${application.firstname}</td>
        <td>${application.lastname}</td>
            <td>${application.emailid}</td>
              <td>${application.gender}</td>
                <td>${application.birthdate}</td>   
                 <td><a href="download.html?path=${application.record.transcript}">${application.record.transcript}</a></td>
                 <td><c:forEach items="${application.getDegrees()}" var="degree">${degree.degreename}<br></c:forEach></td>
                 
                <td><p>${application.addfield.requiredfield}</p></td> 
                
                <c:if test="${application.getApplicationstatus().getStatus()  ne 'submit'}"> <td><a href="editstu.html?applicant_id=${application.applicant_id}">Edit Application</a></td>               
                </c:if>
               
                      <%--   
                       <td>${application.addfield.requiredfield}</td>                   
                      <td>${application.addfield.requiredfield}</td>
                       <td><c:forEach items="${application.getRecord()}" var="record">${record.transcript}<br></c:forEach></td>
                      <td><c:forEach items="${application.getRecord()}" var="score">${score.gpa}<br></c:forEach></td>                     
                        --%>    
      </tr>
         </tbody>
         </table>
         </div>
         </body>
         </html>
        