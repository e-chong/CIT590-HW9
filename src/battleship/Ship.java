package battleship;

import java.util.ArrayList;

public abstract class Ship {
	/*
	 * describes the characteristics common to all ships
	 */

	// the row and column that contains the bow (front part of the ship)
	private int bowRow;
	private int bowColumn;

	// the length of the ship
	private int length;

	// a boolean that represents whether the ship is going to be placed horizontally
	// or vertically
	private boolean horizontal;

	// an array of 4 booleans that indicate whether that part of the ship has been
	// hit or not
	private boolean[] hit;

	/**
	 * default constructor sets the length property of the particular ship and
	 * initializes the hit array
	 * 
	 * @param length
	 */
	public Ship(int length) {
		this.length = length;
		this.hit = new boolean[] { false, false, false, false };
	}

	// Getters
	/**
	 * 
	 * @return the ship length
	 */
	public int getLength() {
		return this.length;
	}

	/**
	 * 
	 * @return the row corresponding to the position of the bow
	 */
	public int getBowRow() {
		return this.bowRow;
	}

	/**
	 * 
	 * @return the column corresponding to the position of the bow
	 */
	public int getBowColumn() {
		return this.bowColumn;
	}

	/**
	 * 
	 * @return the hit boolean array
	 */
	public boolean[] getHit() {
		return this.hit;
	}

	/**
	 * 
	 * @return whether the ship is horizontal (true) or not (false)
	 */
	public boolean isHorizontal() {
		return this.horizontal;
	}

	// Setters
	/**
	 * Sets the value of bowRow
	 * 
	 * @param row
	 */
	public void setBowRow(int row) {
		this.bowRow = row;
	}

	/**
	 * Sets the value of bowColumn
	 * 
	 * @param column
	 */
	public void setBowColumn(int column) {
		this.bowColumn = column;
	}

	/**
	 * Sets the value of the instance variable horizontal If horizontal, set to
	 * true; if vertical, set to false
	 * 
	 * @param horizontal
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	// Abstract methods
	/**
	 * Abstract method overridden in each concrete Ship class
	 * 
	 * @return the type of ship as a String
	 */
	public abstract String getShipType();

	// Other methods
	/**
	 * Based on given parameters, returns true if it is okay to put a ship of this
	 * length with its bow in this location otherwise, returns false The ship must
	 * not overlap another ship or touch another ship (vertically, horizontally, or
	 * diagonally), and it must be fully contained within the array. Does not modify
	 * the ship or ocean.
	 * 
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 * @return true/false
	 */
	boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		// if the row or column are not within 0-9
		if (row < 0 || row > 9 || column < 0 || column > 9) {
			return false;
		}

		/*
		 * Get the ship's extent using the getShipExtent() helper method. If the last
		 * element of the extent array is less than 0, the ship is "hanging off" the
		 * edge of the board and its position is invalid.
		 */
		ArrayList<Integer> extentArray = this.getShipExtent(row, column, horizontal);

		if (extentArray.get(extentArray.size() - 1) < 0) {
			return false;
		}

		/*
		 * If any part of the ship overlaps with or is within 1 cell of another ship in
		 * the ocean, return false
		 */
		if (this.checkNeighbors(row, column, extentArray, horizontal, ocean)) {
			return false;
		}

