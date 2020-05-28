package func;

// Implementation of the interface that generates a modulus function.
public class ModFunction implements DoubleFunctionOfTwoInts {

	@Override
	// Returns x modulo y.
	public double fOfXY(int x, int y) {
		if (y == 0) {
			y = 1;
		}

		return x % y;
	}

	@Override
	// Returns the name of the function.
	public String getName() {
		return "Mod";
	}
}
