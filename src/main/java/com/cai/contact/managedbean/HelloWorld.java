package com.cai.contact.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.cai.contact.service.ContactService;

@ManagedBean(name = "hello", eager = true)
@RequestScoped
public class HelloWorld {

	@ManagedProperty(value = "#{message}")
	private Message messageBean;

	private String message;
	
	@Autowired
	private ContactService contsctService;

	public HelloWorld() {
		System.out.println("HelloWorld started!");
	}

	public String getMessage() {
		if (messageBean != null) {
			message = messageBean.getMessage();
		}
		return message;
	}

	public void setMessageBean(Message message) {
		this.messageBean = message;
	}

	public void setContsctService(ContactService contsctService) {
		this.contsctService = contsctService;
	}

}
