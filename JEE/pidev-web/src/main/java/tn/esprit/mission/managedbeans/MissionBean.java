package tn.esprit.mission.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.behavior.FacesBehavior;
import javax.faces.context.FacesContext;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import Entities.Employee;
import Entities.Mission;
import Entities.MissionRequest;
import Entities.Project;
import Entities.Type;
import MissionService.MissionServiceImpl;

@ManagedBean(name = "missionBean")
@SessionScoped
public class MissionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String dateD;
	private String dateF;
	private String location;
	@Enumerated(EnumType.STRING)
	private Type type;
	private int valide;
	private int maxExpense;
	private String description;
	private List<Mission> missions;
	private List<Mission> missionsValide;
	private List<Mission> missionsNonValide;
	private List<Mission> missionByProjects;
	private List<Project> projects;
	private List<MissionRequest> missionRequests;
	private int missionIdToBeUpdated;
	private Project project;
	private int userId;

	@EJB
	private MissionServiceImpl missionService;

	public MissionBean() {

	}

	public MissionBean(String title, String dateD, String dateF, String location, Type type, int valide, int maxExpense,
			MissionServiceImpl missionService) {
		super();
		this.title = title;
		this.dateD = dateD;
		this.dateF = dateF;
		this.location = location;
		this.type = type;
		this.valide = valide;
		this.maxExpense = maxExpense;
		this.missionService = missionService;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDateD() {
		return dateD;
	}

	public void setDateD(String dateD) {
		this.dateD = dateD;
	}

	public String getDateF() {
		return dateF;
	}

	public void setDateF(String dateF) {
		this.dateF = dateF;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getValide() {
		return valide;
	}

	public void setValide(int valide) {
		this.valide = valide;
	}

	public int getMaxExpense() {
		return maxExpense;
	}

	public void setMaxExpense(int maxExpense) {
		this.maxExpense = maxExpense;
	}

	public MissionServiceImpl getMissionService() {
		return missionService;
	}

	public void setMissionService(MissionServiceImpl missionService) {
		this.missionService = missionService;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Project> getProjects() {
		projects = missionService.getAllProjects();
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Mission> getMissions() {
		missions = missionService.getAllMissions();
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

	public List<Mission> getMissionByProjects(int projectId) {
		missionByProjects = missionService.getMissionsByProject(projectId);
		return missionByProjects;
	}

	public void setMissionByProjects(List<Mission> missionByProjects) {
		this.missionByProjects = missionByProjects;
	}

	public List<Mission> getMissionsValide() {
		missionsValide = missionService.getAllMissionsValide();
		return missionsValide;
	}

	public void setMissionsValide(List<Mission> missionsValide) {
		this.missionsValide = missionsValide;
	}

	public void addMission() {
		missionService.addMission(new Mission(title, dateD, dateF, location, type, maxExpense));
		
	}

	public void removeMission(int missionId) {
		missionService.deleteMissionById(missionId);
	}

	public String displayMission(Mission m1) {
		this.setTitle(m1.getTitle());
		this.setDateD(m1.getDateD());
		this.setDateF(m1.getDateF());
		this.setLocation(m1.getLocation());
		this.setMaxExpense(m1.getMaxExpense());
		this.setType(m1.getType());
		// this.setProjects(m1.getProject());
		this.setMissionIdToBeUpdated(m1.getId());
		System.out.println("***" + m1.getId());
		return "/pages/admin/detailsMission?faces-redirect=true";

	}

	
	public Project getProject() {

		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Mission> getMissionsNonValide() {
		missionsNonValide = missionService.getAllMissionsNonValide();

		return missionsNonValide;
	}

	public void setMissionsNonValide(List<Mission> missionsNonValide) {
		this.missionsNonValide = missionsNonValide;
	}

	public List<MissionRequest> getMissionRequests() {
		missionRequests = missionService.getAllMissionsRequest();
		return missionRequests;
	}

	public Integer getMissionIdToBeUpdated() {
		return missionIdToBeUpdated;
	}

	public void setMissionIdToBeUpdated(Integer missionIdToBeUpdated) {
		this.missionIdToBeUpdated = missionIdToBeUpdated;
	}

	public void updateMission() {
		missionService.updateMission(new Mission(missionIdToBeUpdated, title, dateF, dateD, location, type, maxExpense));
	}

	String navigateTo = "null";

	public String showAddMission() {
		return navigateTo = "/pages/admin/addMission?faces-redirect=true";

	}

	public void affecterEmployeAMission(int employeeId, int missionId, int missionReqId) {
		missionService.affecterEmployeAMission(employeeId, missionId, missionReqId);
	}

	public void addMissionR(Employee e) {
		missionService.addMissionRequest(new MissionRequest(description),missionIdToBeUpdated,e);
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}

	
}
