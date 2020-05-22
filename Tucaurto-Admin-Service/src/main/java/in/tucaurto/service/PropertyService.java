package in.tucaurto.service;

import java.util.List;

import in.tucaurto.entity.Property;

public interface PropertyService 
{
	public List<Property> findAll();
	public String deleteByPropertyId(long id);
	public Long getCount();
}