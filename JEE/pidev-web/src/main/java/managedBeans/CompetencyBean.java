package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Services.GenericService;
import Entities.Job;
import Entities.Competency;

@ManagedBean(name = "competencyBean")
@SessionScoped
public class CompetencyBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Competency> competencies;
	private String name;
	private String description;
	private int level = 0;
	@EJB
	GenericService _service;
	
	public List<Competency> loadCompetencies() {
		return competencies = _service.getAll(Competency.class);
	}
	
	public List<Competency> getCompetencies() {
		return competencies;
	}
	
	public void setCompetencies(List<Competency> competencies) {
		this.competencies = competencies;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getLevel() {
		return level;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String removeCompetency(Competency comp) {
		Iterator<Job> iterator = comp.getJobs().iterator();
		while (iterator.hasNext()) {
			Job j = iterator.next();
			j.getCompetencies().remove(comp);
		}
		_service.delete(comp, Competency.class);
		return "/pages/competencies/Competencies?faces-redirect=true";
	}
	
	public String addCompetency() {
		Competency comp = new Competency(name, description, level, null, null);
		_service.add(comp);
		this.setDescription(null);
		this.setName(null);
		this.setLevel(0);
		return "/pages/competencies/Competencies?faces-redirect=true";
	}

	
}
