package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Project  implements Serializable {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title ;
	private String description ;

	private String startDate ;

	private String endDate ;
	
	@OneToMany(mappedBy="project")
	@JsonBackReference
	private List<Mission> missions;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="project")
	@JsonBackReference
	private List<Task> tasks;

	@ManyToMany(cascade=CascadeType.ALL,mappedBy="project")
	@JsonBackReference
	private Set<Employee> employees;
	

	public List<Task> getTasks() {
	return tasks;
	}
	public void setTasks(List<Task> tasks) {
	this.tasks = tasks;
	}

	public Set<Employee> getEmployees() {
	return employees;
	}
	public void setEmployees(Set<Employee> employees) {
	this.employees = employees;
	}


	public Project(int id) {

		this.id = id;
	}


	
	public Project() {
		super();
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
	
	public Project(int id, String title, String description, String startDate, String endDate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		}

		public Project( String title, String description, String startDate, String endDate) {
		
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		}






		public Project(String description, String startDate, String endDate) {
		
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		}


		public Project(String title, String description) {
		super();
		this.title = title;
		this.description = description;
		}


	

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", title=" + title + ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((missions == null) ? 0 : missions.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((tasks == null) ? 0 : tasks.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (missions == null) {
			if (other.missions != null)
				return false;
		} else if (!missions.equals(other.missions))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (tasks == null) {
			if (other.tasks != null)
				return false;
		} else if (!tasks.equals(other.tasks))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	
	
	
}
