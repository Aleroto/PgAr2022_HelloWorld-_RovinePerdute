package it.unibs.fp.rovinePerdute;

import it.unibs.fp.XML.XMLReader;

public class UI {

	public static String filename; 
	public static MapXML mapFromXML;
	
	/**Runs the Program*/
	public static void runProgram(){
		
		filename = XMLReader.chooseXML();
		mapFromXML = new MapXML(XMLReader.addCities());
		/*for (Map.Entry<City> entry : map.getCities().entrySet()) {
		}*/
		//XMLReader.printXML();
	}
}
