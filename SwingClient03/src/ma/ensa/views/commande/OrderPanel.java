package ma.ensa.views.commande;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ma.ensa.controllers.interfaces.OrderController;
import ma.ensa.controllers.interfaces.PageController;
import ma.ensa.models.CommandeModel;

public class OrderPanel extends JPanel implements OrderController,OrderListViewActionListner {

	private OrderControllpanel  orderControllpanel ;
	private OrderListView orderListView ;
	private PageController pageController ;
	private CommandeModel commandeModel ;
	private JPanel centerPanel ;
	
	public OrderPanel(CommandeModel commandeModel,PageController pageController) {

		this.commandeModel =commandeModel ;
		this.pageController=pageController ;
		
		orderControllpanel =new OrderControllpanel(pageController, this) ;
		centerPanel =new JPanel();
		
		this.setLayout(new BorderLayout());
		this.add(orderControllpanel,BorderLayout.NORTH);
		JScrollPane scrollPane =new JScrollPane(centerPanel);
		scrollPane.setPreferredSize(new Dimension(300,100));
		this.add(scrollPane,BorderLayout.CENTER);
		showAllOrders();
	}

	@Override
	public void next() {
		orderListView.nextPage();
	}


	@Override
	public void prev() {
		orderListView.prevPage();
		
	}





	@Override
	public void quit() {
		pageController.homePage();
	}

	
	
	@Override
	public void sendDiscription(String number) {
		orderControllpanel.showdescripion(number);
	}





	
	
	@Override
	public void showAllOrders() {
		// TODO Auto-generated method stub
		centerPanel.setLayout(new GridLayout(1,1,20,20));
		centerPanel.removeAll();
		centerPanel.repaint();
	
		orderListView =new OrderListView(commandeModel.getAllProduct(),this);
		centerPanel.add(orderListView);
		
		centerPanel.repaint();
		centerPanel.updateUI();	
	}

	@Override
	public void refrechListofOrders() {
		orderListView.refrech();
	}

	
}
