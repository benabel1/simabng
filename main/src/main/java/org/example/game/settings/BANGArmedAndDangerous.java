package org.example.game.settings;

import org.example.game.Game;
import org.example.game.cards.orange.dangerous.*;
import org.example.game.deck.DeckAble;
import org.example.game.cards.brown.basic.*;
import org.example.game.cards.brown.dangerous.*;
import org.example.game.cards.characters.dangerous.*;
import org.example.game.cards.green.dodge.*;
import org.example.game.deck.DeckName;

import java.util.ArrayList;
import java.util.Dictionary;
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

        game.log(0,"DANGEROUS: ON");
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
        //8 DANGEROUS characters
        result.add(new CharAlPreacher());
        result.add(new CharBassGreeves());
        result.add(new CharBloodyMary());
        result.add(new CharFrankieCanton());

        result.add(new CharJulyCutter());
        result.add(new CharMsAbigail());
        result.add(new CharMexicaliKid());
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
        //01 ACE UP THE SLEEVE ♥: A
        result.add(new CardAceUpTheSleeve(HEARTHS,__A));
        //01 BANDOLIER ♥: 2
        result.add(new CardBandolier(HEARTHS, _02));
        //01 BEER KEG ♥: 4
        result.add(new CardBeerKeg(HEARTHS, _04));
        //01 BELL TOWER ♣: 7
        result.add(new CardBellTower(CLUBS, _07));
        //01 BIG FIFTY ♠" Q
        result.add(new CardGun6BigFifty(SPADE,__Q));
        //01 BOMB ♦: 7
        result.add(new CardBomb(DIAMONDS, _07));
        //01 CREATE ♥" 3
        result.add(new CardCreate(HEARTHS, _03));
        //01 BUTLINE SPECIAL ♠: J
        result.add(new CardGun2ButlineSpecial(SPADE, __J));
        //01 DOUBLE BARREL ♣: 6
        result.add(new CardGun1DoubleBarrel(CLUBS, _06));
        //01 LOCK PICK ♣: 2
        result.add(new CardLockPick(CLUBS, _02));
        //01 THUNDERER ♣: 3
        result.add(new CardGun3Thunderer(CLUBS,_03));
        //01 TUMBLE WEED ♣: 4
        result.add(new CardTumbleWeed(CLUBS, _04));
        //01 WHIP ♣: 5
        result.add(new CardWhip(CLUBS, _05));
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
