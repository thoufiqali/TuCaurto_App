package in.tucaurto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.tucaurto.dao.PropertyDAO;
import in.tucaurto.entity.Property;
@Service
public class PropertyServiceImpl implements PropertyService 
{
	@Autowired
	private PropertyDAO propertyDao;

	@Override
	public List<Property> findAll() {
		
		return propertyDao.findAll();
	}

	@Override
	public String deleteByPropertyId(long id) {
	
		propertyDao.deleteById(id);
		return "Property Deleted";
	}

	@Override
	public Long getCount() {
		
		return propertyDao.countProp();
	}

}