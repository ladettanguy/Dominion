package fr.umontpellier.iut.dominion.cards;

import fr.umontpellier.iut.dominion.IOGame;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.base.*;
import fr.umontpellier.iut.dominion.cards.common.*;
import fr.umontpellier.iut.dominion.cards.extension_Properity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
    void testPlatinum() {
        p0.getHand().add(new Platinum());

        p0.playCard("Platinum");

        assertEquals(5,p0.getMoney());
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

    @Test
    void testCityWithTwoEmptyStack() {
        p0.getHand().add(new City());
        p0.addToDraw(new Loan());
        p0.addToDraw(new Bishop());

        for (int i = 0; i < 99; i++) { game.removeFromSupply("Silver"); }   // vider la pile de Silver
        for (int i = 0; i < 99; i++) { game.removeFromSupply("Gold"); }     // vider la pile de Gold

        p0.playCard("City");

        assertEquals(2,p0.getNumberOfActions());
        assertEquals(1,p0.getMoney());
        assertEquals(1,p0.getNumberOfBuys());
        assertNull(p0.getDraw().getCard("Loan"));
        assertNull(p0.getDraw().getCard("Bishop"));
        assertNotNull(p0.getHand().getCard("Loan"));
        assertNotNull(p0.getHand().getCard("Bishop"));
    }

    @Test
    void testCityWithOneEmptyStack() {
        p0.getHand().add(new City());
        p0.addToDraw(new Loan());
        p0.addToDraw(new Bishop());

        for (int i = 0; i < 99; i++) { game.removeFromSupply("Silver"); }   // vider la pile de Silver

        p0.playCard("City");

        assertEquals(2,p0.getNumberOfActions());
        assertEquals(0,p0.getMoney());
        assertEquals(0,p0.getNumberOfBuys());
        assertNull(p0.getDraw().getCard("Loan"));
        assertNull(p0.getDraw().getCard("Bishop"));
        assertNotNull(p0.getHand().getCard("Loan"));
        assertNotNull(p0.getHand().getCard("Bishop"));
    }

    @Test
    void testCityWithoutEmptyStack() {
        p0.getHand().add(new City());
        p0.addToDraw(new Loan());
        p0.addToDraw(new Bishop());

        p0.playCard("City");

        assertEquals(2,p0.getNumberOfActions());
        assertEquals(0,p0.getMoney());
        assertEquals(0,p0.getNumberOfBuys());
        assertNotNull(p0.getDraw().getCard("Loan"));
        assertNull(p0.getDraw().getCard("Bishop"));
        assertNull(p0.getHand().getCard("Loan"));
        assertNotNull(p0.getHand().getCard("Bishop"));
    }

    @Test
    void testKingsCourt() {
        p0.getHand().add(new KingsCourt());
        p0.getHand().add(new Village());
        Card c1 = p0.getDraw().get(0);
        Card c2 = p0.getDraw().get(1);
        Card c3 = p0.getDraw().get(2);


        game.setInput("Village");

        p0.playCard("King's Court");

        assertEquals(6,p0.getNumberOfActions());
        assertTrue(p0.getHand().contains(c1));
        assertTrue(p0.getHand().contains(c2));
        assertTrue(p0.getHand().contains(c3));
    }

    @Test
    void testMonument() {
        p0.getHand().add(new Monument());

        p0.playCard("Monument");

        assertEquals(2,p0.getMoney());
        assertEquals(1,p0.getCountOfPoints());
    }


    @Test
    void testRoyalSeal() {
        p0.getHand().add(new RoyalSeal());
        p0.incrementBuys(1);
        p0.playCard("Royal Seal");

        p0.buyCard("Copper");

        assertEquals(2, p0.getMoney());
        assertNotNull(p0.getHand().getCard("Copper"));
        assertNotNull(p0.getDraw().getCard("Royal Seal"));
    }

    @Test
    void testWorkersVillage() {
        p0.getHand().add(new WorkersVillage());
        Card c1 = p0.getDraw().get(0);

        p0.playCard("Worker's Village");

        assertEquals(2, p0.getNumberOfActions());
        assertEquals(1, p0.getNumberOfBuys());
        assertTrue(p0.getHand().contains(c1));
    }

    @Test
    void testExpand() {
        p2.getHand().add(new Expand());
        p2.getHand().add(new Silver());
        game.setInput("Silver","Colony","Gold");
        p2.playCard("Expand");

        assertNull(p2.getDiscard().getCard("Colony"));
        assertNotNull(p2.getDiscard().getCard("Gold"));
        assertNull(p2.getHand().getCard("Silver"));
    }

    @Test
    void testForge() {
        p2.getHand().add(new Forge());
        p2.getHand().add(new Village());
        p2.getHand().add(new Village());

        game.setInput("Village","Village","","Gold");

        p2.playCard("Forge");

        assertNull(p2.getDiscard().getCard("Village"));
        assertNull(p2.getDiscard().getCard("Colony"));
        assertNotNull(p2.getDiscard().getCard("Gold"));
    }
}
