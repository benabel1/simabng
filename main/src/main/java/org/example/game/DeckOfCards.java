package org.example.game;

import org.example.game.cards.DeckAble;

import java.util.List;

public class DeckOfCards {
    List<DeckAble> content;

    public DeckOfCards(List<DeckAble> content) {
        this.content = content;
    }

    public DeckAble draw() {
        if (content != null && !content.isEmpty()) {
            return content.remove(0);
        } else {
            return null;
        }
    }

    public boolean canBeDrawCards(int count) {
        if (content != null){
            return content.size() >= count;
        } else {
           return false;
        }
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
}
