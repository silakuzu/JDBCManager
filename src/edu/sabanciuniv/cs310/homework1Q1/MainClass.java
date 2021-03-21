package edu.sabanciuniv.cs310.homework1Q1;
import java.util.ArrayList;


public class MainClass {

	public static void main(String[] args) 
	{
	
		ArrayList<Country> allCountries = SilaJDBCManager.readFromFile("world.txt");

		SilaJDBCManager.writeIntoTable(allCountries);
		
		System.out.println(SilaJDBCManager.getCountryByID(2).getName());
		
		SilaJDBCManager.deleteCountryByID(10);
		
		SilaJDBCManager.updateCountryPopulationByID(5, 520);
	}
	
}
