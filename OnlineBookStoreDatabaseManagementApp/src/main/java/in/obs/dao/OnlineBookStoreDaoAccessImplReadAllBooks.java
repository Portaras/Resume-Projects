package in.obs.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Level;

import in.obs.dto.Book;
import in.obs.util.JDBCUtil;


public class OnlineBookStoreDaoAccessImplReadAllBooks implements IOnlineBookStoreDaoAccess {
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement pstmt = null;
	
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(OnlineBookStoreDaoAccessImplReadAllBooks.class);
	static FileAppender appender;
	static{
		

		HTMLLayout layout = new HTMLLayout();
		try {
			appender = new FileAppender(layout, "/Volumes/WorkSpace/logs/log.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.addAppender(appender);
		logger.setLevel(Level.DEBUG);
//		PropertyConfigurator.configure("/Volumes/WorkSpace/INTERNSHIP_PROJECT_PWSKILLS/OnlineBookShop/OBS/src/main/java/logConfigProperties.properties	");
		
	}
	

	Connection connection = JDBCUtil.getConnection();
	@Override
	public List<Book> getAllBooks() {
		
		logger.debug("MAIN METHOD STARTS");
		List<Book> books = new ArrayList<Book>();
		
		String sqlQuery = "SELECT bookId,bookName,authorName,purchaseDate,bookPrice,soldDate,status from onlinebookstore";
		try {
			statement = connection.createStatement();

			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()) {
				Integer bookId = resultSet.getInt(1);
				String bookName = resultSet.getString(2);
				String authorName = resultSet.getString(3);
				Date purchaseDate = resultSet.getDate(4);
				Double bookPrice = resultSet.getDouble(5);
				Date soldDate = resultSet.getDate(6);
				String status = resultSet.getString(7);
				System.out.println(bookId + " " + bookName + " " + authorName + " " + purchaseDate + " " + bookPrice
						+ " " + soldDate + " " + status);
				Book book = new Book();
				book.setBookId(bookId);
				book.setBookName(bookName);
				book.setAuthorName(authorName);
				book.setPurchaseDate(purchaseDate);
				book.setBookPrice(bookPrice);
				book.setSoldDate(soldDate);
				book.setStatus(status);
				books.add(book);
				logger.info("MAIN METHOD INFO");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("MAIN METHOD ENDS");

		return books;

	}

	@Override
	public Book getBookById(Integer bookId) {
		Book book = null;
		String SelectSingleEntrysqlQuery = "SELECT bookId,bookName,authorName,purchaseDate,bookPrice,soldDate,status from onlinebookstore where bookId=?";
		try {
			pstmt = connection.prepareStatement(SelectSingleEntrysqlQuery);
			pstmt.setInt(1, bookId);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				Integer bookID = resultSet.getInt(1);
				String bookName = resultSet.getString(2);
				String authorName = resultSet.getString(3);
				Date purchaseDate = resultSet.getDate(4);
				Double bookPrice = resultSet.getDouble(5);
				Date soldDate = resultSet.getDate(6);
				String status = resultSet.getString(7);
				System.out.println(bookID + " " + bookName + " " + authorName + " " + purchaseDate + " " + bookPrice
						+ " " + soldDate + " " + status);
				book = new Book();
				book.setBookId(bookId);
				book.setBookName(bookName);
				book.setAuthorName(authorName);
				book.setPurchaseDate(purchaseDate);
				book.setBookPrice(bookPrice);
				book.setSoldDate(soldDate);
				book.setStatus(status);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("MAIN METHOD error");

		}
		return book;

	}

	@Override
	public String addBook(Book book) {
		int rowsAffected = 0;
		String sqlInsertQuery = "INSERT INTO onlinebookstore (bookName,authorName,purchaseDate,bookPrice,soldDate,status)values(?,?,?,?,?,?)";
		try {
			pstmt = connection.prepareStatement(sqlInsertQuery);
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2, book.getAuthorName());
			pstmt.setDate(3, (Date) book.getPurchaseDate());
			pstmt.setDouble(4, book.getBookPrice());
			pstmt.setDate(5, (Date) book.getSoldDate());
			pstmt.setString(6, book.getStatus());
			rowsAffected = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rowsAffected > 0)
			return "success";
		else
			return "failure";
	}

	@Override
	public String delBook(int id) {
		int rowsAffected = 0;
		String sqlDelQuery = "DELETE from onlinebookstore WHERE bookId=?";
		try {
			pstmt = connection.prepareStatement(sqlDelQuery);
			pstmt.setInt(1, id);
			rowsAffected = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rowsAffected != 0)
			return "success";
		else
			return "failure";
	}

	@Override
	public String updBook(Book book) {
		int rowAffected = 0;
		String sqlUpdateQry = "UPDATE onlinebookstore SET bookName=?,authorName=?,purchaseDate=?,bookPrice=?,soldDate=?,status=? where bookId=?;";
		try {
			pstmt = connection.prepareStatement(sqlUpdateQry);
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2, book.getAuthorName());
			pstmt.setDate(3, (Date) book.getPurchaseDate());
			pstmt.setDouble(4, book.getBookPrice());
			pstmt.setDate(5, (Date) book.getSoldDate());
			pstmt.setString(6, book.getStatus());
			pstmt.setInt(7, book.getBookId());

			rowAffected = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rowAffected != 0)
			return "success";
		else
			return "failure";
	}

}
