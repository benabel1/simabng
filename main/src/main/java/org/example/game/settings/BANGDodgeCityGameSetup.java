package org.example.game.settings;

import org.example.game.cards.characters.dodge.*;
import org.example.game.cards.railcars.CharacterCardCreator;
import org.example.game.deck.DeckName;
import org.example.game.Game;
import org.example.game.deck.DeckAble;
import org.example.game.cards.blue.basic.*;
import org.example.game.cards.blue.dodge.CardBinocular;
import org.example.game.cards.blue.dodge.CardHideout;
import org.example.game.cards.brown.dodge.*;
import org.example.game.cards.brown.basic.*;
import org.example.game.cards.green.dodge.*;

import java.util.ArrayList;
import java.util.List;

import static org.example.game.cards.PokerValue.*;
import static org.example.game.cards.Suit.*;


public class BANGDodgeCityGameSetup extends GameExpansionSetup {

    public BANGDodgeCityGameSetup() {
        super();
        isTurnOn = true;
    }

    @Override
    public void applySetup(Game game) {

        insertCardsForDeck(game, DeckName.CHARACTERS);
        insertCardsForDeck(game, DeckName.PLAYING_CARDS);

        game.log(0,"DODGECITY: ON");
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
        createGreenBorderCards(result);

        return result;
    }

    @Override
    protected List<DeckAble> createListCardsCharacterDeck(Game game) {
        List<DeckAble> result = new ArrayList<>();

        //15 BASIC characters
        result.add(new CharApacheKid());
        result.add(new CharBelleStar());
        result.add(new CharBillNoface());
        result.add(new CharDocHoliday());

        result.add(new CharChuckWengam());

        //GREG DIGGER
        CharacterCardCreator.createOneForListFromAllPotion(result,
                new CharGregDigger(),
                new CharGregDigger5());
        //HERB HUNTER
        CharacterCardCreator.createOneForListFromAllPotion(result,
                new CharHerbHunter(),
                new CharHerbHunter5());
        //JOSE DELGADO
        CharacterCardCreator.createOneForListFromAllPotion(result,
                new CharJoseDelgado(),
                new CharJoseDelgado1());

        result.add(new CharMollyStar());;
        result.add(new CharPixiePete());
        result.add(new CharSeanMallory());
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
        //01 BARREL ♣: A
        result.add(new CardBarrel(CLUBS, __A));

        //01 BINOCULAR  ♦: 10
        result.add(new CardBinocular(DIAMONDS, _10));

        //01 DYNAMITE ♦: 10
        result.add(new CardDynamit(CLUBS, _10));

        //01 MUSTANG ♥: 5
        result.add(new CardMustang(HEARTHS, _05));

        //01 HIDEOUT ♦: 6
        result.add(new CardHideout(SPADE, _05));

        //01 REMINGTON ♦: 6
        result.add(new CardGun3Remington(DIAMONDS, _06));

        //01 REC CARABINA ♦: 6
        result.add(new CardGun4RevCarabine(SPADE, _05));
    }

    @Override
    protected void createBrownBorderCards(List<DeckAble> result) {
        //BROWN
        //04 BANG ♣: 5,6,K ♠: 8
        result.add(new CardBang(CLUBS, _05));
        result.add(new CardBang(CLUBS, _06));
        result.add(new CardBang(CLUBS, __K));
        result.add(new CardBang(SPADE, _08));

        //02 BEER ♥: 6 ♠: 6
        result.add(new CardBeer(HEARTHS, _06));
        result.add(new CardBeer(SPADE, _06));

        //01 CAT BALOU
        result.add(new CardCatBalou(CLUBS, _08));

        //01 GENERAL STORE ♠: A
        result.add(new CardGeneralStore(SPADE, __A));

        //01 INDIANS ♦: 5
        result.add(new CardIndians(DIAMONDS, _05));

        //01 MISSED ♦: 8
        result.add(new CardMissed(DIAMONDS, _08));

        //01 PANIC ♥: J
        result.add(new CardPanic(HEARTHS, __J));

        //01 PUNCH ♠: 10
        result.add(new CardPunch(SPADE, _10));

        //01 RAGTIME ♥: 9
        result.add(new CardRagTime(HEARTHS, _09));

        //01 BRAWL ♠: J
        result.add(new CardBrawl(SPADE, __J));

        //02 DODGE ♥: K ♦: 7
        result.add(new CardDodge(HEARTHS, __K));
        result.add(new CardDodge(DIAMONDS, _07));

        //01 SPRINGFILED ♠: K
        result.add(new CardSpringfield(SPADE, __K));

        //01 TEQUILA ♣: 9
        result.add(new CardTequila(SPADE, __J));

        //01 WHISKY ♥: Q
        result.add(new CardWhisky(HEARTHS, __Q));
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
