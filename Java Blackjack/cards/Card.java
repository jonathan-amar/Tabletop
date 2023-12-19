package cards;
public class Card {
    private Suit suit;
    private Rank rank;
    private int rankValue;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
        rankValue = rank.getVal();
    }

    public Suit getSuit(){
        return this.suit;
    }

    public Rank getRank(){
        return this.rank;
    }

    public int getRankValue(){
        return this.rankValue;
    }

    public boolean aceHightoLow(){
            if(rankValue == 11){
                rankValue = 1;
                return true;
            }
            return false;
    }

    public void display(){
        System.out.println(rank + " of " + suit);
    }

    public static void main(String[] args){
        Card card = new Card(Suit.CLUBS, Rank.ACE);
        System.out.println(card.getRank());
        System.out.println(card.getSuit());
        System.out.println(card.getRankValue());
        card.display();
        card.aceHightoLow();
        System.out.println(card.getRankValue());
        Card card1 = new Card(Suit.SPADES, Rank.EIGHT);
        System.out.println(card.getRankValue());
        card1.aceHightoLow();
        System.out.println(card.getRankValue());
        card1.display();
    }
}