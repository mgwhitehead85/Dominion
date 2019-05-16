/**
 * Name: Matt Whitehead
 * Title: Dominion
 * Due Date: 11/30/18
 * Description: Create a superclass called Card that contains all the shared attributes 
 * for the cards in the game Dominion.
 */

public class Card {
	
			// Shared variables for all the cards
	protected String cardType;
	protected String cardName;
	protected int cost;
	protected String special;
	
			// Default
	public Card () {
		cardType = "None";
		cardName = "None";
		cost = 0;
		special = "None";
	}

			// Getters and setters for all card variables
	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

			// Return toString for all shared card variables
	public String toString() {
		return String.format("%-19s %-12s %-6s", cardName, cardType, cost);
	}
	
}
