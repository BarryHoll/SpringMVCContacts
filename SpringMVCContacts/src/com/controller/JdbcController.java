package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.beans.Contact;

@Controller
public class JdbcController {
	
	@Autowired
	com.service.SpringJdbcService Service;
	
	@RequestMapping(value="/searchJdbcContact", method=RequestMethod.GET)
	public ModelAndView searchContact() {
		ModelAndView modelAndView = new ModelAndView("JdbcSearch");
		Contact bean = new Contact();
		modelAndView.addObject("searchUserGet", bean);
		return modelAndView;
	}
}
