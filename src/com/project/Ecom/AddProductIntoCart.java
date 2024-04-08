package com.project.Ecom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

	
	
	public class AddProductIntoCart {
		public static void addProductsIntoCart(int ProductID, int Quantity){
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_shopping", "root" , "root@1234");
				
				String sql = "insert into cart(ProductID , Quantity )" + "values(? , ? )";
				
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				
				preparedStatement.setInt(1, ProductID);
				
				preparedStatement.setInt(2, Quantity);
				
				preparedStatement.execute();	
				
				System.out.println("Products Added In The Cart Successfully..");
				
				connection.close();
				preparedStatement.close();
		}

			catch(ClassNotFoundException e) {
			e.printStackTrace();	
			
			}
			
			catch(SQLException e ) {
			e.printStackTrace();	
				
			}
			
			
			}
		
		public static void main(String[] args) {
			
			Scanner input = new Scanner(System.in);
			
			for (int i = 1; i<=2; i++) {
				
				System.out.println("Please Enter ProductID ");
				
				int ProductID = input.nextInt();
				
				System.out.println("Please Enter Quantity");
				int Quantity = input.nextInt();
				
				addProductsIntoCart(ProductID, Quantity);
				
			}
			

		}

	}

	
	
	
	


