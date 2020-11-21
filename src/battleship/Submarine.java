package battleship;

public class Submarine extends Ship {

	// hard-code the ship's length and type
	static final int length = 1;
	static final String type = "submarine";

	// constructor
	/**
	 * Creates a Submarine using the constructor from the Ship extended class
	 */
	public Submarine() {
		super(Submarine.length);		
	}

	// methods
	/**
	 * Override the getShipType() method in the Ship extended class
	 */
	@Override
	public String getShipType() {
		// TODO Auto-generated method stub
		return Submarine.type;
	}

}
