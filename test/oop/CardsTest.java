package oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class CardsTest {
    @Test public void cardObjectExistTest(){
        Card card = new Card("face", "suite");
        assertNotNull(card);
    }
    @Test public void cardObjectPropertiesCanBeSeenTest(){
        Card card = new Card("Face", "Suite");
        String object =  card.toString();
        assertEquals("Face of Suite", object);
    }
    @Test public void creatAnotherCardObjectTest(){
        Card card = new Card("Ace", "Spades");
        String object = card.toString();
        assertEquals("Ace of Spades", object);
    }
    @Test public void createDeckOfCardsObjectTest(){
        DeckOfCard deckObject = new DeckOfCard();
        assertNotNull(deckObject);
    }
    @Test public void deckObjectHasTwoCardTest(){
        Card card = new Card("Ace", "Hearts");
        Card card2 = new Card("Deuce", "Diamond");
        // DeckOfCard has a list of Card objects. That is why it is called a deck of cards
        DeckOfCard deckObject = new DeckOfCard();
        Assertions.assertEquals(card.toString(), String.valueOf(deckObject.dealCard()));
    }
    @Test public void shuffleDeckOfCardsTest(){
        DeckOfCard deckOfCard = new DeckOfCard();
        String deckBeforeShuffle = deckOfCard.getDeckOfCard();
        deckOfCard.shuffleCards();
        String deckAfterShuffle = deckOfCard.getDeckOfCard();
        assertNotEquals(deckBeforeShuffle, deckAfterShuffle);
    }
}