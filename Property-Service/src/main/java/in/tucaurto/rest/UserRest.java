package in.tucaurto.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.tucaurto.dao.PropertyDAO;
import in.tucaurto.dao.UserDAO;
import in.tucaurto.entity.Property;
import in.tucaurto.entity.User;
import in.tucaurto.service.UserService;

@RestController
@CrossOrigin("*")
public class UserRest {

	@Autowired
	private UserService userService;

	// method for user to get the properties he/she has posted
	@GetMapping("/myproperties/{userID}")
	public Iterable<Property> findmyProperties(@PathVariable String userID) {

		return userService.findMyProperties(userID);
	}

	// Method for user to get his profile
	@GetMapping("/myprofile/{userID}")
	public ResponseEntity<User> getMyProfile(@PathVariable String userID) {
		return ResponseEntity.ok().body(userService.getMyProfile(userID));
	}

	// method to delete a property
	@DeleteMapping("/myproperties/{userID}/{propertyID}")
	public ResponseEntity<HttpStatus> deleteProperty(@PathVariable String userID, @PathVariable int propertyID) {
		userService.deleteProperty(userID, propertyID);
		return ResponseEntity.ok().body(HttpStatus.OK);

	}

	// To make update method
	@PutMapping("/myprofile/{userID}")
	public ResponseEntity<User> updateProfile(@PathVariable String userID, @RequestBody User user) {
		return ResponseEntity.ok().body(userService.UpdateProfile(userID, user));
	}

}
