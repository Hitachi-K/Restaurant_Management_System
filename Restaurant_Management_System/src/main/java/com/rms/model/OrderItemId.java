package com.rms.model;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Embeddable
public class OrderItemId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	// primary keys of the tables Order and foodItem
	private String orderID;
	private String itemID;
	
	// Default Constructors
	public OrderItemId() {}
	
	// Overloaded Constructor
	public OrderItemId(String orderID, String itemID) {
		super();
		this.orderID = orderID;
		this.itemID = itemID;
	}

	// Getters and Setters
	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	
	 @Override
	 public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result
	                + ((orderID == null) ? 0 : orderID.hashCode());
	        result = prime * result
	                + ((itemID == null) ? 0 : itemID.hashCode());
	        return result;
	 }
	 
	 @Override
	 public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        OrderItemId other = (OrderItemId) obj; 
	        return Objects.equals(getOrderID(), other.getOrderID()) && Objects.equals(getItemID(), other.getItemID());
	 }

}
