package in.tucaurto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.tucaurto.dao.SupportDAO;
import in.tucaurto.entity.CustomerSupport;

@Service
public class SupportServiceImpl implements SupportService 
{


	@Autowired
	private SupportDAO supportDao;
	
	public SupportServiceImpl(SupportDAO supportDao) {
		super();
		this.supportDao = supportDao;
	}
	

	@Override
	public String deleteByUsername(String username) {
		supportDao.deleteByUsername(username);
		return "Support role deleted!!";
	}

	@Override
	public List<CustomerSupport> findByNameContaining(String name) {

		return supportDao.findByNameContaining(name);
	}

	@Override
	public CustomerSupport findByContactNumber(long number) {
		
		return supportDao.findByContactNumber(number);
	}

	@Override
	public CustomerSupport findByUsername(String username) 
	{
		return supportDao.findByUsername(username);
	}

	@Override
	public List<CustomerSupport> findAll() {

		return supportDao.findAll();
	}

}
