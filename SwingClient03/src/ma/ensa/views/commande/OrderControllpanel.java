package ma.ensa.views.commande;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ma.ensa.controllers.interfaces.OrderController;
import ma.ensa.controllers.interfaces.PageController;
import ma.ensa.controllers.interfaces.ProductController;

public class OrderControllpanel extends JPanel implements ActionListener {

	JButton showAllOrders =new JButton("All Products") ;
	JButton homeButton = new JButton("Home");
	JButton nextButton = new JButton(">>");
	JButton prevButton = new JButton("<<");
	JButton refrechButton = new JButton("refrech");
	
	JLabel pageDisplayer ;
	
	PageController pageController ;
	OrderController orderController;
	
	
	public OrderControllpanel(PageController pageController ,OrderController orderController) {
		
		this.pageController =pageController ;
		this.orderController =orderController ;
		
		
		pageDisplayer = new JLabel("");
	    pageDisplayer.setOpaque(true);
	    pageDisplayer.setBackground(new Color(250, 250, 250));
	    pageDisplayer.setBorder(BorderFactory.createEtchedBorder());
	    pageDisplayer.setHorizontalAlignment(JLabel.CENTER);
	    pageDisplayer.setPreferredSize(new Dimension(60, 30));
		
		
		this.add(homeButton);
		this.add(prevButton);
		this.add(pageDisplayer);
		this.add(nextButton);
		this.add(showAllOrders);
		this.add(refrechButton);

		homeButton.addActionListener(this);
		nextButton.addActionListener(this);
		prevButton.addActionListener(this);
		showAllOrders.addActionListener(this);
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
		
		if (nextButton == e.getSource()) {
			
			orderController.next();
		}
		if (prevButton == e.getSource()) {
			
			orderController.prev();
		}
		if (showAllOrders==e.getSource()) {
			
			orderController.showAllOrders();
		}
		if (refrechButton==e.getSource()) {
			
			orderController.refrechListofOrders();
			
		}

	}
	
}
