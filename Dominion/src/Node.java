/**
 * Name: Matt Whitehead
 * Title: Dominion
 * Due Date: 11/30/18
 * Description: Node class used by the Linked List to hold the card data
 * and reference previous and next elements.
 * 
 */

public class Node {
	Card card;
	Node link;

	public Node () {
		card = null;
	}

	public Node(Card card) {
		this.card = card;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
}

