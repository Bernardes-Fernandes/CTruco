package com.murilos.aline.teconomarrecobot;

import com.bueno.spi.model.CardRank;
import com.bueno.spi.model.GameIntel;
import com.bueno.spi.model.TrucoCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

;
import static com.bueno.spi.model.CardSuit.*;
import static com.bueno.spi.model.CardRank.*;
import static com.bueno.spi.model.CardSuit.*;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TecoNoMarrecoBotTest {

    TecoNoMarrecoBot tecoNoMarrecoBot;

    private List<TrucoCard> cards;

    private TrucoCard cardVira;

    private List<TrucoCard> hand;
    private List<GameIntel.RoundResult> roundResult;

    private GameIntel.StepBuilder stepBuilder;

    @BeforeEach
    void setUp(){ tecoNoMarrecoBot = new TecoNoMarrecoBot();}

    @Test
    @DisplayName("Testa se aceita mão de onze com casal maior")
    void testsWhetherHeAcceptsAhandFromElevenWithABiggerCouple(){
        hand = List.of(TrucoCard.of(FOUR, CLUBS), TrucoCard.of(FOUR, HEARTS), TrucoCard.of(FIVE, SPADES));
        cardVira = TrucoCard.of(THREE, SPADES);
        roundResult = List.of();
        cards = List.of();

        stepBuilder = GameIntel.StepBuilder.with().gameInfo(roundResult, cards, cardVira, 1).botInfo(hand, 11).opponentScore(0);

        Boolean acceptMaoDeOnze = tecoNoMarrecoBot.getMaoDeOnzeResponse(stepBuilder.build());
        assertTrue(acceptMaoDeOnze);
    }


}