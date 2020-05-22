package in.tucaurto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.tucaurto.dao.UserDAO;
import in.tucaurto.entity.User;
import in.tucaurto.entity.UserDTO;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDAO userDao;

	public UserServiceImpl(UserDAO userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public User findUser(String email) {
		User user=userDao.findByEmail(email);
		return user;
	}

	@Override
	public List<User> listAllUsers() {
		List<User> users=userDao.findAll();
		return users;
	}

	@Override
	public String deleteUser(String email) 
	{
		User user=userDao.findByEmail(email);
		if(user != null)
		{
			userDao.deleteById(email);
			return "User deleted successfully!!";
		}
		else
			return "No user found!!";
		
	}
	

	@Override
	public List<User> findByNameContaining(String name) {
		return userDao.findByNameContaining(name);
	}

	@Override
	public List<User> findByCity(String city) {
		return userDao.findByCity(city);
	}

	@Override
	public User findByContactNumber(long contactNumber) {
		return userDao.findByContactNumber(contactNumber);
	}


	@Override
	public ResponseEntity<?> updateUser(UserDTO userDto) 
	{
		String id= userDto.getEmail();
		User user=userDao.findByEmail(id);
		if(userDao.findByEmail(id) == null)
		{
			return ResponseEntity.ok().body("No registered user Found");
		}
		user.setEmail(id);
		user.setAddress(userDto.getAddress());
		user.setCity(userDto.getCity());
		user.setContactNumber(userDto.getContactNumber());
		user.setGender(userDto.getGender());
		user.setImageUrl(userDto.getImageUrl());
		user.setName(userDto.getName());
		user.setState(userDto.getState());
		user.setPincode(userDto.getPincode());
		user.setUserLogin(user.getUserLogin());
		return ResponseEntity.ok().body(userDao.save(user));
	}

	
	
}
