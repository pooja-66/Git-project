package com.project.Ecom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

	

	public class Main1 
	{

		static Map<String, User> users = new HashMap<>();
		static List<Product> products = new ArrayList<>();
		private static List<User> registeredUsers = new ArrayList<>();
		
		
		static Scanner scanner = new Scanner(System.in);
		
		public static void main(String[] args) 
		{
	        

	        System.out.println("Welcome to E-Commerce based application");
	        System.out.println("Select an option:");
	        System.out.println("1. User Operation");
	        System.out.println("2. Admin Operation");
	        System.out.println("3. Guest Operation");
	        int operationChoice = scanner.nextInt();
	        
	        switch (operationChoice)
	        {
	            case 1:
	                userOperation(scanner);
	                break;
	            case 2:
	                adminOperation(scanner);
	                break;
	            case 3:
	                userOperation(scanner);
	                break;
	            default:
	                System.out.println("Invalid choice.");
	                break;
	        }

	        scanner.close();
	    }
	private static void userOperation(Scanner scanner) 
	{
	    System.out.println("User Operation");
	    System.out.println("1. User Registration");
	    System.out.println("2. User Login");
	    System.out.println("3. User view Product item as Sorted Order");
	    System.out.println("4. Buy Product");
	    System.out.println("5. View Cart");
	    System.out.println("6. Purchase the item");
	    int userChoice = scanner.nextInt();
	    
	    switch (userChoice) 
	    {
	        case 1:
	        	registerUser(scanner);
	            break;
	            
	        case 2:
	        	loginUser(scanner);
	            break;
	            
	        case 3:
	        	viewProducts();

	            break;
	        case 4:
	            buyProduct(scanner);
	            break;
	        case 5:
	        	viewCart(null);
	        	break;
	        case 6:
	            purchaseItems(null);
	            break;
	        default:
	            System.out.println("Invalid choice.");
	            break;
	    }
	}
	static void registerUser(Scanner scanner) 
		{
			System.out.println("User Login");

	       System.out.print("Enter username: ");
	       String username = scanner.next();

	       if (!username.contains(username))
	       {
	           System.out.println("User not found. Please login first.");
	  
	       }
	       User user = username.get(username);

	       System.out.print("Enter password: ");
	       String password = scanner.next();

	       if (!user.getPassword().equals(password)) 
	       {
	           System.out.println("Incorrect password. Please try again.");
	          
	       }

	       System.out.println("Login successful!");
		}
		 static void loginUser(Scanner scanner)
		{
			// TODO Auto-generated method stub
			System.out.println("User Registration");

	       System.out.print("Enter username: ");
	       String username = scanner.next();

	       if (username.contains(username)) 
	       {
	           System.out.println("Username already exists. Please choose another one.");
	           return;
	       }

	       System.out.print("Enter password: ");
	       String password = scanner.next();

	       User newUser = new User(username, password);
	       username.add(username, newUser);

	       System.out.println("User registered successfully!");	
		}
		 static void viewProducts()
		{
			// TODO Auto-generated method stub
			System.out.println("Viewing Products");

	       Collections.sort(products, Comparator.comparing(Product::getName));

	       System.out.println("Products:");

	       for (Product product : products) 
	       {
	           System.out.println(product.getName() + " - " + product.getPrice());
	       }
			
		}
		 static void buyProduct(Scanner scanner) 
		{
			viewProducts(); 

	       System.out.print("Enter the name of the product you want to buy: ");
	       String productName = scanner.next();

	    
	       Product productToBuy = null;
	       for (Product product : products) 
	       {
	           if (product.getName().equalsIgnoreCase(productName)) 
	           {
	               productToBuy = product;
	               break;
	           }
	       }
		}
		
		 static void viewCart(User user) 
		{
			System.out.println("Viewing Cart");

	       List<Product> cart = user.getCart();

	       if (cart.isEmpty()) {
	           System.out.println("Your cart is empty.");
	           return;
	       }

	       System.out.println("Cart Contents:");

	       for (Product product : cart) 
	       {
	           System.out.println(product.getName() + " - " + product.getPrice());
	       }
			
		}

		 static void purchaseItems(User user)
		{
			List<Product> cart = user.getCart();

	       if (cart.isEmpty()) 
	       {
	           System.out.println("Your cart is empty.");
	           return;
	       }

	       System.out.println("Purchasing Items:");

	       double totalPrice = 0;

	       for (Product product : cart) 
	       {
	           System.out.println(product.getName() + " - " + product.getPrice());
	           totalPrice += product.getPrice();
	       }
	       
	       System.out.println("Total Price: $" + totalPrice);

	       cart.clear();
	       System.out.println("Purchase successful. Your cart is now empty.");
	   }
		 private static void adminOperation(Scanner scanner)
		 {
		        System.out.println("Admin Operation");
		        System.out.println("7. Add product item");
		        System.out.println("8. Calculate Bill");
		        System.out.println("9. Display amount to End User");
		        System.out.println("10. Check Quantity");
		        System.out.println("11. Check registered user");
		        System.out.println("12. Check the particular user history");
		        int adminChoice = scanner.nextInt();
		        switch (adminChoice)
		        {
		            case 7:
		            	addProductItem(scanner);
		            	break;
		            case 8:
		            	calculateTotal();
		            	break;
		            case 9:
		            	displayAmount();
		            	break;
		            case 10:
		            	checkQuantity(adminChoice);
		            	break;
		            case 11:
		            	checkRegisteredUsers(null, null);
		            	break;
		            case 12:
		            	getPurchaseHistory();
		                break;
		            default:
		                System.out.println("Invalid choice.");
		                break;
		        }
		  }
		 
		 private static void addProductItem(Scanner scanner)
			 {
				 Product product=new Product(105, "128GB","iphone", 150000, 5);
					product.add(products);
					System.out.println("Product item added successfully: " + product);		
			}
		}
		
		private static double calculateTotal() 
		 {
			 double total = 0.0;
		        for (Product item : products)
		        {
		            total += item.getPrice();
		        }
		        return total;		
		}
		private static void displayAmount()
		{
			 int itemCount = scanner.nextInt();
			 for (int i = 0; i < itemCount; i++)
			 {
	            System.out.print("Enter item name: ");
	            String itemName = scanner.nextLine();
	            
	            System.out.print("Enter item price: ");
	            double itemPrice = scanner.nextDouble();
	            scanner.nextDouble();
	            
	            System.out.print("Enter item quantity: ");
	            int itemQuantity = scanner.nextInt();
	            scanner.nextInt();
	            
	        }
		}
		
		private static boolean checkQuantity(int amount)
		 {
			 if (amount <= this.quantity) 
			 {
		            this.quantity -= amount;
		            return true;
		      }
			 else 
			 {
		            return false;
		     }		
		}
		
		private static boolean checkRegisteredUsers(String username2, String password2)
		 {
			 registeredUsers.add(new User("user1", "password1"));
		     registeredUsers.add(new User("user2", "password2"));

		    
		        String username = "user1";
		        String password = "password1";

		        if (checkRegisteredUsers(username, password)) 
		        {
		            System.out.println("User is registered.");
		        }
		        else 
		        {
		            System.out.println("User is not registered.");
		        }
				return false;
		}

		 private static void getPurchaseHistory() 
			{
				 String username = "user1";
				 
				 if (users.containsKey(username)) 
				 {
			            User user = users.get(username);
			            Map<String, Integer> purchaseHistory = user.PurchaseHistory();
			            System.out.println("Purchase history for user " + username + ":");
			            for (Map.Entry<String, Integer> entry : purchaseHistory.entrySet())
			            {
			                System.out.println("Product: " + entry.getKey() + ", Quantity: " + entry.getValue());
			            }
			            
			        } 
				 else 
			        {
			            System.out.println("User not found.");
			        }
			    }
		 		private static void guestOperation(Scanner scanner)
		 		{
		        System.out.println("Guest Operation");
		        System.out.println("13. View product item");
		        System.out.println("14. Not purchase item");
		        int guestChoice = scanner.nextInt();

		        switch (guestChoice) 
		        {
		            case 13:
		            	 viewProduct(scanner);
		                break;
		            case 14:
		            	purchaseItem(null, guestChoice);
		                break;
		            default:
		                System.out.println("Invalid choice.");
		                break;
		        }
		 }

		  public static void viewProduct(Product product)
		  {
				System.out.println("Product: " + product.getName());
				System.out.println("Price: $" + product.getPrice());
				System.out.println("Description: " + product.getDescription());
				System.out.println();
		  }	
				    
		  private static void viewProduct(Scanner scanner2)
					
		  {
							
			  Product product1 = new Product(101,"High-performance laptop with SSD storage.","Laptop",150000,2);
					       
			  Product product2 = new Product(102, "Latest smartphone with 5G connectivity.","Smartphone",12000,9);
					        
			  Product product3 = new Product(103, "Wireless headphones with noise cancellation.","Headphones",5000,5);

					       
					       
			  viewProduct(product1);
					       
			  viewProduct(product2);
					       
			  viewProduct(product3);
					   
		  }
				    
		  private static void purchaseItem(String productName, int quantity)
			 		
		  {
			 			
			  for (Product product : products)
			 			{
			 	            if (product.getName().equals(productName)) 
			 	            {
			 	                System.out.println("Attempting to purchase " + quantity + " " + productName + "(s)");
			 	                product.reduceQuantity(quantity);
			 	                return;
			 	            }
			 	        }
			 	        System.out.println("Product " + productName + " not found.");
			 	    }	

			}	
	
	
	
	


