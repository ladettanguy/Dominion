package fr.umontpellier.iut.dominion.cards;

import fr.umontpellier.iut.dominion.IOGame;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.base.*;
import fr.umontpellier.iut.dominion.cards.common.*;
import fr.umontpellier.iut.dominion.cards.extension_Properity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class CardsTestExtension {
    private IOGame game;
    private Player p0, p2;

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
        p2 = game.getPlayer(1);
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

    @Test
    void testGrandmarket() {
        p2.getHand().add(new Grandmarket());
        Card c1 = p2.getDraw().get(0);
        p2.playCard("Grand Market");
        p2.buyCard("Copper");

        assertNotNull(p2.getDiscard().getCard("Copper"));
        assertEquals(1, p2.getCountOfPoints());
        assertEquals(0, p2.getNumberOfBuys());
        assertEquals(1, p2.getNumberOfActions());
        assertTrue(p2.getHand().contains(c1));
    }

    @Test
    void testTalismanBuyAnColony() {
        p2.getHand().add(new Talisman());
        p2.incrementBuys(1);
        p2.incrementMoney(10);
        p2.playCard("Talisman");
        p2.buyCard("Colony");


        assertTrue(p2.getDiscard().get(0).getName().equals("Colony"));
        assertEquals(1,p2.getDiscard().size());
        assertEquals(0,p2.getMoney());
    }

    @Test
    void testTalismanBuyAnCopper() {
        p2.getHand().add(new Talisman());
        p2.incrementBuys(1);
        p2.playCard("Talisman");
        p2.buyCard("Copper");


        assertTrue(p2.getDiscard().get(0).getName().equals("Copper"));
        assertTrue(p2.getDiscard().get(1).getName().equals("Copper"));
        assertEquals(2,p2.getDiscard().size());
        assertEquals(1,p2.getMoney());
    }

    @Test
    void testBank() {
        //vide la main
        for (int i = 0; i < 5; i++) p2.getHand().remove(0); //vide la main
        //remet des carte en main
        p2.getHand().add(new Bank());
        p2.getHand().add(new Copper());
        p2.getHand().add(new Silver());
        p2.getHand().add(new Gold());
        p2.getHand().add(new Village());
        p2.getInPlay().add(new Colony());
        p2.getInPlay().add(new Talisman());

        p2.playCard("Bank");

        assertEquals(5,p2.getMoney());
    }

    @Test
    void testWatchtower() {
        //vide la main
        for (int i = 0; i < 5; i++) p2.getHand().remove(0); //vide la main
        //remet des carte en main
        p2.getHand().add(new Watchtower());
        p2.getDraw().add(new Copper());
        p2.getDraw().add(new Silver());
        p2.getDraw().add(new Gold());
        p2.getDraw().add(new Village());
        p2.getDraw().add(new Colony());
        p2.getDraw().add(new Talisman());

        p2.playCard("Watchtower");

        assertEquals(6,p2.getHand().size());
    }

    @Test
    void testWatchtowerReactionDraw() {
        //vide la main
        for (int i = 0; i < 5; i++) p2.getHand().remove(0); //vide la main
        //remet des carte en main

        p2.getHand().add(new Watchtower());
        p2.incrementBuys(1);


        game.setInput("Draw");

        p2.buyCard("Copper");

        assertNull(p2.getDiscard().getCard("Copper"));
        assertTrue(p2.getDraw().get(0).getName().equals("Copper"));
    }

    @Test
    void testWatchtowerReactionTrash() {
        //vide la main
        for (int i = 0; i < 5; i++) p2.getHand().remove(0); //vide la main
        //remet des carte en main
        //vide la main
        for (int i = 0; i < 4; i++) p2.getDraw().remove(0); //vide la draw
        //remet des carte en main

        p2.getHand().add(new Watchtower());
        p2.incrementBuys(1);


        game.setInput("Trash");

        Card c = p2.buyCard("Copper");

        assertNull(p2.getDiscard().getCard("Copper"));
        assertFalse(p2.getDraw().contains(c));
        assertFalse(p2.getDraw().get(0).equals(c));
    }

    @Test
    void testWatchtowerReactionPass() {
        //vide la main
        for (int i = 0; i < 5; i++) p2.getHand().remove(0); //vide la main
        //remet des carte en main

        p2.getHand().add(new Watchtower());
        p2.incrementBuys(1);


        game.setInput("");

        p2.buyCard("Copper");

        assertNotNull(p2.getDiscard().getCard("Copper"));
    }

    @Test
    void testQuarry() {
        //vide la main
        for (int i = 0; i < 5; i++) p2.getHand().remove(0); //vide la main
        //remet des carte en main

        p2.getHand().add(new Quarry());
        ListOfCards list = new ListOfCards();
        for (int i = 0; i < 10; i++) {
            list.add(new Village());
        }
        game.addSupplyStacks(list);

        p2.playCard("Quarry");

        p2.incrementBuys(1);

        p2.buyCard("Village");

        assertNotNull(p2.getDiscard().getCard("Village"));
    }

    @Test
    void testQuarryCantBuy() {
        //vide la main
        for (int i = 0; i < 5; i++) p2.getHand().remove(0); //vide la main
        //remet des carte en main

        p2.getHand().add(new Quarry());
        ListOfCards list = new ListOfCards();
        for (int i = 0; i < 10; i++) {
            list.add(new ThroneRoom());
        }
        game.addSupplyStacks(list);

        p2.playCard("Quarry");

        p2.incrementBuys(1);

        p2.buyCard("Throne Room");

        assertNull(p2.getDiscard().getCard("Throne Room"));
    }

    @Test
    void testCountinghouse() {
        //vide la main
        for (int i = 0; i < 5; i++) p2.getHand().remove(0); //vide la main
        //vide la main
        for (int i = 0; i < 5; i++) p2.getDraw().remove(0); //vide la draw

        //remet des carte en main
        p2.getHand().add(new Countinghouse());
        p2.getDiscard().add(new Copper());
        p2.getDiscard().add(new Copper());
        p2.getDiscard().add(new Copper());
        p2.getDiscard().add(new Copper());
        p2.getDiscard().add(new Copper());

        game.setInput("6","5");

        p2.playCard("Counting House");

        assertNull(p2.getDiscard().getCard("Copper"));
        assertEquals(0,p2.getDiscard().size());
        assertNotNull(p2.getDraw().getCard("Copper"));
        assertEquals(5,p2.getDraw().size());
    }

    @Test
    void testCountinghousePass() {
        //vide la main
        for (int i = 0; i < 5; i++) p2.getHand().remove(0); //vide la main
        //vide la main
        for (int i = 0; i < 5; i++) p2.getDraw().remove(0); //vide la draw

        //remet des carte en main
        p2.getHand().add(new Countinghouse());
        p2.getDiscard().add(new Copper());
        p2.getDiscard().add(new Copper());
        p2.getDiscard().add(new Copper());
        p2.getDiscard().add(new Copper());
        p2.getDiscard().add(new Copper());

        game.setInput("");

        p2.playCard("Counting House");

        assertNotNull(p2.getDiscard().getCard("Copper"));
        assertEquals(5,p2.getDiscard().size());
        assertNull(p2.getDraw().getCard("Copper"));
        assertEquals(0,p2.getDraw().size());
    }

    @Test
    void testMint() {
        //vide la main
        for (int i = 0; i < 5; i++) p2.getHand().remove(0); //vide la main
        //vide la main
        for (int i = 0; i < 5; i++) p2.getDraw().remove(0); //vide la draw

        //remet des carte en main
        p2.getHand().add(new Mint());
        p2.getHand().add(new Gold());


        game.setInput("Gold");

        p2.playCard("Mint");

        assertTrue(p2.getHand().get(0).getName().equals("Gold"));
        assertTrue(p2.getHand().get(1).getName().equals("Gold"));
        assertEquals(2,p2.getHand().size());
    }

    @Test
    void testMintPass() {
        //vide la main
        for (int i = 0; i < 5; i++) p2.getHand().remove(0); //vide la main
        //vide la main
        for (int i = 0; i < 5; i++) p2.getDraw().remove(0); //vide la draw

        //remet des carte en main
        p2.getHand().add(new Mint());
        p2.getHand().add(new Gold());

        game.setInput("");

        p2.playCard("Mint");

        assertTrue(p2.getHand().get(0).getName().equals("Gold"));
        assertEquals(1,p2.getHand().size());
    }

    @Test
    void testHoard() {
        //vide la main
        for (int i = 0; i < 5; i++) p2.getHand().remove(0); //vide la main
        //vide la main
        for (int i = 0; i < 5; i++) p2.getDraw().remove(0); //vide la draw

        //remet des carte en main
        p2.getHand().add(new Hoard());
        p2.incrementBuys(1);

        p2.playCard("Hoard");
        p2.buyCard("Estate");

        assertNotNull(p2.getDiscard().getCard("Gold"));
        assertEquals(0,p2.getMoney());
    }

    @Test
    void testPeddler() {
        //vide la main
        for (int i = 0; i < 5; i++) p2.getHand().remove(0); //vide la main

        //remet des carte en main
        p2.getHand().add(new Peddler());

        p2.playCard("Peddler");

        assertEquals(1,p2.getMoney());
        assertEquals(1,p2.getNumberOfActions());
        assertEquals(1,p2.getHand().size());
    }

    @Test
    void testPeddlerToBuy() {
        //vide la main
        for (int i = 0; i < 5; i++) p2.getHand().remove(0); //vide la main
        //vide la main
        for (int i = 0; i < 5; i++) p2.getDraw().remove(0); //vide la draw

        ListOfCards list = new ListOfCards();
        for (int i = 0; i < 10; i++) {
            list.add(new Peddler());
        }
        game.addSupplyStacks(list);

        //remet des carte en main
        p2.getInPlay().add(new Village());
        p2.getInPlay().add(new Village());
        p2.getInPlay().add(new Quarry());
        p2.incrementBuys(1);
        p2.incrementMoney(2);

        p2.buyCard("Peddler");

        assertNotNull(p2.getDiscard().getCard("Peddler"));
        assertEquals(0,p2.getMoney());
    }
}
