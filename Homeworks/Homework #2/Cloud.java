package weather;

public class Cloud {

	private float bottom;
	private float top;

	public Cloud(float theBottom, float theTop) {
		bottom = theBottom;
		top = theTop;
	}

	//Gets the height of the clouds.
	public float getHeight() {
		return top - bottom;
	}

	public String rain() {
		return "It is raining";
	}
}
