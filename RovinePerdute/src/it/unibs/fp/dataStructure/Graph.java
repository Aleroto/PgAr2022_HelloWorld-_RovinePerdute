package it.unibs.fp.dataStructure;

import java.util.*;
import it.unibs.fp.rovinePerdute.*;

/**
 * Graph Class for implements nodes and edge
 */
public class Graph {
	//#TODO mettere attributi per contare le città visitate e carburante totale (somma dei pesi), utilizzare un Set<integer> per raccogliere gli id delle città visitate, utilizzare una PriorityQueue<Vertex> per raccogliere i nodi
	//SEGUI questa guida https://www.softwaretestinghelp.com/dijkstras-algorithm-in-java/
	private static final String TEXT_DELIMITER = "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
	int vertex; // Size of Graph
	private Map<Vertex, LinkedList<Edge>> adj = new HashMap<>();

	public Map<Vertex, LinkedList<Edge>> getAdj() {
		return adj;
	}
	
	public void generateGraph(MapXML mapXML, int type) {
		for(int i = 0;i < mapXML.getCity().size();i++) {
			adj.put(covertToVertex(mapXML.getCity().get(i)), covertToEdge(mapXML.getCity().get(i),mapXML, type));
		}
	}
	
	private Vertex covertToVertex(City city) {
		CityPosition pos = new CityPosition(city.getX(),city.getY(),city.getH());
		return new Vertex(city.getId(),city.getName(),pos);
	}
	private LinkedList<Edge> covertToEdge(City city,MapXML mapXML, int type) {
		LinkedList<Edge> edge = new LinkedList<Edge>();
		if(type == 0) {
			for(int i =0;i<city.getLink().size();i++) {
				edge.add(new Edge(city.getId(),city.getLink().get(i),calcolateDistanceEuclidean(city,mapXML.searchCityById(city.getLink().get(i)))));
			}
		}else {
			for(int i =0;i<city.getLink().size();i++) {
				edge.add(new Edge(city.getId(),city.getLink().get(i),calcolateDistanceAltitude(city,mapXML.searchCityById(city.getLink().get(i)))));
			}
		}		
		return edge;
	}
	
	private Integer calcolateDistanceEuclidean(City city1,City city2) {
		return (int)Math.sqrt(Math.pow(city1.getX()- city2.getX(), 2)+Math.pow(city1.getY() - city2.getY(), 2));
	}
	
	private Integer calcolateDistanceAltitude(City city1,City city2) {
		return Math.abs(city1.getH() - city2.getH());
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
		for (Map.Entry<Vertex, LinkedList<Edge>> entry : adj.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
			System.out.println(TEXT_DELIMITER);
		}
	}
	
}
