package com.jescy.spotter.controller;

import java.io.IOException;
import java.io.ObjectInputStream;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.springframework.web.context.support.WebApplicationContextUtils;

public abstract class GenericController {
	@PostConstruct
	private void init() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		ServletContext servletContext = (ServletContext) externalContext.getContext();
		WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).getAutowireCapableBeanFactory()
				.autowireBean(this);
	}

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		ois.defaultReadObject();
		init();
	}
}
