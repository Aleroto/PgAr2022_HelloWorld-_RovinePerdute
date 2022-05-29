package it.unibs.fp.dataStructure;

import java.util.*;

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
	public void addVertex(String id, String name, CityPosition position, LinkedList<Edge> toIDList) {
		Vertex v = new Vertex(id, name, position);
		this.adj.put(v, toIDList);
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
