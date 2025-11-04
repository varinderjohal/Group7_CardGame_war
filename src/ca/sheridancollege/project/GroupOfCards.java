/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * 
 */
package ca.sheridancollege.project;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author  Varinder Johal OCT 10 ,2025
 */
public class GroupOfCards {
    private final Deque<WarCard> cards = new ArrayDeque<>();

    public void addToBottom(List<WarCard> newCards) {
        for (WarCard c : newCards) {
            if (c != null) cards.addLast(c);
        }
    }

    public WarCard drawTop() { return cards.pollFirst(); }

    public void shuffle() {
        List<WarCard> temp = new ArrayList<>(cards);
        Collections.shuffle(temp);
        cards.clear();
        cards.addAll(temp);
    }

    public int size() { return cards.size(); }
    public boolean isEmpty() { return cards.isEmpty(); }
}