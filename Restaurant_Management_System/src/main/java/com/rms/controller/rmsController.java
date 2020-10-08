package com.rms.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rms.model.*;
import com.rms.repository.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class rmsController {

////////////////////////////////////////// FOOD ITEMS /////////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	foodItemRepository foodItemRepo;
	
	//retrieve all the items from the table
	@GetMapping("/retrieveItems")
	public List<foodItem> getAllItems() {
		List<foodItem> fI = new ArrayList<>();
		foodItemRepo.findAll().forEach(fI::add);
		return fI;
	}
	
	//add items to the table
	@PostMapping("/addItems")
	public void addItem(@RequestBody foodItem foodItem) {
		foodItemRepo.save(foodItem);
	}
	
	//updates item by Item ID
	@PutMapping("/updateItem/{itemID}") 
	public void updateFoodItemByItemId(@PathVariable Long itemID, @RequestBody foodItem foodItem) {
		foodItemRepo.save(foodItem); 
	} 
	
	//retrieve item by name
	@GetMapping("/retrieveItems/{itemName}")
	public Optional<foodItem> getFoodItemByName(@PathVariable String itemName){
		return foodItemRepo.getFoodItemByItemName(itemName); 
	} 
	
	//delete food item by item ID
	@DeleteMapping("/deleteItem/{itemName}")  
	public void deleteFoodItembyItemID(@PathVariable String itemName) {
		foodItemRepo.deleteFoodItemByItemName(itemName);
	} 
	
/////////////////////////////////////////////// CHEF ////////////////////////////////////////////////////////////////////////////////////////////////////

	@Autowired
	chefRepository chefRepo;
	//retrieve all the items from the table
		@GetMapping("/retrieveEmployee/chef")
		public List<chef> getAllChefs() {
			List<chef> fI = new ArrayList<>();
			chefRepo.findAll().forEach(fI::add);
			return fI;
		}
	
	//add chef to the db
	@PostMapping("/addEmployee/chef")
	public void addChef(@RequestBody chef chef) {
		chefRepo.save(chef);
	}
	
	//retrieve employee last name
	@GetMapping("/retrieveEmployee/chef/{chefId}")
	public Optional<chef> getChefById(@PathVariable Long chefId) { 
		return chefRepo.findById(chefId);
	}
	
	//update employee chef by id
	@PutMapping("/updateEmployeeChef/{chefId}")
	public void updateChefbyChefId(@RequestBody chef chef, @PathVariable Long chefId) {
		 chefRepo.save(chef);
	}
	
	@DeleteMapping("/deleteEmployee/chef/{chefId}")
	public void deleteChefById(@PathVariable Long chefId) {
		chefRepo.deleteById(chefId);
	}
	
//////////////////////////////////////////// CUSTOMER ////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	customerRepository customerRepo;
	
	//add customer to the database
	@PostMapping("/addCustomer")
	public void addCustomer(@RequestBody Customer Customer) {
		customerRepo.save(Customer);
	}
	
	//updates customer details by ID
	@PutMapping("/updateCustomer/{customerID}")
	public void updateCustomerByCustomerId(@RequestBody Customer Customer, @PathVariable Long customerID) {
		customerRepo.save(Customer);
	}
	
	//Retrieve all the customers
	@GetMapping("/retrieveCustomers")
	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		customerRepo.findAll().forEach(customers::add);
		return customers;
	}
	
	//Retrieve Customers by type
	@GetMapping("/retrieveCustomer/{type}")
	public Optional<Customer> getCustomerByType(@PathVariable String type){
		return customerRepo.getCustomerByType(type); 
	}
	
	//Delete Customer by ID
	@DeleteMapping("/deleteCustomer/{customerID}")
	public void deleteCustomerByCustomerID(@PathVariable Long customerID) {
		customerRepo.deleteById(customerID);
	}
	
//////////////////////////////////////////// REVIEWS ///////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	reviewRepository reviewRepo;
	
	//add reviews to the database by customer and item id
	@PostMapping("/addReview")
	public void addReview(@RequestBody review review) {
		reviewRepo.save(review);
	} 
	
	//Updates review by review ID
	@PutMapping("/updateReview/{reviewID}")
	public void updateReviewByReviewID(@RequestBody review review, @PathVariable Long reviewID) {
		reviewRepo.save(review);
	}
	
	//retrieves all the reviews
	@GetMapping("/retrieveReviews")
	public List<review> getAllReviews() {
		List<review> reviews = new ArrayList<>();
		reviewRepo.findAll().forEach(reviews::add);
		return reviews;
	} 
	
	// Deletes Review by ID
	@DeleteMapping("/deleteReview/{reviewID}")
	public void deleteReviewByReviewID(@PathVariable Long reviewID) {
		reviewRepo.deleteById(reviewID);
	}

