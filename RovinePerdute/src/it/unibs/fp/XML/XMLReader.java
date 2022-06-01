package it.unibs.fp.XML;

import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import it.unibs.fp.rovinePerdute.City;
import it.unibs.fp.rovinePerdute.UI;

import java.io.File;
import javax.xml.parsers.*;

public class XMLReader {
	private static final String PATH_USER_DIRECTORY = System.getProperty("user.dir");
	private static final String SEPARATORE = "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
	
	private static final String PATH_XML_INPUT = PATH_USER_DIRECTORY + "/XML/INPUT/";

	public static ArrayList<City> addCities() {
		ArrayList<City> cityList = new ArrayList<City>();		
		try {
			File xmlDoc = new File(PATH_XML_INPUT + UI.filename);
			DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dbFact.newDocumentBuilder();
			Document doc = dBuild.parse(xmlDoc);
			
			NodeList ci = doc.getElementsByTagName("city");
			for (int i = 0; i < ci.getLength(); i++) {
				ArrayList<Integer> linkList = new ArrayList<Integer>();
				Node c_ = ci.item(i);	
				if(c_.getNodeType() == Node.ELEMENT_NODE) {
					Element city_ = (Element)c_;
					int id = Integer.parseInt(city_.getAttribute("id"));
					String name = city_.getAttribute("name");
					int x = Integer.parseInt(city_.getAttribute("x"));
					int y= Integer.parseInt(city_.getAttribute("y"));
					int h = Integer.parseInt(city_.getAttribute("h"));					
					
					City c = new City(id, name, x, y, h, linkList);
					
					NodeList li = city_.getElementsByTagName("link");
					for(int j = 0; j < li.getLength(); j++) {
						Node l_ = li.item(j);
						if(l_.getNodeType() == Node.ELEMENT_NODE) {
							Element link_ = (Element) l_;
							int link = Integer.parseInt(link_.getAttribute("to"));
							c.addParameter(link);
						}
					}
					
					cityList.add(c);
				}
			}
			return cityList;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	private static void separatore() {
		System.out.println(SEPARATORE);
	}

	public static String chooseXML() {
		String file1 = "Copy of PgAr_Map_5.xml";
		String file2 = "Copy of PgAr_Map_12.xml";
		String file3 = "Copy of PgAr_Map_50.xml";
		String file4 = "Copy of PgAr_Map_200.xml";
		String file5 = "Copy of PgAr_Map_2000.xml";
		String file6 = "Copy of PgAr_Map_10000.xml";
		boolean stato = true;

		Scanner scan = new Scanner(System.in);
		System.out.println("Seleziona il file che vuoi leggere:" + "\n[1]" + file1 + "\n[2]" + file2 + "\n[3]" + file3
				+ "\n[4]" + file4 + "\n[5]" + file5 + "\n[6]" + file6);

		String fileNumber = scan.nextLine();

		switch (fileNumber) {
		case "1": {
			return file1;
		}
		case "2": {
			return file2;
		}
		case "3": {
			return file3;
		}
		case "4": {
			return file4;
		}
		case "5": {
			return file5;
		}
		case "6": {
			return file6;
		}
		default:
			System.out.println("Inserisci un valore numerico valido!!!");
			chooseXML();
		}

		return null;
	}

}
