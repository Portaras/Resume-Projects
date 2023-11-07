<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.obs.dto.Book"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display all books</title>
</head>
<body>
	<div style="display: grid; justify-content: center;">

		<form method="GET">
			<h1 style="text-align: center">List of books</h1>
			<table style="text-align: center" border="1">
				<tr>
					<th>Book ID</th>
					<th>Book Name</th>
					<th>AuthorName</th>
					<th>PurchaseDate</th>
					<th>BookPrice</th>
					<th>SoldDate</th>
					<th>Status</th>

				</tr>
				<%
				ArrayList<Book> books = (ArrayList<Book>) request.getAttribute("books");
				int id = 0;
				for (Book b : books) {
				%>
				<tr>
					<td><%=b.getBookId()%></td>
					<td><%=b.getBookName()%></td>
					<td><%=b.getAuthorName()%></td>
					<td><%=b.getPurchaseDate()%></td>
					<td><%=b.getBookPrice()%></td>
					<td><%=b.getSoldDate()%></td>
					<td><%=b.getStatus()%></td>



				</tr>
				<%}%>
			</table>
		</form>
		<a href="../index.html" style="margin: auto; padding-top: 10px">
			<button>Home</button>
		</a>
	</div>

</body>
</html>