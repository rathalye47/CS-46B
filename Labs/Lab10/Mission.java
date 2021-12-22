package space;

import java.util.ArrayList;


public class Mission implements Comparable<Mission>
{
	private String			destination;
	private float			cost;
	
	
	public Mission(String destination, Float cost)
	{
		this.destination = destination;
		this.cost = cost;
	}
	
	
	public String getDestination()
	{
		return destination;
	}
	
	
	public float getCost()
	{
		return cost;
	}


	// Compare by cost, then by destination.
	public int compareTo(Mission that) 
	{ 		
		int compareCost = Float.compare(this.cost, that.cost);
		if(compareCost != 0)
			return compareCost;
		int compareDestination = this.destination.compareTo(that.destination);
		return compareDestination;

	}
	
	
	// Let compareTo() do the work. This method should just be 1 line.
	public boolean equals(Object x)
	{
		Mission that = (Mission) x;
		return this.compareTo(that) == 0;
	}
	
	
	// As you saw in lecture, create an ArrayList<Object>. Add destination and
	// cost to the list. Return the list's hash code.
	public int hashCode()
	{
		ArrayList<Object> list = new ArrayList<>();
		list.add(cost);
		list.add(destination);
		return list.hashCode();
		
	}
	
	
	public String toString()
	{
		return "Mission to " + destination + " will cost " + cost;
	}
	
	
	public static void main(String[] args)
	{
		Mission mission1 = new Mission("Bob", 5f);
		Mission mission2 = new Mission("Joe", 5.2f);
		Mission mission3 = new Mission("Bob", 5f);
		
		System.out.println(mission1.compareTo(mission2));
		System.out.println(mission1.equals(mission3));
		System.out.println(mission1.hashCode());
		System.out.println(mission2.hashCode());
		System.out.println(mission3.hashCode());
	}
}
