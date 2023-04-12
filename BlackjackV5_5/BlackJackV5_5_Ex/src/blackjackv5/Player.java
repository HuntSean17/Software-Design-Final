/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjackv5;

/**
 *
 * @author todds
 */
public class Player {
    private final String name;
    private int bank;
    private int score;
    private int bet;

    public Player(String name, int bank) {
        this.name = name;
        this.score = 0;
        this.bet = 0;
        this.bank= bank;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addToScore(int value) {
        score += value;
    }

    public void resetScore() {
        score = 0;
    }

    public int getBet() {
        return bet;
    }
    
     public int getBank() {
        return bank;
    }
     
    public int setBank(int bet) {
        bank += bet;
           return bank;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public void winBet() {
        bank += bet;
        System.out.println(name + " wins " + bet + " credits!");
    }

    public void loseBet() {
        bank -= bet;
        System.out.println(name + " loses " + bet + " credits.");
    }
    
    @Override
    public String toString() {
        return name;
    }

    void clearCards() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setScore(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
