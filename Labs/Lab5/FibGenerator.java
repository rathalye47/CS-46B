package recursion_techniques;

public class FibGenerator {
	
	private int[] callCounter;
	
	public int nthFib(int n)
	{
		callCounter = new int[n + 1];
		return computeFibRecurse(n);
	}
	
	private	int	computeFibRecurse(int n)
	{
		if (n == 1 || n == 2)
		{
			return 1;
		}
		
		callCounter[n-1] += 1;
		callCounter[n-2] += 1;
		
		return computeFibRecurse(n - 1) + computeFibRecurse(n - 2);
		
	}
	
	public void printCallCounter()
	{
		for (int i = 0; i < 21; i++)
		{
			System.out.println(callCounter[i] + " calls to fib(" + i + ")");
		}
	}
	
	public static void main(String[] args)
	{
		FibGenerator fibG = new FibGenerator();
		System.out.println("STARTING");
		
		for (int i = 1; i <= 20; i++)
		{
			System.out.println(i + " Fibonacci value: " + fibG.nthFib(i));
		}
		
		System.out.println("DONE");
		
		fibG.printCallCounter();
		
	}
	

}
