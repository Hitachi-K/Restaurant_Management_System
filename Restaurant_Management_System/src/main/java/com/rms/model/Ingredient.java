package com.rms.model;
import java.sql.Date;
import java.sql.Timestamp; 
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "ingredients")
public class Ingredient {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_seq")
    @GenericGenerator(
        name = "ingredient_seq", 
        strategy = "com.rms.model.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ING_")})
	@Column(name = "ingredientID", updatable = false, nullable = false)
	private String ingredientID;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "stock_level")
	private int stockLevel;
	
	@Column(name = "reorder_level")
	private int reorderLevel;
	
	@Column(name = "purchase_date")
	private Date purchaseDate;
	
	@Column(name = "expiry_date")
	private Date expiryDate;
	
	//relation with Inventory table
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "inventoryID")
	private Inventory inventory;
	
	// Relation with Food Item table
	@ManyToMany(mappedBy = "ingredients", fetch = FetchType.LAZY)
	private Set<foodItem> items = new HashSet<>();
	
	// Default constructor
	public Ingredient() {}

	// Overloaded Constructor
	public Ingredient(String name, int stockLevel, int reorderLevel, Date purchaseDate, Date expiryDate) {
		super();
		this.name = name;
		this.stockLevel = stockLevel;
		this.reorderLevel = reorderLevel;
		this.purchaseDate = purchaseDate;
		this.expiryDate = expiryDate;
	}

	// Getters and Setters
	
	public String getIngredientID() {
		return ingredientID;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Set<foodItem> getItems() {
		return items;
	}

	public void setItems(Set<foodItem> items) {
		this.items = items;
	}

	public void setIngredientID(String ingredientID) {
		this.ingredientID = ingredientID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStockLevel() {
		return stockLevel;
	}

	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}

	public int getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
}
