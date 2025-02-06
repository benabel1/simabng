package org.example.game.settings;

import org.example.game.DeckName;
import org.example.game.Game;
import org.example.game.cards.DeckAble;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.basic.brown.brown.CardBeer;
import org.example.game.cards.basic.brown.brown.CardCatBalou;
import org.example.game.cards.basic.brown.brown.CardPanic;
import org.example.game.cards.basic.brown.brown.CardBang;
import org.example.game.cards.basic.brown.brown.CardMissed;
import org.example.game.cards.basic.characters.*;

import java.util.ArrayList;
import java.util.List;


public class BANGBasicGameSetup extends GameExpansionSetup {

    public BANGBasicGameSetup() {
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

        //25 BANG! cards
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBang(Suit.HEARTHS, PokerValue._02));

        //12 MISSED!
        result.add(new CardMissed(Suit.HEARTHS, PokerValue._02));
        result.add(new CardMissed(Suit.HEARTHS, PokerValue._02));
        result.add(new CardMissed(Suit.HEARTHS, PokerValue._02));
        result.add(new CardMissed(Suit.HEARTHS, PokerValue._02));
        result.add(new CardMissed(Suit.HEARTHS, PokerValue._02));
        result.add(new CardMissed(Suit.HEARTHS, PokerValue._02));
        result.add(new CardMissed(Suit.HEARTHS, PokerValue._02));
        result.add(new CardMissed(Suit.HEARTHS, PokerValue._02));
        result.add(new CardMissed(Suit.HEARTHS, PokerValue._02));
        result.add(new CardMissed(Suit.HEARTHS, PokerValue._02));
        result.add(new CardMissed(Suit.HEARTHS, PokerValue._02));
        result.add(new CardMissed(Suit.HEARTHS, PokerValue._02));

        //06 BEER cards
        result.add(new CardBeer(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBeer(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBeer(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBeer(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBeer(Suit.HEARTHS, PokerValue._02));
        result.add(new CardBeer(Suit.HEARTHS, PokerValue._02));

        //04 PANIC cards
        result.add(new CardPanic(Suit.HEARTHS, PokerValue._02));
        result.add(new CardPanic(Suit.HEARTHS, PokerValue._02));
        result.add(new CardPanic(Suit.HEARTHS, PokerValue._02));
        result.add(new CardPanic(Suit.HEARTHS, PokerValue._02));

        //04 CAT BALOU cards
        result.add(new CardCatBalou(Suit.HEARTHS, PokerValue._02));

        return result;
    }

    @Override
    protected List<DeckAble> createListCardsCharacterDeck() {
        List<DeckAble> result = new ArrayList<>();

        //16 BASIC characters
        result.add(new CharBartCassidy());
        result.add(new CharJesseJones());
        result.add(new CharBlackJack());
        result.add(new CharKitCarlson());
        result.add(new CharPaulRegret());

        result.add(new CharPedroRamirez());

        result.add(new CharSlabTheKiller());
        result.add(new CharSuzyLafayette());
        result.add(new CharVultureSam());
        result.add(new CharWillyTheKid());

        return result;
    }

    @Override
    protected List<DeckAble> createListCardsSpecialDeck() {
        List<DeckAble> result = new ArrayList<>();

        return result;
    }
}
