/**
 * Name: Matt Whitehead
 * Title: Dominion
 * Due Date: 11/30/18
 * Description: CardList to create the linked lists for the different card stacks.
 * These allow players to move cards between stacks, clear stacks, display stacks,
 * and shuffle stacks.
 */

import java.util.Random;

public class CardList {

	Node head;
	int count = 0;
	String name = "none";
	
	public CardList() {
		head = null;
	}
	
	public CardList(String name) {
		this.name = name;
		head = null;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
			// Moves nodes between stacks without creating new nodes
	public static void moveCard(CardList stack1, CardList stack2, int position) {
		Node current1 = stack1.head;
		Node current2 = stack2.head;
		Node previous2 = stack2.head;
		int count = 0;
		
		if(current1 == null) {
			if (position == 0) {
				stack2.head = current2.link;
				stack1.head = previous2;
				previous2.link = null;
			}
			
			else if (position > 0 && position < stack2.getCount()) {
				while(count < position) {
					previous2 = current2;
					current2 = current2.link;
					count++;
				}
			
				stack1.head = current2;
				previous2.link = current2.link;
				current2.link = null;
			}
		}
		
		else {
			while(current1.link != null) {
				current1 = current1.link;
			}
		
			if (position == 0) {
				stack2.head = current2.link;
				current1.link = previous2;
				previous2.link = null;
			}
		
			else if (position > 0 && position < stack2.getCount()) {
				while(count < position) {
					previous2 = current2;
					current2 = current2.link;
					count++;
				}
		
				current1.link = current2;
				previous2.link = current2.link;
				current2.link = null;
			}
		}
	}
		
			// Adds a new node to the front of a linked list. Only used for buying and setting up decks.
	public void addToHead(Card card) {
		Node newNode = new Node();
		newNode.card = card;
		
		if (head == null) {
			head = newNode;
		}
		
		else {
			newNode.link = head;
			head = newNode;
		}
	}

			// Displays a linked list
	public void show() {
		Node node = head;
		int count = 1;
		
		try {
			while (node.link != null) {
				System.out.println("(" + count + ") " + node.card.getCardName());
				node = node.link;
				count++;
			}
			System.out.println("(" + count + ") " + node.card.getCardName());
		}
		
		catch (NullPointerException e) {
			System.out.println("Stack is empty.");
		}
	}
	
			// Counts the nodes in a linked list
	public int getCount() {
		Node node = head;
		int count = 0;
		
		while (node != null) {
			count++;
			node = node.link;
		}
		return count;
	}
	
			// Counts action cards in a players hand
	public int countActions() {
		Node node = head;
		int count = 0;
		
		while (node != null) {
			if(node.getCard().getCardType() == "Action") {
				count ++;
			}
			node = node.link;
		}
		return count;
	}
	
			// Counts the amount of coins a player has in their hand
	public int countCoins() {
		Node current = head;
		int count = 0;
		
		while (current != null)  {
			if(current.card.getCardName().equalsIgnoreCase("Copper")) {
				count = count + 1;
				current = current.link;
			}
			else if(current.card.getCardName().equalsIgnoreCase("Silver")) {
				count = count + 2;
				current = current.link;
			}
			else if(current.card.getCardName().equalsIgnoreCase("Gold")) {
				count = count + 3;
				current = current.link;
			}
			else if(current.card.getCardName().equalsIgnoreCase("Festival")) {
				count = count + 2;
				current = current.link;
			}
			else if(current.card.getCardName().equalsIgnoreCase("Laboratory")) {
				count = count + 1;
				current = current.link;
			}
			else if(current.card.getCardName().equalsIgnoreCase("Market")) {
				count = count + 1;
				current = current.link;
			}
			else if(current.card.getCardName().equalsIgnoreCase("Oasis")) {
				count = count + 1;
				current = current.link;
			}
			else if(current.card.getCardName().equalsIgnoreCase("Platinum")) {
				count = count + 5;
				current = current.link;
			}
			else if(current.card.getCardName().equalsIgnoreCase("Junk Dealer")) {
				count = count + 1;
				current = current.link;
			}
			else if(current.card.getCardName().equalsIgnoreCase("Monument")) {
				count = count + 2;
				current = current.link;
			}
			else {
				current = current.link;
			}
		}
		return count;
	}
	
			// Counts the amount of buys a player has in their hands
	public int countBuys() {
		Node current = head;
		int count = 1;
		
		while (current != null)  {
			if(current.card.getCardName().equalsIgnoreCase("Woodcutter")) {
				count = count + 1;
				current = current.link;
			}
			else if(current.card.getCardName().equalsIgnoreCase("Worker's Village")) {
				count = count + 1;
				current = current.link;
			}
			else if(current.card.getCardName().equalsIgnoreCase("Festival")) {
				count = count + 1;
				current = current.link;
			}
			else if(current.card.getCardName().equalsIgnoreCase("Laboratory")) {
				count = count + 1;
				current = current.link;
			}
			else if(current.card.getCardName().equalsIgnoreCase("Market")) {
				count = count + 1;
				current = current.link;
			}
			else {
				current = current.link;
			}
		}
		return count;
	}
	
			// Counts the amount of point a player has in their hand
	public int countPoints() {
		Node current = head;
		int count = 0;
		
		while (current != null)  {
			if(current.card.getCardName().equalsIgnoreCase("Estate")) {
				count = count + 1;
				current = current.link;
			}
			else if(current.card.getCardName().equalsIgnoreCase("Duchy")) {
				count = count + 3;
				current = current.link;
			}
			else if(current.card.getCardName().equalsIgnoreCase("Province")) {
				count = count + 6;
				current = current.link;
			}
			else if(current.card.getCardName().equalsIgnoreCase("Monument")) {
				count = count + 1;
				current = current.link;
			}
			else if(current.card.getCardName().equalsIgnoreCase("Great Hall")) {
				count = count + 1;
				current = current.link;
			}
			else {
				current = current.link;
			}
		}
		return count;
	}
	
			// Returns a card based on a given position
	public Card getNth(int position) {
		Node current = head;
		int count = 0;
		
		while (current != null) {
			if (count == position) {
				return current.card;
			}
			
			else {
				count++;
				current = current.link;
			}
		}
		return null;
	}
	
			// Checks to see if a card exists in a players' hand
	public boolean checkHand(String name) {
		Node current = head;
		
		while (current != null) {
			if (current.card.getCardName().equalsIgnoreCase(name)) {
				return true;
			}
			else {
				current = current.link;
			}
		}
		return false;
	}
	
			// Finds a card's pile position based on its name
	public static int findPosition(Pile[] board, String name) {
		for (int i = 1; i < board.length; i++) {
			if (board[i].getCard().getCardName().equalsIgnoreCase(name)) {
				return i;
			}
			else {
			}
		}
		return 0;
	}
	
			// Discards unused Action cards and Victory cards
	public void discardUnusedCards(CardList hand, CardList discard) {
		Node current = head;
		int count = 0;
		
		while (current != null) {
			if (current.card.getCardType().equalsIgnoreCase("Action")) {
				moveCard(discard, hand, count);
				current = head;
				count = 0;
			}
			
			else if (current.card.getCardType().equalsIgnoreCase("Victory")) {
				moveCard(discard, hand, count);
				current = head;
				count = 0;
			}
			
			else {
				count++;
				current = current.link;
			}
		}
	}

			// Deletes card based on a given position
	public void deleteCard(int position) {
		Node current = head;
		Node previous = head;
		int count = 0;
		
		if (head == null) {
			System.out.println("Cannot delete card. Stack is empty.");
		}
		
		if (position == 0) {
			head = head.link;
		}
		
		while (current != null && (count < position)) {
			count++;
			previous = current;
			current = current.link;
		}
			
		if (current == null) {
			System.out.println("This position is off the linked list");
		}
			
		else {
			previous.link = current.link;
		}
	}
	
			// Shuffles cards by randomly getting a position in the list,
			// the tail of the lists points at that position, and the card is then deleted
	public static void shuffle(CardList stack) {
		int count = stack.getCount() - 1;
		Random random = new Random();
		
		if (count == 0) {
			System.out.println("Cannot shuffle. Stack is empty.");
		}
		
		else {
			for (int i = 0; i < 30; i++) {
				int position = 0 + random.nextInt(count);
				moveCard(stack, stack, position);
			}
		}
	}
	
			// Moves card at the top of a list to the tail of another list
	public static void moveCard(CardList deck, CardList hand, CardList discard) {
		if (deck.getNth(0) == null) {
			shuffle(discard);
			moveStack(discard, deck);
			moveCard(hand, deck, 0);
		}
		
		else {
			moveCard(hand, deck, 0);
		}
	}
	
			// Finds the cards position in the stack based on its name
	public int findCard(String name) {
		Node current = head;
		int count = 0;
		
		while (current != null) {
			if (current.card.getCardName().equalsIgnoreCase(name)) {
				return count;
			}
			else {
				count++;
				current = current.link;
			}
		}
		return count;
	}
	
			// Moves played cards to a temporary linked list so that they cannot be played twice
	public static void moveToTemp(CardList hand, CardList temp, int position) {
		moveCard(temp, hand, position);
	}
	
			// Moves entire contents of a list to the tail of another list
	public static void moveStack(CardList stack1, CardList stack2) {
		int count = stack1.getCount();
		
		if (count > 0) {
			for(int i = 0; i < count; i++) {
				moveCard(stack2, stack1, 0);
			}
		}
	}
	
			// Moves 5 cards from the deck list to the hand list
	public static void moveToHand(CardList deck, CardList hand, CardList discard) {
		for(int i = 0; i < 5; i++) {
			moveCard(deck, hand, discard);
		}
	}
	
			// Creates starting discard stack for each player with 7 Coppers and 3 Estates
	public static void startingDeck(Pile[] board, CardList discard) {
		int cardAmount;
		String estate = "Estate";
		String copper = "Copper";
		
		int estatePosition = findPosition(board, estate);
		int copperPosition = findPosition(board, copper);
		
		for (int i = 0; i < 7; i++) {
			discard.addToHead(board[copperPosition].getCard());
			cardAmount = board[copperPosition].getNumOfCards() - 1;
			board[copperPosition].setNumOfCards(cardAmount);
		}
	
		for (int i = 0; i < 3; i++) {
			discard.addToHead(board[estatePosition].getCard());
			cardAmount = board[estatePosition].getNumOfCards() - 1;
			board[estatePosition].setNumOfCards(cardAmount);
		}
	}
}
