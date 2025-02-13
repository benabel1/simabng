package org.example.game.settings;

import org.example.game.Game;
import org.example.game.cards.DeckAble;
import org.example.game.cards.blue.basic.*;
import org.example.game.cards.blue.dodge.CardBinocular;
import org.example.game.cards.blue.dodge.CardHideout;
import org.example.game.cards.brown.basic.*;
import org.example.game.cards.brown.dangerous.*;
import org.example.game.cards.brown.dodge.*;
import org.example.game.cards.characters.dodge.CharVeraCuster;
import org.example.game.cards.green.dodge.*;
import org.example.game.deck.DeckName;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

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

        //15 BASIC characters
        result.add(new CharVeraCuster());

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

        //01 CANTEEN ♥: 7
        result.add(new CardCanteen(HEARTHS, _07));

        //01 CAN CAN ♣: J
        result.add(new CardCanCan(CLUBS, __J));

        //01 TEN GALLON HAT ♦: J
        result.add(new CardTenGallonHat(DIAMONDS, __J));

        //01 CONESTOGA ♦: 9
        result.add(new CardConestoga(DIAMONDS, _09));

        //01 DERRINGER ♣: J
        result.add(new CardDerringer(CLUBS, __J));

        //01 BUFFALO RIFLE ♣: Q
        result.add(new CardBuffaloRifle(CLUBS, __Q));

        //01 HOWITZER ♠: 9
        result.add(new CardHowitzer(SPADE, _09));

        //01 PEPPERBOX ♥: A
        result.add(new CardPepperbox(HEARTHS, __A));

        //02 IRON PLATE ♦: A ♠: Q
        result.add(new CardIronPlate(DIAMONDS, __A));
        result.add(new CardIronPlate(SPADE, __Q));

        //01 PONY EXPRESS ♦: Q
        result.add(new CardPonyExpress(DIAMONDS, __Q));

        //01 KNIVE ♥: 8
        result.add(new CardKnive(HEARTHS, _08));

        //01 SOMBRERO ♦: A ♠: Q
        result.add(new CardSombraro(CLUBS, _07));
    }

}
