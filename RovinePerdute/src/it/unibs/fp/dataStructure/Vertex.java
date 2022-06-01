package it.unibs.fp.dataStructure;

import it.unibs.fp.rovinePerdute.*;

public class Vertex {
	private String name;
	private Integer id;
	private CityPosition position;

	public Vertex(Integer id, String name, CityPosition position) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
	}

//Getter, use only this and no the setter because this info is always the same after the implementation
	public Integer getId() {
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
