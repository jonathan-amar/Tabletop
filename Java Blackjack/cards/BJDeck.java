package cards;

/**
 * Represents a deck of playing cards specifically designed for a Blackjack (BJ) game.
 *
 * <p>The Blackjack deck is initialized with six standard playing card decks and shuffled.</p>
 *
 * @author Jonathan Amar
 * @version 1.0
 * @since 1.0
 */
public class BJDeck extends Deck {

    /**
     * Constructs a Blackjack deck with six standard playing card decks and shuffles the cards.
     */
    public BJDeck() {
        super(6);
        this.shuffle();
    }
}
