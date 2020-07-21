package tn.esprit.mission.managedbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.faces.context.FacesContext;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import Entities.Employee;
import Entities.Role;
import MissionService.EmployeeService;

@ManagedBean(name = "employeeBean")
@SessionScoped
public class EmployeeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotBlank(message="Enter the firstname")
	private String firstname;
	@NotBlank(message="Enter the lastname")
	private String lastname;
	@NotBlank(message="Enter the password")
	private String password;
	@Email(message="Recheck the email")
	private String email;
	private Boolean isActif;
	private Date birthday;
	private int phone;
	private int id;
	private Role role;
	private List<Employee> employees;
	private Integer employeeIdToBeUpdated;
	
	@EJB
	EmployeeService employeService;

	
	public void addEmployee() {
		employeService.addEmploye(new Employee(firstname, lastname, email, password, phone, birthday,isActif, role)); 
		
	}
	
	public void removeEmploye(int employeId)
	{
		employeService.deleteEmployeById(employeId);
	}
	
	
	public String displayEmploye(Employee empl)
	{
		this.setEmployeeIdToBeUpdated(empl.getId());
		this.setFirstname(empl.getFirstname());
		this.setLastname(empl.getLastname());
		this.setIsActif(empl.getIsActif());
		this.setEmail(empl.getEmail());
		this.setRole(empl.getRole());
		this.setPassword(empl.getPassword());
		this.setEmployeeIdToBeUpdated(empl.getId());
		return "/pages/administrator/Update?faces-redirect=true"; 
	}
	
	public String updateEmploye()
	{ employeService.updateEmploye(new Employee(employeeIdToBeUpdated, firstname, lastname,
	email, password, phone, birthday,isActif, role));
	return "/pages/administrator/listemployees?faces-redirect=true";
	}
	
	



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public EmployeeService getEmployeService() {
		return employeService;
	}

	public void setEmployeService(EmployeeService employeService) {
		this.employeService = employeService;
	}

	public List<Employee> getEmployees() {
		employees = employeService.getAllEmployees();
		return employees;
	}

	public void setEmployes(List<Employee> employes) {
		this.employees=employes;
	}

	public Integer getEmployeeIdToBeUpdated() {
		return employeeIdToBeUpdated;
	}

	public void setEmployeeIdToBeUpdated(Integer employeIdToBeUpdated) {
		this.employeeIdToBeUpdated = employeIdToBeUpdated;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}


