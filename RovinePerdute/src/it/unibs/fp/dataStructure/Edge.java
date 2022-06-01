package it.unibs.fp.dataStructure;

/**Edge Class, use for implement the edge*/
public class Edge {
	Integer id_source;
	Integer id_destination;
	Integer weight;

	public Edge(Integer source, Integer destination, Integer weight) {
		this.id_source = source;
		this.id_destination = destination;
		this.weight = weight;
	}
	
	
	
	public String toString(){
        return "[From: " + this.id_source + ", To: " + this.id_destination + ", Weight: " + this.weight + "]";
    }
}
