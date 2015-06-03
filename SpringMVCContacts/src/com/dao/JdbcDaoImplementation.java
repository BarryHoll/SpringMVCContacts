package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.beans.Contact;

public class JdbcDaoImplementation implements SpringJdbcDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Contact searchContactDetails(Contact contact) {
		String queryInitial = "select * from vng_mem where NAME ='"
				+ contact.getName() + "'";
		
		System.out.println("Initial query: " + queryInitial);

		List listContacts = jdbcTemplate.query(queryInitial, new RowMapper() {
			public Object mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
				return new Contact(resultSet.getString("name"),
						resultSet.getString("dateOfBirth"), resultSet.getString("emailAddress"),
						resultSet.getString("phoneNumber"), resultSet.getString("address"),
						resultSet.getLong("pinCode"), resultSet.getString("country"));
			}
		});

		if (listContacts.size() > 0) {
			return (Contact) listContacts.get(0);
		}
		return new Contact();
	}

	@Override
	public void insertContactDetails(Contact contactDetailsBean) {

		String query = "insert into vng_mem (NAME, DOB, EMAIL, PHONE, ADDRESS, PINCODE, COUNTRY)"
				+ " VALUES (?,?,?,?,?,?,?)";
		
		jdbcTemplate.update(
				query,
				new Object[] {contactDetailsBean.getName(), contactDetailsBean.getDateOfBirth(),
						contactDetailsBean.getEmailAddress(), contactDetailsBean.getPhoneNumber(),
						contactDetailsBean.getAddress(), contactDetailsBean.getPinCode(),
						contactDetailsBean.getCountry() });
		
	}

}
