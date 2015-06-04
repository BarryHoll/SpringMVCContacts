package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		Contact contact = new Contact();
		modelAndView.addObject("searchUserGet", contact);
		return modelAndView;
	}
	
	@RequestMapping(value="/searchJdbcContact", method=RequestMethod.POST)
	public ModelAndView searchContact(@ModelAttribute("searchlist2") Contact contact) {
		
		ModelAndView modelAndView = new ModelAndView("JdbcSearchResult");
		
		Contact bean = null;
		try {
			bean = Service.searchContactDetails(contact);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		modelAndView.addObject("searchResultPost", bean);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/insertJdbcContact", method=RequestMethod.GET)
	public ModelAndView insertContactDetails() {
		ModelAndView modelAndView = new ModelAndView("JdbcInsert");
		
		Contact contact = new Contact();
		modelAndView.addObject("insertUser", contact);
		modelAndView.addObject("status", "success");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/insertJdbcContact", method=RequestMethod.GET)
	public ModelAndView insertContactDetails(@ModelAttribute("insertUser") Contact contact) {
		ModelAndView modelAndView = new ModelAndView("JdbcInsert");
		try {
			Service.insertContactDetails(contact);
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("insertUserPost", contact);
		return modelAndView;
	}
}
