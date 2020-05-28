package movies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

//Creates a HashFilmArchive that extends HashSet<Movie> and implements the FilmArchive interface.
public class HashFilmArchive extends HashSet<Movie> implements FilmArchive {

	//Sorts movies using a HashSet.
	public ArrayList<Movie> getSorted() {
		TreeSet<Movie> moviesTreeSet = new TreeSet<Movie>(this);
		HashSet<Movie> moviesHashSet = new HashSet<Movie>(moviesTreeSet);
		ArrayList<Movie> moviesArrayList = new ArrayList<Movie>(moviesHashSet);
		return moviesArrayList;
	}

	//Tests the HashFilmArchive class.
	public static void main(String[] args) {
		HashFilmArchive archive = new HashFilmArchive();
		for (Movie m : Movie.getTestMovies())
			archive.add(m);
		for (Movie m : archive)
			System.out.println(m);
		System.out.println("**************");
		for (Movie m : archive.getSorted())
			System.out.println(m);
	}

}
