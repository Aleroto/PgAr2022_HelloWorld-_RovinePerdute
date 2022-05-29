package it.unibs.fp.dataStructure;

/**Edge Class, use for implement the edge*/
public class Edge {
	int id_source;
	int id_destination;
	int weight;

	public Edge(int source, int destination, int weight) {
		this.id_source = source;
		this.id_destination = destination;
		this.weight = weight;
	}
	
	public String toString(){
        return "[From: " + this.id_source + ", To: " + this.id_destination + ", Weight: " + this.weight + "]";
    }
}
