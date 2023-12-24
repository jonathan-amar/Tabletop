import java.util.InputMismatchException;
import java.util.Scanner;
import cards.BJDeck;

/**
 * Represents a simple implementation of the Blackjack card game.
 *
 * <p>This class manages the game flow, player interaction, and card dealing.</p>
 *
 * <p><strong>Note:</strong> The game assumes a simple text-based interface and is played against the house.</p>
 *
 * @author Jonathan Amar
 * @version 1.0
 * @since 1.0
 */
public class Blackjack {
    private static final int QUIT_GAME = -1;
    private static BJDeck deck;
    private static Scanner scanner;
    private static Player player;
    private static HandHolder house;
    private static int wager;

    /**
     * Displays the title card of the Blackjack game.
     */
    private static void displayTitle() {
        System.out.println();
        System.out.println("************************************");
        System.out.println("******* WELCOME TO BLACKJACK *******");
        System.out.println("************************************");
    }

    /**
     * Retrieves the bet amount from the player.
     *
     * @param scanner The scanner object for input.
     * @param player  The player object.
     * @return The bet amount entered by the player.
     */
    private static int getBet(Scanner scanner, Player player) {
        int bet;
        do {
            bet = QUIT_GAME;
            System.out.println("Your Credits: " + player.getCredits());
            System.out.println();
            System.out.print("Enter your wager (" + QUIT_GAME + " to quit): ");
            try {
                bet = scanner.nextInt();

                if (bet > player.getCredits()) {
                    System.out.println("You don't have that many credits!");
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("ERROR: Please enter a number");
                System.out.println();
            }
            scanner.nextLine();
        } while (bet > player.getCredits() || bet < QUIT_GAME);
        return bet;
    }

    /**
     * Deals a card to a hand holder.
     *
     * @param handHolder The hand holder to deal the card to.
     */
    private static void deal(HandHolder handHolder) {
        handHolder.deal(deck.draw());
    }

    /**
     * Sets up the initial game board by dealing cards to the house and player.
     */
    private static void boardSetup() {
        house.deal(deck.draw());
        player.deal(deck.draw());
        house.deal(deck.draw());
        player.deal(deck.draw());
    }

    /**
     * Clears the cards from the game board.
     */
    private static void clearBoard() {
        house.clearHand();
        player.clearHand();
    }

    /**
     * Displays the current state of the game board, showing the player cards and first house card
     */
    private static void showBoard() {
        System.out.println("HOUSE CARDS : ");
        house.showTopCard();
        System.out.println("YOUR CARDS : ");
        player.showHand();
    }

    /**
     * Displays the full game board, showing all cards of the house and player.
     */
    private static void showFullBoard() {
        System.out.println("HOUSE CARDS : ");
        house.showHand();
        System.out.println("YOUR CARDS : ");
        player.showHand();
    }

    /**
     * Displays the total values of the house and player hands.
     */
    private static void displayValues() {
        System.out.println("HOUSE VALUE : " + house.getHandValue());
        System.out.println("YOUR VALUE : " + player.getHandValue());
    }

    /**
     * Asks the player whether to hit or stand and returns the decision.
     *
     * @param scanner The scanner object for input.
     * @return True if the player chooses to hit, false if they choose to stand.
     */
    private static boolean hitOrStand(Scanner scanner) {
        int choice = -1;
        do {
            System.out.print("Enter 1 to hit, enter 0 to stand: ");
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("ERROR: Please enter a number");
                System.out.println();
            }
            scanner.nextLine();
        } while (choice != 0 && choice != 1);
        return choice == 1;
    }


    /**
    * Manages the player's turn in the Blackjack game, allowing them to hit or stand until they bust or choose to stand.
    * Draws cards for the player, updates the display, and continues until the player busts, reaches 21, or stands.
    */
    private static void playerTurn(){
        while (!player.isBust() && player.getHandValue() != 21 && hitOrStand(scanner)) {
                deal(player);
                showBoard();
            }
    }

    /**
     * Handles the outcome of the Blackjack game based on the final hands of the player and the house.
     * Displays messages for different outcomes, such as bust, blackjack, or winning/losing against the house.
     * Adjusts the player's credits accordingly.
     */
    private static void handleOutcome(){
        if (player.isBust()) {
                System.out.println("BUSTED");
                System.out.println();
                System.out.println();
            } else if (player.getHandValue() == 21) {
                System.out.println("BLACKJACK!!");
                System.out.println("YOU WIN!!");
                System.out.println();
                System.out.println();
                player.addCredits(wager * 2);
            } else {
                while (!house.isBust() && house.getHandValue() < player.getHandValue()) {
                    deal(house);
                }
                showFullBoard();
                if (house.isBust()) {
                    displayValues();
                    System.out.println();
                    System.out.println("House busted, you win!");
                    System.out.println();
                    System.out.println();
                    player.addCredits(wager * 2);
                } else {
                    if (house.getHandValue() == 21) {
                        System.out.println("HOUSE BLACKJACK");
                    }
                    displayValues();
                    System.out.println("YOU LOSE");
                    System.out.println("");
                    System.out.println("");
                }
    }
}

    /** 
     * Manages all rounds of Blackjack, including player's turn and handling the outcome.
     * Manages the bet, card dealing, and displaying the board until the player decides to quit or runs out of credits.
     */
    private static void play(){
        while (player.getCredits() != 0) {
            clearBoard();
            boardSetup();
            wager = getBet(scanner, player);
            if (wager == QUIT_GAME) break;
            player.bet(wager);
            showBoard();
            playerTurn();
            handleOutcome();
        }
    }

    /**
     * Displays the final results of the Blackjack game based on the player's credit status.
     * Prints messages indicating whether the player ran out of credits or ended with a specific credit amount.
     */
    public static void displayGameResults(){
        if (player.getCredits() == 0) {
            System.out.println("You have run out of credits, the House wins!");
            System.out.println("Better luck next time!");
        } else {
            System.out.println("You ended with " + player.getCredits() + " credits!");
            System.out.println("See you next time!");
        }
        }

    /**
     * Manages the overall flow of the Blackjack game.
     * Initializes game components, processes multiple rounds until the player runs out of credits or chooses to quit.
     * Displays final game results.
     */
    public static void blackJack() {
        deck = new BJDeck();
        player = new Player();
        house = new HandHolder();
        scanner = new Scanner(System.in);
        displayTitle();
        deck.discard();
        play();
        displayGameResults();
        return;
    }

    /**
     * The main method to start the Blackjack game.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        blackJack();
    }
}
