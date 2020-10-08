package com.rms.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Restaurant_Manager")
public class RestaurantManager {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resManager_seq")
    @GenericGenerator(
        name = "resManager_seq", 
        strategy = "com.rms.model.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ResM_")})
	@Column(name = "restaurantManagerID", updatable = false, nullable = false)
	private String restaurantManagerID;
	
	@Column(name = "user_name")
	private String userName;

	@Column(name = "pass_word")
	private String passWord;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;

	@Column(name = "phoneNo")
	private String phoneNo;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "nic")
	private String nic;
	
	// Relation with Documentation
	@OneToMany(mappedBy = "restaurantManager", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<Documentation> docs = new ArrayList<>(); 
	
	// Default Constructor
	public RestaurantManager () {}
	
	// Overloaded Constructor
	public RestaurantManager(String userName, String passWord, String firstName, String lastName, String phoneNo,
			String email, String nic) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.email = email;
		this.nic = nic;
	}
	
	//Getters and Setters
    
	public String getRestaurantManagerID() {
		return restaurantManagerID;
	}

	public List<Documentation> getDocs() {
		return docs;
	}

	public void setDocs(List<Documentation> docs) {
		this.docs = docs;
	}

	public void setRestaurantManagerID(String restaurantManagerID) {
		this.restaurantManagerID = restaurantManagerID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}
	

}
