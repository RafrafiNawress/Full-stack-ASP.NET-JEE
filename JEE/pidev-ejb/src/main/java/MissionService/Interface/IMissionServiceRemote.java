package MissionService.Interface;

import java.util.List;
import java.util.Set;

import javax.ejb.Remote;

import Entities.Bill;
import Entities.Employee;
import Entities.Mission;
import Entities.MissionRequest;
import Entities.Project;
@Remote
public interface IMissionServiceRemote {
	public int addMission(Mission mission);
	public void deleteMissionById(int missionId);
	public void updateMission(Mission mission);
	public void valideMission(int missionId);
	public List<Mission> getAllMissions();
	public void affecterEmployeAMission(int employeeId, int missionId, int missionReqId);
	public List<Project> getAllProjects();
	//public List<Mission> getMissionsByProject(int projectId) ;
	public List<Mission> getAllMissionsValide();
	public List<MissionRequest> getAllMissionsRequest();
	public List<Mission> getAllMissionsNonValide();
	public List<Mission> getMissionsByProject(int projectId);
	public Mission getMissionById(int id);
	//public int addMissionRequest(MissionRequest missionr, int idMission);
	public int addMissionRequest(MissionRequest missionr, int idMission, Employee e);
	//public int addBill(Bill bill);
	void addBill(Bill resto, Bill heb, Bill trans);
	public int getMissionsByProject2(int projectId);
	public void deleteRequestMissionById(int RequestmissionId);
	public List<MissionRequest> getRequestByMission(int missionId);
	List<Bill> getAllBills();
	Project getProjectById(int projectId);

}
