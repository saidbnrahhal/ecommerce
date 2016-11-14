package ensa.bank.webservices.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ensa.bank.entity.Compte;
import ensa.bank.services.BankServicesInter;

@Stateless
@Path("/comptes")
public class Comptes {
	
	
	@EJB
	BankServicesInter bankServices;
	public Comptes() {
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Compte> getAllComptes(){
		List<Compte> list=bankServices.getAllComptes();
		return list;
	}
}
