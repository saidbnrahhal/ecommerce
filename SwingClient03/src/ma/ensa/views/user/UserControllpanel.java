package ma.ensa.views.user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ma.ensa.controllers.interfaces.PageController;
import ma.ensa.controllers.interfaces.UserController;

public class UserControllpanel extends JPanel implements ActionListener {

	JButton showAllUsers =new JButton("All user") ;
	JButton addUserButton = new JButton("add user");
	JButton homeButton = new JButton("Home");
	JButton nextButton = new JButton(">>");
	JButton prevButton = new JButton("<<");
	JButton refrechButton = new JButton("refrech");
	JLabel pageDisplayer ;
	
	PageController pageController ;
	UserController userController ;
	
	
	public UserControllpanel(PageController pageController ,UserController userController) {
		
		this.pageController =pageController ;
		this.userController =userController ;
		
		
		pageDisplayer = new JLabel("");
	    pageDisplayer.setOpaque(true);
	    pageDisplayer.setBackground(new Color(250, 250, 250));
	    pageDisplayer.setBorder(BorderFactory.createEtchedBorder());
	    pageDisplayer.setHorizontalAlignment(JLabel.CENTER);
	    pageDisplayer.setPreferredSize(new Dimension(60, 30));
		
		
		this.add(addUserButton);
		this.add(homeButton);
		this.add(prevButton);
		this.add(pageDisplayer);
		this.add(nextButton);
		this.add(showAllUsers);
		this.add(refrechButton);

		addUserButton.addActionListener(this);
		homeButton.addActionListener(this);
		nextButton.addActionListener(this);
		prevButton.addActionListener(this);
		showAllUsers.addActionListener(this);
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
		if (addUserButton == e.getSource()) {
			
			userController.addUserPage();
		}
		if (nextButton == e.getSource()) {
			
			userController.next();
		}
		if (prevButton == e.getSource()) {
			
			userController.prev();
		}
		if (showAllUsers==e.getSource()) {
			
			userController.showAllUsers();
		}
		if (refrechButton==e.getSource()) {
			userController.refrechListofUsers(); 
			
		}

	}
	
}
