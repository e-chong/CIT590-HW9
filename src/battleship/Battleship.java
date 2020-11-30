package battleship;

/**
 * This class extends Ship and describes a ship of length 4
 *
 */
public class Battleship extends Ship {

	// hard-code the ship's length and type
	static final int length = 4;
	static final String type = "battleship";

	// constructor
	/**
	 * Creates a Battleship using the constructor from the Ship extended class
	 */
	public Battleship() {
		super(Battleship.length);
	}

	// methods
	/**
	 * Override the getShipType() method in the Ship extended class
	 */
	@Override
	public String getShipType() {
		// TODO Auto-generated method stub
		return Battleship.type;
	}

}
