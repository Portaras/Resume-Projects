package in.obs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.obs.dao.OnlineBookStoreDaoAccessImplReadAllBooks;
import in.obs.dto.Book;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/getallbook/*")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OnlineBookStoreDaoAccessImplReadAllBooks obs = new OnlineBookStoreDaoAccessImplReadAllBooks();

	static {
		System.out.println("MyServlet.enclosing_method()");
	}

	public MyServlet() {
		// TODO Auto-generated constructor stub
		System.out.println("MyServlet.MyServlet()");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = null;
		System.out.println(request.getRequestURI());
		String endStrig = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"));
		System.out.println("END STRING:"+endStrig);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// GET ALL BOOK BY ID

		if ("/getallbook".equals(endStrig)) {
			List<Book> books = obs.getAllBooks();
			request.setAttribute("books", books);
			//
			// System.out.println(books);
			RequestDispatcher rd = request.getRequestDispatcher("../displayAllBooks.jsp");
			rd.forward(request, response);
		}
		// GET ONE BOOK BY ID
		try {
			if ("/getabookbyid".equals(endStrig)) {

				if (request.getParameter("bookId") != null && !("".equals(request.getParameter("bookId")))) {
					Integer bookid = Integer.parseInt(request.getParameter("bookId"));
					book = obs.getBookById(bookid);

				} else {
					out.println("<div style='text-align:center; display:grid; padding-top:100px'> ");
					out.println("<h1 > Please enter the correct ID </h1>");
					out.println("<a href='../index.html' > HOME </a>");
					out.println("</div > ");

				}

				if (book != null) {
					out.println("<div style='text-align:center; display:grid; padding-top:100px'> ");
					out.println("<table border=1 style='background-color:lightgreen; text-align:center'> <tr> ");
					out.println("<td><h1>BookId</h1></td>");
					out.println("<td><h1>Book Name</h1></td>");
					out.println("<td><h1>Author Name</h1></td>");
					out.println("<td><h1>Purchase Date</h1></td>");
					out.println("<td><h1>Book Price</h1></td>");
					out.println("<td><h1>Sold Date</h1></td>");
					out.println("<td><h1>Status</h1></td>");
					out.println(" </tr> ");
					out.println(" <tr> ");

					out.println("<td><h1> " + book.getBookId() + "</h1></td>");
					out.println("<td><h1> " + book.getBookName() + "</h1></td>");
					out.println("<td><h1> " + book.getAuthorName() + "</h1></td>");
					out.println("<td><h1> " + book.getPurchaseDate() + "</h1></td>");
					out.println("<td><h1> " + book.getBookPrice() + "</h1></td>");
					out.println("<td><h1> " + book.getSoldDate() + "</h1></td>");
					out.println("<td><h1> " + book.getStatus() + "</h1></td>");
					out.println(" </tr> </table> ");
					out.println("<a href='../index.html' > HOME </a>");
					out.println("</div > ");

				} else {
					out.println("<div style='text-align:center; display:grid; padding-top:100px'> ");
					out.println("<h1 > RECORD NOT AVAILABLE </h1>");
					out.println("<a href='../index.html' > HOME </a>");
					out.println("</div > ");

				}

			}

		} catch (NumberFormatException ne) {
			out.println("<div style='text-align:center; display:grid; padding-top:100px'> ");
			out.println("<h1 > Please enter the correct ID </h1>");
			out.println("<a href='../index.html' > HOME </a>");
			out.println("</div > ");
		}
		if ("/delabookbyid".equals(endStrig)) {
			int bookId = Integer.parseInt(request.getParameter("bookId"));
			String delStatus = obs.delBook(bookId);
			System.out.println(delStatus);
			if ("success".equals(delStatus)) {
				out.println("<div style='text-align:center; display:grid; padding-top:100px'> ");
				out.println("<h1 > RECORD DELTED SUCCESSFULLY </h1>");
				out.println("<a href='../index.html' > HOME </a>");
				out.println("</div > ");
			}
			else {
				out.println("<div style='text-align:center; display:grid; padding-top:100px'> ");
				out.println("<h1 > RECORD NOT AVAILABLE </h1>");
				out.println("<a href='../index.html' > HOME </a>");
				out.println("</div > ");
			}
		}
		// UPDATE BOOK
		try {
			if ("/getabookbyidforupdate".equals(endStrig)) {

				if (request.getParameter("bookId") != null && !("".equals(request.getParameter("bookId")))) {
					Integer bookid = Integer.parseInt(request.getParameter("bookId"));
					book = obs.getBookById(bookid);

				} else {
					out.println("<div style='text-align:center; display:grid; padding-top:100px'> ");
					out.println("<h1 > Please enter the correct ID </h1>");
					out.println("<a href='../index.html' > HOME </a>");
					out.println("</div > ");

				}
				// PRINTING THE BOOK IN BROWSER
				if (book != null) {
					out.println(" <form  action='./editBook' method = 'POST'> ");

					out.println("<div style='text-align:center; display:grid; padding-top:100px'> ");
					out.println("<table border=1 style='background-color:lightgreen; text-align:center'> <tr> ");
					out.println("<td><h1>BookId</h1></td>");
					out.println("<td><h1>Book Name</h1></td>");
					out.println("<td><h1>Author Name</h1></td>");
					out.println("<td><h1>Purchase Date</h1></td>");
					out.println("<td><h1>Book Price</h1></td>");
					out.println("<td><h1>Sold Date</h1></td>");
					out.println("<td><h1>Status</h1></td>");
					out.println(" </tr> ");
					out.println(" <tr> ");

					out.println("<td><h1> <input type='text' readonly name='bookId' value='" + book.getBookId() + "'/></h1></td>");
					out.println("<td><h1> <input type='text' name='bookName' value='" + book.getBookName() + "'/></h1></td>");
					out.println("<td><h1> <input type='text' name='authorName' value='" + book.getAuthorName() + "'/></h1></td>");
					out.println("<td><h1> <input type='date' name='purchaseDate' value='" + book.getPurchaseDate() + "'/></h1></td>");
					out.println("<td><h1> <input type='text' name='bookPrice' value='" + book.getBookPrice() + "'/></h1></td>");
					out.println("<td><h1> <input type='date' name='soldDate' value='" + book.getSoldDate() + "'/></h1></td>");
					out.println("<td><h1> <input type='text' readonly name='status' value='" + book.getStatus() + "'/></h1></td>");
					out.println(" </tr> </table> ");
					out.println("<a href='../index.html' > HOME </a>");
					out.println("</div > ");
					out.println("<button style='margin-left:48%; padding:5px;' > Update </button> ");

					out.println(" </form> ");

				} else {
					out.println("<div style='text-align:center; display:grid; padding-top:100px'> ");
					out.println("<h1 > RECORD NOT AVAILABLE </h1>");
					out.println("<a href='../index.html' > HOME </a>");
					out.println("</div > ");

				}

			}

		} catch (NumberFormatException ne) {
			out.println("<div style='text-align:center; display:grid; padding-top:100px'> ");
			out.println("<h1 > Please enter the correct ID </h1>");
			out.println("<a href='../index.html' > HOME </a>");
			out.println("</div > ");
		}

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		

		System.out.println("INSIDE DO POST METHOD");
		Book book = new Book();
		java.sql.Date sPurchaseDate = null;
		java.sql.Date sSoldDate = null;
		PrintWriter out = resp.getWriter();

		book.setBookName(req.getParameter("bookName"));
		System.out.println(req.getParameter("bookName"));

		book.setAuthorName(req.getParameter("authorName"));
		System.out.println(req.getParameter("authorName"));

		book.setBookPrice(Double.parseDouble(req.getParameter("bookPrice")));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date pdate = sdf.parse(req.getParameter("purchaseDate"));
			long longdate = pdate.getTime();
			sPurchaseDate = new java.sql.Date(longdate);

			Date sdate = sdf.parse(req.getParameter("soldDate"));
			long longsdate = sdate.getTime();
			sSoldDate = new java.sql.Date(longsdate);
			System.out.println(sSoldDate.getClass().getName());

		} catch (ParseException e) {
			e.printStackTrace();
		}
		book.setPurchaseDate(sPurchaseDate);
		System.out.println(sPurchaseDate);
		book.setSoldDate(sSoldDate);
		System.out.println("SOLD DATE"+req.getParameter("soldDate"));
		book.setStatus(req.getParameter("soldDate")=="" ?"available":"not available");

		String endStrig = req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/"));
		System.out.println(endStrig);
		
		// INSERT BOOK
		if ("/addBook".equals(endStrig)) {
			String addStatus = obs.addBook(book);
			if ("success".equals(addStatus)) {
				out.println("<div style='text-align:center; display:grid; padding-top:100px'> ");
				out.println("<h1 > RECORD INSERTED SUCCESSFULLY </h1>");
				out.println("<a href='../index.html' > HOME </a>");
				out.println("</div > ");
			} else {
				out.println("<div style='text-align:center; display:grid; padding-top:100px'> ");
				out.println("<h1 > RECORD INSERTION FAILED </h1>");
				out.println("<a href='../index.html' > HOME </a>");
				out.println("</div > ");
			}

		}
		
		//UPDATE BOOK
		if("/editBook".equals(endStrig)) {
			System.out.println("INSIDE EDIT BOOK");
			book.setBookId(Integer.parseInt(req.getParameter("bookId")));
			String updateStatus = obs.updBook(book);
			if ("success".equals(updateStatus)) {
				out.println("<div style='text-align:center; display:grid; padding-top:100px'> ");
				out.println("<h1 > RECORD UPDATED SUCCESSFULLY </h1>");
				out.println("<a href='../index.html' > HOME </a>");
				out.println("</div > ");
			} else {
				out.println("<div style='text-align:center; display:grid; padding-top:100px'> ");
				out.println("<h1 > RECORD UPDATION FAILED </h1>");
				out.println("<a href='../index.html' > HOME </a>");
				out.println("</div > ");
			}
		}

	}

}
