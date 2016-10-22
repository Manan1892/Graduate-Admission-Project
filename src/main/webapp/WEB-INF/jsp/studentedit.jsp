<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function send()
{
	alert("submit");
	var form=document.getElementById('myForm');
  alert(form);
	 	form.action='editstu.html';
	 form.method="post";
	 	document.getElementById("type").value = "submit";
	 	alert(document.getElementsByName("file")[0].value);
	 	   	
 	form.submit();
	}
function save()
 {
	alert("save");
		var form=document.getElementById('myForm');
		alert(form);
		form.action='editstu.html';
		form.method="post";
		document.getElementById("type").value = "save";
		alert(document.getElementsByName("file")[0].value);
			
		form.submit();	
	}

</script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
		<h2>Edit Application</h2>
		<table class ="table">		
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
        <th>Additional</th>
    </tr>
		</thead>
		<tbody>
		<tr>
		<div class="form-group">					
		<form id="myForm"  enctype="multipart/form-data">    
	<td><p>${app.department.name}</p></td>
	
<td>	
	<select name ="program_id">
	<c:forEach items="${programs}" var="program">
	<option value="${program.program_id}">${program.name}</option>
	</c:forEach>
	</select>
	</td>
	<td>
<input type="text" name="term" value="${app.term}">
	</td>
   <td>    
  <input type="text" name="firstname" value="${app.firstname}">
  </td>
  <td> 
  <input type="text" name="lastname" value="${app.lastname}" >
  </td>
  <td>
  <input type="text" name="emailid" value="${app.emailid}">
  </td>
  <td> 
  <input type="radio" name="gender"  checked value="${app.gender}"  > Male
  <input type="radio" name="gender" value="${app.gender}" > Female
  </td>
  <td> 
  <input type="date" name="birthdate" value="${app.birthdate}"   >
  <!-- <input type="submit" value="submit"> --><br> 
  </td> 
  <td>
   <p>${app.record.transcript}</p>
   <input type="file" name="file" value="" > 
   <input type="hidden" id="type" name="type"/>
    <input type="hidden" id="appId" name="appId" value="${app.applicant_id}" }/>
   </td>
   
   <td>
   <input type= "text" name="gre" value="${app.addfield.requiredfield}"/>
   
   </td>
   <td>
   <input type="button" name="sub" value="submit" onclick="send();"/> 
   <input type="button" name="sa" value="save" onclick="save();"/>   
   </td>
  </form>
  </div>
  </tr>
		</tbody>		
		</table>
		</div>
</body>
</html>