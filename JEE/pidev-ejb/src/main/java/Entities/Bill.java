package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Bill  implements Serializable {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String matricule;
	private int somme;
	private String image; 
	private Date date;
	
	
	@ManyToOne
	 @JoinColumn(name = "idMission", referencedColumnName = "id")
	private Mission mission;
	//test


	public Bill() {
		super();
	}
	
	

	public Bill(int id) {
		
		this.id = id;
	}



	public Bill(String matricule, int somme, String image, Date date) {
		super();
		this.matricule = matricule;
		this.somme = somme;
		this.image = image;
		this.date = date;
	}


	public Bill(int id, String matricule, int somme, String image, Date date) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.somme = somme;
		this.image = image;
		this.date = date;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public Mission getMission() {
		return mission;
	}


	public void setMission(Mission mission) {
		this.mission = mission;
	}


	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	public int getSomme() {
		return somme;
	}


	public void setSomme(int somme) {
		this.somme = somme;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Bill [id=" + id + ", matricule=" + matricule + ", somme=" + somme + ", image=" + image
				+ ", date=" + date + "]";
	}
	
	
	
}