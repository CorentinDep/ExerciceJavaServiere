/*
 *
 * Pile.java                                                        17/09/21
 */

package info2.outils;

import java.util.Arrays;
import info2.outils.ErreurPile;

/**
 *
 * @author coren
 * @version 1.0
 */
public class PileGenerique <T> {




    /** Capacité maximale de la pile par défaut */
    private static final int CAPACITE_MAX_DEFAUT = 10;

    /** Taille par défaut de la pile */
    private static final int TAILLE_DEFAUT = 0;

    /** Nombre maximum d'élément de la pile */
    private final int capacite;

    /** Nombres d'entiers présents à un instant donné dans la pile */
    private int taille;

    /** Tableau pour stocker les valeurs de la pile */
    private T[] element;


    /**
     * Initialise une pile vide
     */
    public PileGenerique() {
        this.capacite = CAPACITE_MAX_DEFAUT;
        this.taille = TAILLE_DEFAUT;
        element = (T[]) new Object[capacite];
    }

    /**
     * Initialise une pile avec les valeurs passées en arguments
     * @param capacite Nombre maximum d'élément de la pile
     * @throws ErreurPile.ErreurCapaciteInvalide capacité négative
     */
    public PileGenerique(int capacite) throws ErreurPile.ErreurCapaciteInvalide {

        if (capacite < 0) {
            throw new ErreurPile.ErreurCapaciteInvalide(capacite);
        }

        this.capacite = capacite;
        this.taille = TAILLE_DEFAUT;
        element = (T[]) new Object[capacite];

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
     * @throws ErreurPile.ErreurPilePleine La pile est pleine impossible d'ajouter un nb
     */
    public PileGenerique<T> empiler(T newValeur) throws ErreurPile.ErreurPilePleine {
        if (estPleine()) {
            throw new ErreurPile.ErreurPilePleine("Impossible d'empiler la valeur " + newValeur + ". La pile de capacité " + this.capacite + " est pleine.");
        }
        element[taille] = newValeur;
        this.taille ++;
        return this;
    }

    /**
     * Renvoie la valeur du sommet de la pile
     * @return la valeur du sommet actuel
     */
    public T sommet() throws ErreurPile.ErreurPileVide {
        if (this.taille == 0) {
            throw new ErreurPile.ErreurPileVide("Impossible de consulter le sommet d'une pile vide");
        }
        return (T) element[taille - 1];
    }

    /**
     * dépiler l'élément sommet de la pile
     */

    public PileGenerique<T> depiler() throws ErreurPile.ErreurPileVide {
        if (estVide()) {
            throw new ErreurPile.ErreurPileVide("Impossible de dépiler une pile vide");
        }
        element[taille - 1] = null;
        this.taille --;
        return this;
    }

    /**
     * Renvoie un String avec le contenu de la pile
     * @return string
     */
    @Override
    public String toString() {

        StringBuilder chaine = new StringBuilder();

        chaine.append("[ sommet = ");

        for (int i = this.taille - 1; i >= 0; i--) {
            chaine.append(element[i].toString());
            chaine.append(i != 0 ? " | " : "");
        }

        chaine.append(" ]");

        return chaine.toString();
    }

    /**
     * Opération qui détermine si deux piles ont la même capacité
     * @param pileAComparer pile que l'on comparer
     * @return true si égale
     *         false sinon
     */
    public static <T> boolean memeCapacite(PileGenerique<T> pileAComparer, PileGenerique<T> pileAcomparer2) {
        return pileAcomparer2.capacite == pileAComparer.capacite;
    }

    public boolean equals(Object azz) {
        boolean test = true;

        if (!(azz instanceof PileGenerique)) {
            test = false;
        } else {
            @SuppressWarnings("unchecked")
            PileGenerique<T> pileAComparer = (PileGenerique<T>) azz;

            if ((!memeCapacite(pileAComparer, this) || pileAComparer.taille != this.taille)) {
                test = false;
            } else {
                for (int i = 0; i < taille && pileAComparer.element[i].equals(this.element[i]); i++) {
                    test = this.element[i] == pileAComparer.element[i];
                }
            }
        }
        return test;
    }

}





























