package com.service;

import com.beans.Contact;

public interface SpringJdbcService {
	
	Contact searchContactDetails(Contact contact);
	void insertContactDetails(Contact contactDetailsBean);

}
