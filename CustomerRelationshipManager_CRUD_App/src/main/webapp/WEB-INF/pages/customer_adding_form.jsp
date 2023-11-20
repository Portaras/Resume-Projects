<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Adding Form</title>
</head>
<body>
	<div id="container" style="display:grid; justify-content: center; margin-top:50px;">
		<form action="../customer/saveform" method="post">
			<table border=1>
				<tr>
					<td>Enter the Name</td>
					<td><input type="text" name="cname" /></td>
				</tr>
				<tr>
					<td>Enter the Address</td>
					<td><input type="text" name="caddress" /></td>
				</tr>
				<tr>
					<td>Select the Date of Joining</td>
					<td><input type="date" name="doj" /></td>
				</tr>
				<tr>
					
					<td colspan="2" style="text-align: center"><input type="submit" /></td>
				</tr>
			
			</table>

		</form>
		<a href="./list">Go Back to List</a>
	</div>
</body>
</html>