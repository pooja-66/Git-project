package com.project.Ecom;
import java.util.List;
import java.util.Scanner;

class Product 
	{
		private int id;
		private String description;
	    private String name;
	    private double price;
	    private int quantity;

	    public Product(int id,String description,String name, double price,int quantity) 
	    {
	    	this.id=id;
	    	this.description=description;
	        this.name = name;
	        this.price = price;
	        this.quantity=quantity;
	    }
	   
		public int getId()
	    {
	    	return id;
	    }
	    public String  getDescription()
	    {
	    	return description;
	    }
	    public String getName() 
	    {
	        return name;
	    }

	    public double getPrice()
	    {
	        return price;
	    }
	    public int quantity()
	    {
	    	return quantity;
	    }

		public void reduceQuantity(int amount)
		{
			if (amount <= quantity)
			{
	            quantity -= amount;
	        } 
			else
			{
	            System.out.println("Not enough quantity available for " + name);
	        }
	    }		
	}


