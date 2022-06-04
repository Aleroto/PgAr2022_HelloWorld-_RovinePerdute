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



	public Integer getId_source() {
		return id_source;
	}



	public void setId_source(Integer id_source) {
		this.id_source = id_source;
	}



	public Integer getId_destination() {
		return id_destination;
	}



	public void setId_destination(Integer id_destination) {
		this.id_destination = id_destination;
	}



	public Integer getWeight() {
		return weight;
	}



	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	
	
}
