package ensa.bank.webservices.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ensa.bank.services.BankServicesInter;
@Stateless
@Path("/Paying")
public class Paying {
	@EJB
	BankServicesInter bankServices;
	public Paying() {
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers(
			@QueryParam("name") String name,
			@QueryParam("code") String code,
			@QueryParam("money") Double money) {
	int result=	bankServices.paying(name, code, money);
			return Response
			   .status(result)
			   .entity(result+"").build();

		}
}
