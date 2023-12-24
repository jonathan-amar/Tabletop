import cards.Card;
import cards.Hand;

/**
 * Represents a holder for a player's hand in a card game.
 *
 * <p>The class provides methods to interact with the player's hand,
 * such as getting the hand value, dealing a card, clearing the hand, and displaying the hand.</p>
 *
 * @author Jonathan Amar
 * @version 1.0
 * @since 1.0
 */
public class HandHolder {
    Hand hand;

    /**
     * Constructs a HandHolder with an empty hand.
     */
    public HandHolder() {
        hand = new Hand();
    }

    /**
     * Gets the total numerical value of the cards in the hand.
     *
     * @return The total value of the cards in the hand.
     */
    public int getHandValue() {
        return hand.getVal();
    }

    /**
     * Deals a card to the player's hand.
     *
     * @param c The card to be added to the hand.
     */
    public void deal(Card c) {
        hand.add(c);
    }

    /**
     * Clears all cards from the player's hand.
     */
    public void clearHand() {
        hand.clearHand();
    }

    /**
     * Displays all cards in the player's hand.
     */
    public void showHand() {
        hand.showHand();
    }

    /**
     * Displays only the top card in the player's hand.
     */
    public void showTopCard() {
        hand.showSomeCards(1);
    }

    /**
     * Checks if the player's hand is bust (total value over 21).
     *
     * @return True if the hand is bust, false otherwise.
     */
    public boolean isBust() {
        return hand.isBust();
    }
}
