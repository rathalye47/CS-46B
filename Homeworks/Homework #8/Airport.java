package airlines;

import java.util.*;

public class Airport implements Comparable<Airport> {
	private String name;
	private int x;
	private int y;
	private Set<Airport> connections; // all airports with a direct route from this airport

	public Airport(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
		connections = new TreeSet<>();
	}

	//
	// Gets the name of the airport.
	//
	public String getName() {
		return name;
	}

	//
	// Gets the x-position of the airport.
	//
	public int getX() {
		return x;
	}

	//
	// Gets the y-position of the airport.
	//
	public int getY() {
		return y;
	}

	//
	// Gets the list of all airports with a direct route from this airport.
	//
	public List<Airport> getConnections() {
		return new ArrayList<>(connections);
	}

	// Adds that airport to the list of connections. This is a one-way route, so
	// don't add this airport to that's list of connections.
	public void connectTo(Airport that) {
		connections.add(that);
	}

	//
	// Does nothing if this airport is not connected to that airport.
	//
	public void disconnectFrom(Airport that) {
		ArrayList<Airport> removed = new ArrayList<>();

		for (Airport air : connections) {
			if (air.equals(that)) {
				removed.add(air);
			}
		}

		connections.removeAll(removed);
	}

	//
	// Checks if 2 Airport objects are equal to each other.
	//
	public boolean equals(Object x) {
		Airport other = (Airport) x;
		return this.compareTo(other) == 0;
	}

	//
	// Compares Airport objects by their airport names.
	//
	public int compareTo(Airport that) {
		return this.name.compareTo(that.name);
	}

	//
	// Checks if that airport is in connections.
	//
	public boolean isConnectedTo(Airport that) {
		return connections.contains(that);
	}

	//
	// Gets the sum of the hashCodes.
	//
	public int hashCode() {
		ArrayList<Object> list = new ArrayList<>();
		list.add(name);
		list.add(x);
		list.add(y);
		return list.hashCode();
	}

	//
	// Overrides toString() from the Object superclass for easier readability.
	//
	public String toString() {
		return "Airport " + name + " @(" + x + "," + y + ")";
	}
}
