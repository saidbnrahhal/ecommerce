package ensa.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ensa.bank.entity.Compte;
import ensa.bank.services.BankServicesInter;

@WebServlet("/AddCompte")
public class AddCompte extends HttpServlet{
	@EJB
	BankServicesInter bankServices;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Compte> comptes =bankServices.getAllComptes();
		req.setAttribute("comptes", comptes);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addcompt.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action= req.getParameter("action");
		if (action.equals("delet")) {
			String id= req.getParameter("id");
			bankServices.delet(Long.parseLong(id));
		}
		if (action.equals("add")) {
			String name= req.getParameter("name");
			String money= req.getParameter("money");
			String code= req.getParameter("code");
			Double m =10000.00;
			try {
				 m =Double.parseDouble(money);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			bankServices.addCompte(name, m, code);
		}
		
		
		List<Compte> comptes =bankServices.getAllComptes();
		req.setAttribute("comptes", comptes);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addcompt.jsp");
		dispatcher.forward(req, resp);
		
	}
}
