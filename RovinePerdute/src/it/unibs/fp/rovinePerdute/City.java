package it.unibs.fp.rovinePerdute;

import java.util.ArrayList;

public class City {
	private Integer id;
	private Integer x, y, h;
	private String name;
	private ArrayList<Integer> link = new ArrayList<Integer>();

	public City(Integer id, String name, Integer x, Integer y, Integer h, ArrayList<Integer> link) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
		this.h = h;
		this.name = name;
		this.link = link;
	}

	public void printCity() {
		System.out.println("ID: " + id);
		System.out.println("name: " + name);
		System.out.println("Position X: " + x);
		System.out.println("Position Y: " + y);
		System.out.println("Position H: " + h);
		System.out.println("Link: ");
		for(int i  = 0;i< link.size();i++) {
			System.out.println("\tlink("+i+") -> "+link.get(i));
		}

	}
	

//Getter
	public Integer getId() {
		return id;
	}

	public Integer getX() {
		return x;
	}

	public Integer getY() {
		return y;
	}

	public Integer getH() {
		return h;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Integer> getLink() {
		return link;
	}

// Setter
	public void setId(Integer id) {
		this.id = id;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public void setH(Integer h) {
		this.h = h;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addParameter(Integer value) {
		this.link.add(value);
	}

}
