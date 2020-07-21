package TrainingService;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Training;
import Entities.TrainingCentre;
@Stateless
@LocalBean
public class TrainingCenterService {
	@PersistenceContext
	EntityManager em;	

	public int add(TrainingCentre trainin) {
		em.persist(trainin);
		return trainin.getId();
	}

	public void remove(int id) {
		em.remove(em.find(TrainingCentre.class, id));
		
	}

	public TrainingCentre findById(int id) {
		TrainingCentre training = em.find(TrainingCentre.class, id);
		return training;
	}

	public List<TrainingCentre> findAll() {
		List<TrainingCentre> emp = em.createQuery("Select t from TrainingCentre t",
				TrainingCentre.class).getResultList();
				return emp;
	}

	public List<TrainingCentre> getAllTrainings() {
		List<TrainingCentre> emp = em.createQuery("Select t from TrainingCentre t",
				TrainingCentre.class).getResultList();
				return emp;
	}

	public void updateTraining(TrainingCentre trainin) {
		// TODO Auto-generated method stub
		
	}
	

}