package fr.umontpellier.iut.dominion.cards.extension_Properity;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Treasure;

/**
 * +1 money
 *
 * quand cette carte est jouer, révélé des carte de la pioche jusqu'a avoir un treasure , choisissez de la discard ou de la trash.
 *
 * Discard les autres card
 */
public class Loan extends Treasure {
    public Loan() {
        super("Loan", 3);
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(1);

    }
}
