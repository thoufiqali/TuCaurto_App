package in.tucaurto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.tucaurto.entity.Property;

@Repository
public interface PropertyDAO extends JpaRepository<Property, Long>
{
	@Query("SELECT count(proptery_id) FROM Property")
	public long countProp();
}