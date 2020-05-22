package in.tucaurto.entity;

import javax.persistence.Column;

public class UserDTO 
{
private String name;
	
	@Column(unique = true)
	private String email;
	
	private String gender;
	private String city;
	private String state;
	
	
	private long contactNumber;
	
	private String address;
	private long pincode;
	private String imageUrl;
	
	public UserLogin getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}
	private UserLogin userLogin;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public UserDTO(String name, String email, String gender, String city, String state, long contactNumber,
			String address, long pincode, String imageUrl) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.city = city;
		this.state = state;
		this.contactNumber = contactNumber;
		this.address = address;
		this.pincode = pincode;
		this.imageUrl = imageUrl;
		
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
