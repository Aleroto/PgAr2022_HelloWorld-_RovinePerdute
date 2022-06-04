package it.unibs.fp.XML;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Queue;


import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import it.unibs.fp.dataStructure.*;
import it.unibs.fp.rovinePerdute.MapXML;

public class XMLWriter {
	private static final String PATH_USER_DIRECTORY = System.getProperty("user.dir");
	private static final String PATH_FILE_DESTINATION = "/XML/OUTPUT/";
	


	public static void writeXML(MapXML mapXML,String team1,Integer citiesCount1,Queue<Edge> edge1,String team2,Integer citiesCount2,Queue<Edge> edge2) {
		System.out.println(PATH_USER_DIRECTORY);
		directoryExisting();
		XMLOutputFactory xmlof = null;
		XMLStreamWriter xmlw = null;	
		
		try {
			xmlof = XMLOutputFactory.newInstance();
			xmlw = xmlof.createXMLStreamWriter(new FileOutputStream(PATH_USER_DIRECTORY  + "/XML/OUTPUT/Routes.xml"), "utf-8");

			xmlw.writeStartDocument("utf-8", "1.0");
			xmlw.writeStartElement("Routes"); //Scrittura del tag radice [1]
			//BLOCCO XML CON LE PERSONE, liverlli dei tag indicati con [x]
			//team1
			xmlw.writeStartElement("route"); //[2]
			xmlw.writeAttribute("team ", team1); 
			xmlw.writeAttribute("cost ", calcolateWeight(edge1).toString());
			xmlw.writeAttribute("cities ", citiesCount1.toString()); 
			
			for (Edge e : edge1) {
				xmlw.writeStartElement("nome"); 
				xmlw.writeAttribute("id ", e.getId_destination().toString()); 
				xmlw.writeAttribute("name ",mapXML.getCity().get(e.getId_destination()).getName()); 
				xmlw.writeEndElement(); 
			}
			xmlw.writeEndElement(); //[2]
			//team2
			xmlw.writeStartElement("route"); //[2]

			xmlw.writeAttribute("team ", team2); 
			xmlw.writeAttribute("cost ", calcolateWeight(edge2).toString());
			xmlw.writeAttribute("cities ", citiesCount2.toString()); 
			for (Edge e : edge2) {
				xmlw.writeStartElement("nome"); 
				xmlw.writeAttribute("id ", e.getId_destination().toString()); 
				xmlw.writeAttribute("name ",mapXML.getCity().get(e.getId_destination()).getName()); 
				xmlw.writeEndElement(); 
			}
			xmlw.writeEndElement(); //[2]
			//BLOCCO XML CON I CODICI, livelli dei tag indicati con [x]
			xmlw.writeEndElement(); //Chiusura della root [1]
			xmlw.writeEndDocument(); // Scrittura della fine del documento
			xmlw.flush(); //Svuota il buffer e procede alla scrittura
			xmlw.close(); //Chiusura del documento e delle risorse impiegate*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void directoryExisting() {
		try {
            File f = new File(PATH_USER_DIRECTORY+PATH_FILE_DESTINATION);
            if (!f.exists()) {
            	f.mkdir();

                System.out.println("Creating directory");
            	//f.mkdir();
            }
		}
        catch (Exception e) {
            System.err.println(e);
        }

	}

	private static Integer calcolateWeight(Queue<Edge> edge) {
		int weight = 0;
		for (Edge e : edge) {
			weight += e.getWeight();
		}
		return weight;
	}
	
}
