package weather;

public class CirrusCloud extends Cloud {

	public CirrusCloud(float theBottom, float theTop) {
		super(theBottom, theTop);
	}

	//Overrides "rain" method from Cloud class.
	public String rain() {
		return "I cannot make rain";
	}

}
