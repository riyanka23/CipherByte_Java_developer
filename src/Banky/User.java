package Banky;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User 
{
	public static final String RED = "\u001B[31m";
	public static final String RESET = "\u001B[0m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String Cyan = "\u001B[36m";
	
	private Connection con;
	private Scanner sc;
	
	public User(Connection con, Scanner sc) {
		super();
		this.con = con;
		this.sc = sc;
	}



	public void register()
	{
		sc.nextLine();
		System.out.println("Full Name :");
		String full_name= sc.nextLine();
		System.out.println("Email :");
		String email=sc.nextLine();
		System.out.print("Password: ");
		String password = sc.nextLine();
		
		if(userExits(email))
		{
			System.out.println(RED + "User Already Exists for this Email Address!!" + RESET);
			return;
		}
		
		String register_query="insert into Userbank(full_name, email, password) values(?,?,?)";
		try
		{
			PreparedStatement ps= con.prepareStatement(register_query);
			ps.setString(1, full_name);
			ps.setString(2,email);
			ps.setString(3, password);
			int rowAdded= ps.executeUpdate();
			if(rowAdded>0)
			{
				System.out.println(GREEN + "Registration Successfull!\n" + RESET);
			}
			else
			{
				System.out.println(RED + "Registration Failed!" + RESET);
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public String login()
	{
		sc.nextLine();
		System.out.println("Email :");
		String email=sc.nextLine();
		System.out.print("Password: ");
		String password = sc.nextLine();
		
		String login_query="select * from Userbank where email=? and password=?";
		try {
			PreparedStatement ps= con.prepareStatement(login_query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				return email;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean userExits(String email)
	{
		String query= "Select * from Userbank where email=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
