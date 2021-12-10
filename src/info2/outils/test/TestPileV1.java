/*
 *
 * Pile.java                                                        17/09/21
 */

package info2.outils.test;

import info2.outils.Pile;

/**
 * Classe qui représente un individu décrit par son nom et son prénom
 *
 * @author INFO2
 * @version 1.0
 */

public class TestPileV1 {


    public static void main(String[] args) throws Pile.ErreurPileVide, Pile.ErreurCapaciteInvalide, Pile.ErreurPilePleine {

        Pile pile = new Pile(5);

        /* Erreur provoqué */
        System.out.println("Valeur au sommet : " + pile.sommet());


        /* Erreur provoqué */
        pile.depiler();

        if (pile.estVide()) {
            System.out.println("La pile est vide !");
        } else {
            System.out.println("La pile n'est pas vide !");
        }
        pile.empiler(12);
        pile.empiler(45);
        pile.empiler(75);

        if (pile.estVide()) {
            System.out.println("La pile est vide !");
        } else {
            System.out.println("La pile n'est pas vide !");
        }

        System.out.println("Valeur au sommet : " + pile.sommet());
        System.out.println("Valeur de la Pile \n" + pile.toString());
        pile.depiler();
        System.out.println("Valeur de la Pile \n" + pile.toString());
        pile.empiler(19);
        pile.empiler(5);
        pile.empiler(61);

        if (pile.estPleine()) {
            System.out.println("La pile est pleine !");
        } else {
            System.out.println("La pile n'est pas pleine !");
        }

        /* Erreur provoqué */
        pile.empiler(45);

        /* Erreur provoqué */
        Pile pile2 = new Pile(-5);

    }
}
