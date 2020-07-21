package TimesheetInterface;

import java.util.List;

import javax.ejb.Remote;

import Entities.Employee;
import Entities.Project;
import Entities.Task;

@Remote
public interface IProjectServiceRemote {
//project
	public int ajouterProject(Project project);

	public void deleteProjectById(int projectId);

	public List<Project> getAllProjects();

	void updateProject(Project project);

	public Project getProjectById(int projectId);

//task
//public int ajouterTask(Task task, Project p);
	public int ajouterTask(Task task , Employee e);

	public void deleteTaskById(int taskId);

	public void affecterTaskAProject(int taskId, int projectId);

	public void affecterTaskAEmployee(int taskId, int employeeId);

	public List<Task> getAllTasks();

	public List<Employee> getAllEmployees();
	public void setStatus(int taskId);

	public List<Task> listCanceled();

	public void cancelTask(Task task);

	public Project getProjectByName(String titlep);

	void updateTask(Task task);

	public List<Task> getTasksByProject(int projectId);
	public int getTasksByProject2(int projectId) ;

}
