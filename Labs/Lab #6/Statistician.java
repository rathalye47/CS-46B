package bubble;

import java.util.*;


public class Statistician 
{
	private final static int N_REPETITIONS = 1000;
	
	private static void getStats(int arrayLength)
	{
		ArrayList<Long> visitCounts = new ArrayList<>();
		ArrayList<Long> swapCounts = new ArrayList<>();
		
		for (int i=0; i<N_REPETITIONS; i++)
		{
			int[] array = BubbleSortTestCaseMaker.buildRandom(arrayLength, arrayLength*100);
			BubbleSorter sorter = new BubbleSorter(array);
			sorter.sort();
			assert sorter.isSorted();
			visitCounts.add(sorter.getNVisits());
			swapCounts.add(sorter.getNSwaps());
		}

		// Compute and print min/average/max number of visits.
		Long[] countList = getCounts(visitCounts);
		System.out.println("visitCounts Min: " + countList[0]);
		System.out.println("visitCounts Average: " + countList[1]);
		System.out.println("visitCounts Max: " + countList[2]);
		
		// Compute and print min/average/max number of swaps.
		Long[] countList2 = getCounts(swapCounts);
		System.out.println("swapCounts Min: " + countList[0]);
		System.out.println("swapCounts Average: " + countList[1]);
		System.out.println("swapCounts Max: " + countList[2]);
	}
	
	
	public static Long[] getCounts(ArrayList<Long> list)
	{
		long min = Long.MAX_VALUE;
		long sum = 0;
		long max = Long.MIN_VALUE;
		for(long num : list)
		{
			if (num < min)
				min = num;
			sum += num;
			if (num > max)
				max = num;
		}
		Long[] countList = {
				min,
				sum / list.size(),
				max
				};
		return countList;
	}
	
	
	public static void main(String[] args)
	{
		System.out.println("1000:");
		getStats(1000);
		
		System.out.println("3000:");
		getStats(3000);
	}
}
