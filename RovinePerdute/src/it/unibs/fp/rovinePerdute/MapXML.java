package it.unibs.fp.rovinePerdute;

import java.util.ArrayList;


public class MapXML {
	
	private ArrayList<City> city = new ArrayList<City>();
	

	public MapXML() {}
	public MapXML(ArrayList<City> city) {
		this.city = city;
	}
	//Getter
	public ArrayList<City> getCity() {
		return city;
	}
	//Setter
	public void setCity(ArrayList<City> city) {
		this.city = city;
	}
	
}
