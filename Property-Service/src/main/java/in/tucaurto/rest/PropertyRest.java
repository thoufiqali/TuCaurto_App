package in.tucaurto.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.tucaurto.dao.PropertyDAO;
import in.tucaurto.dao.PropertyTypeDAO;
import in.tucaurto.dao.UserDAO;
import in.tucaurto.entity.Property;
import in.tucaurto.entity.PropertyType;
import in.tucaurto.entity.User;
import in.tucaurto.service.PropertyService;

@RestController
@CrossOrigin("http://localhost:4200")
public class PropertyRest {

	@Autowired
	private PropertyService propertyService;

	@PostMapping(value = "/properties/{userID}/{propertyTypeID}")
	public ResponseEntity<Property> saveProperty(@PathVariable String userID, @PathVariable int propertyTypeID,
			@RequestBody Property property) {
		return ResponseEntity.ok().body(propertyService.saveProperty(userID, propertyTypeID, property));
	}

	@GetMapping("/properties")
	public ResponseEntity<Iterable<Property>> getProperties() {

		return ResponseEntity.ok().body(propertyService.getProperties());
	}


	@GetMapping("/properties/{propertyID}")
	public ResponseEntity<Property> getProperty(@PathVariable int propertyID) {
		return ResponseEntity.ok().body(propertyService.getProperty(propertyID));
	}
	
	@GetMapping("/searchproperties")
	public ResponseEntity<Iterable<Property>> search(@RequestParam("str" )String str){
		return ResponseEntity.ok().body(propertyService.search(str));
	}
	

	@GetMapping("/properties/filter")
	public Iterable<Property> getFilteredProperty(@RequestParam(required = false) String city, @RequestParam(required = false) Double price,@RequestParam(required = false )Integer  typeID){
	
		return propertyService.filterProperty(city, price, typeID);
		
	}

	@PutMapping("properties/{userID}/{propertyID}/{propertyTypeID}")
	public ResponseEntity<Property> updateProperty(@PathVariable String userID,@PathVariable int propertyID, @PathVariable int propertyTypeID,@RequestBody Property property){
		 //returning back the property in response entity
		 return ResponseEntity.ok().body(propertyService.updateProperty(userID, propertyID, propertyTypeID, property));
		
	}



}
