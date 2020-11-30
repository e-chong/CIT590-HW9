package battleship;

/**
 * This class extends Ship and describes a ship of length 3
 *
 */
public class Cruiser extends Ship {

	// hard-code the ship's length and type
	static final int length = 3;
	static final String type = "cruiser";

	// constructor
	/**
	 * Creates a Cruiser using the constructor from the Ship extended class
	 */
	public Cruiser() {
		super(Cruiser.length);
	}

	// methods
	/**
	 * Override the getShipType() method in the Ship extended class
	 */
	@Override
	public String getShipType() {
		// TODO Auto-generated method stub
		return Cruiser.type;
	}

}
