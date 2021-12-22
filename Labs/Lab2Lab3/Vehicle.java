package transport;

public class Vehicle {
	private int nWheels;
	private double xPosition;
	private double yPosition;
	
	public Vehicle (int nWheels, double theX, double theY) {
		this.nWheels = nWheels;
		System.out.print("Vehicle ctor ");
		xPosition = theX;
		yPosition = theY;
	}
	
	public void setPosition(double newX, double newY)
	{
		xPosition = newX;
		yPosition = newY;
	}
	
	public double getXPosition()
	{
		return xPosition;
	}
	
	public double getYPosition()
	{
		return yPosition;
	}
	
	public void changePositionBy(double xDelta, double yDelta)
	{
		xPosition = xPosition + xDelta;
		yPosition = yPosition + yDelta;
	}

}
