package ServiceRemote;

import javax.ejb.Remote;

import Entities.Employee;



@Remote
public interface employeeServiceRemote {
	public Employee getEmployeByEmailAndPassword(String login, String password); 
}
