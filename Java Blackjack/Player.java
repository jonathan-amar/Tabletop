import cards.Hand;

/**
 * Represents a player in a card game, extending the HandHolder class.
 *
 * <p>The class includes methods to interact with the player's credits, such as getting the credit balance,
 * removing credits, placing a bet, and adding credits.</p>
 *
 * @author Jonathan Amar
 * @version 1.0
 * @since 1.0
 */
public class Player extends HandHolder {
    private int credits;

    /**
     * Constructs a player with an initial credit balance and an empty hand.
     *
     * @param creds The initial credit balance of the player.
     */
    public Player(int creds) {
        hand = new Hand();
        credits = creds;
    }

    /**
     * Constructs a player with a default credit balance of 1000 and an empty hand.
     */
    public Player() {
        this(1000);
    }

    /**
     * Gets the current credit balance of the player.
     *
     * @return The current credit balance.
     */
    public int getCredits() {
        return this.credits;
    }

    /**
     * Removes a specified amount of credits from the player's balance.
     *
     * @param creds The amount of credits to be removed.
     */
    public void removeCredits(int creds) {
        credits -= creds;
    }

    /**
     * Places a bet by removing the specified amount of credits from the player's balance.
     *
     * @param creds The amount of credits to bet.
     * @return The bet amount.
     */
    public int bet(int creds) {
        removeCredits(creds);
        return creds;
    }

    /**
     * Adds a specified amount of credits to the player's balance.
     *
     * @param creds The amount of credits to add.
     */
    public void addCredits(int creds) {
        credits += creds;
    }
}
