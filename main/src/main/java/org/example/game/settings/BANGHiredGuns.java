package org.example.game.settings;

import org.example.game.Game;
import org.example.game.cards.blue.animalpack.CardMule;
import org.example.game.cards.blue.animalpack.CardTraitorousDog;
import org.example.game.cards.brown.hiredguns.CardMysticDec;
import org.example.game.deck.DeckAble;
import org.example.game.deck.DeckName;

import java.util.ArrayList;
import java.util.List;

import static org.example.game.cards.PokerValue.*;
import static org.example.game.cards.Suit.*;


public class BANGHiredGuns extends GameExpansionSetup {

    public BANGHiredGuns() {
        super();
        isTurnOn = true;
    }

    @Override
    public void applySetup(Game game) {
        insertCardsForDeck(game, DeckName.CHARACTERS);
        insertCardsForDeck(game, DeckName.PLAYING_CARDS);

        game.log(0,"HIRED GUNS: ON");
    }

    @Override
    public void insertCardsForDeck(Game game, DeckName characters) {
        switch (characters) {
            case CHARACTERS:
                game.insert(characters, createListCardsCharacterDeck(game));
                break;
            case PLAYING_CARDS:
                game.insert(characters, createListCardsPlayingDeck());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + characters);
        }
    }

    @Override
    protected List<DeckAble> createListCardsPlayingDeck() {
        List<DeckAble> result = new ArrayList<>();

        createBlueBorderCards(result);
        createBrownBorderCards(result);

        return result;
    }

    @Override
    protected List<DeckAble> createListCardsCharacterDeck(Game game) {
        List<DeckAble> result = new ArrayList<>();
        //8 DANGEROUS characters
//        result.add(new CharAlPreacher());
//        result.add(new CharBassGreeves());
//        result.add(new CharBloodyMary());
//        result.add(new CharFrankieCanton());
//
//        result.add(new CharJulyCutter());
//        result.add(new CharMsAbigail());
//        result.add(new CharMexicaliKid());
//        result.add(new CharRedRingo());

        return result;
    }

    @Override
    protected List<DeckAble> createListCardsSpecialDeck() {
        List<DeckAble> result = new ArrayList<>();

        return result;
    }

    @Override
    protected void createBlueBorderCards(List<DeckAble> result) {
        //01 ACE UP THE SLEEVE ♥: A
        result.add(new CardTraitorousDog(DIAMONDS, __J));
        result.add(new CardMule(CLUBS, __J));

    }

    @Override
    protected void createBrownBorderCards(List<DeckAble> result) {
        //BROWN

        //01 ARROW ♦: 5
        result.add(new CardMysticDec(DIAMONDS, _05));
    }

    @Override
    protected void createGreenBorderCards(List<DeckAble> result) {
        //GREEN
        //01 BIBLE ♥: 10
        //result.add(new CardBible(HEARTHS, _10));
    }

}
