package in.obs.controller;

import java.sql.SQLException;

import java.util.List;


import in.obs.dao.OnlineBookStoreDaoAccessImplReadAllBooks;
import in.obs.dto.Book;


public class MainController  {


	public static void main(String[] args) throws SQLException {
	
		OnlineBookStoreDaoAccessImplReadAllBooks obs = new OnlineBookStoreDaoAccessImplReadAllBooks();
		List<Book> books = obs.getAllBooks();
		System.out.println("TB" +books);
	}

}
