package movies;

import java.util.ArrayList;
import java.util.TreeSet;

//Creates a TreeFilmArchive that extends TreeSet<Movie> and implements the FilmArchive interface.
public class TreeFilmArchive extends TreeSet<Movie> implements FilmArchive {

	//Sorts movies using a TreeSet.
	public ArrayList<Movie> getSorted() {
		ArrayList<Movie> moviesArrayList = new ArrayList<Movie>(this);
		return moviesArrayList;
	}
	
	//Tests the TreeFilmArchive class.
	public static void main(String[] args) {
		TreeFilmArchive archive = new TreeFilmArchive();
		for (Movie m : Movie.getTestMovies())
			archive.add(m);
		for (Movie m : archive)
			System.out.println(m);
		System.out.println("**************");
		for (Movie m : archive.getSorted())
			System.out.println(m);
	}

}
