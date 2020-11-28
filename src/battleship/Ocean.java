package battleship;

import java.util.Random;

public class Ocean {

	/*
	 * contains a 10*10 array of Ships, representing an "ocean" and some methods to
	 * manipulate it
	 */

	/**
	 * Used to determine quickly which ship is in any given location
	 */
	private Ship[][] ships = new Ship[10][10];

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
		
		//iterate through the one battleship
		for (int i = 0; i < 1; i++){
			//initialize the ship
			Ship Battleship = new Battleship();
			
			boolean satisfied = false;
			
			while (!satisfied) {
			
				//generate the row, column, horizontal variables
				Random rand = new Random();
				int row = rand.nextInt(9);
				int column = rand.nextInt(9);
				boolean horizontal = rand.nextBoolean();
				
				//check whether generated location is okToPlaceShipAt
				//if it is ok to place ship, breaks out of the while loop
				//if not, stays in the loop and generates new variables
				satisfied = okToPlaceShipAt(row, column, horizontal, this);
			}
			Battleship.placeShipAt(row, column, horizontal, this);
		}
		
		//iterate through the two cruisers
		for (int i = 0; i < 2; i++){
			//initialize the ship
			Ship Cruiser = new Cruiser();
			
			boolean satisfied = false;
			
			while (!satisfied) {
			
				//generate the row, column, horizontal variables
				Random rand = new Random();
				int row = rand.nextInt(9);
				int column = rand.nextInt(9);
				boolean horizontal = rand.nextBoolean();
				
				//check whether generated location is okToPlaceShipAt
				//if it is ok to place ship, breaks out of the while loop
				//if not, stays in the loop and generate new variables
				satisfied = okToPlaceShipAt(row, column, horizontal, this);
			}
			Cruiser.placeShipAt(row, column, horizontal, this);
		}
		
		//iterate through the three destroyers
		for (int i = 0; i < 3; i++){
			//initialize the ship
			Ship Destroyer = new Destroyer();
			
			boolean satisfied = false;
			
			while (!satisfied) {
			
				//generate the row, column, horizontal variables
				Random rand = new Random();
				int row = rand.nextInt(9);
				int column = rand.nextInt(9);
				boolean horizontal = rand.nextBoolean();
				
				//check whether generated location is okToPlaceShipAt
				//if it is ok to place ship, breaks out of the while loop
				//if not, stays in the loop and generate new variables
				satisfied = okToPlaceShipAt(row, column, horizontal, this);
			}
			Destroyer.placeShipAt(row, column, horizontal, this);
		}
		
		//iterate through the four submarines
		for (int i = 0; i < 4; i++){
			//initialize the ship
			Ship Submarine = new Submarine();
			
			boolean satisfied = false;
			
			while (!satisfied) {
			
				//generate the row, column, horizontal variables
				Random rand = new Random();
				int row = rand.nextInt(9);
				int column = rand.nextInt(9);
				boolean horizontal = rand.nextBoolean();
				
				//check whether generated location is okToPlaceShipAt
				//if it is ok to place ship, breaks out of the while loop
				//if not, stays in the loop and generate new variables
				satisfied = okToPlaceShipAt(row, column, horizontal, this);
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
		
		// Check that area is occupied AND ship is still afloat
		boolean hit = this.ships[row][column].shootAt(row, column);

		// returns true if the given location contains a "real" ship, still afloat
		if (hit) {
			this.hitCount++;
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
	 * Prints the Ocean
	 */
	void print() {
		// prints the Ocean
	}
}
