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
            handVal = handVal + c.getRankValue();
        }
        return handVal;
    }

    public void add(Card c){
        hand.add(c);
    }

    public boolean aceToLow(){
        for(int i = 0; i < hand.size(); i++){
            if(hand.get(i).aceHightoLow()){
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
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.FIVE));
        hand.add(new Card(Suit.CLUBS, Rank.FIVE));
        hand.add(new Card(Suit.CLUBS, Rank.FIVE));
        hand.add(new Card(Suit.SPADES,Rank.ACE));
        System.out.println(hand.getVal());
        hand.aceToLow();
        System.out.println(hand.getVal());
        hand.clearHand();
        System.out.println(hand.getVal());
    }

}
