/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Varinder Johal
 */
public class WarCard extends Card implements Comparable<WarCard> {

    public WarCard(String suit, int rank) {
        super(suit, rank);
    }

    @Override
    public int compareTo(WarCard other) {
        return Integer.compare(this.getRank(), other.getRank());
    }

    @Override
    public String toString() {
        return getRank() + " of " + getSuit();
    }
}
