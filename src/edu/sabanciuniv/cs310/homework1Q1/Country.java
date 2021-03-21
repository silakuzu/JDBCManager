package edu.sabanciuniv.cs310.homework1Q1;

public class Country {

	private int id;
	private String name;
	private String continent;
	private String capital;
	private String population;
	
	
	public Country() {
		this.id = 0;
		this.name = "nowhere";
		this.continent = "no continent";
		this.capital = "no capital";
		this.population = "no population";
	}
	
	public Country (int tableId, String cntry, String cont, String capit, String popu) {
		this.id = tableId;
		this.name = cntry;
		this.continent = cont;
		this.capital = capit;
		this.population = popu;
		
	}
	
	//getters
	public int getID() {
		return id;
	}
	
	public String getName () {
		return name;
	}
	
	public String getContinent() {
		return continent;
	}
	
	public String getCapital() {
		return capital;
	}
	
	public String getPopulation() {
		return population;
	}
	
	
	//setters
	public void setID(int newId) {
		this.id = newId;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public void setContinent(String newCont) {
		this.continent = newCont;
	}
	
	public void setCapital(String newCapital) {
		this.capital = newCapital;
	}
	
	public void setPopulation(String newPopu) {
		this.population = newPopu;
	}
}
