package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import Interfaces.IBaseEntity;

@Entity
public class JobFamily  implements Serializable, IBaseEntity {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(length=2000)
	private String description;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="jobfamily",  cascade = CascadeType.ALL, orphanRemoval=true)
	private Set<Job> jobs;

	public JobFamily() {
	}

	public JobFamily(int id, String name, String description, Set<Job> jobs) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.jobs = jobs;
	}

	public JobFamily(String name, String description, Set<Job> jobs) {
		this.name = name;
		this.description = description;
		this.jobs = jobs;
	}

	@Override
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Set<Job> getJobs() {
		return jobs;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}
	
	public List<List<Job>> getAggregatedJobs(){

		List<List<Job>> res = new ArrayList<List<Job>>();
		Iterator<Job> iterator = this.jobs.iterator();
		boolean found = false;
		while(iterator.hasNext()) {
			Job job = iterator.next();
			
			Iterator<List<Job>> resultIterator = res.iterator();
			found=false;
			while(resultIterator.hasNext() && !found) {
				List<Job> resultJob = resultIterator.next();
				if(resultJob.get(0).getName().toUpperCase().equals(job.getName().toUpperCase())) {
					resultJob.add(job);
					found = true;
				}
			}
			if(!found) {
				List newList = new ArrayList<Job>();
				newList.add(job);
				res.add(newList);
			}
		}
		for(List<Job> list: res) {
			list.sort( new Comparator<Job>() {
	        @Override
	        public int compare(Job job1, Job job2)
	        {
	            return  job1.getLevel() - (job2.getLevel());
	        }
	    });
		}
		res.sort( new Comparator<List<Job>>() {
	        @Override
	        public int compare(List<Job> l1, List<Job> l2)
	        {
	            return  l1.get(0).getName().compareToIgnoreCase(l2.get(0).getName());
	        }
	    });
		 return res;
	}
}
