public class Dealer {
    BJDeck deck;

    public Dealer(){
        deck = new BJDeck();
    }

    public Card draw(){
        return deck.draw();
    }
}
