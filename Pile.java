/**
 * Name: Matt Whitehead
 * Title: Dominion
 * Due Date: 11/30/18
 * Description: A Pile class to assign cards to different piles. 
 * Number of cards in each pile can be found here.
 */

public class Pile {
	
	protected Card card;
	protected int pileNum;
	protected int numOfCards;
	
	public Pile() {
		card = null;
		pileNum = -1;
		numOfCards = -1;
	}
	
	public Pile(Card card, int pileNum, int numOfCards) {
		this.card = card;
		this.pileNum = pileNum;
		this.numOfCards = numOfCards;
	}
	
	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public int getPileNum() {
		return pileNum;
	}

	public void setPileNum(int pileNum) {
		this.pileNum = pileNum;
	}

	public int getNumOfCards() {
		return numOfCards;
	}

	public void setNumOfCards(int numOfCards) {
		this.numOfCards = numOfCards;
	}
	
			// Formats the output for the board
	public String toString() {
		return String.format("%-6s %-8s", pileNum, numOfCards) + card.toString();
	}	
	
}

