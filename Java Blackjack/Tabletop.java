/**
 * The entry point for the Tabletop application.
 * This class contains the main method that invokes the {@link Blackjack#blackJack()} method
 * to start and manage the execution of the Blackjack game.
 * <p>
 * To run the Tabletop application, execute the main method in this class.
 * </p>
 *
 * @author Jonathan Amar
 * @version 1.0
 * @since 1.0
 */
public class Tabletop {
    /**
     * The main method of the Tabletop application.
     * Invokes the {@link Blackjack#blackJack()} method to start and manage the execution of the Blackjack game.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        Blackjack.blackJack();
    }
}