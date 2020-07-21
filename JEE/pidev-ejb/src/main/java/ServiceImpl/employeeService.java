package ServiceImpl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Employee;
import ServiceRemote.employeeServiceRemote;



@Stateless
@LocalBean
public class employeeService implements employeeServiceRemote{
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Employee getEmployeByEmailAndPassword(String email, String password) {
		TypedQuery<Employee> query = 
		em.createQuery("select e from Employee e WHERE e.email=:email and e.password=:password ", Employee.class); 
		query.setParameter("email", email); 
		query.setParameter("password", password); 
		Employee employe = null; 
		try {
			employe = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return employe;
	}
}
