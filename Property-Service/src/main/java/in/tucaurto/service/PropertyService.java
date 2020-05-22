package in.tucaurto.service;


import in.tucaurto.entity.Property;

public interface PropertyService {
	
	public Property saveProperty(String userID,Integer propertyTypeID,Property property);
	
	public Iterable<Property> getProperties();
	
	public Property getProperty(int propertyID);
	
	public Iterable<Property> search(String str);
	
	public Iterable<Property> filterProperty(String city, Double price,Integer TypeID);
	
	public Property updateProperty( String userID, int propertyID,  int propertyTypeID,Property property);
}
