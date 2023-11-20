<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"
	import="java.util.*, in.pws.model.Customer"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Of Customers</title>
<link rel="stylesheet"
	href="<%=pageContext.getServletConfig().getServletContext().getContextPath()%>/css/style.css" />
</head>
<body>

	<div id=button style="display: grid; justify-content: center;">
		<a href="<%=request.getContextPath()%>/customer/getform">
			<button value="Add Customer"
				style="margin-top: 100px; margin-left: 10px; margin-right: 10px; margin-bottom: 10px;">Add
				Customer</button>
		</a>
	</div>
	<div id="container"
		style="display: grid; justify-content: center; text-align: center;">
		<h1>List Of Customers</h1>
		<table border=1>
			<tr>
				<th>Customer ID</th>
				<th>Customer Name</th>
				<th>Customer Address</th>
				<th>Customer Date OF Joining</th>
				<th>Action</th>
				<th>Action</th>
			</tr>
			<c:forEach var="customer" items="${customerList }">
				<tr>
					<c:url var="editPath" value="/customer/showEditForm">
						<c:param name="customerId" value="${ customer.cid}"></c:param>
					</c:url>
					<c:url var="deletePath" value="/customer/deleteForm">
						<c:param name="customerId" value="${ customer.cid}"></c:param>
					</c:url>
					<td>${customer.cid}</td>
					<td>${customer.cname}</td>
					<td>${customer.caddress}</td>
					<td>${customer.doj}</td>
					<td><a href="${editPath}">EDIT</a></td>
					<td><a href="${deletePath}" onclick="if(!confirm('Are you sure deleting this customer?')) return false">DELETE</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>