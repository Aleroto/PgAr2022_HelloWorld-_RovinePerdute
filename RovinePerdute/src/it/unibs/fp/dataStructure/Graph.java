package it.unibs.fp.dataStructure;


import java.util.*;
import java.util.Map.Entry;

import it.unibs.fp.rovinePerdute.*;

/**
 * Graph Class for implements nodes and edge
 */
public class Graph {
	//#TODO mettere attributi per contare le città visitate e carburante totale (somma dei pesi), utilizzare un Set<integer> per raccogliere gli id delle città visitate, utilizzare una PriorityQueue<Vertex> per raccogliere i nodi
	//SEGUI questa guida https://www.softwaretestinghelp.com/dijkstras-algorithm-in-java/
	private static final String TEXT_DELIMITER = "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
	int vertex; // Size of Graph
	Set<Edge> visited;
	Queue<Edge> q = new LinkedList<>(); 
	private Map<Vertex, LinkedList<Edge>> adj = new HashMap<>();

	public Graph(int vertex) {
		super();
		this.vertex = vertex; 
        q = new LinkedList<Edge>();
        visited = new HashSet<Edge>();
	}
	
	public Map<Vertex, LinkedList<Edge>> getAdj() {
		return adj;
	}
	
	public void generateGraph(MapXML mapXML, int type) {
		for(int i = 0;i < mapXML.getCity().size();i++) {
			adj.put(covertToVertex(mapXML.getCity().get(i)), covertToEdge(mapXML.getCity().get(i),mapXML, type));
		}
	}
	

	public void algo_dijkstra(int src_vertex) 
    { 
		for (Map.Entry<Vertex, LinkedList<Edge>> city : adj.entrySet()) {
			 
			if(city.getKey().getId() == src_vertex) {
				//Edge src_city = city.getValue().get(src_vertex);
				q.add(new Edge(src_vertex, src_vertex, 0 ));
				
				Map.Entry<Vertex, LinkedList<Edge>> _city = city;
				while(q.size() != vertex) {
					//fare una funzione a cui passo la città di partenza e l'arco associato e aggiunge alla lista dei visitati la città meno distante e mi ritorna l'id della città
					
					Map.Entry<Vertex, LinkedList<Edge>> tmp = findEdge(_city);
					if(tmp != null) {
						_city = tmp;
					}
				}
				
			}else{continue;}
		}
    }
	
	private Map.Entry<Vertex, LinkedList<Edge>> findEdge(Map.Entry<Vertex, LinkedList<Edge>> src_city){
		Edge edgMIN = new Edge(0, 0, Integer.MAX_VALUE);
		
		//cerco l'arco con il valore minimo
		for(Edge edg : src_city.getValue()){
			boolean stato = true;
			//la destinazione dell'arco deve essere diversa dalla source che ha lui come destinazione nel set di visitati
			for(Edge edgVISIT : q) {
				if(edg.id_destination == edgVISIT.id_source) {
					stato = false;
				}
			}
			if(edg.weight < edgMIN.weight && stato) {				
				edgMIN = edg;
			}
		}	
		
		q.add(edgMIN);
		
		
		//trovo l'entry dalla mappa della destinazione da ritornare;
		for (Map.Entry<Vertex, LinkedList<Edge>> city : adj.entrySet()) {
			if(city.getKey().getId() == edgMIN.id_destination) {
				return city;
			}
		}
		
		return null; 
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

	public void displayGraph() {
		for (Map.Entry<Vertex, LinkedList<Edge>> entry : adj.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
			System.out.println(TEXT_DELIMITER);
		}
	}
	
	public void displayQueue() {
		for (Edge e : q) {
			System.out.println(e);
			System.out.println(TEXT_DELIMITER);
		}
	}

	public Queue<Edge> getQ() {
		return q;
	}

	public void setQ(Queue<Edge> q) {
		this.q = q;
	}
	
}
