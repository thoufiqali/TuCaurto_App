package in.tucaurto.service;

import java.util.List;

import in.tucaurto.entity.CustomerSupport;

public interface SupportService 
{
	public List<CustomerSupport> findAll();
	public String deleteByUsername(String username);
	public List<CustomerSupport> findByNameContaining(String name);
	public CustomerSupport findByContactNumber(long number);
	public CustomerSupport findByUsername(String username);
}
