package it.unibs.fp.dataStructure;

import java.util.*;
import it.unibs.fp.rovinePerdute.*;

/**
 * Graph Class for implements nodes and edge
 */
public class Graph {
	private static final String TEXT_DELIMITER = "--------------------------------------------------------";
	int vertex; // Size of Graph
	Map<Vertex, LinkedList<Edge>> adj = new HashMap<>();

	// to send the info in the xml, for the toIDList create a list with id source
	// and destination and the weight calculated for the two different type of
	// searcher
	/*
	public void addVertex(Integer id, String name, CityPosition position, LinkedList<Edge> toIDList) {
		Vertex v = new Vertex(id, name, position);
		this.adj.put(v, toIDList);
	}
	*/
	
	public void generateGraph(MapXML mapXML) {
		for(int i = 0;i < mapXML.getCity().size();i++) {
			adj.put(covertToVertex(mapXML.getCity().get(i)), covertToEdge(mapXML.getCity().get(i),mapXML));
		}
	}
	
	private Vertex covertToVertex(City city) {
		CityPosition pos = new CityPosition(city.getX(),city.getY(),city.getH());
		return new Vertex(city.getId(),city.getName(),pos);
	}
	private LinkedList<Edge> covertToEdge(City city,MapXML mapXML) {
		LinkedList<Edge> edge = new LinkedList<Edge>();
		for(int i =0;i<city.getLink().size();i++) {
			edge.add(new Edge(city.getId(),city.getLink().get(i),calcolateDistanceWithoutHeight(city,mapXML.searchCityById(city.getLink().get(i)))));
		}
		return edge;
	}
	
	private Integer calcolateDistanceWithoutHeight(City city1,City city2) {
		return (int)Math.sqrt(Math.pow(city1.getX()+city2.getX(), 2)+Math.pow(city1.getY()+city2.getY(), 2));
	}
	/*
	 * public void addEdge(E from, E to, double weight) { List<Edge> fromEdges =
	 * this.getEdges(from); List<Edge> toEdges = this.getEdges(from);
	 * 
	 * // Add source vertex and then add edge if(fromEdges == null) {
	 * this.addVertex(from); } if(toEdges == null) { this.addVertex(to); }
	 * 
	 * fromEdges.add(new Edge(from, to, weight)); } }
	 */

	public void displayGraph() {
		System.out.println(adj);
		System.out.println(TEXT_DELIMITER);
	}
}
