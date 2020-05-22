package in.tucaurto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.tucaurto.entity.Feedback;
@Repository
public interface FeedbackDAO extends JpaRepository<Feedback, Long>
{
	@Query("SELECT count(id) FROM Feedback")
	public long countProp();
	
}
