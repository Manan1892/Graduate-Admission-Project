<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
var counter = 0;
var degrees = {};
function addDegree() {	
	counter++;
	var div = document.createElement('div');
    div.innerHTML =  document.getElementsByName("degreename")[0].value;   
     div.id = counter;
     div.name = counter;     
     var addButton = document.createElement('input');
     addButton.type = "button";
     addButton.value = "remove";
     addButton.onclick = function() {   		
    	 	degrees[counter] = null;
    	   // alert(JSON.stringify(degrees));
    		document.getElementById('parent').removeChild(document.getElementById(counter));   		
    	}    
     div.appendChild(addButton);
     degrees[counter] = document.getElementsByName("degreename")[0].value;
     //alert(JSON.stringify(degrees));   
     document.getElementById('parent').appendChild(div);	
}
function send()
   {
	//alert("submit");
	var form=document.getElementById('myForm');
    // alert(form);
   	 	form.action='create.html';
   	 form.method="post";
   	 	document.getElementById("type").value = "submit";
   	 	
   	 	//alert(document.getElementById("type").value);   
   	 var deg = "";
		for (var key in degrees) {
		 
			//alert(degrees[key]);
 		if(degrees[key] != null)
 			deg = deg.concat(degrees[key]," ");
 	}   	
	
	//alert("degrees are "+deg);
 	document.getElementsByName("degreeCount")[0].value = deg;
    	form.submit();
	}
function save()
    {
	//alert("save");
		var form=document.getElementById('myForm');
		//alert(form);
		form.action='create.html';
		form.method="post";
		document.getElementById("type").value = "save";
		//alert(document.getElementById("type").value);
		var deg = "";
		for (var key in degrees) {
   		 
			//alert(degrees[key]);
    		if(degrees[key] != null)
    			deg = deg.concat(degrees[key]," ");
    	}   	
	//	alert("degrees are "+deg);
    	document.getElementsByName("degreeCount")[0].value = deg;
		form.submit();	
	}
function fillUpCourses(name) {	
	var id =  document.getElementsByName(name)[0].value;
	if(id != null) {		
		//alert("will fetch the courses for" + document.getElementsByName(name)[0].value);
		var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (xhttp.readyState == 4 && xhttp.status == 200) {		     
		    	var select = document.getElementsByName("program_id")[0];
		    	var length = select.options.length;
		    	for (i = 0; i < length; i++) {
		    	  select.remove(select.options[i]);    
		    	}		    		    	
		    	var options = JSON.parse(xhttp.responseText);
		    	//alert(JSON.stringify(options));
		    	var keys = options.keys();
		    	for (var key in options) {		    		
		    		//alert(options[key][0]);		    		
		    		var anOption = document.createElement("OPTION")
			    	anOption.innerHTML = options[key][1];		 
		    		//alert(key);		    				    		
					anOption.value = options[key][0];
					document.getElementsByName("program_id")[0].options.add(anOption);
		    	 }		    		
		    	}	    	
		    }		  
		  xhttp.open("GET", "/gapp/fetchCourses.html?departmentId="+id.toString()+"", true);
		  xhttp.send();
	} else {		
		//alert("courses doesnt exist");
	}		
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
    <h2>Create Applications</h2>    
    <table class="table">
    <thead>   
    </thead>
    <tbody>
    	<form id="myForm"  enctype="multipart/form-data">
	<h1>Department info</h1>
    <br>
    <div class="dropdown">	
	Department:
	<select name = "Departments" onchange="fillUpCourses(this.name);">
	<c:forEach items="${departments}" var="department">
	<option value= "${department.department_id}">${department.name}</option>
	</c:forEach>
	</select>	
	<br>
	<br>
	Program:
	<select name ="program_id">
	<c:forEach items="${programs}" var="program">
	<option value="${program.program_id}">${program.name}</option>
	</c:forEach>
	</select>
	<br>
	<br>
	Term Applied:<input type="text" name="term"><br>
	<br>	
    </div>
    <h1>Basic info</h1>    
  First name:<br>
  <input type="text" name="firstname"><br>
  Last name:<br>
  <input type="text" name="lastname"><br>
  CIN:<br>
  <input type="text" name="cin"><br>
  Phone No:<br>
  <input type="text" name="phno"><br>
  Email:<br>
  <input type="text" name="emailid"><br>
  Gender:<br>
  <input type="radio" name="gender" value="male" checked> Male
  <input type="radio" name="gender" value="female"> Female<br>
  D.O.B:<br>
  <input type="date" name="birthdate">
  <!-- <input type="submit" value="submit"> --><br>
   Citizenship:<br>
  <input type="text" name="citizenship"><br>
  <h1>Educational Background</h1>
   Name of College:<br>
  <input type="text" name="clgname"><br>
   Degree Earned:<br>
  <input type="text" name="degreename"><br><input type="button" name ="Degree" value="addDegree" onclick="addDegree();"/>
  <input type="hidden" value="" name="degreeCount"/>
  <br/>
  <div id="parent"></div>
  <h1>Academic Record</h1>
   GRE/TOEFL:<br>
   <input type="text" name="requiredfield"> <br>
   GPA:<br>
   <input type="text" name="gpa" ><br>
   Transcript:<br>
   <input type="file" name="file">
   <br>
<input type="hidden" id="type" name="type"/>
   <input type="button" name="sub" value="submit" onclick="send();"/> 
   <input type="button" name="sa" value="save" onclick="save();"/>   
  </form>
   </tbody>  
  </table>
  </div>
</body>
</html>