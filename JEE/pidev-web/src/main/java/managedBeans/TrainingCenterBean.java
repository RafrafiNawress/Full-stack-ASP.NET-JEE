package managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Training;
import Entities.TrainingCentre;
import TrainingService.TrainingCenterService;

@ManagedBean
@SessionScoped
public class TrainingCenterBean implements Serializable{
	@EJB
	TrainingCenterService tc;
	private String libelle; private String adress;
	private int contact; private Boolean disponibilite ;


	public TrainingCenterService getTc() {
		return tc;
	}

	public void removeEmploye(int trainingID)
	{
	tc.remove(trainingID);
	}

	public void setTc(TrainingCenterService tc) {
		this.tc = tc;
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


	public int getContact() {
		return contact;
	}


	public void setContact(int contact) {
		this.contact = contact;
	}


	public Boolean getDisponibilite() {
		return disponibilite;
	}
	public void DeletePlaning(int idPlan) {
	tc.remove(idPlan);
	}


	public void setDisponibilite(Boolean disponibilite) {
		this.disponibilite = disponibilite;
	}
	private List<TrainingCentre> training;
	public List<TrainingCentre> getTraining() {
	training = tc.findAll();
	return training;
	}
	public void add() {
		tc.add(new TrainingCentre(libelle, adress, disponibilite, contact));
		}
	public String doLogin() {
		String navigateTo = "CentersList?faces-redirect=true";
	
		return navigateTo; }


	public TrainingCenterBean(String libelle, String adress, int contact, Boolean disponibilite
			) {
		super();
		this.libelle = libelle;
		this.adress = adress;
		this.contact = contact;
		this.disponibilite = disponibilite;
	}


	public TrainingCenterBean() {
		super();
	}
	
}