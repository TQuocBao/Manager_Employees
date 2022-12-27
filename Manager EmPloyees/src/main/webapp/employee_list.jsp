<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Employee Management Application</title>
 <style type="text/css">
   table{
	margin-left: auto;
	margin-right: auto;   
   }
   input,button{
   		padding: 5px;
   }
 </style>
</head>
<body>
 <center>
  <h1>Employee Management</h1>
        <h2>
         <a href="new">Add New Employee</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">List All Employees</a>
         
        </h2>
 </center>
    <form align="center" method="post" action="#" >
    	<input type="text" name="name" class="form-control" placeholder="Search roll no..">
    		<button type="submit" name="save" class="btn btn-primary">Search</button>
        <table border="1" cellpadding="5">
            <caption><h2>List of Employees</h2></caption>
            <!-- <input type="text" name="roll_no" class="form-control" placeholder="Search roll no..">
    		<button type="submit" name="save" class="btn btn-primary">Search</button> -->
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Sex</th>
                <th>Email</th>
                <th>Country</th>
                <th>Phone</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="employee" items="${listEmployee}">
                <tr>
                    <td><c:out value="${employee.id}" /></td>
                    <td><c:out value="${employee.name}" /></td>
                    <td><c:out value="${employee.sex}" /></td>
                    <td><c:out value="${employee.email}" /></td>
                    <td><c:out value="${employee.country}" /></td>
                    <td><c:out value="${employee.phone}" /></td>
                    <td>
                     <a href="edit?id=<c:out value='${employee.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${employee.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form> 
</body>
</html>