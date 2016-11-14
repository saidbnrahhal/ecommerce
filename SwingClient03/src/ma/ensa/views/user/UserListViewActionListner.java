package ma.ensa.views.user;


public interface UserListViewActionListner {

	//the id is the real id of the user
	//the action update and delete are related to the data not to the presentation
	void sendToupdating(Long id) ;
	void sendTodeleting(Long id) ;
	void sendDiscription(String number) ;
	
}
