package ma.ensa.controllers.interfaces;

import ma.ensa.models.entity.User;

public interface UserController {

	//khas bi controller panel
	
	public void showAllUsers();
	public void addUserPage();
	public void addUser(User user);
	public void deletUser(Long id) ;
	public void updateUser(Long id ,User user);
	public void next();
	public void prev();
	public void quit() ;
	public void refrechListofUsers();
}
