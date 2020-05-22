package in.tucaurto.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.tucaurto.dao.SupportRepository;
import in.tucaurto.dao.UserLoginRepository;
import in.tucaurto.dao.UserRepository;
import in.tucaurto.entity.CustomerSupport;
import in.tucaurto.entity.Role;
import in.tucaurto.entity.SupportDTO;
import in.tucaurto.entity.User;
import in.tucaurto.entity.UserDTO;
import in.tucaurto.entity.UserLogin;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserLoginRepository userloginDao;
	
	@Autowired
	private UserRepository userDao;

	@Autowired
	private SupportRepository supportDao;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLogin userLogin = userloginDao.findByUsername(username);
		if (userLogin == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(userLogin.getUsername(), userLogin.getPassword(),
				new ArrayList<>());
	}
	public Role findRole(String username) throws UsernameNotFoundException{
		UserLogin user=userloginDao.findByUsername(username);
		
		return user.getRole();
	}

	public ResponseEntity<?> saveUser(UserDTO user) 
	{
		
		if(userloginDao.findByUsername(user.getUsername()) != null)
		{
			return ResponseEntity.ok("Username already Taken");
		}
		Role role=new Role();
		role.setId(1);
		role.setRole("ROLE_USER");
		UserLogin newUser = new UserLogin();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setRole(role);
		User userDetails= new User(user.getName(),user.getUsername(),user.getContactNumber());
		userDetails.setUserLogin(newUser);
		userDetails.setEmail(user.getUsername());
		return ResponseEntity.ok(userDao.save(userDetails));
		
	}
	public String saveSupport(SupportDTO support)
	{
		if(supportDao.findByUsername(support.getUsername()) != null)
		{
			return "Username already taken!!";
		}
		Role role=new Role();
		role.setId(2);
		role.setRole("ROLE_SUPPORT");
		UserLogin newUser = new UserLogin();
		newUser.setUsername(support.getUsername());
		newUser.setPassword(bcryptEncoder.encode(support.getPassword()));
		newUser.setRole(role);
		CustomerSupport customerSupport = new CustomerSupport();
		customerSupport.setName(support.getName());
		customerSupport.setUsername(support.getUsername());
		customerSupport.setContactNumber(support.getContactNumber());
		customerSupport.setUserLogin(newUser);
		supportDao.save(customerSupport);
		return "New Support account created!!!";
	}
	
	public String changePass(String email,String newPass)
	{
		UserLogin user=userloginDao.findByUsername(email);
		user.setPassword(bcryptEncoder.encode(newPass));
		user.setOtp(null);
		userloginDao.save(user);
		return "Password successfully changed!";
	}
}
