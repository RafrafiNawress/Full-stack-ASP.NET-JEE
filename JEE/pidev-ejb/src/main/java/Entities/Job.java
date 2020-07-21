package Entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import Interfaces.IBaseEntity;

@Entity
public class Job  implements Serializable, IBaseEntity {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private int level;
	
	@ManyToOne(cascade =CascadeType.MERGE)
	private JobFamily jobfamily;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "jobs", cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Set<Competency> competencies;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "job", cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Set<Employee> employees;

	public Job() {
	}

	public Job(int id, String name, String description, int level, JobFamily jobfamily, Set<Competency> competencies,
			Set<Employee> employees) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.level = level;
		this.jobfamily = jobfamily;
		this.competencies = competencies;
		this.employees = employees;
	}

	public Job(String name, String description, int level, JobFamily jobfamily, Set<Competency> competencies,
			Set<Employee> employees) {
		this.name = name;
		this.description = description;
		this.level = level;
		this.jobfamily = jobfamily;
		this.competencies = competencies;
		this.employees = employees;
	}

	@Override
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getLevel() {
		return level;
	}

	public JobFamily getJobfamily() {
		return jobfamily;
	}

	public Set<Competency> getCompetencies() {
		return competencies;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setJobfamily(JobFamily jobfamily) {
		this.jobfamily = jobfamily;
	}

	public void setCompetencies(Set<Competency> competencies) {
		this.competencies = competencies;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}