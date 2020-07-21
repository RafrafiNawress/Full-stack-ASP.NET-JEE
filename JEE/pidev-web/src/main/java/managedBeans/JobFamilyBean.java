package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import Entities.JobFamily;
import Services.GenericService;
import Entities.Job;
import Entities.Competency;
import Entities.Employee;

@ManagedBean(name = "jobFamilyBean")
@SessionScoped
public class JobFamilyBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private JobFamily jobFamily;
	private String name;
	private String description;
	private int level = 0;
	@EJB
	GenericService _service;

	@ManagedProperty(value = "#{jobBean}")
	private JobBean jobBean;

	public JobBean getjobFamilyBean() {
		return jobBean;
	}

	public void setjobFamilyBean(JobBean jobBean) {
		this.jobBean = jobBean;
	}
	
	public String selectJobs(List<Job> jobs) {
		jobBean.setJobs(jobs);
		return "/pages/competencies/JobDetails?faces-redirect=true";
	}

	public JobFamily getJobFamily() {
		return jobFamily;
	}

	public void setJobFamily(JobFamily JobFamily) {
		this.jobFamily = JobFamily;
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public JobBean getJobBean() {
		return jobBean;
	}

	public void setJobBean(JobBean jobBean) {
		this.jobBean = jobBean;
	}

	public String addJob() {
		Job job = new Job(name, description, level, null, null, null);
		_service.add(job);
		job.setJobfamily(jobFamily);
		if (jobFamily.getJobs() == null) {
			jobFamily.setJobs(new HashSet<Job>());
		}
		jobFamily.getJobs().add(job);
		_service.update(jobFamily);
		this.setDescription(null);
		this.setName(null);
		this.setLevel(0);
		return "/pages/competencies/JobFamilyDetails?faces-redirect=true";
	}

	public String deleteJob(List<Job> jobs) {
		Iterator<Job> iterator = jobs.iterator();
		while (iterator.hasNext()) {
			Job j = iterator.next();
			jobFamily.getJobs().remove(j);
			_service.delete(j, Job.class);
		}
		return "/pages/competencies/JobFamilyDetails?faces-redirect=true";
	}
}
