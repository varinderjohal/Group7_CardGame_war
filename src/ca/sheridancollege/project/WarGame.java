/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.*;
/**
 *
 * @author Varinde Johal OCT 10,2025
 */


public class WarGame extends Game {

    private final Scoreboard scoreboard;
    private static final int MAX_ROUNDS = 50;
    private int round = 0;

    public WarGame(String name, ArrayList<Player> players, Scoreboard scoreboard) {
        super(name);
        setPlayers(players); // use your base setter
        this.scoreboard = scoreboard;
    }

    @Override
    public void play() {
        System.out.println("Starting " + getName() + "!\n");

        WarPlayer p1 = (WarPlayer) getPlayers().get(0);
        WarPlayer p2 = (WarPlayer) getPlayers().get(1);

        while (round < MAX_ROUNDS && p1.hasCards() && p2.hasCards()) {
            round++;
            System.out.println("---- Round " + round + " ----");
            playRound(p1, p2);
            System.out.printf("Deck sizes: %s=%d, %s=%d%n%n",
                    p1.getName(), p1.getDeckSize(),
                    p2.getName(), p2.getDeckSize());
        }

        declareWinner();
    }

    private void playRound(WarPlayer p1, WarPlayer p2) {
        WarCard c1 = p1.playCard();
        WarCard c2 = p2.playCard();

        if (c1 == null || c2 == null) return;

        System.out.printf("%s plays %s%n%s plays %s%n",
                p1.getName(), c1, p2.getName(), c2);

        int result = c1.compareTo(c2);
        List<WarCard> table = new ArrayList<>(Arrays.asList(c1, c2));

        if (result > 0) {
            p1.collectCards(table);
            scoreboard.updateWinner(p1);
            System.out.println(p1.getName() + " wins the round!\n");
        } else if (result < 0) {
            p2.collectCards(table);
            scoreboard.updateWinner(p2);
            System.out.println(p2.getName() + " wins the round!\n");
        } else {
            System.out.println("It's a tie! WAR!\n");
            resolveTie(p1, p2, table);
        }
    }

    private void resolveTie(WarPlayer p1, WarPlayer p2, List<WarCard> table) {
        List<WarCard> p1Extra = drawExtra(p1);
        List<WarCard> p2Extra = drawExtra(p2);
        table.addAll(p1Extra);
        table.addAll(p2Extra);

        WarCard final1 = p1.playCard();
        WarCard final2 = p2.playCard();

        if (final1 == null || final2 == null) return;
        table.add(final1);
        table.add(final2);

        int result = final1.compareTo(final2);
        if (result > 0) {
            p1.collectCards(table);
            scoreboard.updateWinner(p1);
            System.out.println(p1.getName() + " wins the war!\n");
        } else if (result < 0) {
            p2.collectCards(table);
            scoreboard.updateWinner(p2);
            System.out.println(p2.getName() + " wins the war!\n");
        } else {
            System.out.println("Another tie! Cards remain on table.\n");
        }
    }

    private List<WarCard> drawExtra(WarPlayer player) {
        List<WarCard> extras = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            WarCard card = player.playCard();
            if (card != null) extras.add(card);
        }
        return extras;
    }

    @Override
    public void declareWinner() {
        WarPlayer p1 = (WarPlayer) getPlayers().get(0);
        WarPlayer p2 = (WarPlayer) getPlayers().get(1);
        System.out.println("Game Over!\nFinal Scores:");
        scoreboard.displayScores();
        if (scoreboard.getScore(p1) > scoreboard.getScore(p2))
            System.out.println(p1.getName() + " wins the game!");
        else if (scoreboard.getScore(p2) > scoreboard.getScore(p1))
            System.out.println(p2.getName() + " wins the game!");
        else
            System.out.println("The game is a draw!");
    }
}