package com.rms.model;

import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Documentation")
public class Documentation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_seq")
    @GenericGenerator(
        name = "document_seq", 
        strategy = "com.rms.model.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "DOC_")})
	@Column(name = "documentationID", updatable = false, nullable = false)
	private String documentationID;
	
    @Column(name = "Date_Time")
    private Timestamp docDate;
    
    @Column(name = "Type")
    private String type;
    
  //relation with Restaurant Manager table
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "resManagerID")
  private RestaurantManager restaurantManager;

    // Default Constructor
    public Documentation() {}
    
    // Overloaded constructor
	public Documentation(Timestamp docDate, String type) {
		super();
		this.docDate = docDate;
		this.type = type;
	}

	//getters amd setters
	
	public Timestamp getDocDate() {
		return docDate;
	}

	public String getDocumentationID() {
		return documentationID;
	}

	public void setDocumentationID(String documentationID) {
		this.documentationID = documentationID;
	}

	public RestaurantManager getRestaurantManager() {
		return restaurantManager;
	}

	public void setRestaurantManager(RestaurantManager restaurantManager) {
		this.restaurantManager = restaurantManager;
	}

	public void setDocDate(Timestamp docDate) {
		this.docDate = docDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

    
}
