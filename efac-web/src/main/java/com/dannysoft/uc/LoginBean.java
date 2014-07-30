package com.dannysoft.uc;

import java.io.Serializable;
import java.security.Principal;
import javax.enterprise.context.RequestScoped;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named
@RequestScoped
public class LoginBean implements Serializable{
	
	private String username;
	private String password;        
	
	public LoginBean(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if(session != null){
			session.invalidate();
		}
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
        
	public String login(){
		String message = "";
		String navto = "";
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		try {
			message = "Username : " + username;
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
                        
			//Login via the Servlet Context
			request.login(username, password);
			
			//Retrieve the Principal
			Principal principal = request.getUserPrincipal();                        
			
			//Display a message based on the User role
			if(request.isUserInRole("Administrator")){
				message = "Username : " + principal.getName() + " You are an Administrator, you can really f**k things up now";
				navto = "admin";
			}else if(request.isUserInRole("Manager")){
				message = "Username : " + principal.getName() + " You are only a Manager, Don't you have a Spreadsheet to be working on??";
				navto = "manager";
			}else if(request.isUserInRole("Guest")){
				message = "Username : " + principal.getName() + " You're wasting my resources...";
				navto = "guest";
			}
			
			//Add the welcome message to the faces context
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
			return navto;
		} catch (ServletException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "An Error Occured: Login failed: " +e.getMessage(), null));
			e.printStackTrace();
		}
		return null;
	}
	
	public void logout(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if(session != null){
			session.invalidate();
		}
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "/Login.xhtml");
	}
	
}
