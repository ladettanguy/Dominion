package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.ActionAttack;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Bandit
 *
 * Gagnez un Or.
 * Chaque joueur révèle les deux premières cartes de son deck, écarte un trésor autre que Cuivre et défausse le reste.
 */
public class Bandit extends ActionAttack {
    public Bandit() {
        super("Bandit", 5);
    }

    @Override
    public void play(Player p) {
        p.gainFromSupply("Gold");
        List<Player> list = p.getGame().otherPlayers(p);
        for (Player pla : list) {
            p.haveMoat();
            if(!p.isProtected()) {
                Card c1 = pla.drawCard();
                Card c2 = pla.drawCard();
                ListOfCards aTrash = new ListOfCards();
                ListOfCards pioche = new ListOfCards();
                if (c1 != null && !c1.getName().equals("Copper") && c1.getTypes().contains(CardType.Treasure))
                    aTrash.add(c1);
                else p.discardCard(c1);
                if (c2 != null && !c2.getName().equals("Copper") && c2.getTypes().contains(CardType.Treasure))
                    aTrash.add(c2);
                else p.discardCard(c2);
                pioche.add(c1);
                pioche.add(c2);
                String s = p.chooseCard("Choisissez une carte a trash entre les deux " + aTrash.toString(), aTrash, false);
                if (!s.equals("")) {
                    pioche.remove(aTrash.getCard(s));
                    pla.discardCard(pioche.get(0));
                }
            }
            p.cancelProtect();
        }
    }

    @Override
    public List<CardType> getTypes() {
        List<CardType> list = new ArrayList<>();
        list.add(CardType.Action);
        list.add(CardType.Attack);
        return list;
    }
}
