package in.tucaurto.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User 
{
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long id;
	private String email;
	private String name;
	
	
	
	private String gender;
	private String city;
	private String state;
	
	
	private long contactNumber;
	
	private String address;
	private long pincode;
	private String imageUrl;
	
	@OneToOne(fetch = FetchType.LAZY,cascade= CascadeType.ALL)
	@JoinColumn(name="userlogin_id")
	private UserLogin userLogin;
	
	
	public UserLogin getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public User(String name, String email, long contactNumber) {
		super();
		this.name = name;
		this.email = email;
		this.contactNumber = contactNumber;
	}
	public User() {
		super();
	}
	
	
	
	
}
