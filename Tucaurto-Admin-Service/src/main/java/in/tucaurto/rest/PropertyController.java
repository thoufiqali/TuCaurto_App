package in.tucaurto.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.tucaurto.entity.Property;
import in.tucaurto.service.PropertyService;
@CrossOrigin("*")
@RestController
@RequestMapping("/property-api")
public class PropertyController 
{
	@Autowired
	private PropertyService propertyService;
	
	public PropertyController(PropertyService propertyService) {
		super();
		this.propertyService = propertyService;
	}

	@DeleteMapping("/properties/{propertyId}")
	public ResponseEntity<String> deleteProperty(@PathVariable(name="propertyId") Long id)
	{
		
		return ResponseEntity.ok().body(propertyService.deleteByPropertyId(id));
	}
	
	@GetMapping("/properties")
	public Iterable<Property> listProperties()
	{
		return propertyService.findAll();
		
	}
	
	@GetMapping("/properties/getcount")
	public Long getCount()
	{
		return propertyService.getCount();
	}
}