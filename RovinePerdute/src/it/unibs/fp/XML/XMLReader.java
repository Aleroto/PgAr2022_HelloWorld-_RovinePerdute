package it.unibs.fp.XML;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import it.unibs.fp.rovinePerdute.City;

import java.io.FileOutputStream;

public class XMLReader {
	private static final String PATH_USER_DIRECTORY = System.getProperty("user.dir");
	private static final String SEPARATORE = "--------------------------------------------------------------------------------------------------------------------";
	private static final String PATH_XML_INPUT = PATH_USER_DIRECTORY + "/XML/INPUT/";
	

	public static void printXML() {
		XMLInputFactory xmlInputFactory = null;
		XMLStreamReader xmlStreamReader = null;

		try {
			// Ask what file want to read
			String filename = chooseXML();
			// File Path
			Reader fileReader = new FileReader(PATH_XML_INPUT + filename); // Read XML file.
			xmlInputFactory = XMLInputFactory.newInstance(); // Get XMLInputFactory instance.
			xmlStreamReader = xmlInputFactory.createXMLStreamReader(fileReader); // Create XMLStreamReader object.

			// Iterate through events.
			while (xmlStreamReader.hasNext()) {
				int xmlEvent = xmlStreamReader.next(); // Get integer value of current event.
				switch (xmlEvent) {
				case XMLStreamConstants.START_DOCUMENT: // Inizio del documento: stampa che inizia il documento
					System.out.println("Start Read Doc " + filename);
					break;
				case XMLStreamConstants.START_ELEMENT: // Inizio di un elemento: stampa il nome del tag e i suoi
														// attributi
					System.out.println("Tag " + xmlStreamReader.getLocalName());
					for (int i = 0; i < xmlStreamReader.getAttributeCount(); i++) {
						separatore();
						System.out.printf("=> attributo %s ->%s%n", xmlStreamReader.getAttributeLocalName(i),
								xmlStreamReader.getAttributeValue(i));
					}
					break;
				case XMLStreamConstants.END_ELEMENT: // Fine di un elemento: stampa il nome del tag chiuso
					// System.out.println("END-Tag " + xmlStreamReader.getLocalName());
					break;
				case XMLStreamConstants.COMMENT:
					System.out.println("// commento " + xmlStreamReader.getText());
					break; // Commento: ne stampa il contenuto
				case XMLStreamConstants.CHARACTERS: // Contentenuto interno di un elemento: stampa il testo
					if (xmlStreamReader.getText().trim().length() > 0) // Controlla se il testo non contiene solo spazi
						System.out.println("-> " + xmlStreamReader.getText());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<City> addCities() {
		
		return null;
	}
	
	private static void separatore() {
		System.out.println(SEPARATORE);
	}

	private static String chooseXML() {
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
