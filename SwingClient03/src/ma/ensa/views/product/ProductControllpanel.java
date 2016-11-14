package ma.ensa.views.product;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ma.ensa.controllers.interfaces.PageController;
import ma.ensa.controllers.interfaces.ProductController;
import ma.ensa.controllers.interfaces.UserController;

public class ProductControllpanel extends JPanel implements ActionListener {

	JButton showAllProducts =new JButton("All Products") ;
	JButton addProductsButton = new JButton("add Product");
	JButton homeButton = new JButton("Home");
	JButton nextButton = new JButton(">>");
	JButton prevButton = new JButton("<<");
	JButton refrechButton = new JButton("refrech");
	JLabel pageDisplayer ;
	
	PageController pageController ;
	ProductController productController ;
	
	
	public ProductControllpanel(PageController pageController ,ProductController productController) {
		
		this.pageController =pageController ;
		this.productController =productController ;
		
		
		pageDisplayer = new JLabel("");
	    pageDisplayer.setOpaque(true);
	    pageDisplayer.setBackground(new Color(250, 250, 250));
	    pageDisplayer.setBorder(BorderFactory.createEtchedBorder());
	    pageDisplayer.setHorizontalAlignment(JLabel.CENTER);
	    pageDisplayer.setPreferredSize(new Dimension(60, 30));
		
		
		this.add(addProductsButton);
		this.add(homeButton);
		this.add(prevButton);
		this.add(pageDisplayer);
		this.add(nextButton);
		this.add(showAllProducts);
		this.add(refrechButton);

		addProductsButton.addActionListener(this);
		homeButton.addActionListener(this);
		nextButton.addActionListener(this);
		prevButton.addActionListener(this);
		showAllProducts.addActionListener(this);
		refrechButton.addActionListener(this);
	}
	public void showdescripion(String description){
		
		pageDisplayer.setText(description);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (homeButton == e.getSource()) {
			
			pageController.homePage();
			
		}
		if ( addProductsButton== e.getSource()) {
			
			productController.addProductPage();
		}
		if (nextButton == e.getSource()) {
			
			productController.next();
		}
		if (prevButton == e.getSource()) {
			
			productController.prev();
		}
		if (showAllProducts==e.getSource()) {
			
			productController.showAllProducts();
		}
		if (refrechButton==e.getSource()) {
			
			productController.refrechListofProducts();
			
		}

	}
	
}
