package it.unibs.fp.dataStructure;

public class Vertex {
	private String id, name;
	private CityPosition position;

	public Vertex(String id, String name, CityPosition position) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
	}

//Getter, use only this and no the setter because this info is always the same after the implementation
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public CityPosition getPosition() {
		return position;
	}

	
	public String toString(){
        return "[ID: " + this.id + ", Name: " + this.name + ", " + " X: " + this.getPosition().X + " Y: " + this.getPosition().Y + " H: " + this.getPosition().H + "]";
    }
}
