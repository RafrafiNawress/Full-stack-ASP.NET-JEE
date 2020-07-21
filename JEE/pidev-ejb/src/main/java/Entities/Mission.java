package Entities;

import java.io.Serializable;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@XmlRootElement(name="mission")
public class Mission  implements Serializable {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private String dateD;
	private String DateF;
	private String location;
	@Enumerated(EnumType.STRING)
	private Type type;
	private int valide;
	private int maxExpense;
	
	
	@OneToMany( mappedBy = "mission", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Bill> bills;

	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "idProject", referencedColumnName = "id")
	private Project project;
	
	@ManyToMany(mappedBy="missions",cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Employee> employes;
	
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="mission")
	@JsonIgnore
	private List<MissionRequest> missionsRequests;

	public Mission() {
		super();
	}

	
	public Mission(String title, String dateD, String dateF, String location, Type type, int maxExpense) {
		super();
		this.title = title;
		this.dateD = dateD;
		DateF = dateF;
		this.location = location;
		this.type = type;
		this.maxExpense = maxExpense;
	}


	public Mission(int id ,String title, String dateD, String dateF, String location, Type type, int maxExpense) {
		this.id=id;
		this.title = title;
		this.dateD = dateD;
		DateF = dateF;
		this.location = location;
		this.type = type;
		this.maxExpense = maxExpense;
	}


	public Mission(int id, String title, String dateD, String dateF, String location, Type type, int valide,int maxExpense) {
		super();
		this.id = id;
		this.title = title;
		this.dateD = dateD;
		DateF = dateF;
		this.location = location;
		this.type = type;
		this.valide = valide;
		this.maxExpense=maxExpense;
	}

	public Mission(String title, String dateD, String dateF, String location, Type type, int valide,int maxExpense) {
		super();
		this.title = title;
		this.dateD = dateD;
		DateF = dateF;
		this.location = location;
		this.type = type;
		this.valide = valide;
		this.maxExpense=maxExpense;
	}

	public Mission(int id) {
		super();
		this.id = id;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return DateF;
	}

	public void setDateF(String dateF) {
		DateF = dateF;
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
	


	public List<Bill> getBills() {
		return bills;
	}


	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}


	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}


	public Set<Employee> getEmployes() {
		return employes;
	}

	public void setEmployes(Set<Employee> employes) {
		this.employes = employes;
	}


	public List<MissionRequest> getMissionsRequests() {
		return missionsRequests;
	}

	public void setMissionsRequests(List<MissionRequest> missionsRequests) {
		this.missionsRequests = missionsRequests;
	}


	@Override
	public String toString() {
		return "Mission [id=" + id + ", title=" + title + ", dateD=" + dateD + ", DateF=" + DateF + ", location="
				+ location + ", type=" + type + ", valide=" + valide + ", maxExpense=" + maxExpense + "]";
	}

	
	
	
	
	
	
}
