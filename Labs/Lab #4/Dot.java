package dotlab;


public class Dot 
{
	
	
	private static String[] 	LEGAL_COLOR_NAMES =
	{
		"RED", "YELLOW", "BLUE", "CYAN", "GREEN", "MAGENTA", "ORANGE", "BLACK"
	};
	
	private String name;
	private int xCoord;
	private int yCoord;
	private int radius;
	
	public Dot(String theName, int x, int y, int r) {
		boolean legalColor = false;
		for(String color : LEGAL_COLOR_NAMES) {
			if(theName.equalsIgnoreCase(color)) {
				name = theName;
				legalColor = true;
			}
		}
		
		if(!legalColor) {
			throw new IllegalArgumentException(theName + " is a bad color name.");
		}
		
		xCoord = x;
		yCoord = y;
		radius = r;
	}
	
	public String getColorName() {
		return name;
	}
	public int getX() {
		return xCoord;
	}
	public int getY() {
		return yCoord;
	}
	public int getRadius() {
		return radius;
	}
	
	public String toString() {
		return "Color Name: " + name + "\nx-Coordiate: " + xCoord + "\ny-Coordiate: "  + yCoord + "\nRadius: "  + radius;
	}
	
	public static void main(String[] args) {
		Dot goodDot = new Dot("green", 1, 2, 3);
		System.out.println(goodDot.toString());
		}


}
