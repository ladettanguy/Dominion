package fr.umontpellier.iut.dominion.cards.extension_Properity;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Treasure;
/**
 * Carte Seau Royal (RoyalSeal)
 *Cout 5
 *
 */

public class RoyalSeal extends Treasure {
    public RoyalSeal() {
        super("Royal Seal", 5);
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(2);
    }
}
