package com.cai.contact.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import com.cai.contact.form.Contact;
import com.cai.contact.service.ContactService;

@Component
public class ContactMBean {
	private Contact contact = new Contact();
	private List<Contact> contacts = new ArrayList<Contact>();

	@Autowired
	private ContactService contactService;

	public void add() {
		try {
			contactService.addContact(getContact());
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Contact has been added.", "Insert success."));
			setContact(new Contact());
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"ERROR: Insert contact failed.", "Insert failed."));
		}

	}

	public void delete(Integer id) {
		try {
			contactService.removeContact(id);
		} catch (AccessDeniedException e) {
			System.out.println("ERROR: " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"ERROR: You have no permission to remove contact.", "Access is denied."));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<Contact> getContacts() {
		contacts = contactService.listContact();
		System.out.print("Size: " + contacts.size());
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

}
