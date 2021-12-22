package movies;

//Analyzes the efficiency of an ArrayList.
public class ListAnalyzer {
	
	//Creates 100,000 fake movies and puts them into a ListFilmArchive.
	public static void main(String[] args) {
		ListFilmArchive archive = new ListFilmArchive();
		for (int i = 0; i < 100000; i++) {
			archive.add(new Movie("Movie" + i, 2020));
			if (i % 1000 == 0)
				System.out.println(i);
		}
		System.out.println("DONE");
	}

}
