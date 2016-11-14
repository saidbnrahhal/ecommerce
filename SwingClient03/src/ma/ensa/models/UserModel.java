package ma.ensa.models;

import java.util.List;

import ma.ensa.models.entity.User;
import ma.ensa.services.interfaces.UsersService;

public class UserModel {

	private UsersService userService ;

	

	public UserModel(ConnectionModel connectionModel) {
		userService=connectionModel.getUserService();
	}

	

	public void addUser(User user) {
		userService.addUser(user);
	}

	public Boolean updateUser(Long id, User user) {
		userService.updateUser(id, user);
		return false;
	}

	public Boolean deleteUser(Long id) {
		userService.deletUser(id);
		return false;
	}

	public Boolean login(String email, String password) {
		userService.loginUser(email, password);
		return false;

	}

	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	public Long getContUsers() {
		return userService.getUserCount();
	}

	public User getUserById(Long id) {
		User user =userService.getUserById(id);
		return user;

	}

	
}
