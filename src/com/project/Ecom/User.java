package com.project.Ecom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

	public class User {

	    private String username;
	    private String password;
	    private List<Product> cart;
	    private Map<String, Integer> purchaseHistory;

	    public User(String username, String password) {
	        this.username = username;
	        this.password = password;
	        this.cart = new ArrayList<>();
	    }

	    public String getUsername() {
	        return username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public List<Product> getCart() {
	        return cart;
	    }

	    public void addToCart(Product product) {
	        cart.add(product);
	    }

		public Map<String, Integer> PurchaseHistory()
		{
			return purchaseHistory;
		}
	    
	   

	}
	
	
	
	
	

