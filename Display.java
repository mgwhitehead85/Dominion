/**
 * Name: Matt Whitehead
 * Title: Dominion
 * Due Date: 11/30/18
 * Description: This class displays the game board
 */

public class Display {
	
	public static void displayBoard(Pile[] board) {
		System.out.println();
		System.out.printf("%-5s %-8s %-19s %-11s %-5s %-7s %-7s %-10s %-11s %-9s %s \n",
				"Pile", "Amount", "Name", "Type", "Cost", "Points", "Worth", "Add Cards",
				"Add Action", "Add Buy", "Special");
		
		System.out.println("-------------------------------------------------------------"
				+ "------------------------------------------------");
		
		for (int i = 1; i < board.length; i++){
			System.out.println(board[i]);
	    }
		System.out.println();
	}
}
