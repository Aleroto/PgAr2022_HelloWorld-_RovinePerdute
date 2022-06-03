package it.unibs.fp.rovinePerdute;

import it.unibs.fp.XML.XMLReader;
import it.unibs.fp.dataStructure.Graph;

public class UI {

	public static String filename; 
	public static MapXML mapFromXML;
	public static Graph graphTonatiuh;
	public static Graph graphMetztli;
	
	private static final String SEPARATORE = "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
	
	/**Runs the Program*/
	public static void runProgram(){
		
		filename = XMLReader.chooseXML();
		mapFromXML = new MapXML(XMLReader.addCities());
		/*mapFromXML.printMapXML();*/
		
		System.out.println("\n\nTonatiuh MAP");
		graphTonatiuh = new Graph(mapFromXML.getCity().size());
		graphTonatiuh.generateGraph(mapFromXML, 0);		
		graphTonatiuh.displayGraph();
		
		System.out.println("\n\nTonatiuh VISITED MAP");
		graphTonatiuh.algo_dijkstra(0);
		System.out.println("\n VISITED QUEUE");
		graphTonatiuh.displayQueue();
		
		
		
		System.out.println("\n\nMetztli MAP");
		graphMetztli = new Graph(mapFromXML.getCity().size());
		graphMetztli.generateGraph(mapFromXML, 1);		
		graphMetztli.displayGraph();
		
		System.out.println("\n\nMetztli VISITED MAP");
		graphMetztli.algo_dijkstra(0);
		System.out.println("\n VISITED QUEUE");
		graphMetztli.displayQueue();
		
		
	}
}
