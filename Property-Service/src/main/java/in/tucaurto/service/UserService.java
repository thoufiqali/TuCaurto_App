package in.tucaurto.service;

import in.tucaurto.entity.Property;
import in.tucaurto.entity.User;

public interface UserService {

	public Iterable<Property> findMyProperties(String userID);
	
	public User getMyProfile(String userID);
	
	public void deleteProperty(String userID,Integer propertyID);
	
	
	public User UpdateProfile(String userID, User user);
}
