package com.dao;

import com.beans.Contact;

public interface SpringJdbcDao {
	
	Contact searchContactDetails(Contact contact);
	void insertContactDetails(Contact contactDetailsBean);

}
