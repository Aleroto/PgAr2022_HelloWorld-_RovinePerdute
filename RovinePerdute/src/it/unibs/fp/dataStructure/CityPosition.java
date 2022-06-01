package it.unibs.fp.dataStructure;
/**Class for position data like cartesian and altitude data*/
public class CityPosition {

	public int X,Y,H;

	
	
	public CityPosition(int x, int y, int h) {
		super();
		X = x;
		Y = y;
		H = h;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public int getH() {
		return H;
	}

	public void setH(int h) {
		H = h;
	}

}
