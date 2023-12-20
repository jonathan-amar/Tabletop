import java.util.InputMismatchException;
import java.util.Scanner;

import cards.BJDeck;
import cards.Hand;

public class Blackjack {
    private static BJDeck deck;
    private static Scanner s;
    private static Player p;
    private static HandHolder house;

    private static void displayTitle(){
        System.out.println();
        System.out.println("************************************");
        System.out.println("******* WELCOME TO BLACKJACK *******");
        System.out.println("************************************");
    }

    private static int getBet(Scanner s, Player p){
        int bet;
        do{
            bet = -1;
        System.out.println("Your Credits : " + p.getCredits());
        System.out.print("Enter your wager (-1 to quit) ");
        try{
        bet = s.nextInt();

        if (bet > p.getCredits()) System.out.println("You don't have that many credits!");
        } catch (InputMismatchException e) {
            System.out.println();
            System.out.println("ERROR : Please enter a number");
            System.out.println();
        }
        s.nextLine();
        }while (bet > p.getCredits() || bet < -1);
        return bet;
    }

    private static void boardSetup(){
        house.deal(deck.draw());
        p.deal(deck.draw());
        house.deal(deck.draw());
        p.deal(deck.draw());
    }


    public static void main(String[] args){
        deck = new BJDeck();
        p = new Player();
        house = new HandHolder();
        s = new Scanner(System.in);
        displayTitle();
        deck.discard();
        boardSetup();
        System.out.println("HOUSE CARDS: ");
        house.showTopCard();
        System.out.println("PLAYER CARDS: ");
        p.showHand();
        
    }
    
}
