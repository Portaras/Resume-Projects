<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Adding Form</title>
</head>
<body>
	<div id="container" style="display:grid; justify-content: center; margin-top:50px;">
		<form:form action="../customer/editCustomer" method="post" modelAttribute="customer">
			<table border=1>
				<tr>
					<td>Customer ID</td>
					<td><form:input path="cid" readonly="true" /></td>
				</tr>
				<tr>
					<td>Enter the Name</td>
					<td><form:input path="cname" /></td>
				</tr>
				<tr>
					<td>Enter the Address</td>
					<td><form:input path="caddress" /></td>
				</tr>
				<tr>
					<td>Select the Date of Joining</td>
					<td><form:input path="doj" /></td>
				</tr>
				<tr>
					
					<td colspan="2" style="text-align: center"><input type="submit" /></td>
				</tr>
			
			</table>

		</form:form>
		<a href="./list">Go Back to List</a>
	</div>
</body>
</html>