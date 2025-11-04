/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 * @author Varinder Johal OCT 10, 2025
 */
public abstract class Card {
    private final String suit;
    private final int rank;

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() { return suit; }
    public int getRank() { return rank; }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}