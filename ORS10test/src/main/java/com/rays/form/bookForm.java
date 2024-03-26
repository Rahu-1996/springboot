package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.BookDTO;

public class bookForm extends BaseForm {

	 @NotEmpty(message = "Name is required")
		private String name;

		@NotEmpty(message = "BookName is required")
		private String bookName;

		@NotEmpty(message = "BookPrice is required")
		private String bookPrice;

		private Date purchaseDate;

	public bookForm() {
	}

	

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



	@Override
	public BaseDTO getDto() {
		BookDTO dto = initDTO(new BookDTO());
		dto.setName(name);
		dto.setBookName(bookName);
		dto.setBookPrice(bookPrice);
		dto.setPurchaseDate(purchaseDate);
		return dto;
	}

}