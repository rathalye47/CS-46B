package movies;

import java.util.ArrayList;
import java.util.TreeSet;

//Creates a ListFilmArchive that extends ArrayList<Movie> and implements the FilmArchive interface.
public class ListFilmArchive extends ArrayList<Movie> implements FilmArchive {

	//Checks every movie in the array list for deep equality to "movie".
	public boolean add(Movie movie) {
		for (Movie m : this) {
			if (m.equals(movie)) {
				return false;
			}
		}

		boolean isAdded = super.add(movie);
		return isAdded;
	}

	//Sorts movies using a TreeSet.
	public ArrayList<Movie> getSorted() {
		TreeSet<Movie> moviesTreeSet = new TreeSet<Movie>(this);
		ArrayList<Movie> moviesArrayList = new ArrayList<Movie>(moviesTreeSet);
		return moviesArrayList;
	}

	//Tests the ListFilmArchive class.
	public static void main(String[] args) {
		ListFilmArchive archive = new ListFilmArchive();
		for (Movie m : Movie.getTestMovies())
			archive.add(m);
		for (Movie m : archive)
			System.out.println(m);
		System.out.println("**************");
		for (Movie m : archive.getSorted())
			System.out.println(m);
	}

}
