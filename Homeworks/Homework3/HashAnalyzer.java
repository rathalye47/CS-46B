package movies;

//Analyzes the efficiency of a HashSet.
public class HashAnalyzer {
	
	//Creates 100,000 fake movies and puts them into a HashFilmArchive.
	public static void main(String[] args) {
		HashFilmArchive archive = new HashFilmArchive();
		for (int i = 0; i < 100000; i++) {
			archive.add(new Movie("Movie" + i, 2020));
			if (i % 1000 == 0)
				System.out.println(i);
		}
		System.out.println("DONE");
	}

}
