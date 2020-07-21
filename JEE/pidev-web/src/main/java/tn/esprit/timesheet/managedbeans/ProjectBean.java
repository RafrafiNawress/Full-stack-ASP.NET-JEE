package tn.esprit.timesheet.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import Entities.Mission;
import Entities.Project;
import Entities.Task;
import MissionService.MissionServiceImpl;
import TimesheetService.ProjectServImpl;

@ManagedBean(name = "projectBean")
@SessionScoped
public class ProjectBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;

	private String title;
	private String description;
	private String startDate;
	private String endDate;
	private List<Project> projects;
	private List<Task> tasks;
	private List<Mission> missions;

	@EJB
	private ProjectServImpl projectService;
	@EJB
	private MissionServiceImpl missionService;

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

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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

	public void addProject() {
		projectService.ajouterProject(new Project(title, description, endDate, startDate));
	}

	public void removeProject(int projectId) {
		projectService.deleteProjectById(projectId);
	}

	private Integer projectIdToBeUpdated;

	public String displayProject(Project pl) {
		if ((projectService.getTasksByProject2(pl.getId()))!=0)
		{
		this.setTitle(pl.getTitle());
		this.setDescription(pl.getDescription());
		this.setStartDate(pl.getStartDate());
		this.setEndDate(pl.getEndDate());
		this.setProjectIdToBeUpdated(pl.getId());
		this.setTasks(projectService.getTasksByProject(pl.getId()));

		
		return "/pages/admin/addTask?faces-redirect=true";
		
		}
		return "/pages/admin/Error?faces-redirect=true";
	

	}
		
	public String displayProject2(Project pl) {
		if ((missionService.getMissionsByProject2(pl.getId()))>0)
		{
		this.setTitle(pl.getTitle());
		this.setDescription(pl.getDescription());
		this.setStartDate(pl.getStartDate());
		this.setEndDate(pl.getEndDate());
		this.setProjectIdToBeUpdated(pl.getId());
		this.setMissions(missionService.getMissionsByProject(pl.getId()));
		return "/pages/admin/test?faces-redirect=true";
		}
		return "/pages/admin/Error?faces-redirect=true";

	}
	public List<Project> getAllProjects() {
		return projectService.getAllProjects();
	}

	public Integer getProjectIdToBeUpdated() {
		return projectIdToBeUpdated;
	}

	public Project getProjectById(int projectId) {
		return projectService.getProjectById(projectId);

	}

	public void setProjectIdToBeUpdated(Integer projectIdToBeUpdated) {
		this.projectIdToBeUpdated = projectIdToBeUpdated;
	}

	public void updateProject() {

		projectService.updateProject(new Project(projectIdToBeUpdated, title, description, startDate, endDate));
	}

	String navigateTo = "null";

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}
	
	public String gotoAdd()
	{
		return "/pages/admin/addTask2?faces-redirect=true";
	}
}
