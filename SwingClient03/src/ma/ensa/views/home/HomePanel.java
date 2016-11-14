package ma.ensa.views.home;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ma.ensa.controllers.interfaces.PageController;

public class HomePanel extends JPanel{

	ChoisePanel UserPanel ;
	ChoisePanel ProductPanel ;
	ChoisePanel ConnectionPanel ;
	ChoisePanel CommandePanel ;
	PageController pageController ;
	JPanel container ;
	
	public HomePanel(PageController pageController) {
		// TODO Auto-generated constructor stub
		this.pageController =pageController ;
		container =new JPanel() ;
		container.setLayout(new GridLayout(2,2,20,20));
		UserPanel = new ChoisePanel("/ma/ensa/views/home/images/Users.png", "Users") ;
		ProductPanel =new ChoisePanel("/ma/ensa/views/home/images/Products.png", "Products") ;
		ConnectionPanel =new ChoisePanel("/ma/ensa/views/home/images/Connections.png", "Connections");
		CommandePanel =new ChoisePanel("/ma/ensa/views/home/images/Commandes.png", "Commandes");
		
		container.add(UserPanel);
		container.add(ProductPanel);
		container.add(ConnectionPanel);
		container.add(CommandePanel);
		
		this.add(container);
		initControlle();
	}

	
	public void initControlle(){
			UserPanel.getActionButton().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							pageController.userPage();
						}
					});
			CommandePanel.getActionButton().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					pageController.commandePage();
				}
			});
			ConnectionPanel.getActionButton().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					pageController.connectPage();
				}
			});
			
			ProductPanel.getActionButton().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					pageController.productPage();
				}
			});
			
			
	}
	
	
}
