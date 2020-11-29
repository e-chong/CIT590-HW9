package battleship;

import java.util.Random;

/**
 * Contains a 10*10 array of Ships, representing an "ocean" and some methods to
 * manipulate it.
 *
 */
public class Ocean {

	/**
	 * Used to determine quickly which ship is in any given location
	 */
	private Ship[][] ships = new Ship[10][10];

	/**
	 * Used to which grid cells have been fired upon
	 */
	private boolean[][] shotAt = new boolean[10][10];

	/**
	 * The total number of shots fired by the user
	 */
	private int shotsFired;

	/**
	 * The number of times a shot hit a ship
	 */
	private int hitCount;

	/**
	 * The number of ships sunk (10 ships in total)
	 */
	private int shipsSunk;

	/**
	 * Constructs an "empty" ocean and fills the ships array with EmptySea objects.
	 * Initialize game variables.
	 */
	public Ocean() {

		// Fill ships array with EmptySea objects
		for (int i = 0; i < this.ships.length; i++) {
			for (int j = 0; j < this.ships[i].length; j++) {
				ships[i][j] = new EmptySea();
			}
		}

		// Initialize game variables
		this.shotsFired = 0;
		this.hitCount = 0;
		this.shipsSunk = 0;

	}

	// Methods

	/**
	 * Places all ten ships randomly on the initially empty ocean
	 */
	void placeAllShipsRandomly() {
		// place all ten ships randomly on the ocean
		// place larger ships before the smaller ones

		// iterate through the one battleship
		for (int i = 0; i < 1; i++) {
			// initialize the ship
			Ship Battleship = new Battleship();

			boolean satisfied = false;

			Random rand = new Random();
			int row = 0;
			int column = 0;
			boolean horizontal = true;

			while (!satisfied) {

				// generate the row, column, horizontal variables
				row = rand.nextInt(10);
				column = rand.nextInt(10);
				horizontal = rand.nextBoolean();

				// check whether generated location is okToPlaceShipAt
				// if it is okay to place ship, breaks out of the while loop
				// if not, stays in the loop and generates new variables
				satisfied = Battleship.okToPlaceShipAt(row, column, horizontal, this);
			}
			Battleship.placeShipAt(row, column, horizontal, this);
		}

		// iterate through the two cruisers
		for (int i = 0; i < 2; i++) {
			// initialize the ship
			Ship Cruiser = new Cruiser();

			boolean satisfied = false;

			Random rand = new Random();
			int row = 0;
			int column = 0;
			boolean horizontal = true;

			while (!satisfied) {

				// generate the row, column, horizontal variables
				row = rand.nextInt(10);
				column = rand.nextInt(10);
				horizontal = rand.nextBoolean();

				// check whether generated location is okToPlaceShipAt
				// if it is okay to place ship, breaks out of the while loop
				// if not, stays in the loop and generates new variables
				satisfied = Cruiser.okToPlaceShipAt(row, column, horizontal, this);
			}
			Cruiser.placeShipAt(row, column, horizontal, this);
		}

		// iterate through the three destroyers
		for (int i = 0; i < 3; i++) {
			// initialize the ship
			Ship Destroyer = new Destroyer();

			boolean satisfied = false;

			Random rand = new Random();
			int row = 0;
			int column = 0;
			boolean horizontal = true;

			while (!satisfied) {

				// generate the row, column, horizontal variables
				row = rand.nextInt(10);
				column = rand.nextInt(10);
				horizontal = rand.nextBoolean();

				// check whether generated location is okToPlaceShipAt
				// if it is okay to place ship, breaks out of the while loop
				// if not, stays in the loop and generates new variables
				satisfied = Destroyer.okToPlaceShipAt(row, column, horizontal, this);
			}
			Destroyer.placeShipAt(row, column, horizontal, this);
		}

		// iterate through the four submarines
		for (int i = 0; i < 4; i++) {
			// initialize the ship
			Ship Submarine = new Submarine();

			boolean satisfied = false;

			Random rand = new Random();
			int row = 0;
			int column = 0;
			boolean horizontal = true;

			while (!satisfied) {

				// generate the row, column, horizontal variables
				row = rand.nextInt(10);
				column = rand.nextInt(10);
				horizontal = rand.nextBoolean();

				// check whether generated location is okToPlaceShipAt
				// if it is okay to place ship, breaks out of the while loop
				// if not, stays in the loop and generates new variables
				satisfied = Submarine.okToPlaceShipAt(row, column, horizontal, this);
			}
			Submarine.placeShipAt(row, column, horizontal, this);
		}
	}

	/**
	 * Check whether a given location contains a ship.
	 * 
	 * @param row
	 * @param column
	 * @return true if the given location contains a ship
	 */
	boolean isOccupied(int row, int column) {
		// Get the type of ship in the given row/column
		String shipType = this.ships[row][column].getShipType();

		// Return true if the shipType is NOT "empty"
		return !shipType.equals(EmptySea.type);
	}

	/**
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	boolean shootAt(int row, int column) {
		// Update the number of shots that have been fired
		this.shotsFired++;

		// Update the shotAt array to indicate the grid cell has been fired upon
		setShotAtArray(row, column);

		// Check that area is occupied AND ship is still afloat
		boolean hit = this.ships[row][column].shootAt(row, column);
		
		// returns true if the given location contains a "real" ship, still afloat
		if (hit) {
			this.hitCount++;
			// Update the shipsSunk
			if (this.ships[row][column].isSunk()) {
				this.shipsSunk++;
			}
			return true;
		} else {
			return false;
		}

	}

	// Getters
	/**
	 * @return the number of shots fired in the game
	 */
	int getShotsFired() {
		return this.shotsFired;
	}

	/**
	 * @return the number of hits recorded in the game
	 */
	int getHitCount() {
		return this.hitCount;
	}

	/**
	 * @return the number of ships sunk in the game
	 */
	int getShipsSunk() {
		return this.shipsSunk;
	}

	/**
	 * 
	 * @return true if all ships have been sunk, otherwise false
	 */
	boolean isGameOver() {
		if (this.getShipsSunk() == 10) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @return the 10x10 array of Ships
	 */
	public Ship[][] getShipArray() {
		// returns the 10*10 array of Ships
		return this.ships;
	}
	
	/**
	 * 
	 * @return the 10x10 shotAt array
	 */
	public boolean[][] getShotAtArray() {
		return this.shotAt;
	}
	
	// Getters
	void setShotAtArray(int row, int column) {
		this.shotAt[row][column] = true;
	}

	/**
	 * Prints the Ocean
	 */
	void print() {
		// print the column labels
		String columnLabels = "  0 1 2 3 4 5 6 7 8 9";
		System.out.println(columnLabels);
		
		// get the arrays for printing
		boolean[][] shotAt = this.getShotAtArray();
		Ship[][] ships = this.getShipArray();
		
		for (int row = 0; row < 10; row++) {
			String rowString = String.valueOf(row);
			for (int col = 0; col < 10; col++) {
				if (shotAt[row][col] == false) {
					rowString += " .";
				} else {
					rowString += " " + ships[row][col].toString();
				}

			}
			System.out.println(rowString);
		}

	}
}
