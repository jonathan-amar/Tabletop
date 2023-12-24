package cards;

/**
 * Enumeration representing the ranks of playing cards.
 *
 * Each rank has an associated numerical value used in card games.
 *
 * @author Jonathan Amar
 * @version 1.0
 * @since 1.0
 */
public enum Rank {

    ACE(11),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10);

    private int value;

    /**
     * Constructs a Rank with the specified numerical value.
     *
     * @param value The numerical value associated with the rank.
     */
    private Rank(int value) {
        this.value = value;
    }

    /**
     * Gets the numerical value associated with the rank.
     *
     * @return The numerical value of the rank.
     */
    public int getVal() {
        return value;
    }
}