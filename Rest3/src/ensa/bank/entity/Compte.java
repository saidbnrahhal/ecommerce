package ensa.bank.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Compte implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id ;
	private Double money; 
	private String name ;
	private String codeBancaire;
	
	public Compte() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodeBancaire() {
		return codeBancaire;
	}

	public void setCodeBancaire(String codeBancaire) {
		this.codeBancaire = codeBancaire;
	}
	
	@Override
	public String toString() {
		return "Compte [id=" + id + ", money=" + money + ", name=" + name
				+ ", codeBancaire=" + codeBancaire + "]";
	}
}
