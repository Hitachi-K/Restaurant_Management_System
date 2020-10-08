package com.rms.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="items")
public class foodItem{
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_seq")
    @GenericGenerator(
        name = "food_seq", 
        strategy = "com.rms.model.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ITM_")})
	@Column(name= "itemID", updatable = false, nullable = false)
	private String itemID;
	
	@Column(name = "Item_Name") 
	private String itemName;
	
	@Column(name = "Price")
	private double price;
	
	@Column(name = "Recipe")
	private String recipe;
	
	/*@Lob
	@Column(name = "Image")
	private byte[] image;*/
	
	@Column(name = "Type")
	private String type;
	
	// relation with review table
	@OneToMany(mappedBy = "item", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<review> reviews = new ArrayList<>();
	
	// Relation with Association table
	@OneToMany(mappedBy = "item")
	private Set<Order_Item> orderItem = new HashSet<>();
	
	//Relation with Ingredients
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	 @JoinTable(name = "foodItem_Ingredient",
	            joinColumns = {
	                    @JoinColumn(name = "item_id", referencedColumnName = "itemID",
	                              updatable = false)},
	            inverseJoinColumns = {
	                    @JoinColumn(name = "ingredient_id", referencedColumnName = "ingredientID",
	                              updatable = false)})
	 private Set<Ingredient> ingredients = new HashSet<>();
	
	public foodItem() {} //default constructor

	// overloaded constructor
	public foodItem(String itemName, double price, String recipe, String type) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.recipe = recipe;
		this.type = type;
	}

	// getters and setters
	
	public String getItemID() {
		return itemID;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}


	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<review> getReviews() {
		return reviews;
	}

	public void setReviews(List<review> reviews) {
		this.reviews = reviews;
	}
	
}

