/**
 * Name: Matt Whitehead
 * Title: Dominion
 * Due Date: 11/30/18
 * Description: Player class that assigns names and the 3 Linked Lists all players will have.
 */

public class Player {

	protected String name;
	protected CardList deck;
	protected CardList hand;
	protected CardList discard;
	
	public Player() {
		name = "none";
		hand = null;
		deck = null;
		discard = null;
	}
	
	public Player(String name, CardList deck, CardList hand, CardList discard) {
		this.name = name;
		this.deck = deck;
		this.hand = hand;
		this.discard = discard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CardList getDeck() {
		return deck;
	}

	public void setDeck(CardList deck) {
		this.deck = deck;
	}

	public CardList getHand() {
		return hand;
	}

	public void setHand(CardList hand) {
		this.hand = hand;
	}

	public CardList getDiscard() {
		return discard;
	}

	public void setDiscard(CardList discard) {
		this.discard = discard;
	}
	
	
	
}