		// otherwise return true
		return true;

	}

	/**
	 * Helper function. Finds the ship's "extent" given row, columns, and
	 * orientation. E.g., a horizontal battleship with its bow placed in column 9
	 * would return the ArrayList: [9, 8, 7, 6], signifying that it extends over 4
	 * columns.
	 * 
	 * @param row
	 * @param column
	 * @param horizontal
	 * @return
	 */
	public ArrayList<Integer> getShipExtent(int row, int column, boolean horizontal) {
		// First initialize an int ArrayList the same length as the ship
		ArrayList<Integer> extent = new ArrayList<Integer>();

		if (horizontal) {
			/*
			 * if horizontally oriented, take row coordinate of ship's bow and subtract
			 * ship's length
			 */
			for (int i = 0; i < extent.size(); i++) {
				extent.add(column - i);
			}

		} else {
			/*
			 * if vertically oriented, take column coordinate of ship's bow and subtract
			 * ship's length
			 */
			for (int i = 0; i < extent.size(); i++) {
				extent.add(row - i);
			}
		}

		return extent;
	}

	/**
	 * Check all the neighboring cells for a proposed ship. If any of those cells is
	 * occupied, return false. Otherwise, return true.
	 * 
	 * @param row
	 * @param column
	 * @param extent
	 * @param horizontal
	 * @param ocean
	 * @return
	 */
	boolean checkNeighbors(int row, int column, ArrayList<Integer> extent, boolean horizontal, Ocean ocean) {

		// initialize an occupied boolean variable
		boolean occupied;

		/*
		 * Increase the ship's extent by 1 in both directions. This accounts for any
		 * ships that may be diagonally adjacent. The first element of the extent
		 * ArrayList is always the largest value, so add 1. The last element is always
		 * the smallest, so subtract 1.
		 */
		extent.add(0, extent.get(0) + 1);
		extent.add(extent.get(extent.size() - 1) - 1);

		// if the ship is horizontally oriented
		if (horizontal) {
			// consider the cells in the row above and below the ship as well
			int[] rows = { row - 1, row, row + 1 };

			// for every column in the extent ArrayList
			for (int i = 0; i < extent.size(); i++) {
				// and every row in the row Array
				for (int j = 0; j < rows.length; j++) {
					// check if that cell is occupied
					occupied = ocean.isOccupied(rows[j], extent.get(i));
					if (occupied) {
						// and if so, return true
						return true;
					}
				}
			}
			// if the ship is vertically oriented
		} else {
			// consider the cells in the column to the left and right of the ship as well
			int[] cols = { column - 1, column, column + 1 };

			// for every row in the extent ArrayList
			for (int i = 0; i < extent.size(); i++) {
				// and every row in the row Array
				for (int j = 0; j < cols.length; j++) {
					// check if that cell is occupied
					occupied = ocean.isOccupied(extent.get(i), cols[j]);
					if (occupied) {
						// and if so, return true
						return true;
					}
				}
			}
		}

		// otherwise, return false
		return false;

	}

	/**
	 * Places a ship in the ocean using the given parameters Also puts a reference
	 * to the ship in the relevant locations in the ships array in the ocean object
	 * Assume that horizontal ships have their bow at the right end, and vertical
	 * ships have their bow at the bottom end
	 * 
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 */
	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
	}

	/**
	 * Returns true if a part of the ship occupies the given row and column, and the
	 * ship hasn't been sunk. Otherwise, return false
	 * 
	 * @param row
	 * @param column
	 * @return true/false
	 */
	boolean shootAt(int row, int column) {

	}

	/**
	 * 
	 * @return true if every part of the ship has been hit, false otherwise
	 */
	boolean isSunk() {
		// initialize a counter for the number of hits
		int hits = 0;

		/*
		 * Loop over the first n elements of the hit array, where n is the length of the
		 * ship. Convert the boolean values to ints and sum them up.
		 */
		for (int i = 0; i < this.getLength() - 1; i++) {
			hits += hit[i] ? 1 : 0;
		}

		/*
		 * If the number of hits is equal to the length of the ship, the ship was sunk, so return true.
		 * Otherwise return false.
		 */
		if (hits == this.getLength()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns a single-character String for use in the Ocean's print method.
	 * Returns "s" if the ship has been sunk and "x" if not. This method can be used
	 * to print out locations in the ocean that have been shot at
	 */
	@Override
	public String toString() {
		if (this.isSunk()) {
			return "s";
		} else {
			return "x";
		}

	}

}
