package oop;

import java.security.SecureRandom;
import java.util.Arrays;

public class DeckOfCard {
    private final int NUMBER_OF_CARDS = 52;
    private Card[] deck = new Card[NUMBER_OF_CARDS];
    SecureRandom randomNumber = new SecureRandom();
    public DeckOfCard() {
        String[] face = new String[]{"Ace", "Deuce", "Three", "Four", "Five",
                "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suite = new String[]{"Hearts", "Diamonds", "Clubs", "Spades"};
        for (int index = 0; index < deck.length; index++){
            deck[index] = new Card(face[index % 13], suite[index / 13]);
        }
    }

    public Card dealCard() {
        int currentCard = 0;
        return deck[currentCard];
    }

    String getDeckOfCard() {
        return Arrays.toString(deck);
    }

    public void shuffleCards() {
        for (int firstCard = 0; firstCard < NUMBER_OF_CARDS; firstCard++ ){
            int randomlyPickedCard = randomNumber.nextInt(NUMBER_OF_CARDS);
            Card cardToBeSwapped = deck[firstCard];
            deck[firstCard] = deck[randomlyPickedCard];
            deck[randomlyPickedCard] = cardToBeSwapped;
        }
    }
}
