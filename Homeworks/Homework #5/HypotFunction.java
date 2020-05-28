package func;

// Implementation of the interface that generates a hypotenuse function.
public class HypotFunction implements DoubleFunctionOfTwoInts {

	@Override
	// Returns the hypotenuse of a right triangle whose legs have length x and y.
	public double fOfXY(int x, int y) {
		return Math.hypot(x, y);
	}

	@Override
	// Returns the name of the function.
	public String getName() {
		return "Hypot";
	}
}
