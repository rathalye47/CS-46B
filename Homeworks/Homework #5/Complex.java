package func;

public class Complex {
	private double real;
	private double imaginary;

	// Constructs an instance, given its real and imaginary components.
	public Complex(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	// Constructs an instance that duplicates source.
	public Complex(Complex source) {
		Complex otherSource = source;
	}

	// Getter method.
	public double getReal() {
		return this.real;
	}

	// Getter method.
	public double getImaginary() {
		return this.imaginary;
	}

	//
	// Constructs and returns a new instance of Complex that represents the sum of
	// its inputs,
	// according to the following formula:
	//
	// (a+bi) plus (c+di) = (a+c) + (b+d)i
	//
	public static Complex add(Complex c1, Complex c2) {
		Complex addComplex = new Complex(c1.getReal() + c2.getReal(), c1.getImaginary() + c2.getImaginary());
		return addComplex;
	}

	//
	// Constructs and returns a new instance of Complex that represents the product
	// of its inputs,
	// according to the following formula:
	//
	// (a+bi) times (c+di) = a*c + a*di + bi*c + bi*di = ac + (ad+bc)i + bd*ii
	// Since ii is -1 by definition, the last term is -bd ==> the result is ac-bd +
	// (ad+bc)i
	//
	public static Complex multiply(Complex c1, Complex c2) {
		double equation1 = (c1.getReal() * c2.getReal()) - (c1.getImaginary() * c2.getImaginary());
		double equation2 = (c1.getReal() * c2.getImaginary()) + (c1.getImaginary() * c2.getReal());
		Complex multiplyComplex = new Complex(equation1, equation2);
		return multiplyComplex;
	}

	//
	// The "norm" of complex number a+bi is the square root of (a^2 + b^2).
	//
	public double norm() {
		return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
	}
}
