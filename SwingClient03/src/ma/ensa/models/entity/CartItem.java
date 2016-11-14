package ma.ensa.models.entity;

import java.io.Serializable;
import java.util.Date;


public class CartItem implements Serializable{

	//Finalized,Pending,Aborted

	private static final long serialVersionUID = 1L;
	

	private Long id;
	private int quantity;
	
	private Boolean paid ;
	
	private String stateOfOrder;
	
	private Date date ;
	private String address ;
	
	
	private User user ;
	
	private Product product ;
	
	
	
	

	public String getStateOfOrder() {
		return stateOfOrder;
	}

	public void setStateOfOrder(String stateOfOrder) {
		this.stateOfOrder = stateOfOrder;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
		
	}
	
}
