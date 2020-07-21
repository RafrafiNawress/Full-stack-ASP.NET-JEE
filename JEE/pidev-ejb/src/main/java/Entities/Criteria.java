package Entities;

import java.io.Serializable;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Criteria implements Serializable {
	
	private static long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String description;
	private int Note;
	@ManyToOne
    @JoinColumn(name = "idEvaluationSheet", referencedColumnName = "id", insertable=true, updatable=true)
	private EvaluationSheet evaluationsheet;
public Criteria(String description) {
		
		
		this.description = description;
		
	}
	public Criteria(int id, String description, int note, EvaluationSheet evaluationsheet) {
		super();
		this.id = id;
		this.description = description;
		Note = note;
		this.evaluationsheet = evaluationsheet;
	}
	
	public Criteria() {
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNote() {
		return Note;
	}
	public void setNote(int note) {
		Note = note;
	}
	public EvaluationSheet getEvaluationsheet() {
		return evaluationsheet;
	}
	public void setEvaluationsheet(EvaluationSheet evaluationsheet) {
		this.evaluationsheet = evaluationsheet;
	}

}