///////////////////////////////////////////// RESERVATION //////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	reservationRepository reservationRepo;
	
	// Add a reservation by type
	@PostMapping("/addReservation")
	public void addReservation(@RequestBody Reservation reservation) {
		reservationRepo.save(reservation);
	}
	
	// Retrieves all the reservations
	@GetMapping("/retrieveReservations")
	public List<Reservation> getAllReservations() {
		List<Reservation> reservations = new ArrayList<>();
		reservationRepo.findAll().forEach(reservations::add);
		return reservations;
	} 
	
	// Retrieves reservation by type
	@GetMapping("/retrieveReservation/{type}")
	public Optional<Reservation> getReservationByType(@PathVariable String type){
		return reservationRepo.getReservationByType(type);  
	} 
	
	//deletes reservation by reservation id
	@DeleteMapping("/deleteReservation/{reservationID}")
	public void deleteReservationByReservationID(@PathVariable Long reservationID) {
		reservationRepo.deleteById(reservationID);
	}

///////////////////////////////////////////// CASHIER //////////////////////////////////////////////////////////////////////////////////////////////////////
 
	@Autowired
	cashierRepository cashierRepo;
	
	//retrieve all the items from the table
	@GetMapping("/retrieveEmployee/Cashier")
	public List<Cashier> getAllCashiers() {
		List<Cashier> fI = new ArrayList<>();
		cashierRepo.findAll().forEach(fI::add);
		return fI;
	}

	
	//add chef to the db
	@PostMapping("/addEmployee/cashier")
	public void addChef(@RequestBody Cashier Cashier) {
		cashierRepo.save(Cashier);
	}
	
//////////////////////////////////////////// RESTAURANT MANAGER ////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Autowired
	restaurantManagerRepository restManagerRepo;
	
	//retrieve all the items from the table
			@GetMapping("/retrieveEmployee/RestaurantManager")
			public List<RestaurantManager> getAllRestaurantManagers() {
				List<RestaurantManager> fI = new ArrayList<>();
				restManagerRepo.findAll().forEach(fI::add);
				return fI;
			}
			
	@PostMapping("/addEmployee/RestaurantManager")
	public void addRestaurantManager(@RequestBody RestaurantManager RestaurantManager) {
		restManagerRepo.save(RestaurantManager);
	}
	
//////////////////////////////////////////// INVENTORY MANAGER ///////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	inventoryManagerRepository invManagerRepo;
	
	//retrieve all the items from the table
	@GetMapping("/retrieveEmployee/InventoryManager")
	public List<InventoryManager> getAllInventoryManagers() {
		List<InventoryManager> fI = new ArrayList<>();
		invManagerRepo.findAll().forEach(fI::add);
		return fI;
	}
	
	@PostMapping("/addEmployee/InventoryManager")
	public void addInventoryManager(@RequestBody InventoryManager InventoryManager) {
		invManagerRepo.save(InventoryManager);
	}
	
	@DeleteMapping("/deleteEmployee/InventoryManager/{inventoryManagerID}")
	public void deleteInventoryManager(@PathVariable Long inventoryManagerID) {
		invManagerRepo.deleteById(inventoryManagerID);
	}

//////////////////////////////////////////// PAYMENT ////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	paymentRepository paymentRepo;
	@PostMapping("/addPayment")
	public void addPayment(@RequestBody Payment Payment) {
		paymentRepo.save(Payment);
	}
	
//////////////////////////////////////////// DOCUMENTATION ///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	documentationRepository docRepo;
	@PostMapping("/addDoc/{type}")
	public void addDocument(@RequestBody Documentation Documentation, @PathVariable String type) {
		docRepo.save(Documentation);
	}

///////////////////////////////////////////// REPORT //////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	reportRepository reportRepo;
	@PostMapping("/addReport")
	public void addReport(@RequestBody Report Report) {
		reportRepo.save(Report);
	}

///////////////////////////////////////////// INVOICE ////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	invoiceRepository invoiceRepo;
	@PostMapping("/addInvoice")
	public void addInvoice(@RequestBody Invoice Invoice) {
		invoiceRepo.save(Invoice);
	}
	
///////////////////////////////////////////// INGREDIENTS ////////////////////////////////////////////////////////////////////////////////////////////////

	@Autowired
	ingredientRepository ingRepo;
	@PostMapping("/addIngredients")
	public void addIngredient(@RequestBody Ingredient Ingredient) {
		ingRepo.save(Ingredient);
	}
	
	@GetMapping("/retrieveIngredients")
	public List<Ingredient> getAllIngredients() {
		List<Ingredient> ingredients = new ArrayList<>();
		ingRepo.findAll().forEach(ingredients::add);
		return ingredients;
	} 
	
	@DeleteMapping("deleteIngredients/{ingredientID}")
	public void deleteIngredientByID(@PathVariable Long ingredientID) {
		ingRepo.deleteById(ingredientID);
	}

///////////////////////////////////////////// ORDER //////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	orderRepository orderRepo;
	@PostMapping("/addOrder")
	public void addOrder(@RequestBody Order Order) {
		orderRepo.save(Order);
	}
} 
