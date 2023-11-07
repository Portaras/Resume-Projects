package in.obs.dto;

public class Book {
	private Integer bookId;
	private String bookName;
	private String authorName;
	private java.sql.Date purchaseDate;
	private Double bookPrice;
	private java.sql.Date soldDate;
	private String status; // Available , SoldOut,

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public java.util.Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(java.sql.Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public java.util.Date getSoldDate() {
		return soldDate;
	}

	public void setSoldDate(java.sql.Date soldDate) {
		this.soldDate = soldDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	@Override
//	public String toString() {
//		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", purchaseDate="
//				+ purchaseDate + ", bookPrice=" + bookPrice + ", soldDate=" + soldDate + ", status=" + status + "]";
//	}

}
