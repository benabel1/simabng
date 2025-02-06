package org.example.game.settings;

import org.example.game.DeckName;
import org.example.game.Game;
import org.example.game.cards.DeckAble;
import org.example.game.cards.blue.basic.*;
import org.example.game.cards.brown.basic.*;
import org.example.game.cards.characters.basic.*;

import java.util.ArrayList;
import java.util.List;

import static org.example.game.cards.PokerValue.*;
import static org.example.game.cards.Suit.*;


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
        result.add(new CardBang(HEARTHS, __Q));
        result.add(new CardBang(HEARTHS, __A));
        result.add(new CardBang(DIAMONDS, _02));
        result.add(new CardBang(DIAMONDS, _03));
        result.add(new CardBang(DIAMONDS, _04));
        result.add(new CardBang(DIAMONDS, _05));
        result.add(new CardBang(DIAMONDS, _06));
        result.add(new CardBang(DIAMONDS, _07));
        result.add(new CardBang(DIAMONDS, _08));
        result.add(new CardBang(DIAMONDS, _07));
        result.add(new CardBang(DIAMONDS, _10));
        result.add(new CardBang(DIAMONDS, __J));
        result.add(new CardBang(DIAMONDS, __Q));
        result.add(new CardBang(DIAMONDS, __K));
        result.add(new CardBang(DIAMONDS, __A));
        result.add(new CardBang(CLUBS, _02));
        result.add(new CardBang(CLUBS, _03));
        result.add(new CardBang(CLUBS, _04));
        result.add(new CardBang(CLUBS, _05));
        result.add(new CardBang(CLUBS, _06));
        result.add(new CardBang(CLUBS, _07));
        result.add(new CardBang(CLUBS, _08));
        result.add(new CardBang(CLUBS, _09));
        //?
        result.add(new CardBang(HEARTHS, _02));
        result.add(new CardBang(HEARTHS, _02));
        //?
        result.add(new CardBang(SPADE, __A));

        //12 MISSED!
        result.add(new CardMissed(HEARTHS, _02));
        result.add(new CardMissed(HEARTHS, _02));
        result.add(new CardMissed(HEARTHS, _02));
        result.add(new CardMissed(HEARTHS, _02));
        result.add(new CardMissed(HEARTHS, _02));
        result.add(new CardMissed(HEARTHS, _02));
        result.add(new CardMissed(HEARTHS, _02));
        result.add(new CardMissed(HEARTHS, _02));
        result.add(new CardMissed(HEARTHS, _02));
        result.add(new CardMissed(HEARTHS, _02));
        result.add(new CardMissed(HEARTHS, _02));
        result.add(new CardMissed(HEARTHS, _02));

        //06 BEER cards
        result.add(new CardBeer(HEARTHS, _02));
        result.add(new CardBeer(HEARTHS, _02));
        result.add(new CardBeer(HEARTHS, _02));
        result.add(new CardBeer(HEARTHS, _02));
        result.add(new CardBeer(HEARTHS, _02));
        result.add(new CardBeer(HEARTHS, _02));

        //04 PANIC cards
        result.add(new CardPanic(HEARTHS, _02));
        result.add(new CardPanic(HEARTHS, _02));
        result.add(new CardPanic(HEARTHS, _02));
        result.add(new CardPanic(HEARTHS, _02));

        //04 CAT BALOU cards
        result.add(new CardCatBalou(HEARTHS, _02));
        result.add(new CardCatBalou(HEARTHS, _02));
        result.add(new CardCatBalou(HEARTHS, _02));
        result.add(new CardCatBalou(HEARTHS, _02));
        
        //02 GENERAL STORE
        result.add(new CardGatling(HEARTHS, _02));

        //02 GENERAL STORE
        result.add(new CardGeneralStore(HEARTHS, _02));
        result.add(new CardGeneralStore(HEARTHS, _02));

        //02 INDIANS
        result.add(new CardIndians(DIAMONDS, _02));
        result.add(new CardIndians(DIAMONDS, _02));

        //03 DUEL
        result.add(new CardDuel(HEARTHS, _02));
        result.add(new CardDuel(HEARTHS, _02));
        result.add(new CardDuel(HEARTHS, _02));

        //Blue border cards
        //02 BARREL ♠: Q,K
        result.add(new CardBarrel(SPADE, __Q));
        result.add(new CardBarrel(SPADE, __K));

        //01 DYNAMITE ♥: 2
        result.add(new CardDynamit(HEARTHS, _02));

        //03 MUSTANG ♥: 4 ♠: 10,J
        result.add(new CardJail(HEARTHS, _04));
        result.add(new CardJail(SPADE, _10));
        result.add(new CardJail(SPADE, __J));

        //02 MUSTANG ♥: 8,9
        result.add(new CardMustang(HEARTHS, _08));
        result.add(new CardMustang(HEARTHS, _09));

        //01 SCOPE ♠: A
        result.add(new CardScope(SPADE, __A));

        //Weapons
        //02 VOLCANIC
        result.add(new CardGun1Volcanic(CLUBS, _10));
        result.add(new CardGun1Volcanic(SPADE, _10));

        //03 SCHOFIELD ♣: J,Q ♠:K
        result.add(new CardGun2Schofield(CLUBS, __J));
        result.add(new CardGun2Schofield(CLUBS, __Q));
        result.add(new CardGun2Schofield(SPADE, __K));

        //01 REMINTON ♣: K
        result.add(new CardGun3Remington(CLUBS, __K));

        //01 REMINTON ♣: K
        result.add(new CardGun3Remington(CLUBS, __K));

        //01 REV CARABINE ♣: K
        result.add(new CardGun4RevCarabine(CLUBS, __A));

        //01 WINCHESTER ♠: 8
        result.add(new CardGun5Winchester(CLUBS, __K));

        return result;
    }

    @Override
    protected List<DeckAble> createListCardsCharacterDeck() {
        List<DeckAble> result = new ArrayList<>();

        //16 BASIC characters
        result.add(new CharBartCassidy());
        result.add(new CharBlackJack());
        result.add(new CharCalamityJanet());
        result.add(new CharElGringo());

        result.add(new CharJesseJones());
        result.add(new CharJourdonnias());
        result.add(new CharKitCarlson());
        result.add(new CharLuckyDuke());

        result.add(new CharPaulRegret());
        result.add(new CharPedroRamirez());
        result.add(new CharRoseDoolan());
        result.add(new CharSidKetchum());

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
