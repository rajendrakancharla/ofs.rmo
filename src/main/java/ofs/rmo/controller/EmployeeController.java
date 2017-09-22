package ofs.rmo.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ofs.rmo.model.Employee;
import ofs.rmo.service.EmployeeService;

@Controller
@Path("/employee")
public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;

	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerEmployee(@QueryParam("username") String username, @QueryParam("password") String password,
			@QueryParam("firstname") String firstname, @QueryParam("lastname") String lastname,
			@QueryParam("email") String email, @QueryParam("address") String address, @QueryParam("phone") int phone)
			throws Exception {

		//validate Employee details
		Employee employee = new Employee(username, password, firstname, lastname, email, address, phone);
		employeeService.register(employee);
		return Response.status(200).entity(employee).build();
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public Response test()
			throws Exception {

		return Response.status(200).entity(new Employee()).build();
	}
	
	@GET
	@Path("/success")
	@Produces(MediaType.APPLICATION_JSON)
	public Response success()
			throws Exception {

		return Response.status(200).entity("success").build();
	}
}