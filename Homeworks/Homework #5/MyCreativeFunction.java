package func;

// Implementation of the interface that generates a creative function.
public class MyCreativeFunction implements DoubleFunctionOfTwoInts {

	// A unique and creative function designed by me.
	public double fOfXY(int x, int y) {
		double result = Math.cos(x) * Math.sin(y);

		if (result > -0.5) {
			return result * Math.tan(x * y);
		}

		Complex myComplex = new Complex(x, y);
		return result * myComplex.norm();
	}

	// Returns the name of the function.
	public String getName() {
		return "My Creation";
	}
}
