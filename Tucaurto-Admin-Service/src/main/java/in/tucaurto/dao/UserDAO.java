package in.tucaurto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import in.tucaurto.entity.User;
@Repository
@EnableTransactionManagement
public interface UserDAO extends JpaRepository<User, String> 
{
	@Query("SELECT count(email) FROM User")
	public long countProp();
	public User findByEmail(String email);
	
}
