package in.tucaurto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.tucaurto.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, String>
{
	User findByEmail(String email);
}
