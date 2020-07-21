package TimesheetService;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Employee;
import Entities.Mission;
import Entities.Project;
import Entities.Status;
import Entities.Task;
import TimesheetInterface.IProjectServiceRemote;

@Stateless
@LocalBean

public class ProjectServImpl implements IProjectServiceRemote {

	@PersistenceContext
	EntityManager em;

	@Override
	public int ajouterProject(Project project) {

		em.persist(project);
		return project.getId();
	}

	@Override
	public Project getProjectById(int projectId) {
		TypedQuery<Project> query = em.createQuery("SELECT c FROM Project c WHERE c.id=:projectId", Project.class);

		query.setParameter("projectId", projectId);
		Project pr = null;
		try {
			pr = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur :+e");
		}
		return pr;
	}

	@Override
	public void deleteProjectById(int projectId) {
		Project project = em.find(Project.class, projectId);
		em.remove(project);
	}


	
	@Override
	public int ajouterTask(Task task, Employee e)
	{

		em.persist(task);

		task.setEmployee(e);
		task.setStatus(Status.To_do);
		//task.setProject(p);
		return task.getId();
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employee = em.createQuery("Select e from Employee e", Employee.class).getResultList();
		return employee;
	}

	@Override
	public void deleteTaskById(int taskId) {
		Task task = em.find(Task.class, taskId);
		em.remove(task);
	}

	@Override
	public void affecterTaskAProject(int taskId, int projectId) {
		Task task = em.find(Task.class, taskId);
		Project pr = em.find(Project.class, projectId);
		pr.getTasks().add(task);
	}

	@Override
	public void affecterTaskAEmployee(int taskId, int employeeId) {
		Task task = em.find(Task.class, taskId);
		Employee emp = em.find(Employee.class, employeeId);
		emp.getTask().add(task);
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> p = em.createQuery("Select e from Project e", Project.class).getResultList();
		return p;
	}

	@Override
	public List<Task> getAllTasks() {
		List<Task> t = em.createQuery("Select e from Task e", Task.class).getResultList();
		return t;
	}

	@Override
	public List<Task> listCanceled() {
		List<Task> t = em.createQuery("Select e from Task tt Where e.status=In_progress", Task.class).getResultList();
		return t;
	}

	@Override
	public void updateProject(Project project) {
		Project p = em.find(Project.class, project.getId());
		p.setTitle(project.getTitle());
		p.setDescription(project.getDescription());
		p.setStartDate(project.getStartDate());
		p.setEndDate(project.getEndDate());

	}

	@Override
	public void updateTask(Task task) {
		Task t = em.find(Task.class, task.getId());
		t.setTitle(task.getTitle());
		t.setDescription(task.getDescription());
		t.setStartDate(task.getStartDate());
		t.setEndDate(task.getEndDate());
		t.setStatus(task.getStatus());

	}

	@Override
	public void cancelTask(Task task) {
		Task t = em.find(Task.class, task.getId());
		t.setStatus(Status.In_progress);

	}

	@Override
	public Project getProjectByName(String titlep) {
		TypedQuery<Project> query = em.createQuery("SELECT c FROM Project c WHERE c.title=:titlep", Project.class);

		query.setParameter("titlep", titlep);
		Project pr = null;
		try {
			pr = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur :+e");
		}
		return pr;
	}
	

	@Override
	public List<Task> getTasksByProject(int projectId) 
	{
		Project projectManagedEntity = em.find(Project.class, projectId);
		System.out.println("userManagedEntity.getProjects().size() : " + projectManagedEntity.getTasks().size());
		System.out.println("userManagedEntity.getProjects().get(0).getDescription() : " + projectManagedEntity.getTasks().get(0).getTitle());
		return projectManagedEntity.getTasks();
		
	}
	
	@Override
	public int getTasksByProject2(int projectId) 
	{
		Project projectManagedEntity = em.find(Project.class, projectId);
		//System.out.println("userManagedEntity.getProjects().size() : " + projectManagedEntity.getTasks().size());
		//System.out.println("userManagedEntity.getProjects().get(0).getDescription() : " + projectManagedEntity.getTasks().get(0).getTitle());
		if (projectManagedEntity.getTasks().size()==0) return 0;
		return 1;
	
		
	
	}
	
	@Override
	public void setStatus(int taskId)
	{	Task task = em.find(Task.class, taskId);
		task.setStatus(Status.In_progress);
	}
}