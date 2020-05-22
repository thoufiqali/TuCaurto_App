package in.tucaurto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.tucaurto.dao.PropertyDAO;
import in.tucaurto.dao.UserDAO;
import in.tucaurto.entity.Property;
import in.tucaurto.entity.User;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private PropertyDAO propertyDao;
	
	@Autowired
	private UserDAO userDao;
	

	@Override
	public Iterable<Property> findMyProperties(String userID) {
	
		User user= userDao.findByEmail(userID);
		return propertyDao.findByUser(user);
	}

	@Override
	public User getMyProfile(String userID) {
	
		return userDao.findByEmail(userID);
	}

	@Override
	public void deleteProperty(String userID, Integer propertyID) {
		// find the user by email
				User user = userDao.findByEmail(userID);

				// find the property by its ID
				Property property = propertyDao.findById(propertyID).get();

				// set the user for a property
				property.setUser(user);

				// Performing a delete operation
				propertyDao.delete(property);
	}

	@Override
	public User UpdateProfile(String userID, User user) {
		return userDao.save(user);
	}

}
