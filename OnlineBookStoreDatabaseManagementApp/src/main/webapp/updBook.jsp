<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Book Details</title>
</head>
<body>
	<div
		style="display: grid; text-align: center; padding: 200px; " >
		<h1>
			<Label for="IdInput">ENTER THE ID TO EDIT</Label>
		</h1>
		<form action="./getallbook/getabookbyidforupdate" method="GET">
			<input id="IdInput" type="text"  placeholder="Enter the ID"
				name="bookId"  ><br> <br>
			<button >Submit</button>
		</form>
		<a href="./index.html" style="margin:auto; padding-top:10px">
			<button>Home</button>
		</a>
	</div>
</body>
</html>