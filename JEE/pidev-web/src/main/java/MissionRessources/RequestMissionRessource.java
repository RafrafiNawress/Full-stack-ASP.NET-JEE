package MissionRessources;


import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Entities.Bill;
import Entities.Mission;
import Entities.MissionRequest;
import MissionService.MissionServiceImpl;
import TimesheetService.ProjectServImpl;

@Path("Requestmission")
public class RequestMissionRessource {


	@EJB
	MissionServiceImpl missionService;
	@EJB
	ProjectServImpl projectService;
	
	

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response addBill(@PathParam("id")int idmission,Bill resto,Bill heb,Bill trans) {
		resto.setMatricule("Restauration");
		resto.setMission(missionService.getMissionById(idmission));
		resto.setDate(new Date());
		heb.setMatricule("Hebergement");
		heb.setMission(missionService.getMissionById(idmission));
		heb.setDate(new Date());
		trans.setMatricule("Transport");
		trans.setMission(missionService.getMissionById(idmission));
		trans.setDate(new Date());
		missionService.addBill(resto.getSomme()==0?null:resto, heb.getSomme()==0?null:heb, trans.getSomme()==0?null:trans);
		return Response.status(Status.CREATED).entity(heb).build();
		
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteMission(@PathParam("id")int idRequestMission) {
		missionService.deleteRequestMissionById(idRequestMission);
		return Response.status(Status.OK).entity("Request supprimer").build();
	}


	
	@GET
    @Path("mission/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public List<MissionRequest> getRequestByMission(@PathParam("id") int idMission) {
   	 return missionService.getRequestByMission(idMission);

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRequestMission() {
		return Response.status(Status.OK).entity(missionService.getAllMissionsRequest()).build();
	}
	
	 	@PUT
	    @Path("mission/{id}/request/{idR}")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response affecterEmployeAMission(@PathParam("idR") int missionReqId, @PathParam("id")int missionId , int employeeId) {
	        missionService.affecterEmployeAMission(1, missionId, missionReqId);
			return Response.status(Status.CREATED).entity("Affecte!").build();

	 
	    }

}
