package com.rms.model;

import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Report")
public class Report {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_seq")
    @GenericGenerator(
        name = "document_seq", 
        strategy = "com.rms.model.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "DOC_")})
	private String reportID;
	
	@Column(name = "Date_Time")
	private Timestamp date;
	
	@Column(name = "Type")
	private String type;
	
	//Default Constructor
	public Report() {}

	// Overloaded Constructor
	public Report(Timestamp date, String type) {
		super();
		this.date = date;
		this.type = type;
	}

	//getters and setters
	
	
	public String getReportID() {
		return reportID;
	}

	public void setReportID(String reportID) {
		this.reportID = reportID;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
}
