package TrainingService;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Employee;
import Entities.FormationComment;
import Entities.Training;


/**
 * Session Bean implementation class GestionCommentaireFormationService
 */
@Stateless
@LocalBean
public class GestionCommentaireFormationService {
	
	@PersistenceContext
	EntityManager em;
	
	

	public void ajouterFormationCommentaire (FormationComment f) {
		em.persist(f);
		
	}
	public void supprimerFormationCommentaire (int id_comment) {
		FormationComment f = em.find(FormationComment.class, id_comment);
		System.out.println("2"+f);
		em.remove(f);
		
	}
	public void updateComment(FormationComment trainin) {      
	FormationComment emp = em.find(FormationComment.class, trainin.getId_comment()); 
emp.setContenu(trainin.getContenu());		

em.merge(emp);


	}
	
	
		public FormationComment findById(int id) {
			FormationComment training = em.find(FormationComment.class, id);
			return training;
		}
	
	
    public List <FormationComment> getAllFormationComments(){
    	TypedQuery<FormationComment> query = em.createQuery("SELECT f FROM FormationComment f",FormationComment.class);  
 	   try {
 		 return query.getResultList();
 	   }
 	   catch (Exception e){
 		   System.out.println("erreur");	   
 	   }
 	   return null;
    }
    
	
    public GestionCommentaireFormationService() {
        
    }
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
}
