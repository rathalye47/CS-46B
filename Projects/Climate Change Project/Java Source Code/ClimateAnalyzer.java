package climatechange;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class ClimateAnalyzer implements IClimateAnalyzer {
	private ArrayList<ITemperature> dataValues;
	
	//
	// Instantiates a WeatherIO object and calls readDataFromFile() on it, allowing us to access any file we put in and store its contents
	// in an ArrayList.
	//
	public ClimateAnalyzer(String fileName) throws FileNotFoundException
	{
		WeatherIO data = new WeatherIO();
		dataValues = data.readDataFromFile(fileName); 					
	}
	
	//
	// Gets the String value of a month given an integer value. This maps integer values of months to String values of months, so when
	// the user inputs a numeric value of a month, it can be mapped to a String value, which can be used for comparisons of months in
	// the weather data file.
	//
	public String mapMonthsToStrings(int monthNum)
	{
		HashMap<Integer, String> integerMonthToStringMonth = new HashMap<Integer, String>();
		// Each integer key is unique and corresponds to a unique String value.
		integerMonthToStringMonth.put(1, "Jan");
		integerMonthToStringMonth.put(2, "Feb");
		integerMonthToStringMonth.put(3, "Mar");
		integerMonthToStringMonth.put(4, "Apr");
		integerMonthToStringMonth.put(5, "May");
		integerMonthToStringMonth.put(6, "Jun");
		integerMonthToStringMonth.put(7, "Jul");
		integerMonthToStringMonth.put(8, "Aug");
		integerMonthToStringMonth.put(9, "Sep");
		integerMonthToStringMonth.put(10, "Oct");
		integerMonthToStringMonth.put(11, "Nov");
		integerMonthToStringMonth.put(12, "Dec");
		
		String monthString = integerMonthToStringMonth.get(monthNum);
		return monthString;
	}
	
	//
	// Gets the lowest temperature reading for a specific country in a given month.
	//
	@Override
	public ITemperature getLowestTempByMonth(String country, int month) {
		double minTemperature = Double.MAX_VALUE; // Initial minimum temperature.
		ITemperature tempObject = null;
		for (ITemperature value : dataValues)
		{
			// Checks if the country name for each value in dataValues is equal to the user input country name and if the month for 
			// each value in dataValues is equal to the user input month.
			if (value.getCountry().equals(country) && value.getMonth().equals(mapMonthsToStrings(month)))
			{
				double temperature = value.getTemperature(false);
				if (temperature < minTemperature) // Checks if the value's temperature is less than the current minimum temperature.
				{
					minTemperature = temperature; // Updates the minimum temperature.
					tempObject = new Temperature(minTemperature, value.getYear(), value.getMonth(), country, value.getCountry3LetterCode());
					// Updates the tempObject whenever a new minimum temperature is found.
				}
			}
		}
				
		return tempObject;
	}

	//
	// Gets the highest temperature reading for a specific country in a given month.
	//
	@Override
	public ITemperature getHighestTempByMonth(String country, int month) {
		double maxTemperature = -1000.0; // Initial maximum temperature. Double.MIN_VALUE is positive, so it is greater than negative temperatures,
										 // and the maximum temperature would not be updated then. This is why I did not use Double.MIN_VALUE.
		ITemperature tempObject = null;
		for (ITemperature value : dataValues)
		{
			// Checks if the country name for each value in dataValues is equal to the user input country name and if the month for 
			// each value in dataValues is equal to the user input month.
			if (value.getCountry().equals(country) && value.getMonth().equals(mapMonthsToStrings(month)))
			{
				double temperature = value.getTemperature(false);
				if (temperature > maxTemperature) // Checks if the value's temperature is greater than the current maximum temperature.
				{
					maxTemperature = temperature; // Updates the maximum temperature.
					tempObject = new Temperature(maxTemperature, value.getYear(), value.getMonth(), country, value.getCountry3LetterCode());
					// Updates the tempObject whenever a new maximum temperature is found.
				}
			}
		}
				
		return tempObject;
	}

	//
	// Gets the lowest temperature reading for a specific country in a given year.
	//
	@Override
	public ITemperature getLowestTempByYear(String country, int year) {
		double minTemperature = Double.MAX_VALUE; // Initial minimum temperature.
		ITemperature tempObject = null;
		for (ITemperature value : dataValues)
		{
			// Checks if the country name for each value in dataValues is equal to the user input country name and if the year for 
			// each value in dataValues is equal to the user input year.
			if (value.getCountry().equals(country) && value.getYear() == year)
			{
				double temperature = value.getTemperature(false);
				if (temperature < minTemperature) // Checks if the value's temperature is less than the current minimum temperature.
				{
					minTemperature = temperature; // Updates the minimum temperature.
					tempObject = new Temperature(minTemperature, year, value.getMonth(), country, value.getCountry3LetterCode());
					// Updates the tempObject whenever a new minimum temperature is found.
				}
			}
		}
				
		return tempObject;	
	}

	//
	// Gets the highest temperature reading for a specific country in a given year.
	//
	@Override
	public ITemperature getHighestTempByYear(String country, int year) {
		double maxTemperature = -1000.0; // Initial maximum temperature. Double.MIN_VALUE is positive, so it is greater than negative temperatures,
		 								// and the maximum temperature would not be updated then. This is why I did not use Double.MIN_VALUE.
		ITemperature tempObject = null;
		for (ITemperature value : dataValues)
		{
			// Checks if the country name for each value in dataValues is equal to the user input country name and if the year for 
			// each value in dataValues is equal to the user input year.
			if (value.getCountry().equals(country) && value.getYear() == year)
			{
				double temperature = value.getTemperature(false);
				if (temperature > maxTemperature) // Checks if the value's temperature is greater than the current maximum temperature.
				{
					maxTemperature = temperature; // Updates the maximum temperature.
					tempObject = new Temperature(maxTemperature, year, value.getMonth(), country, value.getCountry3LetterCode());
					// Updates the tempObject whenever a new maximum temperature is found.
				}
			}
		}
				
		return tempObject;	
	}

	//
	// Gets all temperature data for a specific country that falls within a given temperature range sorted from lowest to highest temperature.
	//
	@Override
	public TreeSet<ITemperature> getTempWithinRange(String country, double rangeLowTemp, double rangeHighTemp) {
		TreeSet<ITemperature> tempsInRange = new TreeSet<ITemperature>();
		for (ITemperature value : dataValues)
		{
			// Checks if the country name for each value in dataValues is equal to the user input country name and if the temperature for
			// each value in dataValues falls within the user input temperature ranges.
			if (value.getCountry().equals(country) && (value.getTemperature(false) >= rangeLowTemp && value.getTemperature(false) <= rangeHighTemp))
			{
				ITemperature values = new Temperature(value.getTemperature(false), value.getYear(), value.getMonth(), country, value.getCountry3LetterCode());
				tempsInRange.add(values); // Adds the values object to the tempsInRange TreeSet. This is sorted from lowest to highest temperature.
			}
		}
		
		return tempsInRange;
	}

	//
	// Gets the lowest temperature reading amongst all data for a specific country.
	//
	@Override
	public ITemperature getLowestTempYearByCountry(String country) {
		double minTemperature = Double.MAX_VALUE; // Initial minimum temperature.
		ITemperature tempObject = null;
		for (ITemperature value : dataValues)
		{
			// Checks if the country name for each value in dataValues is equal to the user input country name.
			if (value.getCountry().equals(country))
			{
				double temperature = value.getTemperature(false);
				if (temperature < minTemperature) // Checks if the value's temperature is less than the current minimum temperature.
				{
					minTemperature = temperature; // Updates the minimum temperature.
					tempObject = new Temperature(minTemperature, value.getYear(), value.getMonth(), country, value.getCountry3LetterCode());
					// Updates the tempObject whenever a new minimum temperature is found.
				}
			}
		}
				
		return tempObject;
	}

	//
	// Gets the highest temperature reading amongst all data for a specific country.
	//
	@Override
	public ITemperature getHighestTempYearByCountry(String country) {
		double maxTemperature = -1000.0; // Initial maximum temperature. Double.MIN_VALUE is positive, so it is greater than negative temperatures,
										// and the maximum temperature would not be updated then. This is why I did not use Double.MIN_VALUE.
		ITemperature tempObject = null;
		for (ITemperature value : dataValues)
		{
			// Checks if the country name for each value in dataValues is equal to the user input country name.
			if (value.getCountry().equals(country))
			{
				double temperature = value.getTemperature(false);
				if (temperature > maxTemperature) // Checks if the value's temperature is greater than the current maximum temperature.
				{
					maxTemperature = temperature; // Updates the maximum temperature.
					tempObject = new Temperature(maxTemperature, value.getYear(), value.getMonth(), country, value.getCountry3LetterCode());
					// Updates the tempObject whenever a new maximum temperature is found.
				}
			}
		}
				
		return tempObject;
	}

	//
	// Gets the top 10 countries with the lowest temperature reading for a given month.
	//
	@Override
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp(int month) {
		ArrayList<Temperature> top10LowestTemps = new ArrayList<Temperature>();
		ArrayList<Temperature> allTemps = new ArrayList<Temperature>();
		ArrayList<ITemperature> updatedTop10LowestTemps = new ArrayList<ITemperature>();
		ArrayList<String> duplicateCountries = new ArrayList<String>();		
		int counter = 0;
		
		for (ITemperature value : dataValues)
		{
			// Checks if the month for each value in dataValues is equal to the user input month.
			if (value.getMonth().equals(mapMonthsToStrings(month)))
			{
				Temperature temp = new Temperature(value.getTemperature(false), value.getYear(), mapMonthsToStrings(month), value.getCountry(), value.getCountry3LetterCode());
				allTemps.add(temp); // Adds the temp object to allTemps ArrayList.
			}
		}
				
		Collections.sort(allTemps); // Sorts allTemps from lowest to highest temperature.
		
		// Finds the top 10 unique countries with the lowest temperatures.
		for (Temperature temp1 : allTemps)
		{
			// Checks if a country's data has not already been used by seeing if duplicateCountries does not contain the name of the country.
			if (!duplicateCountries.contains(temp1.getCountry()))
			{
				counter++;
				top10LowestTemps.add(temp1);
				duplicateCountries.add(temp1.getCountry()); // Adds the name of the country to duplicateCountries.
				
				if (counter == 10)
				{
					break; // Immediately terminates the for loop when 10 unique countries and their lowest temperatures are found.
				}
			}
						
		}
		
		// Adds every element of top10LowestTemps to updatedTop10LowestTemps, an ArrayList<ITemperature> which is the required return type.
		for (int i = 0; i <= top10LowestTemps.size() - 1; i++)
		{
			updatedTop10LowestTemps.add(top10LowestTemps.get(i));
		}
		
		return updatedTop10LowestTemps;
	}

	//
	// Gets the top 10 countries with the highest temperature reading for a given month.
	//
	@Override
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp(int month) {
		ArrayList<Temperature> top10HighestTemps = new ArrayList<Temperature>();
		ArrayList<Temperature> allTemps = new ArrayList<Temperature>();
		ArrayList<ITemperature> updatedTop10HighestTemps = new ArrayList<ITemperature>();
		ArrayList<String> duplicateCountries = new ArrayList<String>();
		int counter = 0;
		
		for (ITemperature value : dataValues)
		{
			// Checks if the month for each value in dataValues is equal to the user input month.
			if (value.getMonth().equals(mapMonthsToStrings(month)))
			{
				Temperature temp = new Temperature(value.getTemperature(false), value.getYear(), mapMonthsToStrings(month), value.getCountry(), value.getCountry3LetterCode());
				allTemps.add(temp); // Adds the temp object to allTemps ArrayList.			 
			}
			
		}
		
		Collections.sort(allTemps, Collections.reverseOrder()); // Sorts allTemps from highest to lowest temperature.	
		
		// Finds the top 10 unique countries with the highest temperatures.
		for (Temperature temp1 : allTemps)
		{
			// Checks if a country's data has not already been used by seeing if duplicateCountries does not contain the name of the country.
			if (!duplicateCountries.contains(temp1.getCountry()))
			{
				counter++;
				top10HighestTemps.add(temp1);
				duplicateCountries.add(temp1.getCountry()); // Adds the name of the country to duplicateCountries.
				
				if (counter == 10)
				{
					break; // Immediately terminates the for loop when 10 unique countries and their highest temperatures are found.
				}
			}
						
		}
		
		Collections.sort(top10HighestTemps); // Sorts the highest temperatures in top10HighestTemps from lowest to highest temperature.
		
		// Adds every element of top10HighestTemps to updatedTop10HighestTemps, an ArrayList<ITemperature> which is the required return type.
		for (int i = 0; i <= top10HighestTemps.size() - 1; i++)
		{
			updatedTop10HighestTemps.add(top10HighestTemps.get(i));
		}
		
		return updatedTop10HighestTemps;		
	}

	//
	// Gets the top 10 countries with the lowest temperature reading.
	//
	@Override
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp() {
		ArrayList<Temperature> top10LowestTemps = new ArrayList<Temperature>();
		ArrayList<Temperature> allTemps = new ArrayList<Temperature>();
		ArrayList<ITemperature> updatedTop10LowestTemps = new ArrayList<ITemperature>();
		ArrayList<String> duplicateCountries = new ArrayList<String>();		
		int counter = 0;
		
		
		for (ITemperature value : dataValues)
		{
			
			Temperature temp = new Temperature(value.getTemperature(false), value.getYear(), value.getMonth(), value.getCountry(), value.getCountry3LetterCode());
			allTemps.add(temp);	// Adds every temp object to allTemps ArrayList.		
		}
				
		Collections.sort(allTemps); // Sorts allTemps from lowest to highest temperature.
		
		// Finds the top 10 unique countries with the lowest temperatures.
		for (Temperature temp1 : allTemps)
		{
			// Checks if a country's data has not already been used by seeing if duplicateCountries does not contain the name of the country.
			if (!duplicateCountries.contains(temp1.getCountry()))
			{
				counter++;
				top10LowestTemps.add(temp1);
				duplicateCountries.add(temp1.getCountry()); // Adds the name of the country to duplicateCountries.
				
				if (counter == 10)
				{
					break; // Immediately terminates the for loop when 10 unique countries and their lowest temperatures are found.
				}
			}
						
		}
		
		// Adds every element of top10LowestTemps to updatedTop10LowestTemps, an ArrayList<ITemperature> which is the required return type.
		for (int i = 0; i <= top10LowestTemps.size() - 1; i++)
		{
			updatedTop10LowestTemps.add(top10LowestTemps.get(i));
		}
		
		return updatedTop10LowestTemps;
	}

	//
	// Gets the top 10 countries with the highest temperature reading.
	//
	@Override
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp() {
		ArrayList<Temperature> top10HighestTemps = new ArrayList<Temperature>();
		ArrayList<Temperature> allTemps = new ArrayList<Temperature>();
		ArrayList<ITemperature> updatedTop10HighestTemps = new ArrayList<ITemperature>();
		ArrayList<String> duplicateCountries = new ArrayList<String>();
		int counter = 0;
		
		for (ITemperature value : dataValues)
		{
			Temperature temp = new Temperature(value.getTemperature(false), value.getYear(), value.getMonth(), value.getCountry(), value.getCountry3LetterCode());
			allTemps.add(temp);	// Adds the temp object to allTemps ArrayList.				
		}
		
		Collections.sort(allTemps, Collections.reverseOrder());	// Sorts allTemps from highest to lowest temperature.	
		
		// Finds the top 10 unique countries with the highest temperatures.
		for (Temperature temp1 : allTemps)
		{
			// Checks if a country's data has not already been used by seeing if duplicateCountries does not contain the name of the country.
			if (!duplicateCountries.contains(temp1.getCountry()))
			{
				counter++;
				top10HighestTemps.add(temp1);
				duplicateCountries.add(temp1.getCountry()); // Adds the name of the country to duplicateCountries.
				
				if (counter == 10)
				{
					break; // Immediately terminates the for loop when 10 unique countries and their highest temperatures are found.
				}
			}
						
		}
		
		Collections.sort(top10HighestTemps); // Sorts the highest temperatures in top10HighestTemps from lowest to highest temperature.
		
		// Adds every element of top10HighestTemps to updatedTop10HighestTemps, an ArrayList<ITemperature> which is the required return type.
		for (int i = 0; i <= top10HighestTemps.size() - 1; i++)
		{
			updatedTop10HighestTemps.add(top10HighestTemps.get(i));
		}
		
		return updatedTop10HighestTemps;	
	}

	//
	// Gets all temperature data for all countries that fall within a specific temperature range.
	//
	@Override
	public ArrayList<ITemperature> allCountriesGetAllDataWithinTempRange(double lowRangeTemp, double highRangeTemp) {
		ArrayList<ITemperature> updatedTempsInRange = new ArrayList<ITemperature>();
		ArrayList<Temperature> tempsInRange = new ArrayList<Temperature>();
		
		for (ITemperature value : dataValues)
		{
			// Checks if each value's temperature in dataValues is within the temperature range of the user input.
			if (value.getTemperature(false) >= lowRangeTemp && value.getTemperature(false) <= highRangeTemp)
			{
				Temperature values = new Temperature(value.getTemperature(false), value.getYear(), value.getMonth(), value.getCountry(), value.getCountry3LetterCode());
				tempsInRange.add(values); // Adds the values object to tempsInRange ArrayList.
			}
		}
		
		Collections.sort(tempsInRange); // Sorts tempsInRange from lowest to highest temperature.
		
		// Adds every element of tempsInRange to updatedTempsInRange, an ArrayList<ITemperature> which is the required return type.
		for (int index = 0; index <= tempsInRange.size() - 1; index++)
		{
			updatedTempsInRange.add(tempsInRange.get(index));
		}
		
		return updatedTempsInRange;
	}

	//
	// Gets the top 10 countries with the largest change in temperature in the same month between two different years.
	//
	@Override
	public ArrayList<ITemperature> allCountriesTop10TempDelta(int month, int year1, int year2) {
		ArrayList<ITemperature> updatedDeltaTemps = new ArrayList<ITemperature>();
		ArrayList<Temperature> allMonthsAndYear1 = new ArrayList<Temperature>();
		ArrayList<Temperature> allMonthsAndYear2 = new ArrayList<Temperature>();
		ArrayList<Temperature> deltaTemps = new ArrayList<Temperature>();
		
		for (ITemperature value : dataValues)
		{
			// Checks if the month for every value in dataValues is equal to the user input month and if the first year for every value in
			// dataValues is equal to the user input first year.
			if (value.getMonth().equals(mapMonthsToStrings(month)) && value.getYear() == year1)
			{
				Temperature values = new Temperature(value.getTemperature(false), Math.abs(year2 - year1), value.getMonth(), value.getCountry(), value.getCountry3LetterCode());
				allMonthsAndYear1.add(values); // Adds all data that matches the given month and year1 to allMonthsAndYear1 ArrayList.			
			}
		}
		
		for (ITemperature value1 : dataValues)
		{
			// Checks if the month for every value in dataValues is equal to the user input month and if the second year for every value in
			// dataValues is equal to the user input second year.
			if (value1.getMonth().equals(mapMonthsToStrings(month)) && value1.getYear() == year2)
			{
				Temperature values1 = new Temperature(value1.getTemperature(false), Math.abs(year2 - year1), value1.getMonth(), value1.getCountry(), value1.getCountry3LetterCode());
				allMonthsAndYear2.add(values1); // Adds all data that matches the given month and year2 to allMonthsAndYear2 ArrayList.	
			}
		}
		
		for (int i = 0; i <= allMonthsAndYear2.size() - 1; i++)
		{
			// Since allMonthsAndYear1 and allMonthsAndYear2 are based on the order of insertion into the ArrayList, this checks if each
			// country in allMonthsAndYear1 is equal to the country in allMonthsAndYear2, so the data in both ArrayLists match each other.
			if (allMonthsAndYear1.get(i).getCountry().equals(allMonthsAndYear2.get(i).getCountry()))
			{
				// The temperature is now the change in temperature in the same country between 2 different years in the same month.
				// The year is the difference between the 2 years (year2 - year1).
				Temperature values2 = new Temperature(Math.abs(allMonthsAndYear2.get(i).getTemperature(false) - allMonthsAndYear1.get(i).getTemperature(false)), Math.abs(year2 - year1), mapMonthsToStrings(month), allMonthsAndYear2.get(i).getCountry(), allMonthsAndYear2.get(i).getCountry3LetterCode());
				deltaTemps.add(values2); // Adds the values2 object to deltaTemps ArrayList.
			}			
		}
		
		Collections.sort(deltaTemps); // Sorts deltaTemps from lowest to highest temperature change.
		
		// Gets the last 10 elements in deltaTemps, which consist of the highest temperature changes, and adds them to updatedDeltaTemps,
		// which is an ArrayList<ITemperature> and is the required return type.
		for (int i = deltaTemps.size() - 10; i <= deltaTemps.size() - 1; i++)
		{
			updatedDeltaTemps.add(deltaTemps.get(i));
		}
		
		return updatedDeltaTemps;
	}

	// 
	// Starts the climate-change task activities, asking the user to enter input when needed and writing the results to data files.
	//
	@Override
	public void runClimateAnalyzer() throws IOException {
		WeatherIO wIO = new WeatherIO();	
		Scanner scan = new Scanner(System.in);
		
		// A HashSet of Strings that contains all the names of the countries from the weather data file and will be used to check 
		// that the user did not input any invalid country name.
		HashSet<String> allCountries = new HashSet<String>();
		for (ITemperature value : dataValues)
		{
			allCountries.add(value.getCountry());
		}
		
		// An ArrayList of Integers that contains all the possible months as integers and will be used to check that the user did not
		// input an invalid month.
		ArrayList<Integer> allMonths = new ArrayList<Integer>();		
		for (int i = 1; i <= 12; i++)
		{
			allMonths.add(i);
		}
		
		// An ArrayList of Integers that contains all the possible years as integers and will be used to check that the user did not
		// input an invalid year.
		ArrayList<Integer> allYears = new ArrayList<Integer>();		
		for (int i = 2000; i <= 2016; i++)
		{
			allYears.add(i);
		}
		
		System.out.println("Task A1 - Get the Lowest and Highest Temperatures By Month for a Country");
		String country;
		
		do
		{
			System.out.print("Enter the name of the country: ");
			country = scan.nextLine();
		}
				
		while (!allCountries.contains(country)); // Makes sure that the user input country name is valid. If not, the user will be prompted to enter input again.
		
		int month;
		
		do
		{
			System.out.print("Enter a numeric value of the month from 1 to 12: ");
			
			// If the user input month is not an integer, the user will be prompted to enter a valid month as an integer again.
			while (!scan.hasNextInt())
			{
				System.out.println("This month is not an integer. Please try again.");
				scan.next();
			}
			
			month = scan.nextInt();
		}
		
		while (!allMonths.contains(month)); // Makes sure that the user input month is an integer from 1 to 12. If not, the user will be prompted to enter input again.
					
		ArrayList<ITemperature> taskA1_1 = new ArrayList<ITemperature>();
		ITemperature taskA1_1Obj = getLowestTempByMonth(country, month); // Calls getLowestTempByMonth() passing in user input.
		taskA1_1.add(taskA1_1Obj);
		// Writes the subject header for Task A1_1.
		wIO.writeSubjectHeaderInFile("data/taskA1_climate_info.csv", "Task A1_1: Lowest Temperature for " + country + " in " + mapMonthsToStrings(month));
		// Writes the data for Task A1_1.
		wIO.writeDataToFile("data/taskA1_climate_info.csv", "Temperature, " + "Year, " + "Month, " + "Country, " + "Country_Code", taskA1_1);
		
		ArrayList<ITemperature> taskA1_2 = new ArrayList<ITemperature>();
		ITemperature taskA1_2Obj = getHighestTempByMonth(country, month); // Calls getHighestTempByMonth() passing in user input.
		taskA1_2.add(taskA1_2Obj);
		// Writes the subject header for Task A1_2.
		wIO.writeSubjectHeaderInFile("data/taskA1_climate_info.csv", "Task A1_2: Highest Temperature for " + country + " in " + mapMonthsToStrings(month));
		// Writes the data for Task A1_2.
		wIO.writeDataToFile("data/taskA1_climate_info.csv", "Temperature, " + "Year, " + "Month, " + "Country, " + "Country_Code", taskA1_2);
		
		System.out.println("Task A2 - Get the Lowest and Highest Temperatures By Year for a Country");
		// The same country the user inputted in Task A-1 will also be used here.
		int year;
		
		do
		{
			System.out.print("Enter a numeric value of the year from 2000 to 2016: ");
			
			// If the user input year is not an integer, the user will be prompted to enter a valid year as an integer again.
			while (!scan.hasNextInt())
			{
				System.out.println("This year is not an integer. Please try again.");
				scan.next();
			}
			
			year = scan.nextInt();
		}
		
		while (!allYears.contains(year)); // Makes sure that the user input year is an integer from 2000 to 2016. If not, the user will be prompted to enter input again.
		
		ArrayList<ITemperature> taskA2_1 = new ArrayList<ITemperature>();
		ITemperature taskA2_1Obj = getLowestTempByYear(country, year); // Calls getLowestTempByYear() passing in user input.
		taskA2_1.add(taskA2_1Obj);
		// Writes the subject header for Task A2_1.
		wIO.writeSubjectHeaderInFile("data/taskA2_climate_info.csv", "Task A2_1: Lowest Temperature for " + country + " in " + year);
		// Writes the data for Task A2_1.
		wIO.writeDataToFile("data/taskA2_climate_info.csv", "Temperature, " + "Year, " + "Month, " + "Country, " + "Country_Code", taskA2_1);
		
		ArrayList<ITemperature> taskA2_2 = new ArrayList<ITemperature>();
		ITemperature taskA2_2Obj = getHighestTempByYear(country, year); // Calls getHighestTempByYear() passing in user input.
		taskA2_2.add(taskA2_2Obj);
		// Writes the subject header for Task A2_2.
		wIO.writeSubjectHeaderInFile("data/taskA2_climate_info.csv", "Task A2_2: Highest Temperature for " + country + " in " + year);
		// Writes the data for Task A2_2.
		wIO.writeDataToFile("data/taskA2_climate_info.csv", "Temperature, " + "Year, " + "Month, " + "Country, " + "Country_Code", taskA2_2);
		
		System.out.println("Task A3 - Get all Data that falls within a Specific Temperature Range for a Country");
		// The same country the user inputted in Task A-1 will also be used here.
		double lowTemp;
		double highTemp;
		
		System.out.print("Enter the Lowest Temperature in Celsius: ");
		
		// If the user input lowTemp is not a double, the user will be prompted to enter a valid lowTemp as a double again.
		while (!scan.hasNextDouble())
		{
			System.out.println("This lowest temperature is not a double value. Please try again.");
			scan.next();
		}
		
		lowTemp = scan.nextDouble();
		
		do
		{	
			System.out.print("Enter the Highest Temperature in Celsius: ");
			
			// If the user input highTemp is not a double, the user will be prompted to enter a valid highTemp as a double again.
			while (!scan.hasNextDouble())
			{
				System.out.println("This highest temperature is not a double value. Please try again.");
				scan.next();
			}
			
			highTemp = scan.nextDouble();
		}
		
		while (lowTemp >= highTemp); // Checks to make sure the lowTemp is less than the highTemp. If not, the user will be prompted to enter input, specifically highTemp, again.
			
		TreeSet<ITemperature> taskA3 = new TreeSet<ITemperature>();
		taskA3 = getTempWithinRange(country, lowTemp, highTemp); // Calls getTempsWithinRange() passing in user input.
		ArrayList<ITemperature> rangeTemps = new ArrayList<ITemperature>();
		
		// Adds each value of taskA3 to rangeTemps, which is an ArrayList<ITemperature> and is one of the required arguments in
		// writeDataToFile().
		for (ITemperature value : taskA3)
		{
			rangeTemps.add(value);
		}
		
		// Writes the subject header for Task A3.
		wIO.writeSubjectHeaderInFile("data/taskA3_climate_info.csv", "Task A3: Temperatures for " + country + " within " + lowTemp + "-" + highTemp);
		// Writes the data for Task A3.
		wIO.writeDataToFile("data/taskA3_climate_info.csv", "Temperature, " + "Year, " + "Month, " + "Country, " + "Country_Code", rangeTemps);
		
		System.out.println("Task A4 - Get the Lowest and Highest Temperatures for a Country");
		// The same country the user inputted in Task A-1 will also be used here.
		
		ArrayList<ITemperature> taskA4_1 = new ArrayList<ITemperature>();
		ITemperature taskA4_1Obj = getLowestTempYearByCountry(country); // Calls getLowestTempYearByCountry() passing in user input.
		taskA4_1.add(taskA4_1Obj);
		// Writes the subject header for Task A4_1.
		wIO.writeSubjectHeaderInFile("data/taskA4_climate_info.csv", "Task A4_1: Lowest Temperature for " + country);
		// Writes the data for Task A4_1.
		wIO.writeDataToFile("data/taskA4_climate_info.csv", "Temperature, " + "Year, " + "Month, " + "Country, " + "Country_Code", taskA4_1);
		
		ArrayList<ITemperature> taskA4_2 = new ArrayList<ITemperature>();
		ITemperature taskA4_2Obj = getHighestTempYearByCountry(country); // Calls getHighestTempYearByCountry() passing in user input.
		taskA4_2.add(taskA4_2Obj);
		// Writes the subject header for Task A4_2.
		wIO.writeSubjectHeaderInFile("data/taskA4_climate_info.csv", "Task A4_2: Highest Temperature for " + country);
		// Writes the data for Task A4_2.
		wIO.writeDataToFile("data/taskA4_climate_info.csv", "Temperature, " + "Year, " + "Month, " + "Country, " + "Country_Code", taskA4_2);
		
		System.out.println("Task B1 - The Top 10 Countries with the Lowest and Highest Temperatures for a given month");
		int month2;
		
		do
		{
			System.out.print("Enter a numeric value of the month from 1 to 12: ");
			
			// If the user input month is not an integer, the user will be prompted to enter a valid month as an integer again.
			while (!scan.hasNextInt())
			{
				System.out.println("This month is not an integer. Please try again.");
				scan.next();
			}
			
			month2 = scan.nextInt();
		}
		
		while (!allMonths.contains(month2)); // Makes sure that the user input month is an integer from 1 to 12. If not, the user will be prompted to enter input again.
		
		ArrayList<ITemperature> taskB1_1 = new ArrayList<ITemperature>();
		taskB1_1 = allCountriesGetTop10LowestTemp(month2); // Calls allCountriesGetTop10LowestTemp() passing in user input.
		// Writes the subject header for Task B1_1.
		wIO.writeSubjectHeaderInFile("data/taskB1_climate_info.csv", "Task B1_1: The Top 10 Countries with the Lowest Temperatures in " + mapMonthsToStrings(month2));
		// Writes the data for Task B1_1.
		wIO.writeDataToFile("data/taskB1_climate_info.csv", "Temperature, " + "Year, " + "Month, " + "Country, " + "Country_Code", taskB1_1);
		
		ArrayList<ITemperature> taskB1_2 = new ArrayList<ITemperature>();
		taskB1_2 = allCountriesGetTop10HighestTemp(month2); // Calls allCountriesGetTop10HighestTemp() passing in user input.
		// Writes the subject header for Task B1_2.
		wIO.writeSubjectHeaderInFile("data/taskB1_climate_info.csv", "Task B1_2: The Top 10 Countries with the Highest Temperatures in " + mapMonthsToStrings(month2));
		// Writes the data for Task B1_2.
		wIO.writeDataToFile("data/taskB1_climate_info.csv", "Temperature, " + "Year, " + "Month, " + "Country, " + "Country_Code", taskB1_2);
		
		System.out.println("Task B2 - The Top 10 Countries with the Lowest and Highest Temperatures");
		
		ArrayList<ITemperature> taskB2_1 = new ArrayList<ITemperature>();
		taskB2_1 = allCountriesGetTop10LowestTemp(); // Calls allCountriesGetTop10LowestTemp().
		// Writes the subject header for Task B2_1.
		wIO.writeSubjectHeaderInFile("data/taskB2_climate_info.csv", "Task B2_1: The Top 10 Countries with the Lowest Temperatures");
		// Writes the data for Task B2_1.
		wIO.writeDataToFile("data/taskB2_climate_info.csv", "Temperature, " + "Year, " + "Month, " + "Country, " + "Country_Code", taskB2_1);
		
		ArrayList<ITemperature> taskB2_2 = new ArrayList<ITemperature>();
		taskB2_2 = allCountriesGetTop10HighestTemp(); // Calls allCountriesGetTop10HighestTemp().
		// Writes the subject header for Task B2_2.
		wIO.writeSubjectHeaderInFile("data/taskB2_climate_info.csv", "Task B2_2: The Top 10 Countries with the Highest Temperatures");
		// Writes the data for Task B2_2.
		wIO.writeDataToFile("data/taskB2_climate_info.csv", "Temperature, " + "Year, " + "Month, " + "Country, " + "Country_Code", taskB2_2);
		
		System.out.println("Task B3 - All Countries that fall within a Specific Temperature Range");
		double lowRangeTemp;
		double highRangeTemp;
		
		System.out.print("Enter the Lowest Temperature in Celsius: ");
		
		// If the user input lowRangeTemp is not a double, the user will be prompted to enter a valid lowRangeTemp as a double again.
		while (!scan.hasNextDouble())
		{
			System.out.println("This lowest temperature is not a double value. Please try again.");
			scan.next();
		}
		
		lowRangeTemp = scan.nextDouble();
		
		do
		{
			System.out.print("Enter the Highest Temperature in Celsius: ");
			
			// If the user input highRangeTemp is not a double, the user will be prompted to enter a valid highRangeTemp as a double again.
			while (!scan.hasNextDouble())
			{
				System.out.println("This highest temperature is not a double value. Please try again.");
				scan.next();
			}
			
			highRangeTemp = scan.nextDouble();
		}
		
		while (lowRangeTemp >= highRangeTemp); // Checks to make sure the lowRangeTemp is less than the highRangeTemp. If not, the user will be prompted to enter input, specifically highRangeTemp, again.
		
		ArrayList<ITemperature> taskB3 = new ArrayList<ITemperature>();
		taskB3 = allCountriesGetAllDataWithinTempRange(lowRangeTemp, highRangeTemp); // Calls allCountriesGetAllDataWithinTempRange() passing in user input.
		// Writes the subject header for Task B3.
		wIO.writeSubjectHeaderInFile("data/taskB3_climate_info.csv", "Task B3: Temperatures for all Countries within " + lowRangeTemp + "-" + highRangeTemp);
		// Writes the data for Task B3.
		wIO.writeDataToFile("data/taskB3_climate_info.csv", "Temperature, " + "Year, " + "Month, " + "Country, " + "Country_Code", taskB3);
		
		System.out.println("Task C1 - The Top 10 Countries with the Largest Temperature Changes in the same month between 2 different years");
		int month3;
		
		do
		{
			System.out.print("Enter a numeric value of the month from 1 to 12: ");
			
			// If the user input month is not an integer, the user will be prompted to enter a valid month as an integer again.
			while (!scan.hasNextInt())
			{
				System.out.println("This month is not an integer. Please try again.");
				scan.next();
			}
			
			month3 = scan.nextInt();
		}
		
		while (!allMonths.contains(month3)); // Makes sure that the user input month is an integer from 1 to 12. If not, the user will be prompted to enter input again.
		
		int year1;
		
		do
		{
			System.out.print("Enter a numeric value of the first year from 2000 to 2016: ");
			
			// If the user input first year is not an integer, the user will be prompted to enter a valid first year as an integer again.
			while (!scan.hasNextInt())
			{
				System.out.println("This first year is not an integer. Please try again.");
				scan.next();
			}
			
			year1 = scan.nextInt();
		}
		
		while (!allYears.contains(year1)); // Makes sure that the user input first year is an integer from 2000 to 2016. If not, the user will be prompted to enter input again.
		
		int year2;
		
		do
		{
			System.out.print("Enter a numeric value of the second year from 2000 to 2016: ");
			
			// If the user input second year is not an integer, the user will be prompted to enter a valid second year as an integer again.
			while (!scan.hasNextInt())
			{
				System.out.println("This second year is not an integer. Please try again.");
				scan.next();
			}
			
			year2 = scan.nextInt();
		}
		
		while (!allYears.contains(year2) || year2 == year1); // Makes sure that the user input second year is an integer from 2000 to 2016 and year2 is not equal to year1. If not, the user will be prompted to enter input, specifically year2, again.
		
		ArrayList<ITemperature> taskC1 = new ArrayList<ITemperature>();
		taskC1 = allCountriesTop10TempDelta(month3, year1, year2); // Calls allCountriesTop10TempDelta passing in user input.
		// Writes the subject header for Task C1.
		wIO.writeSubjectHeaderInFile("data/taskC1_climate_info.csv", "Task C1: The Top 10 Countries with the Largest Temperature Changes in " + mapMonthsToStrings(month3) + " between " + year1 + " and " + year2);
		// Writes the data for Task C1.
		wIO.writeDataToFile("data/taskC1_climate_info.csv", "Delta Temperature, " + "Delta Year, " + "Month, " + "Country, " + "Country_Code", taskC1);
		
		scan.close(); // Closes the scanner.
	}
	
	//
	// Tests the runClimateAnalyzer() method.
	//
	public static void main(String[] args) throws IOException
	{
		ClimateAnalyzer cAnalyzer = new ClimateAnalyzer("data/world_temp_2000-2016.csv"); // Any data file can be passed in here for testing.
		cAnalyzer.runClimateAnalyzer();
	}
}
