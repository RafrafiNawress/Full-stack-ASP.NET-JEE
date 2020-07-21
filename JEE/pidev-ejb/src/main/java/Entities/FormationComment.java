package Entities;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FormationComment implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_comment;
	private String contenu;

	@OneToOne
	private Training formation; 

	
	
	public FormationComment(Training formation) {
		//this.formation = formation;
	}
	
	

	public int getId_comment() {
		return id_comment;
	}
	public void setId_comment(int id_comment) {
		this.id_comment = id_comment;
	}
	
	

	
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Training getFormation() {
		return formation;
	}
	public void setFormation(Training formation) {
		this.formation = formation;
	}

	public FormationComment(int id_comment, String contenu) {
		super();
		this.id_comment = id_comment;
		this.contenu = contenu;
	}

	public FormationComment(String contenu) {
		
		this.contenu = contenu;
	}

	public FormationComment() {
		super();
	}
	
	
}
