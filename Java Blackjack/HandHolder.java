import cards.Card;
import cards.Hand;

public class HandHolder {
    Hand hand;

    public HandHolder(){
        hand = new Hand();
    }

    public int getHandValue(){
        return hand.getVal();
    }

    public void deal(Card c){
        hand.add(c);
    }

    public void clearHand(){
        hand.clearHand();
    }

    public void showHand() {
        hand.showHand();
    }

    public void showTopCard(){
        hand.showSomeCards(1);
    }

    public boolean isBust(){
        return hand.isBust();
    }


}
