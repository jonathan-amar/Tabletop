package cards;

/**
 * Represents a playing card with a specific suit and rank.
 *
 * @author Jonathan Amar
 * @version 1.0
 * @since 1.0
 */
public class Card {
    private Suit suit;
    private Rank rank;
    private int rankValue;

    /**
     * Constructs a Card with the specified suit and rank.
     *
     * @param suit The suit of the card.
     * @param rank The rank of the card.
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        rankValue = rank.getVal();
    }

    /**
     * Gets the suit of the card.
     *
     * @return The suit of the card.
     */
    public Suit getSuit() {
        return this.suit;
    }

    /**
     * Gets the rank of the card.
     *
     * @return The rank of the card.
     */
    public Rank getRank() {
        return this.rank;
    }

    /**
     * Gets the numerical value associated with the card's rank.
     *
     * @return The numerical value of the card's rank.
     */
    public int getValue() {
        return this.rankValue;
    }

    /**
     * Gets a display representation of the card.
     * For face cards, returns the first character of the rank's name.
     * For other cards, returns the numerical value as a string.
     *
     * @return The display representation of the card.
     */
    public String displayChar() {
        if (rank.equals(Rank.ACE) || rank.equals(Rank.JACK) || rank.equals(Rank.QUEEN) || rank.equals(Rank.KING)) {
            return rank.name().substring(0, 1);
        } else {
            return Integer.toString(rankValue);
        }
    }

    /**
     * Converts the ACE rank from high value to low value.
     *
     * @return True if the card was an ACE and its value was changed, false otherwise.
     */
    public boolean aceHighToLow() {
        if (rankValue == 11) {
            rankValue = 1;
            return true;
        }
        return false;
    }

    /**
     * Displays the card's rank and suit.
     */
    public void display() {
        System.out.println(rank + " of " + suit);
    }
}
