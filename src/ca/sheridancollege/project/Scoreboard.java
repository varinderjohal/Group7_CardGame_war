/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.*;
/**
 *
 * @author Varinder Johal OCT 10, 2025
 */
public class Scoreboard {
    private final Map<String, Integer> scores = new HashMap<>();

    public void updateWinner(WarPlayer winner) {
        scores.put(winner.getName(), scores.getOrDefault(winner.getName(), 0) + 1);
    }

    public int getScore(WarPlayer player) {
        return scores.getOrDefault(player.getName(), 0);
    }

    public void displayScores() {
        for (Map.Entry<String, Integer> e : scores.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }
    
}