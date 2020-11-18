package battleship;

public abstract class Ship {
	/*
	 * describes the characteristics common to all ships
	 */
	
	//the row and column that contains the bow (front part of the ship)
	private int bowRow;
	private int bowColumn;
	
	//the length of the ship
	private int length;
	
	//a boolean that represents whether the ship is going to be placed horizontally or vertically
	private boolean horizontal;
	
	//an array of 4 booleans that indicate whether that part of the ship has been hit or not
	private boolean[] hit;
	
	//default constructor
	//sets the length property of the particular ship and initializes the int array
	public Ship(int length) {
		this.length = length;
	}
	
	/*
	 * Getters
	 */
	public int getLength() {
		//returns the ship length
		return this.length;
	}
	
	public int getBowRow() {
		//returns the row of the bow
		return this.bowRow;
	}
	
	public int getBowColumn() {
		//returns the column of the bow
		return this.bowColumn;
	}
	
	public boolean[] getHit() {
		//returns the hit array
		return this.hit;
	}
	
	public boolean isHorizontal() {
		//returns whether the ship is horizontal or not
		return this.horizontal;
	}
	
	/*
	 * Setters
	 */
	public void setBowRow(int row) {
		//sets the value of bowRow
		this.bowRow = row;
	}
	
	public void setBowColumn(int column) {
		//sets the value of bowColumn
		this.bowColumn = column;
	}
	
	public void setHorizontal(boolean horizontal) {
		//sets the value of the instance variable horizontal
		this.horizontal = horizontal;
	}
	
	/*
	 * Abstract methods
	 */
	public abstract String getShipType() {
		//returns the type of ship as a String
		return ;
	}
	
	boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		//check whether it is ok to place a ship at a certain location
		if() {
			return true;
		} else {
			return false;
		}
	}
	
	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		//"puts" the ship in the ocean
	}
	
	boolean shootAt(int row, int column) {
		//mark the part has been shot but not sunk, mark as "hit" and return true, otherwise return false
	}
	
	boolean isSunk() {
		//return true if every part of the ship has been hit
	}
	
	public String toString() {
		
	}
	
	//describes a ship of length 4
	class Battleship extends Ship{
		
	}
	
	//describes a ship of length 3
	class Cruiser extends Ship{
		
	}
	
	//describes a ship of length 2
	class Destroyer extends Ship{
		
	}
	
	//describes a ship of length 1
	class Submarine extends Ship{
		
	}
	
	//describes a part of the ocean that doesn't have a ship in it
	class EmptySea extends Ship{
		public EmptySea() {
			
		}
	}

}
