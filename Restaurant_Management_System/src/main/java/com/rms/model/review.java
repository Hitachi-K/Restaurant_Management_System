package com.rms.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Review")
public class review {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_seq")
    @GenericGenerator(
        name = "review_seq", 
        strategy = "com.rms.model.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "REV_")})
	@Column(name = "reviewID", updatable = false, nullable = false)
	private String reviewID;
	
	@Column(name = "Comment")
	private String comment;
	
	//relation with Customer table
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerID")
	private Customer customer;
	
	//relation with Item table
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "itemID")
	private foodItem item;
	
	//default contructor
	public review() {}

	
	// Overloaded Constructor
	public review(String comment) {
		super();
		this.comment = comment;
	}

	
	//Getters and Setters

	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public foodItem getItem() {
		return item;
	}


	public void setItem(foodItem item) {
		this.item = item;
	}


	public String getReviewID() {
		return reviewID;
	}

	public void setReviewID(String reviewID) {
		this.reviewID = reviewID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
