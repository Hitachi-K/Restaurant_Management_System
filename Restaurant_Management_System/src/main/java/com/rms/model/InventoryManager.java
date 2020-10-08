package com.rms.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Inventory_Manager")
public class InventoryManager {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invManager_seq")
    @GenericGenerator(
        name = "invManager_seq", 
        strategy = "com.rms.model.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "InvM_")})
	@Column(name = "inventoryManagerID", updatable = false, nullable = false)
	private String inventoryManagerID;
	
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
	
	// Relation with Inventory table
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "inventoryID")
	private Inventory inventory;
	
	// Default Constructor
	public InventoryManager() {}

	// Overloaded Constructor
	public InventoryManager(String userName, String passWord, String firstName, String lastName, String phoneNo,
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
	
	// Getters and Setters
	
	

	public String getInventoryManagerID() {
		return inventoryManagerID;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void setInventoryManagerID(String inventoryManagerID) {
		this.inventoryManagerID = inventoryManagerID;
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
