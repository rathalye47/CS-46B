package airlines;

import java.util.HashSet;

public class FlightNet extends HashSet<Airport> {

	//
	// Returns true if the FlightNet doesn't contain an airport with the given name.
	// Otherwise, returns false.
	//
	public boolean nameIsAvailable(String name) {
		for (Airport air : this) {
			if (air.getName().equals(name)) {
				return false;
			}
		}

		return true;
	}

	//
	// Connects a1 and a2 in both directions.
	//
	public void connect(Airport a1, Airport a2) {
		a1.connectTo(a2);
		a2.connectTo(a1);
	}

	//
	// Disconnects a1 and a2 in both directions.
	//
	public void disconnect(Airport a1, Airport a2) {
		a1.disconnectFrom(a2);
		a2.disconnectFrom(a1);
	}

	//
	// Removes removeMe from FlightNet and disconnects it from any airports in
	// FlightNet.
	//
	public void removeAndDisconnect(Airport removeMe) {
		this.remove(removeMe);

		for (Airport air : this) {
			if (air.isConnectedTo(removeMe)) {
				air.disconnectFrom(removeMe);
			}
		}
	}

	//
	// Returns the first airport whose (x, y) location is within maximumDistance of
	// the given (x, y). Otherwise, returns null if there are no airports within
	// maximumDistance.
	//
	public Airport getAirportNearXY(int x, int y, int maximumDistance) {
		for (Airport air : this) {
			int xDistance = Math.abs(air.getX() - x);
			int yDistance = Math.abs(air.getY() - y);
			double airportDistance = Math.hypot(xDistance, yDistance);

			if (airportDistance <= maximumDistance) {
				return air;
			}
		}

		return null;
	}
}
