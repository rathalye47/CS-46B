package func;

// Implementation of the interface that generates a subtraction function.
public class SubtractionFunction implements DoubleFunctionOfTwoInts {

	@Override
	// Returns x - y.
	public double fOfXY(int x, int y) {
		return x - y;
	}

	@Override
	// Returns the name of the function.
	public String getName() {
		return "Subtraction";
	}
}
