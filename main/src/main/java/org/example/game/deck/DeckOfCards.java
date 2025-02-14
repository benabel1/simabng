package org.example.game.deck;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.shuffle;

public class DeckOfCards {
    //Draw and discard deck are pairs
    DeckOfCards linkedPairDeck;
    List<DeckAble> content;

    public DeckOfCards(List<DeckAble> addingContent) {
        this.content = new ArrayList<>(addingContent);
    }

    public DeckAble draw() {
        if (content != null)
            if (!content.isEmpty()) {
            return content.remove(0);
        } else {
            shuffle();
            return content.remove(0);
        } else {
                return null;
        }
    }

    public boolean canBeDrawCards(int count) {
        if (content != null){
            return content.size() >= count;
        } else {

            if (linkedPairDeck != null && linkedPairDeck.isNotEmpty()) {
                shuffle();
            }

           return false;
        }
    }

    private void shuffle() {
        if (linkedPairDeck == null) {

        } else {

            while (!linkedPairDeck.isEmpty()) {
                int randomInx = (int) (Math.random() * linkedPairDeck.getSize());
                DeckAble picked = content.remove(randomInx);

                content.add(picked);
            }

            System.out.println("Deck was reshuffled!");
        }
    }

    private int getSize() {
        return content.size();
    }

    private boolean isEmpty() {
        return content.isEmpty();
    }

    private boolean isNotEmpty() {
        return !content.isEmpty();
    }

    public void putOnTop(DeckAble card) {
        if (card != null) {
            content.add(card);
        }
    }

    public void putOnBottom(DeckAble card) {
        if (card != null) {
            content.add(content.size(), card);
        }
    }

    public void setPairDeck(DeckOfCards deck) {
        if (deck != null && deck != this) {
            this.linkedPairDeck = deck;
        }
    }

    /**
     * Reorganise existing deck
     */
    public void reshuffle() {
        List<DeckAble> reshuffled = new ArrayList<>();
        if (!content.isEmpty()) {

            while (!content.isEmpty()) {
                int randomInx = (int) (Math.random() * content.size());
                DeckAble picked = content.remove(randomInx);

                reshuffled.add(picked);
            }

            content.addAll(reshuffled);
            System.out.println("Deck was reshuffled!");
        }
    }
}
