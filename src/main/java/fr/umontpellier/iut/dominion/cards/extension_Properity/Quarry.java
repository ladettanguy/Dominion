package fr.umontpellier.iut.dominion.cards.extension_Properity;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Treasure;

public class Quarry extends Treasure {
    public Quarry() {
        super("Quarry", 4);
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(1);
        p.setQuarryOn(true);
    }
}
