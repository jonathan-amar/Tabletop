package cards;

import java.util.ArrayList;

/**
 * Represents a hand of playing cards in a card game.
 *
 * <p>The class provides methods to manipulate and display the hand, such as adding cards, getting the hand value,
 * checking if the hand is bust, and displaying the cards in the hand.</p>
 *
 * @author Jonathan Amar
 * @version 1.0
 * @since 1.0
 */
public class Hand {
    ArrayList<Card> hand;

    /**
     * Constructs an empty hand.
     */
    public Hand() {
        hand = new ArrayList<>();
    }

    /**
     * Gets the total numerical value of the cards in the hand.
     *
     * @return The total value of the cards in the hand.
     */
    public int getVal() {
        int handVal = 0;
        for (Card c : hand) {
            handVal += c.getValue();
        }
        return handVal;
    }

    /**
     * Adds a card to the hand and adjusts the value if necessary (for high Aces).
     *
     * @param c The card to add to the hand.
     */
    public void add(Card c) {
        hand.add(c);
        while (getVal() > 21 && hasHighAce()) {
            aceToLow();
        }
    }

    /**
     * Checks if the hand has a high Ace.
     *
     * @return True if the hand has a high Ace, false otherwise.
     */
    private boolean hasHighAce() {
        for (Card c : hand) {
            if (c.getValue() == 11) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the hand is bust (total value over 21).
     *
     * @return True if the hand is bust, false otherwise.
     */
    public boolean isBust() {
        return getVal() > 21;
    }

    /**
     * Converts a high Ace in the hand to a low Ace.
     *
     * @return True if a high Ace was converted, false otherwise.
     */
    private boolean aceToLow() {
        for (Card c : hand) {
            if (c.aceHighToLow()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Displays all cards in the hand.
     */
    public void showHand() {
        showSomeCards(hand.size());
    }

    /**
     * Displays a specified number of cards in the hand as face up, the rest faced down.
     *
     * @param cardNum The number of cards to display faced up.
     */
    public void showSomeCards(int cardNum) {
        for (int i = 0; i < hand.size(); i++)
            System.out.print("_____  ");
        System.out.println();
        for (int i = 0; i < hand.size(); i++)
            System.out.print("|   |  ");
        System.out.println();
        for (int i = 0; i < hand.size(); i++) {
            System.out.print("| ");
            if (i < cardNum)
                System.out.print(hand.get(i).displayChar());
            else System.out.print(" ");
            if (hand.get(i).getRank() == Rank.TEN && i < cardNum)
                System.out.print("|  ");
            else
                System.out.print(" |  ");
        }
        System.out.println();
        for (int i = 0; i < hand.size(); i++)
            System.out.print("|   |  ");
        System.out.println();
        for (int i = 0; i < hand.size(); i++)
            System.out.print("-----  ");
        System.out.println();
        System.out.println();
    }

    /**
     * Gets the number of cards in the hand.
     *
     * @return The number of cards in the hand.
     */
    public int getNumCards() {
        return hand.size();
    }

    /**
     * Clears all cards from the hand.
     */
    public void clearHand() {
        hand.clear();
    }
}
