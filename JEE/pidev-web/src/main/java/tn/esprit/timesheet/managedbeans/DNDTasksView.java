package tn.esprit.timesheet.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.primefaces.event.DragDropEvent;

import Entities.Task;
import TimesheetService.ProjectServImpl;

@ManagedBean(name ="dndTasksView")
@ApplicationScoped
public class DNDTasksView implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ProjectServImpl projectService=new ProjectServImpl();
  
    
 
    private List<Task> tasks;
     
    private List<Task> droppedTasks;
     
    private Task selectedTask;
     
    @PostConstruct
    public void init() {
    	tasks = projectService.getAllTasks();
    	System.out.println(projectService.listCanceled());
    	droppedTasks = projectService.listCanceled();
    }
     
    public void onTaskDrop(DragDropEvent ddEvent) {
        Task task = ((Task) ddEvent.getData());
  
        droppedTasks.add(task);
        projectService.cancelTask(task);
        tasks.remove(task);
    }
    
   
     
    public void setService(ProjectServImpl service) {
        this.projectService = service;
    }
    
    
 
    public ProjectServImpl getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectServImpl projectService) {
		this.projectService = projectService;
	}

	public List<Task> getTasks() {
		tasks = projectService.getAllTasks() ;
        return tasks;
    }
    
    
 
    public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Task> getDroppedTasks() {
        return droppedTasks;
    }  
	
	public void setDropped(List<Task> droppedTasks) {
		this.droppedTasks = droppedTasks;
	}
 
    public Task getSelectedTask() {
        return selectedTask;
    }
 
    public void setSelectedTask(Task selectedTask) {
        this.selectedTask = selectedTask;
    }
}