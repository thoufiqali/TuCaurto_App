package in.tucaurto.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import in.tucaurto.entity.User;
import in.tucaurto.entity.UserDTO;

public interface UserService
{
	public Long getCount();
	public ResponseEntity<?> updateUser(UserDTO userDto);
	public User findUser(String email);
	public List<User> listAllUsers();
	public String deleteUser(String email);
}
