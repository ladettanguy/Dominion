package fr.umontpellier.iut.dominion.cards.SousTypeDeCard;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

public abstract class ActionPlaySeveralTimes extends Action {
    public ActionPlaySeveralTimes(String name, int cost) {
        super(name, cost);
    }

    public void play(Player p, int nombreDePlay) {
        ListOfCards list = p.getHand();
        ListOfCards jouable = new ListOfCards();
        for (Card c: list)
            if (c.getTypes().contains(CardType.Action))jouable.add(c);
        String s;
        s = p.chooseCard("choisissez une carte à jouer deux fois parmi les suivantes",jouable, jouable.isEmpty());
        Card c = list.getCard(s);
        p.playCard(s);
        for (int i = 0; i < nombreDePlay-1; i++) {
            c.play(p);
        }
    }
}
