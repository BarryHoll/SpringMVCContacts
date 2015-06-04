package com.service;

import org.springframework.jdbc.BadSqlGrammarException;

import com.beans.Contact;
import com.dao.JdbcDaoImplementation;

public class JdbcServiceImplementation implements SpringJdbcService {
	
	JdbcDaoImplementation jdbcDaoImplementation;
	public JdbcDaoImplementation getJdbcDao() {
		return jdbcDaoImplementation;
	}
	
	public void setJdbcDao(JdbcDaoImplementation jdbcDao) {
		this.jdbcDaoImplementation = jdbcDao;
	}

	@Override
	public Contact searchContactDetails(Contact contact) {
		try {
			return jdbcDaoImplementation.searchContactDetails(contact);
		} catch (BadSqlGrammarException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertContactDetails(Contact contactDetailsBean) {
		jdbcDaoImplementation.insertContactDetails(contactDetailsBean);
	}

}
