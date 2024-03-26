package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "BOOK")
public class BookDTO extends BaseDTO {
	
	
	@Column(name = "Name", length = 50)
	private String name;
	
	@Column(name = "BOOK_NAME")
	private String bookName;
	
	@Column(name = "BOOK_PRICE")
	private String bookPrice;
	
	@Column(name = "PURCHASE_DATE")
	private Date purchaseDate;
	
	@Column(name = "IMAGE_ID")
	private Long imageId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}

	

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}


	
	
}
