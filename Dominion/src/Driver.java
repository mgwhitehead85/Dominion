/**
 * Name: Matt Whitehead
 * Title: Dominion
 * Due Date: 11/30/18
 * Description: The Driver class reads in the text file and sets the variables of the cards.
 * A Pile array of cards is created.
 * Players are created and three card stacks are created for them (via linked lists).
 * The game starts and players rotate between turns until 3 piles are empty.
 * A winner is then declared.
 */

import java.io.*;
import java.util.*;

public class Driver {
	
		public static java.io.File inFile;
		public static Scanner inputFile;
		public static Scanner inputFile2;
		public static Scanner input;
		
		public static void main(String[] args) throws IOException {
			
			System.out.println();
			System.out.println("DOMINION\n");
			System.out.println("Let's Play!!\n");
			
			int numOfPlayers = 0;
			int pileCount = getCount();
			Pile[] board = setBoard();
			
					// Sets the number of players. User must enter an input between 2 - 5
			while (numOfPlayers < 2 || numOfPlayers > 5) {
					System.out.print("Enter number of players (2 - 5): ");
					try {
						numOfPlayers = input.nextInt();
					}
					catch (InputMismatchException e) {
						System.out.println("**You must enter a numerical value**");
					}
					input.nextLine();
					System.out.println();
			}
			
			Player[] player = new Player[numOfPlayers];
			
			String deckName = "Deck";
			String discardName = "Discard";
			String handName = "Hand";
			
					// For loop that creates the players and sets up their card stacks
			for (int i = 0; i < numOfPlayers; i++) {
				System.out.print("Enter name of Player " + (i + 1) + " : " );
				String name = input.nextLine();
				CardList deck = new CardList(deckName);
				CardList discard = new CardList(discardName);
				CardList hand = new CardList(handName);
				player[i] = new Player(name, deck, hand, discard);
				CardList.startingDeck(board, discard);
			}

			System.out.println();
			
			int counter = 0;
	
					// While loop to switch back and forth between players' turns
					// Once 3 card piles are empty the while loop is broken and the game is over
			while (GameOver.gameOver(board) < 3) {
				int turn = counter % numOfPlayers;
				
				System.out.println("-------------------------------------\n");
				System.out.println(player[turn].getName() + "'s turn!\n");
				
				ActionPhase.actionPhase(board, player[turn].getDeck(), player[turn].getHand(), player[turn].getDiscard(), pileCount);
				BuyPhase.buyPhase(board, player[turn].getHand(), player[turn].getDiscard(), pileCount);
				counter++;
			}
			
			int max = 0;
			String maxPlayer = "none";
			
					// For loop that puts the player with the highest score into the max slot
			for (int i = 0; i < numOfPlayers; i++) {
				int turn = i % numOfPlayers;
				CardList.moveStack(player[turn].getDeck(), player[turn].getDiscard());
				int points = player[turn].getDiscard().countPoints();
				
				if (points > max) {
					max = points;
					maxPlayer = player[turn].getName();
				}
			}
					// A winner is declared
			System.out.println("The winner is " + maxPlayer + " with " + max + " points!!\n");
		
		}
				
				// Reads-in the text file and sets the game piles
		public static Pile[] setBoard() throws FileNotFoundException {
			input = new Scanner(System.in);

					// Read in cards.txt file
			inFile = new java.io.File("cards.txt");
	
					// If not found then close system
			if(!inFile.exists() ) {
				System.out.println("file not found");
				System.exit(-1);
			}
	
			int pileCount = getCount();
	
			inputFile2 = new Scanner(inFile);
			Pile[] board = new Pile[pileCount];
			int num = 1;
			int numOfCards;
	
					// do while loop to scan lines for different cards
			do {
				String scan = inputFile2.nextLine();
		
						// Scans for victory card header and sets variables for cards and displays
				if (scan.equalsIgnoreCase("victory")) {
					Victory victory = new Victory();
					victory.setCardType("Victory");
					victory.setCardName(inputFile2.nextLine());
					numOfCards = inputFile2.nextInt();
					victory.setCost(inputFile2.nextInt());
					victory.setVictoryPts(inputFile2.nextInt());
					inputFile2.nextLine();
					victory.setSpecial(inputFile2.nextLine());
					board[num] = new Pile(victory, num, numOfCards);
					num++;
				}
		
						// Scans for treasure card header and sets variables for card and displays
				else if (scan.equalsIgnoreCase("treasure")) {
					Treasure treasure = new Treasure();
					treasure.setCardType("Treasure");
					treasure.setCardName(inputFile2.nextLine());
					numOfCards = inputFile2.nextInt();
					treasure.setCost(inputFile2.nextInt());
					treasure.setWorth(inputFile2.nextInt());
					inputFile2.nextLine();
					treasure.setSpecial(inputFile2.nextLine());
					board[num] = new Pile(treasure, num, numOfCards);
					num++;
				}
		
						// Scans for action card header and sets variables for card and displays
				else if (scan.equalsIgnoreCase("action")) {
					Action action = new Action();
					action.setCardType("Action");
					action.setCardName(inputFile2.nextLine());
					numOfCards = inputFile2.nextInt();
					action.setCost(inputFile2.nextInt());
					action.setWorth(inputFile2.nextInt());
					action.setVictoryPts(inputFile2.nextInt());
					action.setAddCards(inputFile2.nextInt());
					action.setAddAction(inputFile2.nextInt());
					action.setAddBuy(inputFile2.nextInt());
					inputFile2.nextLine();
					action.setSpecial(inputFile2.nextLine());
					board[num] = new Pile(action, num, numOfCards);
					num++;
				}
			} while (num < pileCount);
	
			inputFile2.close();
	
			return board;
		}
		
				// Counts the required piles in the text file
		public static int getCount() throws FileNotFoundException {
			input = new Scanner(System.in);

			inFile = new java.io.File("cards.txt");
	
			if(!inFile.exists() ) {
				System.out.println("file not found");
				System.exit(-1);
			}
	
			inputFile = new Scanner(inFile);
			int pileCount = 1;
			boolean closeCount = true;
	
			while (closeCount == true){
				String scanPile = inputFile.nextLine();
		
				if (scanPile.equalsIgnoreCase("victory") || scanPile.equalsIgnoreCase("treasure")
						|| scanPile.equalsIgnoreCase("action")) {
					pileCount++;
				}
				
				else if (scanPile.equals("*")) {
					closeCount = false;
				}
			}
			
			inputFile.close();
	
			return pileCount;
		}
}
	
/**
 * Problems: Dominion Redo #1 - (1) Nodes are now only created when a player buys a card or when the hands are initially
 * created. (2) A player's turn automatically ends when they are out of buys or actions. (3) The hand is now shown at the
 * beginning of each player's turn. (4) Main size has been reduced by half. (5) Actions cards are now played based on their
 * number in the player's hand. (6) When Action cards are played they are removed from a player's hand so they cannot be played
 * again and are then added back into a player's hand for the buy phase.
 */

