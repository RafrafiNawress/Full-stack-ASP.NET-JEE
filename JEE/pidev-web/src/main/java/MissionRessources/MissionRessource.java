package MissionRessources;


import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Entities.Mission;
import Entities.Project;
import MissionService.MissionServiceImpl;
import TimesheetService.ProjectServImpl;

@Path("mission")
public class MissionRessource {

	@EJB
	MissionServiceImpl missionService;
	@EJB
	ProjectServImpl projectService;
	

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMission(Mission m) {
		
		missionService.addMission(m);
		return Response.status(Status.CREATED).entity(m).build();
	}
	

	
	@DELETE
	@Path("{id}")
	public Response deleteMission(@PathParam("id")int idMission) {
		missionService.deleteMissionById(idMission);
		return Response.status(Status.OK).entity("mission supprimer").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getMissionById(@PathParam("id")int idMission) {
		return Response.status(Status.OK).entity(missionService.getMissionById(idMission)).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("project/{project}")
	public Response getMissionsByProject(@PathParam("project")int idProject) {
		
		Project p =projectService.getProjectById(idProject);
		return Response.status(Status.OK).entity(missionService.getMissionsByProject(p.getId())).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMissions() {
		return Response.status(Status.OK).entity(missionService.getAllMissions()).build();
	}

	
}
