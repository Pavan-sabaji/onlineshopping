<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
				<style>
					table, tr, td{
						 border: 1px solid black;
						 width : 25%;
						 text-align: center;
					}
				</style>
</head>
<body bgcolor="#A9A9A9">

<center>
<table>
						<thead>
						
						<th>Customer id</th>
						<th>Customer name</th>
						<th>Customer password</th>
						<th>Customer balance</th>
						
						
							</thead>
							
					<c:forEach var="customer" items="${list}">
						
							<tr>
								<td>
									<h5><c:out value="${customer.getCustomerid()}"></c:out></h5>
								</td>
								<td>
									<h5><c:out value="${customer.getCustomername()}"></c:out></h5>
								</td>
								<td>
									<h5><c:out value="${customer.getPassword()}"></c:out></h5>
								</td>	
								<td>
									<h5><c:out value="${customer.getBalance()}"></c:out></h5>
								</td>
								
								
							</tr>
						
					</c:forEach>
					</table>
					</center>
</body>
</html>
