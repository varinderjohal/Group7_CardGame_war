/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.*;
/**
 * @author Varinder Johal OCT 10, 2025
 */
public class WarPlayer extends Player {
    private final GroupOfCards deck;

    public WarPlayer(String name, GroupOfCards deck) {
        super(name);
        this.deck = deck;
    }

    @Override
    public WarCard playCard() {
        return deck.drawTop();
    }

    public void collectCards(List<WarCard> wonCards) {
        deck.addToBottom(wonCards);
    }

    public boolean hasCards() {
        return !deck.isEmpty();
    }

    public int getDeckSize() {
        return deck.size();
    }
}
