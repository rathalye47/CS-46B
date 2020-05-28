package space;

import java.util.*;


/*
 * During iteration, missions that cost < $1 trillion (1e12) are presented in insertion order.
 * Then expensive missions (that cost >= $1 trillion) are presented in the natural sorting order
 * of the Mission class.
 */


public class MissionOrganizer implements Iterable<Mission>
{
	private final static float			ONE_TRILLION = 1.0e12f;
	
	// Insert declarations for 2 collections: 1 for cheap missions, 1 for expensive missions.
	private ArrayList<Mission> 			cheapMissions;
	private TreeSet<Mission> 			expensiveMissions;
	
	
	MissionOrganizer()
	{
		// Create the 2 mission collections.
		cheapMissions = new ArrayList<>();
		expensiveMissions = new TreeSet<>();
	}
	
	
	// Returns true if either cheapMissions or expensiveMissions contains m.
	public boolean contains(Mission m)
	{
		return cheapMissions.contains(m) || expensiveMissions.contains(m);
	}
	
	
	// Only adds if mission is not yet contained in this collection. Adds to
	// cheapMissions or expensiveMissions, depending on whether the mission's
	// cost is < $1 trillion or >= $1 trillion.
	public void add(Mission mission)
	{
		if(!this.contains(mission))
		{
			if(mission.getCost() < ONE_TRILLION)
				cheapMissions.add(mission);
			else
				expensiveMissions.add(mission);
		}
	}
	
	
	// Create an ArrayList<Mission>. Add all the cheap missions to the ArrayList; then
	// add all the expensive missions. (Hint: look in the API page for ArrayList for a
	// method that adds all members of a collection.) The ArrayList will then contain
	// all the missions, in the desired order. Return the ArrayList's iterator. This
	// technique was shown in lecture, in the presentation of the Roster class, and will
	// be on the final exam.
	public Iterator<Mission> iterator()
	{
		ArrayList<Mission> allMissions = new ArrayList<>(cheapMissions);
		allMissions.addAll(expensiveMissions);
		return allMissions.iterator();

	}
	
	
	
	
	// All costs are uneducated guesses.
	private final static Mission[]		TEST_MISSIONS =
	{
        new Mission("Alderaan", 1E16f),
        new Mission("High Earth Orbit", 3E8f),
        new Mission("Moon", 2.5E10f),
        new Mission("Alpha Centauri", 1E14f),
        new Mission("Asteroids", 7E11f),
        new Mission("Uranus", 9E11f),
        new Mission("Jupiter", 2E11f),
        new Mission("Low Earth Orbit", 1E8f),
        new Mission("Cetaganda", 13E16f),
        new Mission("Mars", 8E10f),
        new Mission("Neptune", 1.0E12f),
        new Mission("Barrayar", 1E16f),
        new Mission("Saturn", 8E11f),
        new Mission("Venus", 7.23E9f), // cheap
        new Mission("Mercury", 8.33E11f), // cheap
        new Mission("Sun", 9.99999E15f), // expensive
        new Mission("Black Hole", 2.8E22f), // expensive
	};
	
	
	public static void main(String[] args)
	{

		MissionOrganizer organizer = new MissionOrganizer();
		for (Mission m: TEST_MISSIONS)
			organizer.add(m);
		
		for (Mission m: organizer)
			System.out.println(m);
	}
	
/*
Expected output:
	 
Mission to High Earth Orbit will cost 3.0E8
Mission to Moon will cost 2.49999995E10
Mission to Asteroids will cost 6.9999998E11
Mission to Uranus will cost 8.9999999E11
Mission to Jupiter will cost 1.99999996E11
Mission to Low Earth Orbit will cost 1.0E8
Mission to Mars will cost 8.0E10
Mission to Saturn will cost 7.9999998E11
new Mission to Venus will cost 7.23E9
new Mission to Mercury will cost 8.33E11
Mission to Neptune will cost 1.0E12
Mission to Alpha Centauri will cost 1.0E14
new Mission to Sun will cost 9.99999E15
Mission to Alderaan will cost 1.00000003E16
Mission to Barrayar will cost 1.00000003E16
Mission to Cetaganda will cost 1.30000001E17	 
new Mission to Black Hole will cost 2.8E22
*/
}
