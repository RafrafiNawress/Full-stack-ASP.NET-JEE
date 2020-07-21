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

import Interfaces.IBaseEntity;

@Entity
public class Competency implements Serializable, IBaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private int level;

	@ManyToMany(fetch = FetchType.EAGER,cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Set<Job> jobs;

	@ManyToMany(fetch = FetchType.EAGER, cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Set<Employee> employees;

	public Competency() {
	}

	public Competency(int id, String name, String description, int level, Set<Job> jobs, Set<Employee> employees) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.level = level;
		this.jobs = jobs;
		this.employees = employees;
	}

	public Competency(String name, String description, int level, Set<Job> jobs, Set<Employee> employees) {
		this.name = name;
		this.description = description;
		this.level = level;
		this.jobs = jobs;
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

	public Set<Job> getJobs() {
		return jobs;
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

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}
