package battleship;

/**
 * This class extends Ship and describes a part of the ocean that doesn't have a
 * ship in it.
 *
 */
public class EmptySea extends Ship {

	// hard-code the ship's length and type
	static final int length = 1;
	static final String type = "empty";

	// constructor
	/**
	 * Creates a Submarine using the constructor from the Ship extended class
	 */
	public EmptySea() {
		super(EmptySea.length);
	}

	// methods
	/**
	 * Override the getShipType() method in the Ship extended class
	 */
	@Override
	public String getShipType() {
		// TODO Auto-generated method stub
		return EmptySea.type;
	}

	/**
	 * Override the getShipType() method in the Ship extended class
	 * 
	 * @return always returns false
	 */
	@Override
	boolean shootAt(int row, int column) {
		return false;
	}

	/**
	 * Override the isSunk() method in the Ship extended class
	 * 
	 * @return always returns false
	 */
	@Override
	boolean isSunk() {
		return false;
	}

	/**
	 * Override the toString() method in the Ship extended class
	 * 
	 * @return returns "-", a character indicating a shot has been fired but nothing
	 *         has been hit
	 */
	@Override
	public String toString() {
		return "-";
	}

}