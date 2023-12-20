import cards.Hand;

public class Player extends HandHolder{
    private int credits;
    
    public Player(int creds){
        hand = new Hand();
        credits = creds;
    }

    public Player(){
        this(1000);
    }
    
    public int getCredits() {
        return this.credits;
    }

    public void removeCredits(int creds){
        credits = credits - creds;
    }

    public void bet(int creds){
        removeCredits(creds);
    }

    public static void main(String[] args){
        Player player1 = new Player();
        Player player2 = new Player(1005);
        System.out.println(player1.getCredits());
        System.out.println(player2.getCredits());
    }
}
