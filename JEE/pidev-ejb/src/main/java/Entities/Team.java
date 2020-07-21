package Entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Team implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Employee> Employees;

	public Team(int id, Set<Employee> employees) {
		super();
		this.id = id;
		Employees = employees;
	}

	public Team() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Employee> getEmployees() {
		return Employees;
	}

	public void setEmployees(Set<Employee> employees) {
		Employees = employees;
	} 
	
	
	
}
