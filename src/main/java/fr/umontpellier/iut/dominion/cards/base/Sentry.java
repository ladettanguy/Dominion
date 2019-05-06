package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Sentinelle (Sentry)
 *
 * +1 Carte.
 * +1 Action.
 * Regardez les 2 premières cartes de votre deck. Écartez et/ou défaussez celles que vous voulez.
 * Replacez le sur votre deck dans l'ordre de votre choix.
 */
public class Sentry extends Card {
    public Sentry() {
        super("Sentry", 5);
    }

    @Override
    public void play(Player p) {
        p.drawToHand();
        p.incrementActions(1);

        ListOfCards list = new ListOfCards();
        list.add(p.removeToDraw(1));list.add(p.removeToDraw(0));
        String s = " ";
        int count = 0;
        while (!list.isEmpty() && count < 2) {
            s = p.chooseCard("Choissiez si vous voullez trash (une ou les deux) cartes suivant : ", list, true);
            if (!s.equals("")){
                list.remove(s);
            }
            count++;
        }
        String string = "a";
        while (!list.isEmpty() && !string.equals("")){
            string = p.chooseCard("Choissiez si vous voullez défausser une (ou les deux) cartes suivant : ", list, true);
            if (!string.equals("")){
                p.discardCard(list.getCard(string));
                list.remove(string);
            }
        }
        if (!list.isEmpty()){
            String choix = p.chooseCard("Choissiez la carte que vous voulez metre en premier dans draw : ", list, false);
            Card c = list.remove(choix);
            p.addToDraw(c);
            p.addToDraw(list.get(0));
        }
    }

    @Override
    public List<CardType> getTypes() {
        List<CardType> list = new ArrayList<>();
        list.add(CardType.Action);
        return list;
    }
}
