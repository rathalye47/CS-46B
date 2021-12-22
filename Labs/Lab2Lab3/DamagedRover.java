package transport;

public class DamagedRover extends MarsRover {
	private final static int MAX_TRAVEL_METERS_BEFORE_EMPTY_BATTERY = 10000;
	private final static int METERS_FROM_START_TO_CLIFF = 1000;
	private final static int N_SIMULATIONS = 500;

	private double metersTraveled; // Total meters traveled
									// back and forth.
	private boolean fell; // If true, an expensive loss.

	private void move(double distance, boolean forward) {
		/**
		if (forward) {
			super.changePositionBy(distance, 0);
		}
		
		else {
			super.changePositionBy(-distance, 0);
		}	
		*/
		
		super.changePositionBy(forward ? distance : -distance, 0);
	}

	//
	// Simulates travel under damage conditions. In each turn, travels forward or
	// backward either 1, 2, 3, or 4 meters. Continues until there's no more power
	// in the battery, or we fall off a cliff. Cliffs are at position = 1000 or
	// position = -1000.
	//
	public void simulateStormDamageTravel() {
		// Reset instance variables here
		super.setPosition(0, 0);
		metersTraveled = 0;
		fell = false;
		while (metersTraveled < MAX_TRAVEL_METERS_BEFORE_EMPTY_BATTERY && !fell) {
			double distanceNextTurn = (int) (1 + 4 * Math.random());
			boolean forwardNotBack = (Math.random() > 0.5);

			// Adjust position and metersTraveled.
			move(distanceNextTurn, forwardNotBack);
			metersTraveled += distanceNextTurn;
			// Check for falling off cliff. If Rover fell, set fell to true and
			// terminate (break out of) the loop.
			if (super.getXPosition() > METERS_FROM_START_TO_CLIFF
					|| super.getXPosition() < -1 * METERS_FROM_START_TO_CLIFF) {
				fell = true;
				// TERMINATE THE LOOP
			}
		}
	}

	public double getMetersTraveled() {
		return metersTraveled;
	}

	public boolean getFell() {
		return fell;
	}

	public static void main(String args[]) {
		DamagedRover dr = new DamagedRover();
		int timesFallen = 0;
		for (int i = 0; i < N_SIMULATIONS; i++) {
			dr.simulateStormDamageTravel();
			if (dr.getFell()) {
				timesFallen++;
			}
		}
		System.out.print(timesFallen);
	}
}
