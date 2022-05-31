package it.unibs.fp.rovinePerdute;

import java.util.ArrayList;

public class MapXML {
	private ArrayList<City> cities = new ArrayList<City>();
	
	public MapXML(ArrayList<City> cities) {
		super();
		this.cities = cities;
	}

	public ArrayList<City> getCities() {
        return cities;
    }

	public void addParameter(City c) {
        cities.add(c);
    }
    
    public void clearCities() {
    	cities.clear();
    }
}
