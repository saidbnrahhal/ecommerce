package ma.ensa.views.user;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ma.ensa.models.entity.User;

public class UserListView extends JPanel implements OneUserActionListner {

	List<OneUserPanel> oneUserPanelList;
	private UserListViewActionListner userListViewActionListner;
	private List<User> userslist;
	private JPanel container;
	
	
	int numberOfItemes=0 ;
	int numberOfPages ;
	int numberOfItemesByPage= 3 ;
	int actualPage =0 ;
	
	public UserListView(List<User> userslist,UserListViewActionListner userListViewActionListner) {
		container = new JPanel();
		this.userslist =userslist ;
		this.userListViewActionListner =userListViewActionListner ;
		refrech();
	}
	public void calculateNumberOfPages(){
		
		numberOfItemes=userslist.size();
		numberOfPages =(int) numberOfItemes/numberOfItemesByPage ;
		int restItems =numberOfItemes-numberOfPages * numberOfItemesByPage ;
		
		if (restItems >0) {
			numberOfPages ++ ;
		}
		
	}
	public void nextPage(){
		
		if (actualPage< numberOfPages-1) {
			actualPage++;
			refrech();
		}
	}
	
	public void prevPage(){
		
		if (actualPage>0) {
			actualPage--;
			refrech();
		}
	}
	
	public Long userIdFromPanelId(int panelId){
		
		int indexInUserList  =actualPage*numberOfItemesByPage +panelId ; 
		long userId =userslist.get(indexInUserList).getId();
		return userId;
	}
	
	
	
	
	public void refrech() {
		calculateNumberOfPages();
		userListViewActionListner.sendDiscription(""+(actualPage+1)+"/"+(numberOfPages));
		container.setLayout(new GridLayout(numberOfItemesByPage,1,20,20));
		container.removeAll();
		container.repaint();
		for (int i = 0; i < numberOfItemesByPage; i++) {
			int indexInArray = actualPage*numberOfItemesByPage +i;
			if (indexInArray >= numberOfItemes) {
				container.add(new JLabel(""));
			}
			else {
				User user = userslist.get(indexInArray);
				OneUserPanel oneUserPanel = new OneUserPanel();

				// the id of the panel will be equal to the order of it's user in
				// userList
				oneUserPanel.setPanelId(i);
				oneUserPanel.setLastName(user.getLastName());
				oneUserPanel.setFirstName(user.getFirstName());
				oneUserPanel.setEmail(user.getEmail());
				oneUserPanel.setPassword(user.getPassword());
				oneUserPanel.setTelephone(user.getTelephone());
				oneUserPanel.setOneUserActionListner(this);
				container.add(oneUserPanel);
				oneUserPanel.setOneUserActionListner(this);
			}
			
		}
		container.repaint();
        container.updateUI();
        
        this.add(container);
	}

	@Override
	public void delete(int idPanel) {
		System.out.println("delete from Userlistview id of the panel:"+idPanel);
		System.out.println("the id of the user "+userIdFromPanelId(idPanel));
		userListViewActionListner.sendTodeleting(userIdFromPanelId(idPanel));
		
	}

	@Override
	public void update(int idPanel) {
		System.out.println("update from user listView id of the panel :"+idPanel);
		userListViewActionListner.sendToupdating(userIdFromPanelId(idPanel));
	}

	
}
