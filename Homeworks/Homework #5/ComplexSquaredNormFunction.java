package func;

// Implementation of the interface that generates a complex squared norm function.
public class ComplexSquaredNormFunction implements DoubleFunctionOfTwoInts {

	@Override
	// Treats x and y inputs as the components of a complex number x + bi and
	// returns the norm of (x + bi) * (x + bi).
	public double fOfXY(int x, int y) {
		Complex normSquaredComplex = new Complex(x, y);
		return Math.pow(normSquaredComplex.norm(), 2);
	}

	@Override
	// Returns the name of the function.
	public String getName() {
		return "Complex Squared Norm";
	}
}
