package tn.esprit.mission.managedbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entities.Employee;
import Entities.Role;
import MissionService.EmployeeService;


@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String password;
	private Employee employe;
	private Boolean loggedIn;

	
	
	@EJB
	EmployeeService employeService;
	
	public String doLogin() {
		String navigateTo = "null";
		employe = employeService.getEmployeeByEmailAndPassword(login, password);
		if (employe != null && employe.getRole() == Role.ADMINISTRATOR) {
			navigateTo = "/pages/admin/addProject?faces-redirect=true"; loggedIn = true; }
		else if (employe != null && employe.getRole() == Role.MANAGER) {
			navigateTo = "/pages/admin/Add?faces-redirect=true"; loggedIn = true; }
		else if (employe != null && employe.getRole() == Role.EMPLOYEE) {
			navigateTo = "/pages/admin/Add?faces-redirect=true"; loggedIn = true; }
		else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Login or password"));
		}
	return navigateTo; 
	}
	
	public String doLogout() {
	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	return "/login?faces-redirect=true"; 
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee getEmploye() {
		return employe;
	}

	public void setEmploye(Employee employe) {
		this.employe = employe;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public EmployeeService getEmployeService() {
		return employeService;
	}

	public void setEmployeService(EmployeeService employeService) {
		this.employeService = employeService;
	}

	

	

}