package com.codewars.kata.training;

import com.codewars.kata.training.exceptions.MyOwnRuntimeException;

public class Game {
    private static final String[] CARD_RANK = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};


    public String winner(String[] deckSteve, String[] deckJosh) {
        int length;
        if (deckSteve.length != deckJosh.length) {
            throw new MyOwnRuntimeException("Invalid parameters: You need an equal number of cards for the players");
        } else {
            length = deckSteve.length;
        }

        int scoreSteve = 0;
        int scoreJosh = 0;
        for (int i = 0; i < length; i++) {
            int cardSteve = getCard(deckSteve[i]);
            int cardJosh = getCard(deckJosh[i]);
            if (cardSteve > cardJosh) {
                scoreSteve++;
            }
            if (cardSteve < cardJosh) {
                scoreJosh++;
            }
        }
        if (scoreSteve > scoreJosh) {
            return String.format("Steve wins %d to %d", scoreSteve, scoreJosh);
        }
        if (scoreJosh > scoreSteve) {
            return String.format("Josh wins %d to %d", scoreJosh, scoreSteve);
        }
        return "Tie";
    }

    private int getCard(String card) {
        int index = 0;
        while (!CARD_RANK[index].equals(card)) {
            index++;
        }
        return index;
    }
}
