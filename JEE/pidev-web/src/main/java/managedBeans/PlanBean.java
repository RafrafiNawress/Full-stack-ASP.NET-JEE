package managedBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entities.Employee;
import Entities.Training;
import Entities.TrainingCentre;
import Entities.plan;
import MissionService.EmployeeService;
import TrainingService.PlanService;
import TrainingService.TrainingCenterService;
import TrainingService.TrainingService;


@ManagedBean
@SessionScoped
public class PlanBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int formation;
	private int user;
	private Date dateplan;
	private int lieu;
	private List<plan> plans;
	private int planIdUpdate;
	private List<Employee> employelist;
	private List<Training> formationlist;
	private List<TrainingCentre> Centerlist;

	@EJB
	PlanService Pservice;

	@EJB
	TrainingService Fservice;

	@EJB
	EmployeeService Uservice;
	@EJB
	TrainingCenterService tService;
	public void InsertPlaning() {
		Training fc = Fservice.findById(formation);
		Employee uc = Uservice.getUserId(user);
		TrainingCentre tr = tService.findById(lieu);
		Pservice.InsertPlan(new plan(fc, uc, dateplan, tr));
		 FacesMessage message = new FacesMessage( "Planning succefully added!" );
	        FacesContext.getCurrentInstance().addMessage( null, message );

		
	}
	public void DeletePlaning(int idPlan) {
		Pservice.DeletePlan(idPlan);
	}
	public List<plan> getPlanings() {
		plans = Pservice.getAllPlaning();
		System.out.println(plans.toString());
		return plans;
	}
	public void RemplirChamp(plan plan) {
		this.setFormation(formation);
		this.setLieu(lieu);
		this.setUser(user);
		this.setDateplan(dateplan);
		System.out.println(employelist.toString());
		System.out.println(formationlist.toString());
	}
private List<String> ForamtionList;

	public List<String> getForamtionList() {
	return ForamtionList;
}
public void setForamtionList(List<String> foramtionList) {
	ForamtionList = foramtionList;
}
	@PostConstruct
	public void init() {
		employelist = Uservice.getAllUsers();
		formationlist = Fservice.getAllTrainings();
		Centerlist = tService.findAll();
		
		
	}
	public int getFormation() {
		return formation;
	}
	public void setFormation(int formation) {
		this.formation = formation;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public Date getDateplan() {
		return dateplan;
	}
	public void setDateplan(Date dateplan) {
		this.dateplan = dateplan;
	}
	public int getLieu() {
		return lieu;
	}
	public void setLieu(int lieu) {
		this.lieu = lieu;
	}
	public List<plan> getPlans() {
		return plans;
	}
	public void setPlans(List<plan> plans) {
		this.plans = plans;
	}
	public int getPlanIdUpdate() {
		return planIdUpdate;
	}
	public void setPlanIdUpdate(int planIdUpdate) {
		this.planIdUpdate = planIdUpdate;
	}
	public List<Employee> getEmployelist() {
		return employelist;
	}
	public void setEmployelist(List<Employee> employelist) {
		this.employelist = employelist;
	}
	public List<Training> getFormationlist() {
		return formationlist;
	}
	public void setFormationlist(List<Training> formationlist) {
		this.formationlist = formationlist;
	}
	public List<TrainingCentre> getCenterlist() {
		return Centerlist;
	}
	public void setCenterlist(List<TrainingCentre> centerlist) {
		Centerlist = centerlist;
	}
	public PlanService getPservice() {
		return Pservice;
	}
	public void setPservice(PlanService pservice) {
		Pservice = pservice;
	}
	public TrainingService getFservice() {
		return Fservice;
	}
	public void setFservice(TrainingService fservice) {
		Fservice = fservice;
	}
	public EmployeeService getUservice() {
		return Uservice;
	}
	public void setUservice(EmployeeService uservice) {
		Uservice = uservice;
	}
	public TrainingCenterService gettService() {
		return tService;
	}
	public void settService(TrainingCenterService tService) {
		this.tService = tService;
	}
	

	public String redirect() {
		String navigateTo = "Planning?faces-redirect=true";
	
		return navigateTo; }
}