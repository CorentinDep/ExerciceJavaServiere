/*
 *
 * Pile.java                                                        17/09/21
 */

package info2.outils;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author coren
 * @version 1.0
 */
public class Pile {

    /**
     * Exception levée si la capacité entrée par l'utilisateur est invalide
     */
    public static class ErreurCapaciteInvalide extends Exception {

        public ErreurCapaciteInvalide(String message) {
            super(message);
        }
        /* Corps vide pour le moment */
    }

    /**
     * Exception levée si lorsque la pile est vide l'utilisateur essaye de
     * dépiler un entier
     */
    public static class ErreurPileVide extends Exception {
        /* Corps vide pour le moment */
    }

    /**
     * Exception levée si lorsque la pile est pleine l'utilisateur essaye de
     * piler un nouvelle entier
     */
    public static class ErreurPilePleine extends Exception {
        /* Corps vide pour le moment */
    }


    /** Capacité mmaximale de la pile par défaut */
    private static final int CAPACITE_MAX_DEFAUT = 10;

    /** Taille par défaut de la pile */
    private static final int TAILLE_DEFAUT = 0;

    /** Nombre maximum d'élément de la pile */
    private int capacite;

    /** Nombres d'entiers présents à un instant donné dans la pile */
    private int taille;

    /** Pour stocker les valeurs */
    private int[] element;

    /**  */

    /**
     * Initialise une pile vide
     */
    public Pile() {
        this.capacite = CAPACITE_MAX_DEFAUT;
        this.taille = TAILLE_DEFAUT;
        element = new int[this.capacite];
    }

    /**
     * Initialise une pile avec les valeurs passées en arguments
     * @param capacite Nombre maximum d'élément de la pile
     * @throws ErreurCapaciteInvalide capacité négative
     */
    public Pile(int capacite) throws ErreurCapaciteInvalide {

        if (capacite < 0) {
            throw new ErreurCapaciteInvalide("La capacité de la pile doit être supérieur ou égale à 0");
        }

        this.capacite = capacite;
        this.taille = TAILLE_DEFAUT;
        element = new int[capacite];
    }

    /**
     * Détermine si la pile est vide
     * @return true si vide
     *         false sinon
     */
    public boolean estVide() {
        return this.taille == 0;
    }

    public boolean estPleine() {
        return this.taille == capacite;
    }

    /**
     * empiler l'entier argument
     * @param newValeur nouvelle valeur à empiler
     * @throws ErreurPilePleine La pile est pleine impossible d'ajouter un nb
     */
    public void empiler(int newValeur) throws ErreurPilePleine {
        if (this.taille == capacite) {
            throw new ErreurPilePleine();
        }
        element[taille] = newValeur;
        this.taille ++;
    }

    /**
     * Renvoie la valeur du sommet de la pile
     * @return la valeur du sommet actuel
     */
    public int sommet() throws ErreurPileVide {
        if (this.taille == 0) {
            throw new ErreurPileVide();
        }
        return element[taille - 1];
    }

    /**
     * dépiler l'élément sommet de la pile */
    public void depiler() throws ErreurPileVide{
        if (this.taille == 0) {
            throw new ErreurPileVide();
        }
        element[taille - 1] = 0;
        this.taille --;
    }

    /**
     * Renvoie un String avec le contenu de la pile
     * @return string
     */
    @Override
    public String toString() {

        StringBuilder chaine = new StringBuilder();

        chaine.append("[ sommet = ");

        for (int i = this.taille - 1; i > 0; i--) {
            chaine.append(element[i] + " | ");
        }

        chaine.append("]");

        return chaine.toString();
    }

    /**
     * Opération qui détermine si deux piles ont la même capacité
     * @param pileAComparer pile que l'on comparer
     * @return true si égale
     *         false sinon
     */
    public static boolean memeCapacite(Pile pileAComparer, Pile pileAcomparer2) {
        return pileAcomparer2.capacite == pileAComparer.capacite;
    }

    public boolean equals(Pile aComparer) {

        boolean test;

        test = true;

        for (int i = 0; i < this.capacite; i++) {
            if (this.element[i] != aComparer.element[i]) {
                test = false;
            }
        }

        return test;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pile pile = (Pile) o;
        return capacite == pile.capacite && Arrays.equals(element, pile.element);
    }

}





























