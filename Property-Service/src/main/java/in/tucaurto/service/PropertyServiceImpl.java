package in.tucaurto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.tucaurto.dao.PropertyDAO;
import in.tucaurto.dao.PropertyTypeDAO;
import in.tucaurto.dao.UserDAO;
import in.tucaurto.entity.Property;
import in.tucaurto.entity.PropertyType;
import in.tucaurto.entity.User;

@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyDAO propertyDao;

	@Autowired
	private PropertyTypeDAO propertyTypeDao;

	@Autowired
	private UserDAO userDao;

	@Override
	public Property saveProperty(String userID, Integer propertyTypeID, Property property) {
		// getting and setting the propertyType
		PropertyType propertyType = propertyTypeDao.findById(propertyTypeID).get();
		property.setType(propertyType);

		// getting and setting the useremail
		User user = userDao.findByEmail(userID);
		property.setUser(user);

		// saving the property
		return propertyDao.save(property);

	}

	@Override
	public Iterable<Property> getProperties() {

		return propertyDao.findAll();
	}

	@Override
	public Property getProperty(int propertyID) {

		return propertyDao.findById(propertyID).get();
	}

	@Override
	public Iterable<Property> search(String str) {

		return propertyDao.findByNameContaining(str);
	}

	@Override
	public Iterable<Property> filterProperty(String city, Double price, Integer TypeID) {
		PropertyType type = null;
		type = propertyTypeDao.findById(TypeID).get();
		return propertyDao.findByCityAndPriceGreaterThanEqualAndType(city, price, type);
	}

	@Override
	public Property updateProperty(String userID, int propertyID, int propertyTypeID, Property property) {
		// getting and setting the propertyType
		PropertyType propertyType = propertyTypeDao.findById(propertyTypeID).get();
		property.setType(propertyType);

		// getting and setting the useremail
		User user = userDao.findByEmail(userID);
		property.setUser(user);

		// saving the property
		return propertyDao.save(property);

	}

}
