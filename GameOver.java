/**
 * Name: Matt Whitehead
 * Title: Dominion
 * Due Date: 11/30/18
 * Description: This class counts the amount of card piles that have 0 cards.
 * It is used to end the game. Once 3 piles are empty the game is over
 */

public class GameOver {
	
	public static int gameOver(Pile[] board) {
		int count = 0;
		
		for (int i = 1; i < board.length; i++) {
			if (board[i].getNumOfCards() == 0) {
				count++;
			}
		}
		return count;
	}
}
