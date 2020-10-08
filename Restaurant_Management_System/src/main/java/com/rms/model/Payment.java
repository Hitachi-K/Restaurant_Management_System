package com.rms.model;

import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Payment")
public class Payment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
    @GenericGenerator(
        name = "payment_seq", 
        strategy = "com.rms.model.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PAY_")})
	@Column(name = "paymentID", updatable = false, nullable = false)
	private String paymentID;
	
	@Column(name = "Amount")
	private double amount;
	
	@Column(name = "Date_Time")
	private Timestamp paydate;
	
	//relation with Cashier table
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cashierID")
	private Cashier cashier;
	
	// Relation with Customer table
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerID")
	private Customer customer;
	
	// Relation with Reservation table
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reservationID")
	private Reservation reservation;
	
	// Relation with Order table
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderID")
	private Order order;
	
	//Default Constructor
	public Payment() {}

	// Overloaded Contructor
	public Payment(double amount, Timestamp paydate) {
		super();
		this.amount = amount;
		this.paydate = paydate;
	}

	// Getters and Setters
	
	
	public String getPaymentID() {
		return paymentID;
	}

	public Cashier getCashier() {
		return cashier;
	}

	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getPaydate() {
		return paydate;
	}

	public void setPaydate(Timestamp paydate) {
		this.paydate = paydate;
	}

}
