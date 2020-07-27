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
						
						<th>Product id</th>
						<th>Product name</th>
						<th>Product cost</th>
						<th>Product quantity</th>
						<th>Product discount</th>
						
							</thead>
					<c:forEach var="product" items="${list}">
						
					
							
							<tr>
								<td>
									<h5><c:out value="${product.getProductid()}"></c:out></h5>
								</td>
								<td>
									<h5><c:out value="${product.getProductname()}"></c:out></h5>
								</td>
								<td>
									<h5><c:out value="${product.getProductcost()}"></c:out></h5>
								</td>	
								<td>
									<h5><c:out value="${product.getProductquantity()}"></c:out></h5>
								</td>
								<td>
									<h5><c:out value="${product.getProductdiscount()}"></c:out></h5>
								</td>
								
							</tr>
							
						
					</c:forEach>
					</table>
					</center>
</body>
</html>
