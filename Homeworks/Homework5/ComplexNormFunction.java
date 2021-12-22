package func;

// Implementation of the interface that generates a complex norm function.
public class ComplexNormFunction implements DoubleFunctionOfTwoInts {

	@Override
	// Treats x and y inputs as the components of x + bi and returns the norm of
	// that complex number.
	public double fOfXY(int x, int y) {
		Complex normComplex = new Complex(x, y);
		return normComplex.norm();
	}

	@Override
	// Returns the name of the function.
	public String getName() {
		return "Complex Norm";
	}
}
