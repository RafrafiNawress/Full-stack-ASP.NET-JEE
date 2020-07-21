package tn.esprit.timesheet.managedbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import Entities.Employee;
import Entities.Mission;
import Entities.Project;
import Entities.Status;
import Entities.Task;
import MissionService.EmployeeService;
import TimesheetService.ProjectServImpl;

@ManagedBean(name = "taskBean")
@SessionScoped
public class TaskBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String String = null;

	private int id;

	private String title;
	private String description;
	private String startDate;
	private String endDate;
	@Enumerated(EnumType.STRING)
	private Status status;
	private String titlep;
	private String name;
	private List<Project> projects;
	private List<Employee> employees;
	private List<Task> tasks;
	private Project project;
	private Employee employee;
	private List<Task> tasksByProject;

	@ManagedProperty(value="#{projectBean}")
	ProjectBean projectBean;
	
	@EJB
	private ProjectServImpl projectService;

	@EJB
	private EmployeeService employeeService;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getTitlep() {
		return titlep;
	}

	public void setTitlep(String titlep) {
		this.titlep = titlep;
	}

	public ProjectServImpl getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectServImpl projectService) {
		this.projectService = projectService;
	}

	

	public List<Project> getProjects() {
		projects = projectService.getAllProjects();
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Task> getTasks() {
		tasks = projectService.getAllTasks();
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Employee> getEmployees() {
		employees = projectService.getAllEmployees();
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public void addTask() {
		employee = employeeService.getEmployeeByName(name);

		projectService.ajouterTask(new Task(title, description, startDate, endDate, status),employee);
	}

	public void removeProject(int projectId) {
		projectService.deleteProjectById(projectId);
	}

	private Integer projectIdToBeUpdated;

	public void displayProject(Project pl) {
		this.setTitle(pl.getTitle());
		this.setDescription(pl.getDescription());
		this.setStartDate(pl.getStartDate());
		this.setEndDate(pl.getEndDate());
		this.setProjectIdToBeUpdated(pl.getId());

	}

	public String setStatus(int taskId)
	{
		projectService.setStatus(taskId);
		return "/pages/admin/employeeTask?faces-redirect=true";
		
	}
	public Integer getProjectIdToBeUpdated() {
		return projectIdToBeUpdated;
	}

	public void setProjectIdToBeUpdated(Integer projectIdToBeUpdated) {
		this.projectIdToBeUpdated = projectIdToBeUpdated;
	}

	public void updateProject() {

		projectService.updateProject(new Project(projectIdToBeUpdated, title, description, startDate, endDate));
	}

	String navigateTo = "null";

	public String gototask() {
		return navigateTo = "/pages/admin/task?faces-redirect=true";
	}

	public List<Task> getTasksByProject(int projectId) {
		
		tasksByProject = projectService.getTasksByProject(projectId);
		return tasksByProject;
	}

	public void setTasksByProject(List<Task> tasksByProject) {
		this.tasksByProject = tasksByProject;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public ProjectBean getProjectBean() {
		return projectBean;
	}

	public void setProjectBean(ProjectBean projectBean) {
		this.projectBean = projectBean;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public List<Task> getTasksByProject() {
		return tasksByProject;
	}
	

}
