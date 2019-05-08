package fr.umontpellier.iut.dominion.cards.extension_Properity;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Treasure;

public class Talisman extends Treasure {
    public Talisman() {
        super("Talisman", 4);
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(1);
    }
}
