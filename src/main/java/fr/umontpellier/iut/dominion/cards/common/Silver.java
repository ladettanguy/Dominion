package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Treasure;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Argent (Silver)
 *
 * 2 Pièces
 */
public class Silver extends Treasure {
    public Silver() {
        super("Silver", 3);
    }

    @Override
    public void play(Player p) {
        if (p.isHasMerchantEffect()>0) {
            p.incrementMoney(1);
            p.setHasMerchantEffect(-1);
        }
        p.incrementMoney(2);
    }
}
