package edu.sabanciuniv.cs310.homework1Q1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//import java.sql.* ;
//import java.util.* ;
 

public class SilaJDBCManager {
	

	public static ArrayList<Country> readFromFile ( String filename ) 
	{
		ArrayList<Country> countries = new ArrayList<Country>();
		
		try 
		{
			FileReader reader = new FileReader(filename);
			BufferedReader bfr = new BufferedReader(reader);
			int id = 1;
			while(true)
			{
				String line = bfr.readLine();
				if (line == null)
				{
					break;
				}
				//System.out.println(line);
				String[] arr = line.split(",");
				int tableId = id;
				String name= arr[0];
				String cont= arr[1];
				String capit = arr[2];
				String popu = arr[3];
				Country c = new Country(tableId, name, cont, capit, popu);
				
				countries.add(c);
				id++;
			}
			reader.close();
		
		}
		catch (FileNotFoundException e) {
			System.out.println("no file");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("no have rights to read that file");
			e.printStackTrace();
		}
		return countries;
	}
	
	
	public static void writeIntoTable ( ArrayList<Country> countries )
	{
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cs310?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root", "Yfiqb50Ae-*");
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Yfiqb50Ae-*");		
			for (Country c : countries)
			{
				PreparedStatement ps =  connection.prepareStatement("Insert into countries (id, country, continent,capital, population) values (?,?,?,?,?) ");
				ps.setInt(1, c.getID());
				ps.setString(2, c.getName());
				ps.setString(3, c.getContinent());
				ps.setString(4, c.getCapital());
				ps.setString(5, c.getPopulation());
				
				ps.execute();
			}
			
			
			System.out.println("Data inserted!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static Country getCountryByID (int countryID)
	{
		Country info = new Country();
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cs310?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root", "Yfiqb50Ae-*");
			
			java.sql.Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from countries where id = " + countryID );
			while (rs.next()) {
				// retrieve and print the values for the current row
				info.setID(rs.getInt("id"));
				info.setName(rs.getString("country"));
				info.setContinent(rs.getString("continent"));
				info.setCapital(rs.getString("capital"));
				info.setPopulation(rs.getString("population"));
			}
			
			System.out.println("Data is taken from the database!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}
	
	public static void deleteCountryByID (int countryID)
	{
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cs310?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root", "Yfiqb50Ae-*");
			
			PreparedStatement ps =  connection.prepareStatement("delete from countries where id = " + countryID); //deletes from table(not database!!)
				
			ps.execute();
			
			System.out.println("Data deleted!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void updateCountryPopulationByID (int countryID, int population_) {
		
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cs310?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root", "Yfiqb50Ae-*");
			
			PreparedStatement ps =  connection.prepareStatement("update countries set population = " + population_  + " where id = " + countryID); //deletes from table(not database!!)
		
			ps.execute();
			
			System.out.println("Data updated!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
