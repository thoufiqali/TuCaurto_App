package in.tucaurto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "properties")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proptery_id")
	private int id;

	@Column(name = "property_name")
	private String name;

	@Column(name = "property_desc")
	private String description;

	@Column(name = "property_address")
	private String address;

	@Column(name = "property_price")
	private Double price;

	@Column(name = "property_image")
	private String imageUrl;

	@Column(name = "property_city")
	private String city;

	@ManyToOne
	@JsonIgnore
	private PropertyType type;

	@ManyToOne
	@JsonIgnore
	private User user;

	@Override
	public String toString() {
		return "Property [id=" + id + ", name=" + name + ", description=" + description + ", address=" + address
				+ ", price=" + price + ", imageUrl=" + imageUrl + ", city=" + city + " ]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public PropertyType getType() {
		return type;
	}

	public void setType(PropertyType type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Property(int id, String name, String description, String address, Double price, String imageUrl, String city,
			PropertyType type, User user) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.address = address;
		this.price = price;
		this.imageUrl = imageUrl;
		this.city = city;
		this.type = type;
		this.user = user;
	}
	
	

}
