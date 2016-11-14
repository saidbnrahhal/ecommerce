package ma.ensa.views.product;


public interface OneProductActionListner {

	//for the id id the panel id not the user id
	// the action delete and update are more related to the button than the service
	public void delete(int idPanel);
	public void update(int idPanel);
	
}
