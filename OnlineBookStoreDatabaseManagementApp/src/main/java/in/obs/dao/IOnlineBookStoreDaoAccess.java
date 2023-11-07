package in.obs.dao;

import java.sql.SQLException;
import java.util.List;

import in.obs.dto.Book;

public interface IOnlineBookStoreDaoAccess {
	/*
	 * In interface by default methods are public abstract even if it is not
	 * mentioned
	 */
	List<Book> getAllBooks() throws SQLException;
	Book getBookById(Integer bookId);
	String addBook(Book book);
	String delBook(int id);
	String updBook(Book book);
	
}

