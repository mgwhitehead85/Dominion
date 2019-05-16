/**
 * Name: Matt Whitehead
 * Title: Dominion
 * Due Date: 11/30/18
 * Description: This class controls the buy phase. This phase allows players
 * to buy more cards based on how many buys and coins they have in their hand
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class BuyPhase {
	public static Scanner input = new Scanner(System.in);
	
			// Runs through the buy phase for each players' turn
	public static void buyPhase(Pile[] board, CardList hand, CardList discard, int pileCount) {
		
		int userInput = -1;
		int coinCount = hand.countCoins();
		int buyCount = hand.countBuys();
		
		while (buyCount > 0 && userInput != 4) {
			int cardAmount;
			
			System.out.println("You have " + coinCount + " coins & " + buyCount + " buys. What would you like to do?");
			System.out.println("[1] Buy a card");
			System.out.println("[2] Show hand");
			System.out.println("[3] Display board");
			System.out.println("[4] End your turn");
			System.out.print("Enter a number: ");
			try {
				userInput = input.nextInt();
			}
			catch (InputMismatchException e) {
				userInput = 0;
				input.nextLine();
			}
		
			if (userInput == 1) {
				int cardBuy = 0;
				Display.displayBoard(board);
				System.out.println("You have " + coinCount + " coins. Which card would you like to buy?");
				System.out.print("Enter card number: ");
				try {
					cardBuy = input.nextInt();
				}
				catch (InputMismatchException e) {
					cardBuy = 0;
					input.nextLine();
				}
				
				if (cardBuy <= 0 || cardBuy >= pileCount) {
					System.out.println("\n**Not a valid input**\n");
				}
					
						// When the player buys a card it is added to their discard pile and the total card amount is reduced
				else if (coinCount >= board[cardBuy].getCard().getCost() && buyCount > 0 && board[cardBuy].getNumOfCards() > 0) {
					discard.addToHead(board[cardBuy].getCard());
					cardAmount = board[cardBuy].getNumOfCards() - 1;
					board[cardBuy].setNumOfCards(cardAmount);
					coinCount = coinCount - board[cardBuy].getCard().getCost();
					buyCount--;
					System.out.println("\nYou purchased the " + board[cardBuy].getCard().getCardName() + " card\n");
				}
				
						// Error message when a player doesn't have enough coins
				else if (coinCount < board[cardBuy].getCard().getCost()) {
					System.out.println("\n-------------------------------------------------------------");
					System.out.println("You do not have enough coins to buy the " + board[cardBuy].getCard().getCardName() + " card");
					System.out.println("-------------------------------------------------------------\n");
				}
				
						// Allows players to always purchase Coppers
				else if (buyCount == 0 && board[cardBuy].getNumOfCards() > 0){
					if (board[cardBuy].getCard().getCardName().equalsIgnoreCase("Copper")) {
						discard.addToHead(board[cardBuy].getCard());
						cardAmount = board[cardBuy].getNumOfCards() - 1;
						board[cardBuy].setNumOfCards(cardAmount);
						System.out.println("\nYou purchased the " + board[cardBuy].getCard().getCardName() + " card\n");
					}
				
							// Error message when a player doesn't have enough buys
					else {
						System.out.println("\n------------------------------------------------------------");
						System.out.println("You do not have enough buys to buy the " + board[cardBuy].getCard().getCardName() + " card");
						System.out.println("------------------------------------------------------------\n");
					}
				}
				
						// Error message if player buys from a card pile that is empty
				else if (board[cardBuy].getNumOfCards() < 1) {
					System.out.println("\n****The " + board[cardBuy].getCard().getCardName() + " pile is empty****\n");
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
				// Moves all cards in the players' hand to their discard pile when their turn is over
		CardList.moveStack(hand, discard);
    }
}
