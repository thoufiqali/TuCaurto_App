package in.tucaurto.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.tucaurto.dao.FeedbackDAO;
import in.tucaurto.entity.Feedback;

@RestController
@CrossOrigin("*")
public class FeedbackController 
{
	@Autowired
	private FeedbackDAO feedbackDao;

	public FeedbackController(FeedbackDAO feedbackDao) {
		super();
		this.feedbackDao = feedbackDao;
	}
	
	@PostMapping("/feedback")
	public ResponseEntity<String> createFeedback(@RequestBody Feedback feedback)
	{
		feedbackDao.save(feedback);
		return ResponseEntity.ok("Feedback recorded!! Thanks for contacting us.");
	}
	
	@GetMapping("/feedback")
	public ResponseEntity<List<Feedback>> listAll()
	{
		return ResponseEntity.ok().body(feedbackDao.findAll());
	}
	
	@DeleteMapping("/feedback")
	public ResponseEntity<?> deleteFeedback(@RequestParam Long id)
	{
		feedbackDao.deleteById(id);
		return ResponseEntity.ok("Feedback resolved!!");
	}
	
	@GetMapping("/feedbackcount")
	public ResponseEntity<?> getCount()
	{
		return ResponseEntity.ok().body(feedbackDao.countProp());
	}
}
