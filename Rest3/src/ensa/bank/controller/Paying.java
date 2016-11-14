package ensa.bank.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ensa.bank.services.BankServicesInter;

/**
 * Servlet implementation class Paying
 */
@WebServlet("/Paying")
public class Paying extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	BankServicesInter bankServices;
    public Paying() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Double result= bankServices.paying("said", "123456789", 1000.00);
//		Double result2=bankServices.paying("amin", "123456789", 100000.00);
//		Double result3=bankServices.paying("allal", "123456789", 20.00);
//		Double result4=bankServices.paying("khorafa", "123456789", 20.00);
//		System.out.println("said"+result);
//		System.out.println("amin"+result2);
//		System.out.println("allal"+result3);
//		System.out.println("khorafa"+result4);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
