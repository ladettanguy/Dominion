package fr.umontpellier.iut.dominion.cards;

import fr.umontpellier.iut.dominion.IOGame;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.base.*;
import fr.umontpellier.iut.dominion.cards.common.Copper;
import fr.umontpellier.iut.dominion.cards.common.Duchy;
import fr.umontpellier.iut.dominion.cards.common.Gold;
import fr.umontpellier.iut.dominion.cards.common.Silver;
import fr.umontpellier.iut.dominion.cards.extension_Properity.Bishop;
import fr.umontpellier.iut.dominion.cards.extension_Properity.Loan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.io.PrintStream;

import static fr.umontpellier.iut.dominion.TestUtils.hasCards;
import static org.junit.jupiter.api.Assertions.*;


class CardsTestExtension {
    private IOGame game;
    private Player p0, p1, p2;

    @BeforeEach
    void disableConsole() {

        System.setOut(new PrintStream(new OutputStream() {

            @Override
            public void write(int arg0) {

            }
        }));

    }

    @BeforeEach
    void setUp() {
        String[] playerNames = new String[]{"Toto", "Titi", "Tutu"};
        game = new IOGame(playerNames, new String[0]);
        p0 = game.getPlayer(0);
        p1 = game.getPlayer(1);
        p2 = game.getPlayer(2);
    }

    @Test
    void testLoanDiscard() {
        Village village = new Village();
        Loan loan = new Loan();
        Gold gold = new Gold();
        p0.addToHand(loan);
        p0.addToDraw(gold);
        p0.addToDraw(village);


        game.setInput("y", "" , "Discard");
        p0.playCard("Loan");
        assertNull(p0.getDraw().getCard("Village"));
        assertNull(p0.getDraw().getCard("Gold"));
        assertNotNull(p0.getDiscard().getCard("Village"));
        assertNotNull(p0.getDiscard().getCard("Gold"));
    }

    @Test
    void testBishop() {
        p0.getHand().add(new Bishop());
        p0.getHand().add(new Gold());

        game.setInput("Gold");

        p0.playCard("Bishop");
        assertEquals(4,p0.getCountOfPoints());
        assertEquals(1,p0.getMoney());
    }




}
