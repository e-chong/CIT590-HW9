package battleship;

public class Destroyer extends Ship {

	// hard-code the ship's length and type
	static final int length = 2;
	static final String type = "destroyer";

	// constructor
	/**
	 * Creates a Destroyer using the constructor from the Ship extended class
	 */
	public Destroyer() {
		super(Destroyer.length);		
	}

	// methods
	/**
	 * Override the getShipType() method in the Ship extended class
	 */
	@Override
	public String getShipType() {
		// TODO Auto-generated method stub
		return Destroyer.type;
	}

}
