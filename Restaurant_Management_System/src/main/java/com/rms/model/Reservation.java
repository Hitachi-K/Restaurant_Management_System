package com.rms.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "Reservation")
public class Reservation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reserve_seq")
    @GenericGenerator(
        name = "reserve_seq", 
        strategy = "com.rms.model.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "RES_")})
	@Column(name = "reservationID", updatable = false, nullable = false)
	private String reservationID;
	
	@Column(name = "Customer Name")
	private String customerName;
	
	@Column(name = "Time")
	private Time reservationTime;

	@Column(name = "Date")
	private Date date;
	
	@Column(name = "No_of_People")
	private int noOfPeople;
	
	@Column(name = "Hall_no")
	private int hallNo;
	
	@Column(name = "Table_no")
	private int tableNo;
	
	@Column(name = "Event_package")
	private String ePackage;
	
	@Column(name = "Reservation_Type")
	private String type;
	
	// Relation with Customer table
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerID")
	private Customer customer;
	
	// Relation with the Payment
	@OneToOne(mappedBy = "reservation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Payment payment;

	// Default Consrtructor
	public Reservation() {}
	
	// Overloaded Constructor
	public Reservation(Date date, int noOfPeople, int hallNo, int tableNo, String ePackage, String type, String customerName, Time reservationTime) {
		super();
		this.date = date;
		this.noOfPeople = noOfPeople;
		this.hallNo = hallNo;
		this.tableNo = tableNo;
		this.ePackage = ePackage;
		this.type = type;
		this.customerName = customerName;
		this.reservationTime = reservationTime;
	}

	// Getters and Setters
	
	public Time getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(Time reservationTime) {
		this.reservationTime = reservationTime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public int getTableNo() {
		return tableNo;
	}

	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}

	public String getReservationID() {
		return reservationID;
	}


	public int getHallNo() {
		return hallNo;
	}

	public void setHallNo(int hallNo) {
		this.hallNo = hallNo;
	}

	public String getePackage() {
		return ePackage;
	}

	public void setePackage(String ePackage) {
		this.ePackage = ePackage;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNoOfPeople() {
		return noOfPeople;
	}

	public void setNoOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
