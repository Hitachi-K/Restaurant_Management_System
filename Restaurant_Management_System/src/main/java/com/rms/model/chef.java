package com.rms.model;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table (name = "Chef")
public class chef {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chef_seq")
    @GenericGenerator(
        name = "chef_seq", 
        strategy = "com.rms.model.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "CHF_")})
		@Column(name= "Chef_Id", updatable = false, nullable = false)
		private String chefId;
	
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
	
	// Relation with Order
	 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	 @JoinTable(name = "chef_Order",
	            joinColumns = {
	                    @JoinColumn(name = "chef_id", referencedColumnName = "Chef_Id",
	                              updatable = false)},
	            inverseJoinColumns = {
	                    @JoinColumn(name = "order_id", referencedColumnName = "orderID",
	                              updatable = false)})
	 private Set<Order> orders = new HashSet<>();
	
	//default constructor
	public chef() {}
		
	//overloaded constructor
	public chef(String userName, String passWord, String firstName, String lastName, String phoneNo, String email,
			String nic) {
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
    
	public String getChefId() {
		return chefId;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public void setChefId(String chefId) {
		this.chefId = chefId;
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
