package TrainingService;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Employee;
import Entities.Training;
import Entities.plan;


@Stateless
@LocalBean
public class PlanService {
	@PersistenceContext
	EntityManager em ;
	
	
	public void AffecterEmployeAFormation(int idEmp, int idFom, plan p) {
		Employee u = em.find(Employee.class,idEmp);
		 Training form = em.find(Training.class, idFom);
		 p.setUser(u);
		 p.setFormation(form);		
			em.merge(form);

	}

	public void PlanifierFormation(List<Employee> users, List<Training> formations) {
		// TODO Auto-generated method stub
		
	}

	public void InsertPlan(plan Plan) {
		em.persist(Plan);		
	}

	public void UpdatePlan(plan Plan) {
		em.merge(Plan);		
	}

	public void DeletePlan(int idPlan) {
		plan p = em.find(plan.class,idPlan); em.remove(p);		
	}

	public void SelectPlan(int idPlan) {
		em.find(plan.class,idPlan);		
	}

	public List<plan> getAllPlaning() {
		List<plan> plans = em.createQuery("Select f from plan f ", plan.class).getResultList();
		System.out.println(plans);
		return plans;
	}

	public plan getPlaningId(int idP) {
		plan p = em.find(plan.class, idP);
		return p;
	}
}

	