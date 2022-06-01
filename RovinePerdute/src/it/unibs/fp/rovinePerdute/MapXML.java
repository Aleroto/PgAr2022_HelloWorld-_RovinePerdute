package it.unibs.fp.rovinePerdute;

import java.util.ArrayList;


public class MapXML {
	
	private ArrayList<City> city = new ArrayList<City>();
	
	public void printMapXML() {
		for(int i = 0;i<city.size();i++) {
			city.get(i).printCity();
		}
	}
	
	public City searchCityById(Integer id) {
		for(int i = 0; i < city.size();i++) {
			if(city.get(i).getId().equals(id)) {
				return city.get(i);
			}
		}
		return null;
	}

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
