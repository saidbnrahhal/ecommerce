package ensa.bank.services;

import java.util.List;

import javax.ejb.Local;

import ensa.bank.entity.*;
 @Local
public interface BankServicesInter {

	public void addCompte(String name,Double money,String code);
	public int paying(String name ,String codeBancaire,Double money);
	public List<Compte> getAllComptes();
	public void delet(long id);
}
