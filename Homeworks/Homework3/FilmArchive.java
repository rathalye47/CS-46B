package movies;

import java.util.ArrayList;

//Defines two methods getSorted() and add() for use in classes that implement them.
public interface FilmArchive {

	ArrayList<Movie> getSorted();
	boolean add(Movie movie);
}
