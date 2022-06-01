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
	private static final String SEPARATORE = "--------------------------------------------------------------------------------------------------------------------";
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
	/*
	 * public static void printXML() { XMLInputFactory xmlInputFactory = null;
	 * XMLStreamReader xmlStreamReader = null; ArrayList<City> c = new
	 * ArrayList<City>();
	 * 
	 * try { // File Path Reader fileReader = new FileReader(PATH_XML_INPUT +
	 * UI.filename); // Read XML file. xmlInputFactory =
	 * XMLInputFactory.newInstance(); // Get XMLInputFactory instance.
	 * xmlStreamReader = xmlInputFactory.createXMLStreamReader(fileReader); //
	 * Create XMLStreamReader object.
	 * 
	 * // Iterate through events. while (xmlStreamReader.hasNext()) { int xmlEvent =
	 * xmlStreamReader.next(); // Get integer value of current event. switch
	 * (xmlEvent) { case XMLStreamConstants.START_DOCUMENT: // Inizio del documento:
	 * stampa che inizia il documento System.out.println("Start Read Doc " +
	 * UI.filename); break; case XMLStreamConstants.START_ELEMENT: // Inizio di un
	 * elemento: stampa il nome del tag e i suoi // attributi
	 * System.out.println("Tag " + xmlStreamReader.getLocalName()); for (int i = 0;
	 * i < xmlStreamReader.getAttributeCount(); i++) { separatore();
	 * System.out.printf("=> attributo %s ->%s%n",
	 * xmlStreamReader.getAttributeLocalName(i),
	 * xmlStreamReader.getAttributeValue(i)); } break; case
	 * XMLStreamConstants.END_ELEMENT: // Fine di un elemento: stampa il nome del
	 * tag chiuso // System.out.println("END-Tag " +
	 * xmlStreamReader.getLocalName()); break; case XMLStreamConstants.COMMENT:
	 * System.out.println("// commento " + xmlStreamReader.getText()); break; //
	 * Commento: ne stampa il contenuto case XMLStreamConstants.CHARACTERS: //
	 * Contentenuto interno di un elemento: stampa il testo if
	 * (xmlStreamReader.getText().trim().length() > 0) // Controlla se il testo non
	 * contiene solo spazi System.out.println("-> " + xmlStreamReader.getText());
	 * break; } } } catch (Exception e) { e.printStackTrace(); } }
	 */

	/*
	 * public static ArrayList<City> addCities() { ArrayList<City> c = new
	 * ArrayList<City>(); System.out.println(cityReader().size()); for(int i = 0; i
	 * < cityReader().size();i++) { ArrayList<String> t = linkReader();
	 * System.out.println(t);
	 * /*System.out.println(Integer.parseInt(nameReader().get(i)));
	 * System.out.println(Integer.parseInt(xReader().get(i)));
	 * System.out.println(Integer.parseInt(yReader().get(i)));
	 * System.out.println(Integer.parseInt(hReader().get(i)));
	 */
	// City temp = new City(Integer.parseInt(idReader().get(i)),
	// nameReader().get(i), Integer.parseInt(xReader().get(i)),
	// Integer.parseInt(yReader().get(i)), Integer.parseInt(hReader().get(i)));
	// temp.addLink(linkReader());
	// c.add(temp);
	/*
	 * } return null; }
	 * 
	 * public static ArrayList<String> cityReader(){ ArrayList<String> c = new
	 * ArrayList<String>(); c.addAll(finder("city")); return c; }
	 * 
	 * public static ArrayList<String> idReader(){ ArrayList<String> id = new
	 * ArrayList<String>(); id.addAll(finder("id")); return id; }
	 * 
	 * public static ArrayList<String> nameReader(){ ArrayList<String> n = new
	 * ArrayList<String>(); n.addAll(finder("name")); return n; }
	 * 
	 * public static ArrayList<String> xReader(){ ArrayList<String> n = new
	 * ArrayList<String>(); n.addAll(finder("x")); return n; }
	 * 
	 * public static ArrayList<String> yReader(){ ArrayList<String> n = new
	 * ArrayList<String>(); n.addAll(finder("y")); return n; }
	 * 
	 * public static ArrayList<String> hReader(){ ArrayList<String> n = new
	 * ArrayList<String>(); n.addAll(finder("h")); return n; }
	 * 
	 * public static ArrayList<String> linkReader(){ ArrayList<String> n = new
	 * ArrayList<String>(); n.addAll(finder("link")); return n; }
	 * 
	 * public static ArrayList<String> finder(String type){ XMLInputFactory
	 * xmlInputFactory = null; XMLStreamReader xmlStreamReader = null;
	 * ArrayList<String> value = new ArrayList<String>();
	 * 
	 * try { Reader fileReader = new FileReader(PATH_XML_INPUT + UI.filename);
	 * //Read XML file. xmlInputFactory = XMLInputFactory.newInstance(); //Get
	 * XMLInputFactory instance. xmlStreamReader =
	 * xmlInputFactory.createXMLStreamReader(fileReader); //Create XMLStreamReader
	 * object. boolean stato = false; while(xmlStreamReader.hasNext()){ int xmlEvent
	 * = xmlStreamReader.next(); //Get integer value of current event. if(stato) {
	 * value.add(xmlStreamReader.getText());
	 * System.out.println(xmlStreamReader.getText()); stato = false; } if(xmlEvent
	 * == XMLStreamConstants.START_ELEMENT && xmlStreamReader.getLocalName() ==
	 * type) { stato = true; } } } catch (Exception e) { e.printStackTrace(); }
	 * return value; }
	 */

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
