/**
 * Name: Matt Whitehead
 * Title: Dominion
 * Due Date: 11/30/18
 * Description: This is the subclass for the Action cards. This takes the 
 * attributes of the parent class (Card) and adds its own attributes.
 */

public class Action extends Card {
	
			// Added variables for Action cards
	protected int worth;
	protected int victoryPts;
	protected int addCards;
	protected int addAction;
	protected int addBuy;
	
	public Action () {
		super();
		worth = 0;
		victoryPts = 0;
		addCards = 0;
		addAction = 0;
		addBuy = 0;
	}
	
			// Getters and setters for action variables
	public int getWorth() {
		return worth;
	}

	public void setWorth(int worth) {
		this.worth = worth;
	}

	public int getVictoryPts() {
		return victoryPts;
	}

	public void setVictoryPts(int victoryPts) {
		this.victoryPts = victoryPts;
	}

	public int getAddCards() {
		return addCards;
	}

	public void setAddCards(int addCards) {
		this.addCards = addCards;
	}

	public int getAddAction() {
		return addAction;
	}

	public void setAddAction(int addAction) {
		this.addAction = addAction;
	}

	public int getAddBuy() {
		return addBuy;
	}

	public void setAddBuy(int addBuy) {
		this.addBuy = addBuy;
	}

			// Calls parent toString and adds and formats Action-only variables
	public String toString() {
		return super.toString() + String.format("%s %-7s %-9s %-11s %-9s %-7s %s",
				"", victoryPts, worth, addCards, addAction, addBuy, special);
	}
}