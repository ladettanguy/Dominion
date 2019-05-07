package fr.umontpellier.iut.dominion.cards.extension_Properity;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

/**
 * +1 money
 *
 * +1 VictoryPoint
 *
 * ecarte une carte de la main .  +1 VictoryPoint
 * tous les 2 Cost de la carte ecarté
 * Tous les autre joueur trash une carte depuis leur main
 */
public class Bishop extends Action {
    public Bishop() {
        super("Bishop",4);
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(1);
        p.incrementVictoryPoint(1);
        String s = p.chooseCard("Trasher une carte de la main pour gagner +1 poitnde victoire pour tout les 2 cost", p.getCardsInHand() , false);
        if (!s.equals(""))    {
            Card c = p.getCardsInHand().getCard(s);
            int x = c.getCost();
            p.incrementVictoryPoint(x/2);
        }
    }
}
