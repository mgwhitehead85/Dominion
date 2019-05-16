/**
 * Name: Matt Whitehead
 * Title: Dominion
 * Due Date: 11/30/18
 * Description: This class controls the action phase of the game. Players
 * can use action cards based on how many actions they have. Once all their
 * actions are exhausted or they no longer want to play cards then it moves
 * to the buy phase
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class ActionPhase {
	public static Scanner input = new Scanner(System.in);
	
			// Runs through the action phase for each players' turn
	public static void actionPhase(Pile[] board, CardList deck, CardList hand, CardList discard, int pileCount) {
		CardList.moveToHand(deck, hand, discard);
		System.out.println("Your Hand:");
		hand.show();
		System.out.println();
		
		int userInput = -1;
		
		int actionCount = hand.countActions();
		int actionCheck = 1;
		
		if (actionCount > 0) {
			actionCount = 1;
		}
		
		else {
			actionCount = 0;
		}
		
		if(actionCount == 0) {
			System.out.println("***No actions available. Move to buy phase***\n");
		}
		
		else {
		
					// Linked list to hold the played cards temporarily
			CardList used = new CardList();
		
		while (userInput != 4 && actionCheck > 0) {
			System.out.println("You have " + actionCount + " actions. What would you like to do?");
			System.out.println("[1] Use action");
			System.out.println("[2] Show hand");
			System.out.println("[3] Display board");
			System.out.println("[4] Go to buy phase");
			System.out.print("Enter a number: ");
			try {
				userInput = input.nextInt();
			}
			
					// Catches any character inputs and converts them to 0
			catch (InputMismatchException e) {
				userInput = 0;
				input.nextLine();
			}
			
			if (userInput == 1) {
				if (actionCount > 0) {
					System.out.println();
					hand.show();
					int cardCount = hand.getCount();
					int actionCard = 0;
					System.out.println("\nWhich action card would you like to use?");
					System.out.print("Enter card number: ");
					try {
						actionCard = input.nextInt();
					}
					catch (InputMismatchException e) {
						actionCard = 0;
						input.nextLine();
					}
					
							// Numbers outside 1, 2, 3, or 4 are handled. So are characters as they are converted to 0.
					if (actionCard <= 0 || actionCard > cardCount) {
						System.out.println("\n**Not a valid input**\n");
					}
					
							// Conditionals to find the action cards played, add or subtract actions based on their attributes,
							// move them to a temporary linked list once played, and delete from the players' hand so they
							// cannot be used again.
					else if (hand.getNth(actionCard - 1).getCardName().equalsIgnoreCase("Village") && hand.checkHand("Village")) {
						CardList.moveToTemp(hand, used, actionCard - 1);
						CardList.moveCard(deck, hand, discard);
						actionCount++;
						System.out.println("\nYou used the Village card\n");
						actionCheck = hand.countActions();
						if(actionCheck < 1) {
							System.out.println("There are no action cards in your hand. Move to Buy Phase.\n");
						}
					}
				
					else if (hand.getNth(actionCard - 1).getCardName().equalsIgnoreCase("Smithy") && hand.checkHand("Smithy")) {
						CardList.moveToTemp(hand, used, actionCard - 1);
						CardList.moveCard(deck, hand, discard);
						CardList.moveCard(deck, hand, discard);
						CardList.moveCard(deck, hand, discard);
						actionCount--;
						System.out.println("\nYou used the Smithy card\n");
						actionCheck = hand.countActions();
						if(actionCheck < 1) {
							System.out.println("There are no action cards in your hand. Move to Buy Phase.\n");
						}
					}
					
					else if (hand.getNth(actionCard - 1).getCardName().equalsIgnoreCase("Woodcutter") && hand.checkHand("Woodcutter")) {
						CardList.moveToTemp(hand, used, actionCard - 1);
						actionCount--;
						System.out.println("\nYou used the Woodcutter card\n");
						actionCheck = hand.countActions();
						if(actionCheck < 1) {
							System.out.println("There are no action cards in your hand. Move to Buy Phase.\n");
						}
					}

					else if (hand.getNth(actionCard - 1).getCardName().equalsIgnoreCase("Worker's Village") && hand.checkHand("Worker's Village")) {
						CardList.moveToTemp(hand, used, actionCard - 1);
						CardList.moveCard(deck, hand, discard);
						actionCount++;
						System.out.println("\nYou used the Worker's Village card\n");
						actionCheck = hand.countActions();
						if(actionCheck < 1) {
							System.out.println("There are no action cards in your hand. Move to Buy Phase.\n");
						}
					}
					
					else if (hand.getNth(actionCard - 1).getCardName().equalsIgnoreCase("Festival") && hand.checkHand("Festival")) {
						CardList.moveToTemp(hand, used, actionCard - 1);
						actionCount++;
						System.out.println("\nYou used the Festival card\n");
						actionCheck = hand.countActions();
						if(actionCheck < 1) {
							System.out.println("There are no action cards in your hand. Move to Buy Phase.\n");
						}
					}
					
					else if (hand.getNth(actionCard - 1).getCardName().equalsIgnoreCase("Laboratory") && hand.checkHand("Laboratory")) {
						CardList.moveToTemp(hand, used, actionCard - 1);
						CardList.moveCard(deck, hand, discard);
						System.out.println("\nYou used the Laboratory card\n");
						actionCheck = hand.countActions();
						if(actionCheck < 1) {
							System.out.println("There are no action cards in your hand. Move to Buy Phase.\n");
						}
					}
					
					else if (hand.getNth(actionCard - 1).getCardName().equalsIgnoreCase("Market") && hand.checkHand("Market")) {
						CardList.moveToTemp(hand, used, actionCard - 1);
						CardList.moveCard(deck, hand, discard);
						System.out.println("\nYou used the Market card\n");
						actionCheck = hand.countActions();
						if(actionCheck < 1) {
							System.out.println("There are no action cards in your hand. Move to Buy Phase.\n");
						}
					}
					
					else if (hand.getNth(actionCard - 1).getCardName().equalsIgnoreCase("Cellar") && hand.checkHand("Cellar")) {
						CardList.moveToTemp(hand, used, actionCard - 1);
						System.out.println("\nYou used the Cellar card\n");
						actionCheck = hand.countActions();
						if(actionCheck < 1) {
							System.out.println("There are no action cards in your hand. Move to Buy Phase.\n");
						}
					}
					
					else if (hand.getNth(actionCard - 1).getCardName().equalsIgnoreCase("Oasis") && hand.checkHand("Oasis")) {
						CardList.moveToTemp(hand, used, actionCard - 1);
						CardList.moveCard(deck, hand, discard);
						System.out.println("\nYou used the Oasis card\n");
						actionCheck = hand.countActions();
						if(actionCheck < 1) {
							System.out.println("There are no action cards in your hand. Move to Buy Phase.\n");
						}
					}
					
					else if (hand.getNth(actionCard - 1).getCardName().equalsIgnoreCase("Junk Dealer") && hand.checkHand("Junk Dealer")) {
						CardList.moveToTemp(hand, used, actionCard - 1);
						CardList.moveCard(deck, hand, discard);
						System.out.println("\nYou used the Junk Dealer card\n");
						actionCheck = hand.countActions();
						if(actionCheck < 1) {
							System.out.println("There are no action cards in your hand. Move to Buy Phase.\n");
						}
					}
					
					else if (hand.getNth(actionCard - 1).getCardName().equalsIgnoreCase("Monument") && hand.checkHand("Monument")) {
						CardList.moveToTemp(hand, used, actionCard - 1);
						actionCount--;
						System.out.println("\nYou used the Monument card\n");
						actionCheck = hand.countActions();
						if(actionCheck < 1) {
							System.out.println("There are no action cards in your hand. Move to Buy Phase.\n");
						}
					}
					
					else if (hand.getNth(actionCard - 1).getCardName().equalsIgnoreCase("Great Hall") && hand.checkHand("Great Hall")) {
						CardList.moveToTemp(hand, used, actionCard - 1);
						CardList.moveCard(deck, hand, discard);
						System.out.println("\nYou used the Great Hall card\n");
						actionCheck = hand.countActions();
						if(actionCheck < 1) {
							System.out.println("There are no action cards in your hand. Move to Buy Phase.\n");
						}
					}
					
					else {
						System.out.println("\n" + hand.getNth(actionCard - 1).getCardName() + " card cannot be played\n");
					}
				}
				
				else {
					System.out.println("\nYou do not have any actions left\n");
					actionCheck = hand.countActions();
				}
			}
			
			else if (userInput == 2) {
				System.out.println("\nYour Hand:");
				hand.show();
				System.out.println();
			}
			
			else if (userInput == 3) {
				System.out.println();
				Display.displayBoard(board);
			}
			
			else if (userInput == 4) {
				System.out.println();
			}
			
			else {
				System.out.println("\n**Not a valid input**\n");
			}
		}
				// Unused action and victory cards are moved to discard pile
				// Played action cards are moved back into the players' hand
		hand.discardUnusedCards(hand, discard);
		CardList.moveStack(used, hand);
		}
    }
}
