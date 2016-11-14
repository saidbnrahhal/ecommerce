package ensa.bank.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ensa.bank.entity.Compte;

@Stateless
public class BankService implements BankServicesInter {
	@PersistenceContext(name = "Bank2")
	EntityManager entityManager;

	public BankService() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public int paying(String name, String codeBancaire, Double money) {
		TypedQuery<Compte> query = entityManager
				.createQuery(
						"SELECT c FROM Compte c WHERE c.name=:name AND c.codeBancaire=:codeBancaire",
						Compte.class);
		query.setParameter("name", name);
		query.setParameter("codeBancaire", codeBancaire);
		Compte compte;
		try {
			compte = query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			return 400;
		}

		Double allMoney = compte.getMoney();
		Double rest = allMoney - money;
		if (rest < 0) {
			return 400;
		} else {
			compte.setMoney(rest);
			entityManager.merge(compte);
			return 200;
		}

	}

	@Override
	public List<Compte> getAllComptes() {
		TypedQuery<Compte> query = entityManager.createQuery(
				"SELECT c FROM Compte c", Compte.class);
		List<Compte> list = query.getResultList();
		return list;
	}


	@Override
	public void addCompte(String name, Double money, String code) {
	
		Compte compte = new Compte();
		compte.setName(name);
		compte.setMoney(money);
		compte.setCodeBancaire(code);
		entityManager.persist(compte);
		
	}


	@Override
	public void delet(long id) {
		Compte compte =entityManager.find(Compte.class,id );
		entityManager.remove(compte);
		
	}

}
