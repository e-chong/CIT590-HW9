package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShipTest_v2 {

	Ocean ocean;
	Ship ship;
	
	@BeforeEach
	void setUp() throws Exception {
		ocean = new Ocean();
	}

	@Test
	void testGetLength() {
		ship = new Battleship();
		assertEquals(4, ship.getLength());
		
		//TODO
		//More tests
		ship = new Submarine();
		assertEquals(1, ship.getLength());
		
		ship = new Cruiser();
		assertEquals(3, ship.getLength());
	}

	@Test
	void testGetBowRow() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, battleship.getBowRow());
		
		//TODO
		//More tests
		Ship submarine = new Submarine();
		row = 1;
		column = 9;
		horizontal = true;
		submarine.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, submarine.getBowRow());
		
		Ship destroyer = new Destroyer();
		row = 8;
		column = 2;
		horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, destroyer.getBowRow());
	}

	@Test
	void testGetBowColumn() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		battleship.setBowColumn(column);
		assertEquals(column, battleship.getBowColumn());	
		
		//TODO
		//More tests
		Ship submarine = new Submarine();
		row = 1;
		column = 9;
		horizontal = true;
		submarine.placeShipAt(row, column, horizontal, ocean);
		assertEquals(column, submarine.getBowColumn());
		
		Ship destroyer = new Destroyer();
		row = 8;
		column = 2;
		horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		assertEquals(column, destroyer.getBowColumn());
	}

	@Test
	void testGetHit() {
		ship = new Battleship();
		boolean[] hits = new boolean[4];
		assertArrayEquals(hits, ship.getHit());
		assertFalse(ship.getHit()[0]);
		assertFalse(ship.getHit()[1]);
		
		//TODO
		//More tests
		ship = new Submarine();
		hits = new boolean[4];
		assertArrayEquals(hits, ship.getHit());
		assertFalse(ship.getHit()[0]);
		
		ship = new Cruiser();
		hits = new boolean[4];
		assertArrayEquals(hits, ship.getHit());
		assertFalse(ship.getHit()[0]);

	}
	@Test
	void testGetShipType() {
		ship = new Battleship();
		assertEquals("battleship", ship.getShipType());
		
		//TODO
		//More tests
		ship = new Submarine();
		assertEquals("submarine", ship.getShipType());
		
		ship = new Destroyer();
		assertEquals("destroyer", ship.getShipType());
	}
	
	@Test
	void testIsHorizontal() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		assertTrue(battleship.isHorizontal());
		
		//TODO
		//More tests	
		Ship submarine = new Submarine();
		row = 2;
		column = 5;
		horizontal = false;
		submarine.placeShipAt(row, column, horizontal, ocean);
		assertFalse(submarine.isHorizontal());
		
		Ship destroyer = new Destroyer();
		row = 7;
		column = 9;
		horizontal = true;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		assertTrue(destroyer.isHorizontal());
	}
	
	@Test
	void testSetBowRow() {
		Ship battleship = new Battleship();
		int row = 0;
		battleship.setBowRow(row);
		assertEquals(row, battleship.getBowRow());
		
		//TODO
		//More tests
		Ship submarine = new Submarine();
		row = 2;
		submarine.setBowRow(row);
		assertEquals(row, submarine.getBowRow());
		
		Ship destroyer = new Destroyer();
		row = 7;
		destroyer.setBowRow(row);
		assertEquals(row, destroyer.getBowRow());
	}

	@Test
	void testSetBowColumn() {
		Ship battleship = new Battleship();
		int column = 4;
		battleship.setBowColumn(column);
		assertEquals(column, battleship.getBowColumn());
		
		//TODO
		//More tests
		Ship submarine = new Submarine();
		column = 5;
		submarine.setBowColumn(column);
		assertEquals(column, submarine.getBowColumn());
		
		Ship destroyer = new Destroyer();
		column = 9;
		destroyer.setBowColumn(column);
		assertEquals(column, destroyer.getBowColumn());
	}

	@Test
	void testSetHorizontal() {
		Ship battleship = new Battleship();
		boolean horizontal = true;
		battleship.setHorizontal(horizontal);
		assertTrue(battleship.isHorizontal());
		
		//TODO
		//More tests
		Ship submarine = new Submarine();
		horizontal = false;
		submarine.setHorizontal(horizontal);
		assertFalse(submarine.isHorizontal());
		
		Ship destroyer = new Destroyer();
		horizontal = true;
		destroyer.setHorizontal(horizontal);
		assertTrue(destroyer.isHorizontal());
	}

	@Test
	void testOkToPlaceShipAt() {
		
		//test when other ships are not in the ocean
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		boolean ok = battleship.okToPlaceShipAt(row, column, horizontal, ocean);
		assertTrue(ok, "OK to place ship here.");
		battleship.placeShipAt(row, column, horizontal, ocean);
		
		//TODO
		//More tests
		Ship submarine = new Submarine();
		row = 2;
		column = 5;
		horizontal = true;
		boolean ok1 = submarine.okToPlaceShipAt(row, column, horizontal, ocean);
		assertTrue(ok1, "OK to place ship here.");
		submarine.placeShipAt(row, column, horizontal, ocean);
		
		Ship cruiser = new Cruiser();
		row = 2;
		column = 5;
		horizontal = true;
		boolean ok2 = cruiser.okToPlaceShipAt(row, column, horizontal, ocean);
		assertFalse(ok2, "There is already a ship here.");
	}
	
	@Test
	void testOkToPlaceShipAtAgainstOtherShipsOneBattleship() {
		
		//test when other ships are in the ocean
		
		//place first ship
		Battleship battleship1 = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		boolean ok1 = battleship1.okToPlaceShipAt(row, column, horizontal, ocean);
		assertTrue(ok1, "OK to place ship here.");
		battleship1.placeShipAt(row, column, horizontal, ocean);

		//test second ship
		Battleship battleship2 = new Battleship();
		row = 1;
		column = 4;
		horizontal = true;
		boolean ok2 = battleship2.okToPlaceShipAt(row, column, horizontal, ocean);
		assertFalse(ok2, "Not OK to place ship vertically adjacent below.");
		
		//TODO
		//More tests
		Battleship battleship3 = new Battleship();
		row = 1;
		column = 6;
		horizontal = true;
		boolean ok3 = battleship3.okToPlaceShipAt(row, column, horizontal, ocean);
		assertFalse(ok3, "Not OK to place ship diagonally adjacent.");
	}

	@Test
	void testPlaceShipAt() {
		
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, battleship.getBowRow());
		assertEquals(column, battleship.getBowColumn());
		assertTrue(battleship.isHorizontal());
		
		assertEquals("empty", ocean.getShipArray()[0][0].getShipType());
		assertEquals(battleship, ocean.getShipArray()[0][1]);
		

		//TODO
		//More tests
		Ship submarine = new Submarine();
		row = 1;
		column = 6;
		horizontal = true;
		submarine.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, submarine.getBowRow());
		assertEquals(column, submarine.getBowColumn());
		assertTrue(submarine.isHorizontal());
		
		assertEquals("empty", ocean.getShipArray()[2][6].getShipType());
		assertEquals(submarine, ocean.getShipArray()[1][6]);
		
		Ship destroyer = new Destroyer();
		row = 5;
		column = 6;
		horizontal = true;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, destroyer.getBowRow());
		assertEquals(column, destroyer.getBowColumn());
		assertTrue(destroyer.isHorizontal());
		
		assertEquals("empty", ocean.getShipArray()[5][4].getShipType());
		assertEquals(destroyer, ocean.getShipArray()[5][5]);
	}

	@Test
	void testShootAt() {
		
		Ship battleship = new Battleship();
		int row = 0;
		int column = 9;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		
		assertFalse(battleship.shootAt(1, 9));
		boolean[] hitArray0 = {false, false, false, false};
		assertArrayEquals(hitArray0, battleship.getHit());
		
		//TODO
		//More tests
		Ship destroyer= new Destroyer();
		row = 2;
		column = 3;
		horizontal = true;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		assertFalse(destroyer.shootAt(1, 3));
		boolean[] hitArray1 = {false, false, false, false};
		assertArrayEquals(hitArray1, destroyer.getHit());
		
		Ship submarine = new Submarine();
		row = 5;
		column = 9;
		horizontal = false;
		submarine.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(submarine.shootAt(5, 9));
		boolean[] hitArray2 = {true, false, false, false};
		assertArrayEquals(hitArray2, submarine.getHit());
	}
	
	@Test
	void testIsSunk() {
		
		Ship submarine = new Submarine();
		int row = 3;
		int column = 3;
		boolean horizontal = true;
		submarine.placeShipAt(row, column, horizontal, ocean);
		
		assertFalse(submarine.isSunk());
		assertFalse(submarine.shootAt(5, 2));
		assertFalse(submarine.isSunk());
		
		//TODO
		//More tests
		assertTrue(submarine.shootAt(3,3));
		assertTrue(submarine.isSunk());
		
		Ship destroyer = new Destroyer();
		row = 0;
		column = 2;
		horizontal = true;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		assertFalse(destroyer.isSunk());
		assertTrue(destroyer.shootAt(0, 2));
		assertTrue(destroyer.shootAt(0, 1));
		assertTrue(destroyer.isSunk());
		
		
		Ship cruiser = new Cruiser();
		row = 7;
		column = 6;
		horizontal = false;
		cruiser.placeShipAt(row, column, horizontal, ocean);
		
		assertFalse(cruiser.isSunk());
		assertTrue(cruiser.shootAt(7, 6));
		assertTrue(cruiser.shootAt(6, 6));
		assertTrue(cruiser.shootAt(5, 6));
		assertTrue(cruiser.isSunk());
		
	}

	@Test
	void testToString() {
		
		Ship battleship = new Battleship();
		assertEquals("x", battleship.toString());
		
		int row = 9;
		int column = 1;
		boolean horizontal = false;
		battleship.placeShipAt(row, column, horizontal, ocean);
		battleship.shootAt(9, 1);
		assertEquals("x", battleship.toString());
		
		//TODO
		//More tests
		Ship submarine = new Submarine();
		assertEquals("x", submarine.toString());
		
		row = 0;
		column = 0;
		horizontal = false;
		submarine.placeShipAt(row, column, horizontal, ocean);
		submarine.shootAt(0, 0);
		assertEquals("s", submarine.toString());
		
		Ship destroyer = new Destroyer();
		assertEquals("x", destroyer.toString());
		
		row = 4;
		column = 5;
		horizontal = true;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		destroyer.shootAt(4, 5);
		assertEquals("x", destroyer.toString());
		destroyer.shootAt(4, 4);
		assertEquals("s", destroyer.toString());
	}

}
