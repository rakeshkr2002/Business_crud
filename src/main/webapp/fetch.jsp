<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="x" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fetch</title>
</head>
<body>
    <div align="center">
    <h1>Employee Records Table</h1>
    <table border="1">
    		<tr>
    		<th> Name</th>
    		<th> Email</th>
    		<th> Mobile</th>
    		<th>Salary</th>
    		<th>Delete</th>
    		<th>Edit</th>
    		</tr>
    		<x:forEach var ="emp" items = "${list}">
    		 <tr>
    		 		<th>${emp.name}</th>
    		 		<th>${emp.email}</th>
    		 		<th>${emp.mobile}</th>
    		 		<th>${emp.salary}</th>
    		 		<th> 
    		 		<a href="remove?id=${emp.id}"><button>Delete</button> </a>
    		 		</th>
    		 		<th><button>Edit</button></th>
    		 </tr>
    		</x:forEach>
    </table>
    <br>
    <a href = "home"><button>Back</button></a>
    </div>
    
</body>
</html>