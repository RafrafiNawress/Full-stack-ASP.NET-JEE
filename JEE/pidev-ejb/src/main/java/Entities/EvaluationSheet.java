package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class EvaluationSheet  implements Serializable {
	
	private static long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
public EvaluationSheet(TypeEvaluationSheet typeevaluation, float Score) {
	this.typeevaluation = typeevaluation;
	this.Score = Score;
	}
public EvaluationSheet(int id, TypeEvaluationSheet typeevaluation, float Score) {
	this.typeevaluation = typeevaluation;
	this.Score = Score;
	this.id=id;
	}
	
	
	public EvaluationSheet(int id, TypeEvaluationSheet typeevaluation, float score, List<Criteria> criteria,
			Date date) {
		super();
		this.id = id;
		this.typeevaluation = typeevaluation;
		Score = score;
		this.criteria = criteria;
		this.date = date;
	}
	
	
	public EvaluationSheet() {
		this.criteria= new ArrayList<Criteria>();
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
	public TypeEvaluationSheet getTypeevaluation() {
		return typeevaluation;
	}
	public void setTypeevaluation(TypeEvaluationSheet typeevaluation) {
		this.typeevaluation = typeevaluation;
	}
	public float getScore() {
		return Score;
	}
	public void setScore(float score) {
		Score = score;
	}
	public List<Criteria> getCriteria() {
		return criteria;
	}
	public void setCriteria(List<Criteria> criteria) {
		this.criteria = criteria;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Enumerated(EnumType.STRING) 
	private TypeEvaluationSheet typeevaluation;
  private float Score;
  
	
	public static long getSerialVersionUID() {
	return serialVersionUID;
}
public static void setSerialVersionUID(long serialVersionUID) {
	EvaluationSheet.serialVersionUID = serialVersionUID;
}
	@OneToMany(mappedBy="evaluationsheet", fetch = FetchType.EAGER, cascade= CascadeType.ALL)
	private List<Criteria> criteria;
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@OneToOne(mappedBy="evaluationsheet") private Employee employee;
	
	Date date;
}