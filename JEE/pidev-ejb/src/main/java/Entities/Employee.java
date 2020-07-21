package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

import Interfaces.IBaseEntity;


@Entity
@XmlRootElement(name="employee") 

public class Employee  implements Serializable, IBaseEntity  {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private String photo;
	
	private String password;
	
	private int phone;
	
	private Date birthday;
	
	private Boolean isActif;
	
	@ManyToMany(mappedBy="Employees", cascade = CascadeType.ALL)
	private Set<Team> Teams;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Mission> missions;
	
	@OneToOne
	private MissionRequest missionRequest;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="employee")
	@JsonBackReference
	private Set<Task> task;

	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Project> project;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(mappedBy="user")
	@JsonBackReference
	private  List<plan> planings;
	
	@OneToOne private EvaluationSheet evaluationsheet;
	
	@ManyToOne(cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Job job;
	
	@ManyToMany(mappedBy = "employees", cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Set<Competency> competencies;


	public Employee() {}
	
	
	public Employee(String firstname, String lastname, String email, String password, int phone, Date birthday,
			Boolean isActif, Role role) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.birthday = birthday;
		this.isActif = isActif;
		this.role = role;
	}
	
	public Employee(int id, String firstname, String lastname, String email, String password, int phone, Date birthday,
			Boolean isActif, Role role) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.birthday = birthday;
		this.isActif = isActif;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Set<Team> getTeams() {
		return Teams;
	}

	public void setTeams(Set<Team> teams) {
		Teams = teams;
	}


	public Job getJob() {
		return job;
	}


	public void setJob(Job job) {
		this.job = job;
	}


	public Set<Competency> getCompetencies() {
		return competencies;
	}


	public void setCompetencies(Set<Competency> competencies) {
		this.competencies = competencies;
	}


	public List<plan> getPlanings() {
		return planings;
	}


	public void setPlanings(List<plan> planings) {
		this.planings = planings;
	}


	public EvaluationSheet getEvaluationsheet() {
		return evaluationsheet;
	}


	public void setEvaluationsheet(EvaluationSheet evaluationsheet) {
		this.evaluationsheet = evaluationsheet;
	}


	public void setMissions(Set<Mission> missions) {
		this.missions = missions;
	}


	public Set<Mission> getMissions() {
		return missions;
	}
	public void setMissions(List<Mission> missions2) {
		this.missions = (Set<Mission>) missions2;
	}


	public MissionRequest getMissionRequest() {
		return missionRequest;
	}


	public void setMissionRequest(MissionRequest missionRequest) {
		this.missionRequest = missionRequest;
	}


	public Set<Task> getTask() {
		return task;
	}


	public void setTask(Set<Task> task) {
		this.task = task;
	}


	public Set<Project> getProject() {
		return project;
	}


	public void setProject(Set<Project> project) {
		this.project = project;
	}


	@Override
	public String toString() {
		return  firstname;
	}
	
	


	
	
	
	
	
	
	
}
