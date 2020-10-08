package com.rms.model; 
import javax.persistence.*;

@Entity
@Table(name = "Order_Item")
public class Order_Item {
	
	@EmbeddedId
	private OrderItemId orderItemId = new OrderItemId();

	@ManyToOne
	@MapsId("orderID")
	Order order;
	
	@ManyToOne
	@MapsId("itemID")
	foodItem item;
	
	@Column(name = "quantity")
	private int quantity;

	// Getters and Setters
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public foodItem getItem() {
		return item;
	}

	public void setItem(foodItem item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
