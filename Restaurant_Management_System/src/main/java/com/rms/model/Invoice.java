package com.rms.model;
import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Invoice")
public class Invoice {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_seq")
    @GenericGenerator(
        name = "document_seq", 
        strategy = "com.rms.model.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "DOC_")})
	@Column(name = "invoiceID", updatable = false, nullable = false)
	private String invoiceID;
	
	@Column(name = "Date_Time")
	private Timestamp date;
	
	// Default constructor
	public Invoice() {}

	// Overloaded Constructor
	
	public Invoice(Timestamp date) {
		super();
		this.date = date;
	}
	
	// Getters and setters
	public String getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(String invoiceID) {
		this.invoiceID = invoiceID;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}	
	
}
