package ma.ensa.services.interfaces;

import java.util.List;

import ma.ensa.models.entity.Category;
import ma.ensa.models.entity.Product;


public interface ProductService {

	public void addProduct(Product product);
	public List<Product> getAllProduct();
	public Product getProductById(Long id);
	public void updateProduct(Long id ,Product product);
	public void deleteProduct(Long id);
	
	//general shopping 
	public Integer getAllProductsCount();
	public List<Product> searchProduct(String name ,Category gameGenre);
	
	
}
