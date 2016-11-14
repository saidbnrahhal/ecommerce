package ma.ensa.services.interfaces;

import java.util.List;

import ma.ensa.models.entity.User;
public interface UsersService {
	
	public void addUser(User user) ;
	
	public void deletUser(long id) ;
	
	public void updateUser(long id ,User user);
	
	public User loginUser(String email ,String password); 
	
	public List<User> getAllUser();
	
	public long getUserCount();
	
	public void initUser();
	
	public User getUserById(Long id);
	
}
