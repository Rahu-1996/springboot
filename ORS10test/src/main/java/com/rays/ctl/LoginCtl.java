package com.rays.ctl;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.BookDTO;
import com.rays.form.LoginForm;
import com.rays.form.bookForm;
import com.rays.service.BookServiceInt;

@RestController
@RequestMapping(value = "Auth")
public class LoginCtl extends BaseCtl<bookForm, BookDTO, BookServiceInt> {

	
}