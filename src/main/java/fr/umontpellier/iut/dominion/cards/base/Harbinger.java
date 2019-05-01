package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Avant-coureur (Harbinger)
 *
 * +1 Carte.
 * +1 Action.
 * Regardez dans votre défausse, vous pouvez prendre une carte et la mettre sur votre deck.
 */
public class Harbinger extends Card {
    public Harbinger() {
        super("Harbinger", 3);
    }

    @Override
    public void play(Player p) {
        p.incrementActions(1);
        p.drawToHand();

        ListOfCards discard = p.getDiscard();
        String choose = p.chooseCard("Choissisez une carte de votre défausse", discard, !discard.isEmpty());
        Card c = p.getDiscard().getCard(choose);
        p.addToDraw(c);
        p.removeToDiscard(c);

    }
}
