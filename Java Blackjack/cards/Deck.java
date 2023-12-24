package cards;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a deck of playing cards. Includes functionality for drawing and discarding cards.
 *
 * @author Jonathan Amar
 * @version 1.0
 * @since 1.0
 */
public class Deck {
    private ArrayList<Card> deck;

    /**
     * Constructs a deck with standard playing cards.
     */
    public Deck() {
        this(1);
    }

    /**
     * Constructs a deck with a specified number of standard playing card decks.
     *
     * @param numDecks The number of decks to include in the combined deck.
     */
    public Deck(int numDecks) {
        if (deck == null) {
            deck = new ArrayList<Card>();
            for (int i = 0; i < numDecks; i++) {
                for (Suit s : Suit.values()) {
                    for (Rank r : Rank.values()) {
                        deck.add(new Card(s, r));
                    }
                }
            }
        }
    }

    /**
     * Gets the number of cards in the deck.
     *
     * @return The number of cards in the deck.
     */
    public int numCards() {
        return deck.size();
    }

    /**
     * Discards the top card from the deck.
     */
    public void discard() {
        deck.remove(0);
    }

    /**
     * Draws the top card from the deck.
     *
     * @return The top card from the deck.
     */
    public Card draw() {
        return deck.remove(0);
    }

    /**
     * Shuffles the cards in the deck.
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Gets the entire deck of cards.
     *
     * @return The ArrayList containing all cards in the deck.
     */
    public ArrayList<Card> getDeck() {
        return deck;
    }
}
