package com.cai.contact.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "nav", eager = true)
@RequestScoped
public class NavigationController {
	
	@ManagedProperty (value="#{param.pageId}")
	private String pageId;
	
	public String moveToPage1() {
		return "/pages/unsecured/page1";
	}
	public String showPage(){
		if (pageId.equals("1"))
			return "/pages/unsecured/page1";
		else if (pageId.equals("2"))
			return "/pages/unsecured/page2";
		else
			return "/pages/unsecured/home";
	}
	
	public String processPage1(){
		return "/pages/unsecured/page";
	}
	public String processPage2(){
		return "/pages/unsecured/page";
	}
	
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
}
