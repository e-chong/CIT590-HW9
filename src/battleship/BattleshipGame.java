package battleship;

import java.util.Scanner;

/**
 * 
 * @author Tianxiao Zhang, Eugene Chong
 *
 */
public class BattleshipGame {

	/**
	 * the "main" class
	 */
	public static void main(String[] args) {

		new BattleshipGame().run();

	}

	/**
	 * The method for running the game
	 */
	public void run() {
		// TODO Auto-generated method stub
		Ocean ocean = new Ocean();

		// place ships
		ocean.placeAllShipsRandomly();

		// initialize scanner
		Scanner scanner = new Scanner(System.in);

		// welcome message
		this.printWelcome();
		
		boolean gameState = false;
		// run
		while (gameState == false) {
			// print the ocean
			ocean.print();
			
			// ask for the player's next shot
			this.askNextShot();
			
			// assign first number to variable "row" and second to variable "col"
			String entry = scanner.next();
			String[] move = entry.split(",");
			int row = Integer.parseInt(move[0]);
			int col = Integer.parseInt(move[1]);
			
			// take the shot
			boolean hit = ocean.shootAt(row, col);
			
			// if it was a hit, return a success message
			if (hit) {
				System.out.println("Hit!");
				Ship ship = ocean.getShipArray()[row][col];
				// if the user just sank a ship, tell them what type of ship
				if (ship.isSunk()) {
					System.out.println("You sank a " + ship.getShipType() + "!");
				}
			// otherwise return a miss message
			} else {
				System.out.println("Miss :(");
			}
						
			// print number of shots taken so far
			String shotsFired = String.valueOf(ocean.getShotsFired());
			System.out.println("");
			System.out.println("You've fired " + shotsFired + " shot(s) so far.");
			System.out.println("");
						
			gameState = ocean.isGameOver();
		}
		
		String shotsFired = String.valueOf(ocean.getShotsFired());
		
		System.out.println("Game over!");
		System.out.println("It took you " + shotsFired + " to win.");
		
		scanner.close();
		

		/*
		 * 
		 * // print ocean ocean.print();
		 * 
		 * // testing ocean.shootAt(5, 7); ocean.shootAt(2, 7); ocean.shootAt(4, 7);
		 * ocean.shootAt(3, 7); ocean.shootAt(5, 6); ocean.shootAt(2, 6);
		 * ocean.shootAt(4, 6); ocean.shootAt(3, 6); ocean.shootAt(5, 8);
		 * ocean.shootAt(2, 8); ocean.shootAt(4, 8); ocean.shootAt(3, 8);
		 * ocean.shootAt(5, 9); ocean.shootAt(2, 9); ocean.shootAt(4, 9);
		 * ocean.shootAt(3, 9); ocean.shootAt(5, 5); ocean.shootAt(2, 5);
		 * ocean.shootAt(4, 5); ocean.shootAt(3, 5); ocean.shootAt(5, 4);
		 * ocean.shootAt(2, 4); ocean.shootAt(4, 4); ocean.shootAt(3, 4);
		 * ocean.shootAt(5, 3); ocean.shootAt(2, 3); ocean.shootAt(4, 3);
		 * ocean.shootAt(3, 3); ocean.shootAt(5, 2); ocean.shootAt(2, 2);
		 * ocean.shootAt(4, 2); ocean.shootAt(3, 2); ocean.shootAt(5, 1);
		 * ocean.shootAt(2, 1); ocean.shootAt(4, 1); ocean.shootAt(3, 1);
		 * ocean.shootAt(5, 0); ocean.shootAt(2, 0); ocean.shootAt(4, 0);
		 * ocean.shootAt(3, 0); ocean.shootAt(9, 0); ocean.shootAt(9, 1);
		 * ocean.shootAt(9, 2); ocean.shootAt(9, 3); ocean.shootAt(9, 4);
		 * ocean.shootAt(9, 5); ocean.shootAt(9, 6); ocean.shootAt(9, 7);
		 * ocean.shootAt(9, 8); ocean.shootAt(9, 9); ocean.print();
		 * 
		 * System.out.println(ocean.getHitCount());
		 * System.out.println(ocean.getShipsSunk());
		 * 
		 * Ship Battleship = new Battleship();
		 * System.out.println(Battleship.getLength());
		 * 
		 */
	}

	/**
	 * Prints a welcome message.
	 */
	public void printWelcome() {
		System.out.println("Welcome to Battleship!");
		System.out.println("This is a one-player variant of the popular game.");
		System.out.println("The computer will place its ships randomly across a 10x10 board.");
		System.out.println("Your goal is to sink all of the computer's ships in as few moves as possible.");
		System.out.println("Here's how the board looks now.");
		System.out.println("");
	}

	/**
	 * Asks the user where they want to shoot next.
	 */
	public void askNextShot() {
		System.out.println("");
		System.out.println("Where do you want to fire your next shot (row,column)? ");
		System.out.println("");
	}

}
