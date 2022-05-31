package it.unibs.fp.rovinePerdute;

import java.util.Map;

import it.unibs.fp.XML.XMLReader;

public class UI {

	public static MapXML map;
	/**Runs the Program*/
	public static void runProgram(){
		
		map = new MapXML(addCities());
		for (Map.Entry<City> entry : map.getCities().entrySet()) {
		}
		XMLReader.printXML();
	}
}
