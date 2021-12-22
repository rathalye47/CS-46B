package recursion_techniques;

public class FactorialGenerator {
	
	public double nthFactorial(int n)
	{
		return computeFactorialRecurse(n);
	}
	
	private	double computeFactorialRecurse(int n)
	{
		assert n >= 0 : "Illegal n: " + n;
		
		if (n == 0)
		{
			return 1;
		}
		
		return n * computeFactorialRecurse(n - 1);
	}
	
	public static void main(String[] args)
	{
		FactorialGenerator fg = new FactorialGenerator();
		
		/**
		for (int i = 1; i <= 32; i++)
		{
			System.out.println(i + "!:" + " " + fg.nthFactorial(i));
		}
		
		System.out.println(Long.MAX_VALUE);
		*/
		
		System.out.println(fg.nthFactorial(-1));
	}
}
