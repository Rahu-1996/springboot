package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.BookDTO;

@Repository
public class BookDAOImp extends BaseDAOImpl<BookDTO> implements BookDAOInt {

	
	public Class<BookDTO> getDTOClass(){
		return BookDTO.class;
		
	}
	@Override
	public List<Predicate> getWhereClause(CriteriaBuilder builder, Root qRoot, BookDTO dto) {

		List<Predicate> whereConditon = new ArrayList<Predicate>();

		if (dto.getBookName() != null && dto.getBookName().length() > 0) {
			whereConditon.add(builder.like(qRoot.get("bookName"), dto.getBookName()));
		}

		return whereConditon;
	}

}
