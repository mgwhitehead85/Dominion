/**
 * Name: Matt Whitehead
 * Title: Dominion
 * Due Date: 11/30/18
 * Description: This is the subclass for the Victory cards. This takes the 
 * attributes of the parent class (Card) and adds its own attributes.
 */

public class Victory extends Card {
	
			// Added variable for Victory cards
	protected int victoryPts;
	
	public Victory () {
		super();
		victoryPts = 0;
	}
	
			// Getters and setters for Victory Points
	public int getVictoryPts() {
		return victoryPts;
	}

	public void setVictoryPts(int victoryPts) {
		this.victoryPts = victoryPts;
	}
	
			// Calls parent toString and adds and formats Victory-only variables 
	public String toString() {
		return super.toString() + String.format("%s %-47s %s", "", victoryPts, special);
	}		
}
