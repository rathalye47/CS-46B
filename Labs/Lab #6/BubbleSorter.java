package bubble;

public class BubbleSorter 
{
	private int[]		a;
	private long		nVisits;
	private long		nSwaps;
	
	
	public BubbleSorter(int[] a)
	{
		this.a = a; 
	}
	
	
	public void sort()
	{
		for (int n = a.length - 1; n >= 0; n--)
		{
			for (int i = n - 1; i >= 0; i--)
			{
				// Increment number of visits by 2.
				nVisits += 2;
				if (a[n] < a[i])
				{
					int temp = a[n];
					a[n] = a[i];
					a[i] = temp;
					nSwaps++;
				}
			}
		}
	}
	
	
	public String toString()
	{
		String s = nVisits + " visits, " + nSwaps + " swaps\n{";
		for (int n: a)
			s += " " + n;
		s += " }";
		return s;
	}
	
	
	public boolean isSorted()
	{
		for(int i = 0; i <= a.length - 2; i++)
			if(!(a[i] <= a[i + 1]))
				return false;
		return true;
	}
	
	
	public long getNVisits()
	{
		return nVisits;
	}
	
	
	public long getNSwaps()
	{
		return nSwaps;
	}
	
	
	public int[] getArray()
	{
		return a;
	}
	
	
	public static void main(String[] args)
	{
		//getTiny(); getAlreadySorted(); getBackward();
		int[] a = BubbleSortTestCaseMaker.getBackward();
		
		BubbleSorter sorter = new BubbleSorter(a);
		sorter.sort();
		System.out.println(sorter);
		System.out.println(sorter.isSorted()  ?  "SORTED"  :  "NOT SORTED");
	}
}
