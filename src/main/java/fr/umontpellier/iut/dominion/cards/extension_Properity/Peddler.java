package fr.umontpellier.iut.dominion.cards.extension_Properity;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Action;

public class Peddler extends Action {
    public Peddler() {
        super("Peddler", 8);
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(1);
        p.incrementActions(1);
        p.drawToHand();
    }
}
