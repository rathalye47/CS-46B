package cast;

public class Primitives {
	public static void dumpMaxValues() {
		System.out.println("Byte Maximum Value " + Byte.MAX_VALUE);
		System.out.println("Short Maximum Value " + Short.MAX_VALUE);
		System.out.println("Integer Maximum Value " + Integer.MAX_VALUE);
		System.out.println("Long Maximum Value " + Long.MAX_VALUE);
		System.out.println("Float Maximum Value " + Float.MAX_VALUE);
		System.out.println("Double Maximum Value " + Double.MAX_VALUE);
	}

	public static void main(String[] args) {
		dumpMaxValues();
		// long to int.
		long l = Long.MAX_VALUE;
		int i = (int) l;
		System.out.println("long to int: " + l + ", " + i);

		// long to int.
		long l1 = Long.MAX_VALUE - 5;
		int i1 = (int) l1;
		System.out.println("long to int: " + l1 + ", " + i1);

		// int to long.
		int i2 = Integer.MAX_VALUE;
		long l2 = i2;
		System.out.println("int to long: " + i2 + ", " + l2);

		// byte to double.
		byte b = 100;
		double d1 = b;
		System.out.println("byte to double: " + b + ", " + d1);

		// double to byte.
		double d2 = 45.67;
		byte b1 = (byte) d2;
		System.out.println("double to byte: " + d2 + ", " + b1);

		// double to byte.
		double d3 = 456.789;
		byte b2 = (byte) d3;
		System.out.println("double to byte: " + d3 + ", " + b2);

		// float to long.
		float f1 = 12345.6789f;
		long l3 = (long) f1;
		System.out.println("float to long: " + f1 + ", " + l3);

		// float to long.
		float f2 = Float.MAX_VALUE;
		long l4 = (long) f2;
		System.out.println("float to long: " + f2 + ", " + l4);

		// long to float.
		long l5 = Long.MAX_VALUE;
		float f3 = l5;
		System.out.println("long to float: " + l5 + ", " + f3);

	}

}
