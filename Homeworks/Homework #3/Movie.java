package movies;

//Movie class with methods that perform operations on movies.
public class Movie implements Comparable<Movie> {

	private String title;
	private int year;

	public Movie(String theTitle, int theYear) {
		title = theTitle;
		year = theYear;
	}

	//Compares movies by their titles, then by their years.
	public int compareTo(Movie otherMovie) {
		if (title.compareTo(otherMovie.title) != 0) {
			return title.compareTo(otherMovie.title);
		}

		return Integer.compare(year, otherMovie.year);
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	//Tests whether two movies are equal to each other.
	public boolean equals(Object other) {
		Movie otherMovie = (Movie) other;

		return this.compareTo(otherMovie) == 0;
	}

	public String toString() {
		return "Movie " + title + " (" + year + ")";
	}

	//Creates and returns an array of 10 unique Movie instances.
	public static Movie[] getTestMovies() {
		Movie[] movies = new Movie[10];

		movies[0] = new Movie("Diary of a Wimpy Kid", 2012);
		movies[1] = new Movie("Diary of a Wimpy Kid", 2017);
		movies[2] = new Movie("Fantasy Island", 2020);
		movies[3] = new Movie("A Quiet Place 2", 2020);
		movies[4] = new Movie("Insidious", 2010);
		movies[5] = new Movie("Insidious", 2010);
		movies[6] = new Movie("Bodyguard", 2011);
		movies[7] = new Movie("Don't Breathe", 2015);
		movies[8] = new Movie("A Perfect Getaway", 2009);
		movies[9] = new Movie("Countdown", 2019);

		return movies;
	}

	public int hashCode() {
		return title.hashCode() + year;
	}

}
