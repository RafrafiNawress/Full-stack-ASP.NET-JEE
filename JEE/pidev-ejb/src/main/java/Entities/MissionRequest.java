package Entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@XmlRootElement(name="Requestmission")
public class MissionRequest  implements Serializable {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String description;
	private int affect;
	
	@OneToOne
	@JsonBackReference
	private Employee employee;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonBackReference
	private Mission mission;

	public MissionRequest() {
		super();
	}

	public MissionRequest(String description) {
		super();
		this.description = description;
	}

	public MissionRequest(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public MissionRequest(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public int getAffect() {
		return affect;
	}

	public void setAffect(int affect) {
		this.affect = affect;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	@Override
	public String toString() {
		return "MissionRequest [id=" + id + ", description=" + description + "]";
	}

	
	


	
}
