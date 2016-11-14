package ma.ensa.models.entity;

import java.io.Serializable;
import java.util.List;


public class Product implements Serializable {
	
	
	
	private static final long serialVersionUID = 1L;

	
	private Long id;

	private String name;
	private int qtyInstock;
	private Boolean available;
	private Double price;
	private String imageLink;
	private String shortDiscreption;
	
	private Category gameGenre;
	
	private String searchDiscreption;
	
	private List<CartItem>cartItems ;
	
	

	public Product() {
	
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQtyInstock() {
		return qtyInstock;
	}

	public void setQtyInstock(int qtyInstock) {
		this.qtyInstock = qtyInstock;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getGameGenre() {
		return gameGenre;
	}

	public void setGameGenre(Category gameGenre) {
		this.gameGenre = gameGenre;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getSearchDiscreption() {
		return searchDiscreption;
	}

	public void setSearchDiscreption(String searchDiscreption) {
		this.searchDiscreption = searchDiscreption;
	}

	public String getShortDiscreption() {
		return shortDiscreption;
	}

	public void setShortDiscreption(String shortDiscreption) {
		this.shortDiscreption = shortDiscreption;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
}
