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

@ManagedBean(name = "jobBean")
@SessionScoped
public class JobBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Job> jobs;
	private String theme = "bluesky";
	Job selectedJob;

	@EJB
	GenericService _service;
	public ArrayList<String> selectedCompetencies;

	public String selectCompetency(Competency competency) {
		// selectedJob = job;
		return "/pages/competencies/JobDetails?faces-redirect=true";
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
		selectedJob = jobs.get(0);
	}

	public Job getSelectedJob() {
		return selectedJob;
	}

	public String setSelectedJob(Job selectedJob) {
		this.selectedJob = selectedJob;
		return "/pages/competencies/JobDetails?faces-redirect=true";
	}

	public ArrayList<String> getSelectedCompetencies() {
		return selectedCompetencies;
	}

	public void setSelectedCompetencies(ArrayList<String> selectedCompetencies) {
		this.selectedCompetencies = selectedCompetencies;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String removeCompetency(Competency comp) {
		selectedJob.getCompetencies().remove(comp);
		comp.getJobs().remove(selectedJob);
		_service.update(comp);
		selectedJob = _service.update(selectedJob);
		return "/pages/competencies/JobDetails?faces-redirect=true";
	}

	public List<Competency> getAllCompetencies() {
		List<Competency> allComp= _service.getAll(Competency.class);
		Iterator<Competency> itr = selectedJob.getCompetencies().iterator();
		while(itr.hasNext()) {
			Competency c = itr.next();
			Iterator<Competency> itr2 = allComp.iterator();
			while(itr2.hasNext()) {
				Competency c2 = itr2.next();
				if(c2.getId()==c.getId()) {
					itr2.remove();
				}
			}
		}
		return allComp;
	}

	public String addCompetencies() {
		Iterator<String> iter = selectedCompetencies.iterator();
		while (iter.hasNext()) {
			int id = Integer.parseInt(iter.next());
			Competency c = _service.get(id, Competency.class);
			if (selectedJob.getCompetencies() == null) {
				selectedJob.setCompetencies(new HashSet<Competency>());
			}
			selectedJob.getCompetencies().add(c);
			if (c.getJobs() == null) {
				c.setJobs(new HashSet<Job>());
			}
			c.getJobs().add(selectedJob);
		}
		_service.update(selectedJob);
		selectedCompetencies=new ArrayList<String>();
		return "/pages/competencies/JobDetails?faces-redirect=true";
	}
}
