package fr.umontpellier.iut.dominion.cards.extension_Properity;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Treasure;

public class Hoard extends Treasure {
    public Hoard() {
        super("Hoard", 6);
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(2);
    }
}
