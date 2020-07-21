package tn.esprit.mission.managedbeans;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Bill;
import Entities.Mission;
import MissionService.MissionServiceImpl;

@ManagedBean(name = "billBean")
@SessionScoped
public class BillBean implements Serializable{

	private Bill heb;
	private Bill trans;
	private Bill resto;
	public Bill getHeb() {
		return heb;
	}
	public void setHeb(Bill heb) {
		this.heb = heb;
	}
	public Bill getTrans() {
		return trans;
	}
	public void setTrans(Bill trans) {
		this.trans = trans;
	}
	public Bill getResto() {
		return resto;
	}
	public void setResto(Bill resto) {
		this.resto = resto;
	}
	
	public BillBean() {
		super();
		this.heb=new Bill();
		this.resto=new Bill();
		this.trans=new Bill();
	}
	public BillBean(Bill heb, Bill trans, Bill resto, MissionServiceImpl missionService) {
		super();
		this.heb = heb;
		this.trans = trans;
		this.resto = resto;
		this.missionService = missionService;
	}
	public MissionServiceImpl getMissionService() {
		return missionService;
	}
	public void setMissionService(MissionServiceImpl missionService) {
		this.missionService = missionService;
	}
	public void addBills(Mission mission) {
		resto.setMatricule("Restauration");
		resto.setMission(mission);
		resto.setDate(new Date());
		heb.setMatricule("Hebergement");
		heb.setMission(mission);
		heb.setDate(new Date());
		trans.setMatricule("Transport");
		trans.setMission(mission);
		trans.setDate(new Date());
		
		missionService.addBill(resto.getSomme()==0?null:resto, heb.getSomme()==0?null:heb, trans.getSomme()==0?null:trans);
		
		
	}
	
	
	@EJB
	private MissionServiceImpl missionService;
	
}
