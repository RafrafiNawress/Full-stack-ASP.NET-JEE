package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class plan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id_planing;
	
	@ManyToOne
	@JoinColumn(name = "id_formation", referencedColumnName = "id")
	private  Training formation;
	
	@ManyToOne
	@JoinColumn(name ="id_User", referencedColumnName = "id" )
	private Employee user;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_formation ; 
	@ManyToOne
	@JoinColumn(name ="id_center", referencedColumnName = "id" )
	private TrainingCentre centre;
	
	
	
	

	public plan() {
		super();
	}
	

	public plan(Training formation, Employee user, Date date_formation, TrainingCentre centre) {
		super();
		this.formation = formation;
		this.user = user;
		this.date_formation = date_formation;
		this.centre = centre;
	}


	
	public plan(int id_planing, Training formation, Employee user, Date date_formation, TrainingCentre centre) {
		super();
		this.id_planing = id_planing;
		this.formation = formation;
		this.user = user;
		this.date_formation = date_formation;
		this.centre = centre;
	}


	public int getId_planing() {
		return id_planing;
	}


	public void setId_planing(int id_planing) {
		this.id_planing = id_planing;
	}


	public Training getFormation() {
		return formation;
	}


	public void setFormation(Training formation) {
		this.formation = formation;
	}


	public Employee getUser() {
		return user;
	}


	public void setUser(Employee user) {
		this.user = user;
	}


	public Date getDate_formation() {
		return date_formation;
	}


	public void setDate_formation(Date date_formation) {
		this.date_formation = date_formation;
	}


	public TrainingCentre getCentre() {
		return centre;
	}


	public void setCentre(TrainingCentre centre) {
		this.centre = centre;
	}


	@Override
	public String toString() {
		return "plan [id_planing=" + id_planing + ", formation=" + formation + ", user=" + user + ", date_formation="
				+ date_formation + ", centre=" + centre + "]";
	}


	

	
	
	
	
	

}