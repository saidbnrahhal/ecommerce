package ma.ensa.views.user;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ma.ensa.controllers.interfaces.PageController;
import ma.ensa.controllers.interfaces.UserController;
import ma.ensa.models.UserModel;
import ma.ensa.models.entity.User;

public class UserPanel extends JPanel implements UserController ,UserListViewActionListner{

	private UserControllpanel  userControllpanel ;
	private UserListView userListView ;
	private PageController pageController ;
	private UserModel userModel ;
	private JPanel centerPanel ;
	
	public UserPanel(UserModel userModel,PageController pageController) {

		this.userModel =userModel ;
		this.pageController=pageController ;
		
		userControllpanel =new UserControllpanel(pageController ,this) ;
		centerPanel =new JPanel();
		
		this.setLayout(new BorderLayout());
		this.add(userControllpanel,BorderLayout.NORTH);
		JScrollPane scrollPane =new JScrollPane(centerPanel);
		scrollPane.setPreferredSize(new Dimension(300,100));
		this.add(scrollPane,BorderLayout.CENTER);
		
		showAllUsers() ;
	}
	
	
	


	@Override
	public void addUserPage() {
		centerPanel.setLayout(new GridLayout(1,1,20,20));
		centerPanel.removeAll();
		centerPanel.repaint();
		userListView =new UserListView(userModel.getAllUser(),this);
		userListView.refrech();
		centerPanel.add(new AddUserPanel(this));
		centerPanel.repaint();
		centerPanel.updateUI();	
		
	}


	@Override
	public void addUser(User user) {
		userModel.addUser(user);
		showAllUsers();
		userListView.refrech();
	}

	@Override
	public void updateUser(Long id, User user) {
		userModel.updateUser(id, user);
		showAllUsers();
		userListView.refrech();
	}


	@Override
	public void next() {
		userListView.nextPage();
	}


	@Override
	public void prev() {
		userListView.prevPage();
		
	}





	@Override
	public void quit() {
		pageController.homePage();
	}





	@Override
	public void showAllUsers() {
		centerPanel.setLayout(new GridLayout(1,1,20,20));
		centerPanel.removeAll();
		centerPanel.repaint();
	
		userListView =new UserListView(userModel.getAllUser(),this);
		centerPanel.add(userListView);
		
		centerPanel.repaint();
		centerPanel.updateUI();
	}

		@Override
	public void sendToupdating(Long id) {
			centerPanel.setLayout(new GridLayout(1,1,20,20));
			centerPanel.removeAll();
			centerPanel.repaint();
			
			UpdateUserPanel  updateUserPanel =new UpdateUserPanel(this,userModel.getUserById(id));

			userListView =new UserListView(userModel.getAllUser(),this);
			centerPanel.add(updateUserPanel);
			
			centerPanel.repaint();
			centerPanel.updateUI();
	}
	@Override
	public void sendTodeleting(Long id) {
		if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		    deletUser(id);
		} else {
			
		}
	}





	@Override
	public void deletUser(Long id) {
		userModel.deleteUser(id);
		showAllUsers();
		userListView.refrech();
	}





	@Override
	public void refrechListofUsers() {
		userListView.refrech();
		
	}

	@Override
	public void sendDiscription(String number) {
		userControllpanel.showdescripion(number);
	}

	
}
