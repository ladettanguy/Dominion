package fr.umontpellier.iut.dominion.cards.extension_Properity;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.SousTypeDeCard.ActionPlaySeveralTimes;

/**
 * Carte court du trône (King's Court)
 *
 * Choisissez 1 carte Action de votre main.
 * Jouez-la trois fois.
 */

public class KingsCourt  extends ActionPlaySeveralTimes {
    public KingsCourt() {
        super("King's Court", 7);
    }

    @Override
    public void play(Player p) {super.play(p,3);}
}
