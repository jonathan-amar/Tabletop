public class BJDeck extends Deck {
    public BJDeck(){
        super(6);
        this.shuffle();
    }
    
    

    public static void main (String[] args){
        BJDeck deck = new BJDeck();
        System.out.println(deck.numCards());
        while(deck.numCards() != 0){
            deck.draw().display();
        }
    }
}
