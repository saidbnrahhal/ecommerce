package ma.ensa.controllers.interfaces;

import ma.ensa.models.entity.Product;

public interface ProductController {

	public void showAllProducts();
	public void addProductPage();
	public void adddProduct(Product product);
	public void deletProduct(Long id) ;
	public void updateProduct(Long id ,Product product);
	public void next();
	public void prev();
	public void quit() ;
	public void refrechListofProducts();
	
}
