package Entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Training  implements Serializable {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name ;
	private String description;
	private int duree;
	private Boolean status ;
	private int NumberMax;
	private String  image  ;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Employee> formationEmp; 
	
	@OneToOne
	private FormationComment commentaire;
	

	public FormationComment getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(FormationComment commentaire) {
		this.commentaire = commentaire;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	

	public Training(String name, String description, int duree, Boolean status, int numberMax, String image) {
		super();
		this.name = name;
		this.description = description;
		this.duree = duree;
		this.status = status;
		NumberMax = numberMax;
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public int getNumberMax() {
		return NumberMax;
	}
	

	public Training(String image) {
		super();
		this.image = image;
	}

	public void setNumberMax(int numberMax) {
		NumberMax = numberMax;
	}

	public Set<Employee> getFormationEmp() {
		return formationEmp;
	}

	public void setFormationEmp(Set<Employee> formationEmp) {
		this.formationEmp = formationEmp;
	}

	public Training(int id, String name, String description, int duree, Boolean status, int numberMax,
			Set<Employee> formationEmp) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.duree = duree;
		this.status = status;
		NumberMax = numberMax;
		this.formationEmp = formationEmp;
	}
	public Training(int id, String name, String description, int duree, int numberMax) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.duree = duree;
		NumberMax = numberMax;
	}


	public Training(int id) {
		super();
		this.id = id;
	}

	public Training(String name, String description, int duree, int numberMax) {
		super();
		this.name = name;
		this.description = description;
		this.duree = duree;
		NumberMax = numberMax;
	}
	
	public Training(String name, String description, int duree, Boolean status, int numberMax) {
		super();
		this.name = name;
		this.description = description;
		this.duree = duree;
		this.status = status;
		NumberMax = numberMax;
	}

	public Training() {
		super();
	}

	public Training(int id, String name, String description, int duree , Boolean status,int numberMax
			) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.duree = duree;
		this.status = status;
		NumberMax = numberMax;
	}

	

	@Override
	public String toString() {
		return name;
	}
	
	
	
	
	
	
	
	
}