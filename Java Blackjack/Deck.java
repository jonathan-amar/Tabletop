
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;

    public Deck(){
        deck = new ArrayList<Card>();
        for(Suit s : Suit.values()){
            for(Rank r : Rank.values()){
                deck.add(new Card(s, r));
            }
        }
    }

    public int numCards(){
        return deck.size();
    }

    public Card draw(){
        return deck.removeFirst();
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public static void main (String[] args){
        Deck deck = new Deck();
        deck.shuffle();
        System.out.println(deck.numCards());
        while(deck.numCards()!=0){
            deck.draw().display();
        }
        System.out.println(deck.numCards());
    }
}