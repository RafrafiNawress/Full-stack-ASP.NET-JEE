package Entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TrainingCentre  implements Serializable {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String libelle;
	private String adress ;
	private Boolean disponibilite;
	private int contact;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Boolean getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(Boolean disponibilite) {
		this.disponibilite = disponibilite;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public TrainingCentre(String libelle, String adress, Boolean disponibilite, int contact) {
		super();
		this.libelle = libelle;
		this.adress = adress;
		this.disponibilite = disponibilite;
		this.contact = contact;
	}
	public TrainingCentre() {
		super();
	}
	@Override
	public String toString() {
		return libelle;
	}
	
}
	