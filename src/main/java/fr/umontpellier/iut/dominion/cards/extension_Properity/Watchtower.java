package fr.umontpellier.iut.dominion.cards.extension_Properity;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.ActionReaction;

public class Watchtower extends ActionReaction {
    public Watchtower() {
        super("Watchtower", 3);
    }

    @Override
    public void play(Player p) {
        while (p.getCardsInHand().size() < 6){
            p.drawToHand();
        }
    }
}
