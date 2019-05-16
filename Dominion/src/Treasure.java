/**
 * Name: Matt Whitehead
 * Title: Dominion
 * Due Date: 11/30/18
 * Description: This is the subclass for the Treasure cards. This takes the 
 * attributes of the parent class (Card) and adds its own attributes.
 */

public class Treasure extends Card {

			// Added variable for Worth cards
	protected int worth;
	
	public Treasure () {
		super();
		worth = 0;
	}
	
			// Getters and setters for Worth
	public int getWorth() {
		return worth;
	}

	public void setWorth(int worth) {
		this.worth = worth;
	}
	
			// Calls parent toString and adds and formats Treasure-only variables
	public String toString() {
		return super.toString() + String.format("%-8s %-39s %s", "", worth, special);
	}		
}