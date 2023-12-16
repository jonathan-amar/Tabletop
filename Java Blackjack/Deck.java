import java.util.Stack;
public class Deck {
    Stack<Card> deck;

    public Deck(){
        for(Suit s : Suit.values()){
            for(Rank r : Rank.values()){
                deck.add(new Card(s, r));
            }
        }
    }

    public static void main(String[] args){
        
    }
}