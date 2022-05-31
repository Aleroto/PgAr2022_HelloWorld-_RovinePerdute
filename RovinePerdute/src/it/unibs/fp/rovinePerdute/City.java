package it.unibs.fp.rovinePerdute;

import java.util.ArrayList;

public class City {
	private Integer id;
	private Double x, y, h;
	private String name;
	private static ArrayList<Integer> link = new ArrayList<Integer>();

	public City(Integer id, Double x, Double y, Double h, String name) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
		this.h = h;
		this.name = name;
	}

//Getter
	public Integer getId() {
		return id;
	}

	public Double getX() {
		return x;
	}

	public Double getY() {
		return y;
	}

	public Double getH() {
		return h;
	}

	public String getName() {
		return name;
	}

// Setter
	public void setId(Integer id) {
		this.id = id;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public void setH(Double h) {
		this.h = h;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public ArrayList<Integer> getLink() {
        return link;
    }

    public void addParameter(Integer value) {
        link.add(value);
    }
}
