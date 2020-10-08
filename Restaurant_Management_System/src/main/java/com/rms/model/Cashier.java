package com.rms.model;

import java.util.ArrayList; 
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Cashier")
public class Cashier {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cashier_seq")
    @GenericGenerator(
        name = "cashier_seq", 
        strategy = "com.rms.model.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "CSH_")})
	@Column(name = "cashierID", updatable = false, nullable = false)
	private String cashierID;
	
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
	
	// relation with Payment table
	@OneToMany(mappedBy = "cashier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<Payment> payments = new ArrayList<>();
	
	//Default Constructor
	public Cashier() {}

	public String getCashierID() {
		return cashierID;
	}

	public void setCashierID(String cashierID) {
		this.cashierID = cashierID;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	// Overloaded Contructor
	public Cashier(String userName, String passWord, String firstName, String lastName, String phoneNo, String email,
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

	// Setters and Getters
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
