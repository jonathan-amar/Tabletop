import java.util.InputMismatchException;
import java.util.Scanner;

import cards.BJDeck;
import cards.Hand;

public class Blackjack {
    private static BJDeck deck;
    private static Scanner s;
    private static Player p;
    private static HandHolder house;
    private static int wager;

    private static void displayTitle(){
        System.out.println();
        System.out.println("************************************");
        System.out.println("******* WELCOME TO BLACKJACK *******");
        System.out.println("************************************");
    }

    private static int getBet(Scanner s, Player p){
        int bet;
        do{
            bet = -2;
        System.out.println("Your Credits : " + p.getCredits());
        System.out.println();
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

    private static void deal(HandHolder h){
        h.deal(deck.draw());
    }

    private static void boardSetup(){
        house.deal(deck.draw());
        p.deal(deck.draw());
        house.deal(deck.draw());
        p.deal(deck.draw());
    }

    private static void clearBoard(){
        house.clearHand();
        p.clearHand();
    }

    private static void showBoard(){
        System.out.println("HOUSE CARDS : ");
        house.showTopCard();
        System.out.println("YOUR CARDS : ");
        p.showHand();
    }

    private static void showFullBoard(){
        System.out.println("HOUSE CARDS : ");
        house.showHand();
        System.out.println("YOUR CARDS : ");
        p.showHand();
    }

    private static void displayValues(){
        System.out.println("HOUSE VALUE : " + house.getHandValue());
        System.out.println("YOUR VALUE : " + p.getHandValue());
    }

    private static boolean hitOrStand(Scanner s){
        int choice = -1;
        do{
            System.out.print("Enter 1 to hit, enter 0 to stand.");
        try{
        choice = s.nextInt();
        } catch (InputMismatchException e) {
            System.out.println();
            System.out.println("ERROR : Please enter a number");
            System.out.println();
        }
        s.nextLine();
        }while(choice != 0 && choice !=1);
        if(choice == 0){
            return false;
        }
        else return true;
    }


    public static void main(String[] args){
        deck = new BJDeck();
        p = new Player();
        house = new HandHolder();
        s = new Scanner(System.in);
        displayTitle();
        deck.discard();
        while(p.getCredits() != 0){
        clearBoard();
        boardSetup();
        wager = getBet(s, p);
        if (wager == -1) break;
        p.bet(wager);
        showBoard();
        while(!p.isBust() && p.getHandValue()!= 21 && hitOrStand(s)){
            deal(p);
            showBoard();
        }
        if(p.isBust()){
            System.out.println("BUSTED");
            System.out.println();
            System.out.println();
        }
        else if(p.getHandValue() == 21){
            System.out.println("BLACKJACK!!");
            System.out.println("YOU WIN!!");
            System.out.println();
            System.out.println();
            p.addCredits(wager * 2);
        }
        else{
            while(!house.isBust() && house.getHandValue() < p.getHandValue()){
                deal(house);
            }
            showFullBoard();
            if(house.isBust()){
            displayValues();
            System.out.println();
            System.out.println("House busted, you win!");
            System.out.println();
            System.out.println();
            p.addCredits(wager * 2);
            }
            else{
                if(house.getHandValue() == 21) System.out.println("HOUSE BLACKJACK");
                displayValues();
                System.out.println("YOU LOSE");
                System.out.println("");
                System.out.println("");

            }
        }
        }
        if(p.getCredits() == 0){
            System.out.println("You have run out of credits, the House wins!");
            System.out.println("Better luck next time!");
        }
        else {
            System.out.println("You ended with " + p.getCredits() + " credits!");
            System.out.println("See you next time!");
        }
     return;   
    }
    
}
