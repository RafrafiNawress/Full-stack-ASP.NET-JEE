package MissionRessources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Entities.Employee;
import MissionService.EmployeeService;


@Path("employee")
@RequestScoped
public class EmployeeRessource {
	
	
	@EJB
	EmployeeService UserService ; 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser (@QueryParam(value="login") String login ,@QueryParam(value="password") String password) {
		
        if (UserService.getEmployeeByEmailAndPassword(login,password)!=null)
	    return Response.status(Status.CREATED).entity(UserService.getEmployeeByEmailAndPassword(login,password)).build();
		return Response.status(Status.CREATED).entity(new Employee()).build();
	} 

	@Path("all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers() {
		if (UserService.getAllEmployees() != null)
			return Response.status(Status.FOUND).entity(UserService.getAllEmployees()).build();
		return Response.status(Status.NOT_FOUND).build();
	} 
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response deleteUser(@PathParam("id")Integer id) {
		Employee u = UserService.getUserId(id);
		UserService.deleteEmployeById(u.getId());
		return Response.status(Status.OK).entity("user removed").build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response chercherUser(@PathParam("id") Integer id) 
	{
		if(UserService.getUserId(id)!=null)
			return Response.status(Status.OK).entity(UserService.getUserId(id)).build() ;
			else
				return Response.status(Status.NOT_FOUND).build();
	} 
	
	  @POST
		@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	  @Produces(MediaType.APPLICATION_JSON)
		public Response ajoutUser(Employee u)
		{
		 UserService.addEmploye(u);
		 return Response.status(Status.CREATED).entity(u).build();
			
		}
	  @PUT
	  @Path("{id}")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response UpdateUser(@PathParam("id") Integer id, Employee u) {
	  	u.setId(id);
	  	if (UserService.updateEmploye(u)){

	  		return Response.status(Status.OK).entity(u).build();
	  	}

	  	return Response.status(Status.NOT_FOUND).entity(u).build();
	  }

	}

