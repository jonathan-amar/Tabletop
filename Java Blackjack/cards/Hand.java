package cards;

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> hand;
    

    public Hand(){
        hand = new ArrayList<>();
        
    }

    public int getVal(){
        int handVal = 0;
        for(Card c : hand){
            handVal = handVal + c.getValue();
        }
        return handVal;
    }

    public void add(Card c){
        hand.add(c);
        while(getVal() > 21 && hasHighAce()) {
            aceToLow();
        }
    }

    private boolean hasHighAce(){
        for(Card c : hand){
            if (c.getValue() == 11) {
                return true;
            } 
        }
        return false;
    }

    private boolean aceToLow(){
        for(Card c : hand){
            if(c.aceHightoLow()){
                return true;
            }
        }
        return false;
    }

    public void clearHand(){
        hand.clear();
    }

    public static void main(String[] args) {
        Hand hand = new Hand();
        hand.add(new Card(Suit.CLUBS, Rank.FIVE));
        hand.add(new Card(Suit.CLUBS, Rank.FIVE));
        System.out.println(hand.getVal());
        hand.add(new Card(Suit.SPADES,Rank.ACE));
        System.out.println(hand.getVal());
    
    }

}
