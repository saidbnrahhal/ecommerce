package ma.ensa.views.product;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ma.ensa.controllers.interfaces.PageController;
import ma.ensa.controllers.interfaces.ProductController;
import ma.ensa.models.ProductModel;
import ma.ensa.models.entity.Product;

public class ProductPanel extends JPanel implements ProductController ,ProductListViewActionListner{

	private ProductControllpanel  productControllpanel ;
	private ProductListView productListView ;
	private PageController pageController ;
	private ProductModel productModel ;
	private JPanel centerPanel ;
	
	public ProductPanel(ProductModel productModel,PageController pageController) {

		this.productModel =productModel ;
		this.pageController=pageController ;
		
		productControllpanel =new ProductControllpanel(pageController ,this) ;
		centerPanel =new JPanel();
		
		this.setLayout(new BorderLayout());
		this.add(productControllpanel,BorderLayout.NORTH);
		JScrollPane scrollPane =new JScrollPane(centerPanel);
		scrollPane.setPreferredSize(new Dimension(300,100));
		this.add(scrollPane,BorderLayout.CENTER);
		
		showAllProducts();
	}

	@Override
	public void next() {
		productListView.nextPage();
	}


	@Override
	public void prev() {
		productListView.prevPage();
		
	}





	@Override
	public void quit() {
		pageController.homePage();
	}

		@Override
	public void sendToupdating(Long id) {
			centerPanel.setLayout(new GridLayout(1,1,20,20));
			centerPanel.removeAll();
			centerPanel.repaint();
			
			UpdateProductPanel  updateUserPanel =new UpdateProductPanel(this,productModel.getProductById(id));

			//productListView =new ProductListView(productModel.getAllProduct(),this);
			centerPanel.add(updateUserPanel);
			
			centerPanel.repaint();
			centerPanel.updateUI();
	}
	@Override
	public void sendTodeleting(Long id) {
		if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		    deletProduct(id);
		} else {
			
		}
	}





	






	@Override
	public void sendDiscription(String number) {
		productControllpanel.showdescripion(number);
	}





	@Override
	public void showAllProducts() {
		centerPanel.setLayout(new GridLayout(1,1,20,20));
		centerPanel.removeAll();
		centerPanel.repaint();
	
		productListView =new ProductListView(productModel.getAllProduct(),this);
		centerPanel.add(productListView);
		
		centerPanel.repaint();
		centerPanel.updateUI();		
	}





	@Override
	public void addProductPage() {
		centerPanel.setLayout(new GridLayout(1,1,20,20));
		centerPanel.removeAll();
		centerPanel.repaint();
		productListView =new ProductListView(productModel.getAllProduct(),this);
		productListView.refrech();
		centerPanel.add(new AddProductPanel(this));
		centerPanel.repaint();
		centerPanel.updateUI();	

	}





	@Override
	public void adddProduct(Product product) {
		// TODO Auto-generated method stub
		productModel.addProduct(product);
		showAllProducts();
		productListView.refrech();
	}





	@Override
	public void deletProduct(Long id) {
		// TODO Auto-generated method stub
		productModel.deleteProduct(id);
		showAllProducts();
		productListView.refrech();
		
	}





	@Override
	public void updateProduct(Long id, Product product) {
		productModel.updateProduct(id, product);
		showAllProducts();
		productListView.refrech();
	}





	@Override
	public void refrechListofProducts() {
		// TODO Auto-generated method stub
		productListView.refrech();
		
	}

	
}
