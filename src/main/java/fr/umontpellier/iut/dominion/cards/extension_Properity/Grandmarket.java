package fr.umontpellier.iut.dominion.cards.extension_Properity;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Action;

public class Grandmarket extends Action {
    public Grandmarket() {
        super("Grand Market", 6);
    }

    @Override
    public void play(Player p) {
        p.incrementActions(1);
        p.incrementBuys(1);
        p.incrementMoney(2);
        p.drawToHand();
    }
}
