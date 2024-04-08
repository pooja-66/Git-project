package com.project.Ecom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

	public class InsertUserDataForUserLogin {

		public static void insertIntoUsers(String FirstName, String LastName, String UserName, String Password, String City,
				String EmailID, String MobileNumber) {

			try {

				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_shopping", "root","root@1234");

				String sql = "insert into users(FirstName, LastName, UserName, Password, City, EmailID, MobileNumber)"
						+ "values (?,?,?,?,?,?,?)";

				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				preparedStatement.setString(1, "FirstName");
				preparedStatement.setString(2, "LastName");
				preparedStatement.setString(3, "UserName");
				preparedStatement.setString(4, "Password");
				preparedStatement.setString(5, "City");
				preparedStatement.setString(6, "EmailID");
				preparedStatement.setString(7, "MobileNumber");

				preparedStatement.execute();

				System.out.println(" Records Insert Successfully..");

				connection.close();
				preparedStatement.close();

			}

			catch (ClassNotFoundException e) {

				e.printStackTrace();
			} 
			
			catch (SQLException e) {

				e.printStackTrace();
			}

		}

		public static void main(String[] args) {

			Scanner input = new Scanner(System.in);

			for (int i = 1; i <= 7; i++) {

				System.out.println("Please Enter Your First Name ");
				String FirstName = input.next();

				System.out.println("Please Enter Your Last Name ");
				String LastName = input.next();

				System.out.println("Please Enter Your User Name ");
				String UserName = input.next();

				System.out.println("Please Enter Your Password ");
				String Password = input.next();

				System.out.println("Please Enter Your City ");
				String City = input.next();

				System.out.println("Please Enter Your EmailID ");
				String EmailID = input.next();

				System.out.println("Please Enter Your Mobile Number ");
				String MobileNumber = input.next();

				insertIntoUsers(FirstName, LastName, UserName, Password, City, EmailID, MobileNumber);

			}

		}

	}

	
	
	
	


