package com.jescy.spotter.login.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

@ManagedBean(name="loginMgmtBean")
@RequestScoped
public class LoginBean {
     
    /** The user name. */
    private String userName = null;
     
    /** The password. */
    private String password = null;
 
    @ManagedProperty(value="#{authenticationManager}")
    private AuthenticationManager authenticationManager = null;
    /**
     * Login.
     * 
     * @return the string
     */
    public String login() {
    	System.out.println("Authenticating...");
    	try {
            Authentication request = new UsernamePasswordAuthenticationToken(this.getUserName(), this.getPassword());
            Authentication result = authenticationManager.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);
        } catch (AuthenticationException e) {
        	System.out.println("Authentication failed.");
        	FacesContext.getCurrentInstance().addMessage(null, 
        			new FacesMessage(FacesMessage.SEVERITY_ERROR, 
        					"ERROR: Username and/or password is/are incorrect.", "Authentication failed."));
            return null;
        }
    	System.out.println("You passed the authentication. Congrats!");
        return "validuser";
    }
    
    public String logout(){
        SecurityContextHolder.clearContext();
        return "/pages/login?faces-redirect=true";
    }
     
    /**
     * Cancel.
     * 
     * @return the string
     */
    public String cancel() {
        return null;
    }
 
    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }
 
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
 
    /**
     * Gets the user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }
 
    /**
     * Sets the user name.
     * 
     * @param userName
     *            the new user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    /**
     * Gets the password.
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }
 
    /**
     * Sets the password.
     * 
     * @param password
     *            the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
