/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.*;
/**
 *
 * @author Varinder Johal 0CT 10, 2025
 */
public class Main {
    public static void main(String[] args) {
        // Create and shuffle full deck
        List<WarCard> deck = generateDeck();
        Collections.shuffle(deck);

        // Split deck into two halves
        GroupOfCards deck1 = new GroupOfCards();
        GroupOfCards deck2 = new GroupOfCards();
        deck1.addToBottom(deck.subList(0, 26));
        deck2.addToBottom(deck.subList(26, 52));

        // Create two players with their decks
        WarPlayer p1 = new WarPlayer("Player 1", deck1);
        WarPlayer p2 = new WarPlayer("Player 2", deck2);

        // Prepare scoreboard
        Scoreboard sb = new Scoreboard();

        // ✅ FIX: use ArrayList<Player> to match Game.java
        ArrayList<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);

        // Start the game
        WarGame game = new WarGame("War Card Game", players, sb);
        game.play();
    }

    // Generates 52 War cards (13 ranks × 4 suits)
    private static List<WarCard> generateDeck() {
        List<WarCard> deck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new WarCard(suit.name(), rank.getValue()));
            }
        }
        return deck;
    }
}