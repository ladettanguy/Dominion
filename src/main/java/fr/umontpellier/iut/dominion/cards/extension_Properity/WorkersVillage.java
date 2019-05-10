package fr.umontpellier.iut.dominion.cards.extension_Properity;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Action;

public class WorkersVillage extends Action {
    public WorkersVillage() {
        super("Worker's Village", 4);
    }

    @Override
    public void play(Player p) {
        p.incrementActions(2);
        p.incrementBuys(1);
        p.drawToHand();
    }
}