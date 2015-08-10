package com.cai.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cai.contact.dao.ContactDAO;
import com.cai.contact.form.Contact;
@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO contactDAO;
	
	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}
	
	@Transactional
	public void addContact(Contact contact) {
		contactDAO.addContact(contact);
	}

	@Transactional
	public List<Contact> listContact() {
		return contactDAO.listContact();
	}
	
	@PreAuthorize("hasRole('ROLE_SUPER')")
	@Transactional
	public void removeContact(Integer id) {
		contactDAO.removeContact(id);
	}
}
