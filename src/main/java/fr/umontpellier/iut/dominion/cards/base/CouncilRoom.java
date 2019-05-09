package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Chambre du conseil (Council Room)
 *
 * +4 Cartes.
 * +1 Achat.
 * Tous vos adversaires piochent 1 carte.
 */
public class CouncilRoom extends Action {
    public CouncilRoom() {
        super("Council Room", 5);
    }

    @Override
    public void play(Player p) {
        p.incrementBuys(1);
        for (int i = 0; i < 4; i++) {
            p.drawToHand();
        }
        List<Player> list = p.getGame().otherPlayers(p);
        for (Player pla : list) {
            pla.drawToHand();
        }
    }

}