public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit(){
        return this.suit;
    }

    public Rank getRank(){
        return this.rank;
    }

    public static void main(String[] args){
        Card card = new Card(Suit.CLUBS, Rank.ACE);
        System.out.println(card.getRank());
        System.out.println(card.getSuit());
        System.out.println(card.getRank().getVal());

    }

}