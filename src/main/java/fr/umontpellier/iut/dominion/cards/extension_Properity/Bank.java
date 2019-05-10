package fr.umontpellier.iut.dominion.cards.extension_Properity;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Treasure;

public class Bank extends Treasure {
    public Bank() {
        super("Bank", 7);
    }

    @Override
    public void play(Player p) {
        int numberOfTreasure = 0;
        for (Card c: p.getCardsInInplay()) if(c.getTypes().contains(CardType.Treasure))numberOfTreasure++;
        //je me permet de faire ça car la phase "Trésor" joue automatiquement toute les trésors.
        for (Card c: p.getCardsInHand()) if(c.getTypes().contains(CardType.Treasure))numberOfTreasure++;
        p.incrementMoney(numberOfTreasure);
    }
}
