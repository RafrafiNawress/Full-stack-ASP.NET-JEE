package ServiceImpl;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Employee;
import Entities.EvaluationSheet;
import ServiceRemote.EvaluationSheetInterf;







@Stateless
@LocalBean
public class EvaluationSheetService implements EvaluationSheetInterf {

	@PersistenceContext
	EntityManager em;


	public int ajouterEvaluationSheet(EvaluationSheet evaluationsheet) {
		em.persist(evaluationsheet);
		return evaluationsheet.getId();
	}
	@Override
	public void updateEval(EvaluationSheet evaluationsheet) { 

		em.merge(evaluationsheet);
	}
	public void updateEvalscore(EvaluationSheet ev) {
		EvaluationSheet e = em.find(EvaluationSheet.class, ev.getId());
		e.setScore(ev.getScore());
		em.merge(e);
		 



	}


	
	public EvaluationSheet findEvalById(int id) {
		
		EvaluationSheet eval = em.find(EvaluationSheet.class, id);
		
		return eval;
	}
public Employee findEmpById(int id) {
		
		Employee emp = em.find(Employee.class, id);
		
		return emp;
	}
	
	
	public List <Employee> getAllEmployes() { List <Employee> emp = em.createQuery("Select e from Employee e",
			Employee.class).getResultList(); return emp;
			
	} 
	
	public void removeEval(int id) {
		System.out.println("In removeEmp : ");
		em.remove(em.find(EvaluationSheet.class, id));
		System.out.println("Out of removeEmp : ");	

	}
	
	
	public EvaluationSheet getevalbyemp(int employeId) {
		/*TypedQuery<EvaluationSheet> eval = em.createQuery(
		  "select ev from EvaluationSheet ev join ev.Employee e where ev.id=:employeId "
				 
				   , EvaluationSheet.class);
		  eval.setParameter("employeId", employeId);
		  EvaluationSheet EVnew=eval.getSingleResult();
		  return EVnew;*/
		return em.find(Employee.class, employeId).getEvaluationsheet();
		}
	
	
	public void deleteAllevaluationJPQL() {
		int modified = em.createNativeQuery("DELETE from evaluationsheet WHERE DATEDIFF(NOW(),date) >90 ").executeUpdate();
		if(modified > 1){
			System.out.println("successfully deleted");
		}else{
			System.out.println("failed to delete");
		}
	}
	public List <EvaluationSheet> getAllEval() { List <EvaluationSheet> emp = em.createQuery("Select e from EvaluationSheet e",
			EvaluationSheet.class).getResultList(); return emp;}
	
	
	public Employee findEemp(int id) {
		
		Employee user = em.find(Employee.class, id);
		
		return user;
	}
	
	
	}
