package ma.ensa.models.entity;

import java.io.Serializable;
import java.util.List;


public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long id ;
	
	private String firstName ;
	
	private String lastName ;
	
	private String email ;
	
	private String password ;
	
	private String telephone ;
	
	private List<CartItem> cartItems ;
	
	

	public User() {
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public List<CartItem> getCartItems() {
		return cartItems;
	}


	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}


	
}
