package com.rays.service;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImp;
import com.rays.dao.BookDAOInt;
import com.rays.dto.BookDTO;

@Service
@Transactional
public class BookServiceImpl extends BaseServiceImp<BookDTO, BookDAOInt> implements BookServiceInt {
	
	
}