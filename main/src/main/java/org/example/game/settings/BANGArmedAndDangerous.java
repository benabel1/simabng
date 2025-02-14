package org.example.game.settings;

import org.example.game.Game;
import org.example.game.cards.DeckAble;
import org.example.game.cards.blue.basic.*;
import org.example.game.cards.brown.basic.*;
import org.example.game.cards.brown.dangerous.*;
import org.example.game.cards.characters.dangerous.CharRedRingo;
import org.example.game.cards.characters.dangerous.CharBloodyMary;
import org.example.game.cards.characters.dangerous.CharJulyCutter;
import org.example.game.cards.characters.dangerous.CharMsAbigail;
import org.example.game.cards.green.dodge.*;
import org.example.game.deck.DeckName;

import java.util.ArrayList;
import java.util.List;

import static org.example.game.cards.PokerValue.*;
import static org.example.game.cards.Suit.*;


public class BANGArmedAndDangerous extends GameExpansionSetup {

    public BANGArmedAndDangerous() {
        super();
        isTurnOn = true;
    }

    @Override
    public void applySetup(Game game) {
        insertCardsForDeck(game, DeckName.CHARACTERS);
        insertCardsForDeck(game, DeckName.PLAYING_CARDS);
    }

    @Override
    public void insertCardsForDeck(Game game, DeckName characters) {
        switch (characters) {
            case CHARACTERS:
                game.insert(characters, createListCardsCharacterDeck());
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
    protected List<DeckAble> createListCardsCharacterDeck() {
        List<DeckAble> result = new ArrayList<>();

        //8 BASIC characters
        result.add(new CharBloodyMary());
        result.add(new CharJulyCutter());
        result.add(new CharMsAbigail());
        result.add(new CharRedRingo());

        return result;
    }

    @Override
    protected List<DeckAble> createListCardsSpecialDeck() {
        List<DeckAble> result = new ArrayList<>();

        return result;
    }

    @Override
    protected void createBlueBorderCards(List<DeckAble> result) {
        //TODO
        //01 BARREL ♣: A
        result.add(new CardBarrel(CLUBS, __A));
    }

    @Override
    protected void createBrownBorderCards(List<DeckAble> result) {
        //BROWN

        //01 ARROW ♦: 5
        result.add(new CardArrow(DIAMONDS, _05));

        //04 BANG ♥: 6 ♦: 2,3 ♣: 2
        result.add(new CardBang(HEARTHS, _06));
        result.add(new CardBang(DIAMONDS, _02));
        result.add(new CardBang(DIAMONDS, _03));
        result.add(new CardBang(CLUBS, _02));

        //01 CARAVAN ♠: 2
        result.add(new CardCaravan(SPADE, _02));

        //01 CAT BALOU ♥: 3
        result.add(new CardCatBalou(HEARTHS, _03));

        //01 DUCK ♦: 5
        result.add(new CardDuck(DIAMONDS, _03));

        //01 FLINTLOCK
        result.add(new CardFlintlock(SPADE, __A));

        //01 A LITTLE NIP
        result.add(new CardALittleNip(HEARTHS, _05));

        //01 RELOADING
        result.add(new CardALittleNip(HEARTHS, _05));

        //01 RUST
        result.add(new CardRust(SPADE, _09));

    }

    @Override
    protected void createGreenBorderCards(List<DeckAble> result) {
        //GREEN
        //01 BIBLE ♥: 10
        result.add(new CardBible(HEARTHS, _10));
    }

}
