package TrainingService;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Training;

@Stateless
@LocalBean

public class TrainingService  {
	@PersistenceContext
	EntityManager em;	

	public int add(Training trainin) {
		em.persist(trainin);
		return trainin.getId();
	}

	public void remove(int id) {
		em.remove(em.find(Training.class, id));
	}

	public Training findById(int id) {
		Training training = em.find(Training.class, id);
		return training;
	}

	public List<Training> findAll() {
		List<Training> emp = em.createQuery("Select t from Training t",
				Training.class).getResultList();
				return emp;
	}

	public List<Training> getAllTrainings() {
		List<Training> emp = em.createQuery("Select t from Training t",
				Training.class).getResultList();
				return emp;
	}

	public void updateTraining(Training trainin) {      
		System.out.println(trainin.getName());
	Training emp = em.find(Training.class, trainin.getId()); 
emp.setDescription(trainin.getDescription());		
emp.setName(trainin.getName());		
emp.setDuree(trainin.getDuree());
emp.setNumberMax(trainin.getNumberMax());
emp.setStatus(trainin.getStatus());
em.persist(emp);


	}

	public Training getTrainingByName(String name)
	{
		
		TypedQuery<Training> query =
				em.createQuery("SELECT e FROM Training e WHERE e.name=:name  ",
				Training.class);
				
				query.setParameter("name", name);
				Training tr = null;
				try { tr = query.getSingleResult(); }
				catch (Exception e) { System.out.println("Erreur : " + e); }
				return tr;
	}
	

	}
