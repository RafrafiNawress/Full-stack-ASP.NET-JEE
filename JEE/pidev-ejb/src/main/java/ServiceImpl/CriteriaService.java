
package ServiceImpl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Criteria;
import Entities.EvaluationSheet;
import ServiceRemote.CriteriaRemote;

@Stateless
@LocalBean
public class CriteriaService implements CriteriaRemote {

	@PersistenceContext
	EntityManager em;


	public  int ajouterCriteria(Criteria criteria) {
		em.persist(criteria);
		return criteria.getId();
			
	}
	public  int ajouterev(EvaluationSheet ev) {
		em.persist(ev);
		return ev.getId();
			
	}
	public List <Criteria> getAllCriterien() { List <Criteria> emp = em.createQuery("Select e from Criteria e",
			Criteria.class).getResultList(); return emp;
			}
	public void removeCriterien(int id) {
		System.out.println("In removeEmp : ");
		em.remove(em.find(Criteria.class, id));
		System.out.println("Out of removeEmp : ");	

	}




}
