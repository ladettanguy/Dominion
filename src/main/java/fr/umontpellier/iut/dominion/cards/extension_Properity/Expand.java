package fr.umontpellier.iut.dominion.cards.extension_Properity;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.SousTypeDeCard.TrashAndChangeACard;
import fr.umontpellier.iut.dominion.cards.type.Action;

public class Expand extends TrashAndChangeACard {
    public Expand() {
        super("Expand", 7);
    }

    @Override
    public void play(Player p) {
        super.play(p,3);
    }
}
