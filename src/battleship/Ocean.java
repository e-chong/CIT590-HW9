package battleship;

public class Ocean {
	
	/*
	 * contains a 10*10 array of Ships, representing an "ocean"
	 * and some methods to manipulate it
	 */
	
	//used to determine which ship is in any given location
	private Ship[][]ships = new Ship[10][10];
	
	//the total number of shots fired by the user
	private int shotsFired;
	
	//the  number of times a shot hit a ship
	private int hitCount;
	
	//the number of ships sunk (10 ships in total)
	private int shipsSunk;
	
	//creates an "empty" ocean and initializes game variables
	public Ocean() {
		
	}
	
	/*
	 * Methods
	 */
	void placeAllShipsRandomly() {
		//place all ten ships randomly on the ocean
		//place larger ships before the smaller ones
	}
	
	boolean isOccupied(int row, int column) {
		//returns true if the given location contains a ship
	}
	
	boolean shootAt(int row, int column) {
		//returns true if the given location contains a "real" ship, still afloat
	}
	
	/*
	 * Getters
	 */
	int getShotsFired() {
		//returns the number of shots fired
		return this.shotsFired;
	}
	
	int getHitCount() {
		//returns the number of hits recorded
		return this.hitCount;
	}
	
	int getShipsSunk() {
		//returns he number of ships sunk
		return this.shipsSunk;
	}
	
	boolean isGameOver() {
		//returns true if all ships have been sunk
		if (this.getShipsSunk() == 10){
			return true;
		} else {
			return false;
		}
	}
	
	Ship[] [] getShipArray(){
		//returns the 10*10 array of Ships
		return this.ships;
	}
	
	void print() {
		//prints the Ocean
	}
}
