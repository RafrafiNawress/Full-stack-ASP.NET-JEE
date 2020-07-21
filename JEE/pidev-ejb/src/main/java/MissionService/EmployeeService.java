package MissionService;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Employee;
import Entities.Team;

@Stateless
@LocalBean
public class EmployeeService {

	@PersistenceContext
	EntityManager em;

	public int addEmploye(Employee employee) {
		em.persist(employee);
		return employee.getId();
	}

	public void deleteEmployeById(int employeId) {
		Employee employe = em.find(Employee.class, employeId);

		// Desaffecter l'employe de toutes les equipes
		for (Team team : employe.getTeams()) {
			team.getEmployees().remove(employe);
		}

		em.remove(employe);
	}

	public boolean updateEmploye(Employee employe) {
		Employee emp = em.find(Employee.class, employe.getId());
		emp.setFirstname(employe.getFirstname());
		emp.setFirstname(employe.getLastname());
		emp.setEmail(employe.getEmail());
		emp.setPassword(employe.getPassword());
		emp.setIsActif(employe.getIsActif());
		emp.setRole(employe.getRole());
		emp.setBirthday(employe.getBirthday());
		em.persist(emp);
		return true;
	}

	public void updateEmployeeByEmployee(Employee employee) {
		Employee emp = em.find(Employee.class, employee.getId());
		emp.setPhoto(employee.getPhoto());
		emp.setPhone(employee.getPhone());
		emp.setPassword(employee.getPassword());

	}

	public Employee getEmployeeByEmailAndPassword(String email, String password) {
		TypedQuery<Employee> query = em
				.createQuery("select e from Employee e WHERE e.email=:email and e.password=:password ", Employee.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		Employee employee = null;
		try {
			employee = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return employee;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> emp = em.createQuery("Select e from Employee e", Employee.class).getResultList();
		return emp;
	}

	public Employee getEmployeeByName(String firstname) {
		TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.firstname=:firstname",
				Employee.class);

		query.setParameter("firstname", firstname);
		Employee emp = null;
		try {
			emp = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur :+e");
		}
		return emp;
	}

	public List<Employee> getAllUsers() {
		List<Employee> users = em.createQuery("Select u from Employee u ", Employee.class).getResultList();
		System.out.println(users);
		return users;

	}

	public Employee getUserId(int idU) {
		Employee u = em.find(Employee.class, idU);
		return u;
	}
}
