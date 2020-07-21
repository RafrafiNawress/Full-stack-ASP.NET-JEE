package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import Entities.JobFamily;
import Services.GenericService;
import Entities.Job;
import Entities.Competency;
import Entities.Employee;

@ManagedBean(name = "globalCompetenciesBean")
@SessionScoped
public class GlobalCompetenciesBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<JobFamily> jobFamilies;
	private String name;
	private String description;
	@EJB
	GenericService _service;

	@ManagedProperty(value = "#{jobFamilyBean}")
	private JobFamilyBean jobFamilyBean;

	public JobFamilyBean getjobFamilyBean() {
		return jobFamilyBean;
	}

	public void setjobFamilyBean(JobFamilyBean jobFamilyBean) {
		this.jobFamilyBean = jobFamilyBean;
	}

	public String selectJobFamiliy(JobFamily jobfamily) {
		jobFamilyBean.setJobFamily(jobfamily);
		return "/pages/competencies/JobFamilyDetails?faces-redirect=true";
	}

	public List<JobFamily> loadJobFamilies() {
		return jobFamilies = _service.getAll(JobFamily.class);
	}

	public List<JobFamily> getJobFamilies() {
		return jobFamilies;
	}

	public ArrayList<Job> getJobs() {
		HashSet<Job> jobs = new HashSet<Job>();
		Iterator<JobFamily> iterator = jobFamilies.iterator();

		while (iterator.hasNext()) {
			Iterator<Job> innerIterator = iterator.next().getJobs().iterator();
			while (innerIterator.hasNext()) {
			}
			Job job = innerIterator.next();
			if (!jobs.contains(job)) {
				jobs.add(job);
			}
		}
		return new ArrayList<Job>(jobs);
	}

	public void setJobFamilies(List<JobFamily> jobFamilies) {
		this.jobFamilies = jobFamilies;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String addJobFamily() {
		_service.add(new JobFamily(name, description, null));
		this.setDescription(null);
		this.setName(null);
		return "/pages/competencies/JobFamilies?faces-redirect=true";
	}

	public void deleteJobFamily(JobFamily jobfamily) {
		Iterator<Job> iterator = jobfamily.getJobs().iterator();
		while (iterator.hasNext()) {
			Job j = iterator.next();
			jobfamily.getJobs().remove(j);
			_service.delete(j, Job.class);
		}
		_service.delete(jobfamily, JobFamily.class);
	}
}
