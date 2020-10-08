package com.rms.model;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.*;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @GenericGenerator(
        name = "order_seq", 
        strategy = "com.rms.model.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ORD_")})
	@Column(name = "orderID", updatable = false, nullable = false)
	private String orderID;
	
	@Column(name = "status")
	private String status;
	
	// Relation with Payment table
	@OneToOne(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Payment payment;
	
	// Relation with Customer table
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerID")
	private Customer customer;
	
	// Relation with Chef
	@ManyToMany(mappedBy = "orders", fetch = FetchType.LAZY)
	private Set<chef> chefs = new HashSet<>();
	
	// Relation with the Assocation table
	@OneToMany(mappedBy = "order")
	private Set<Order_Item> orderItem = new HashSet<>();
	
	//Default Constructor
    public Order() {}

    //Overloaded Constructor
	public Order(String status) {
		super();
		this.status = status;
	}

	// Getters and Setters
	
	public String getOrderID() {
		return orderID;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<chef> getChefs() {
		return chefs;
	}

	public void setChefs(Set<chef> chefs) {
		this.chefs = chefs;
	}


	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
    
}
