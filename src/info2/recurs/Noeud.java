
/*
 * Noeud d'un arbre binaire                    12/17
 * Noeud.java
 */
package info2.recurs;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que représnte un noeud dans un arbre binaire de recherche, sans valeur
 * en double. Chaque noeud contient une valeur d'un type T, un sous-arbre gauche
 * éventuellement vide, et un sous-arbre droit éventuellement vide. Le
 * sous-arbre gauche ne contient que des valeurs inférieures à la valeur du
 * noeud courant. Le sous-arbre droit ne contient que des valeurs supérieures à
 * la valeur du noeud couant.
 *
 * @param <T> type paramètre de généricité : le type des éléments de l'arbre. Les
 *            objets de ce type doivent être "comparables" (utilisation de la
 *            méthode compareTo)
 * @author INFO2
 */
public class Noeud<T extends Comparable<T>> implements Serializable {


    /**
     * Constante égale au nombre d'espaces d'indentation à laisser lors de
     * l'affichage des différents niveaux de l'arbre
     */
    private static final int DECALAGE = 5;


    /**
     * Valeur du noeud
     */
    private T valeur;

    /**
     * sous-arbre gauche du noeud courant : contient des valeurs inférieures à
     * celle du noeud courant
     */
    private Noeud<T> arbreGauche;

    /**
     * Sous-arbre droit du noeud courant : contient des valeurs supérieures à
     * celle du noeud courant
     */
    private Noeud<T> arbreDroit;


    /**
     * Constructeur avec la valeur du noeud à créer. Le noeud créé n'aura pas de
     * descendant.
     * @param valeurNoeud contient la valeur du noeud
     */
    public Noeud(T valeurNoeud) {
        valeur = valeurNoeud;
        arbreGauche = arbreDroit = null;
    }

    /**
     * Accesseur sur la valeur du noeud courant
     * @return la valeur contenue dans le noeud courant
     */
    public T getValeur() {
        return valeur;
    }

    /**
     * Accesseur sur le sous-arbre gauche
     * @return le sous-arbre gauche du noeud courant
     */
    public Noeud<T> getArbreGauche() {
        return arbreGauche;
    }

    /**
     * Accesseur sur le sous-arbre droit
     * @return le sous-arbre droit du noeud courant
     */
    public Noeud<T> getArbreDroit() {
        return arbreDroit;
    }



    /**
     * Ajoute la valeur argument à l'arbre qui débute au noeud courant.
     * @param aInserer
     *            valeur à insérer à gauche si inférieure au noeud courant, à
     *            droite si supérieure au noeud courant
     * @return un booléen égal à vrai ssi l'insertion a pu se faire,
     *         c'est-à-dire si la valeur à insérer n'est pas déjà présente dans
     *         l'arbre
     */
    public boolean inserer(T aInserer) {
        if (aInserer.compareTo(valeur) < 0) {

            // si insertion possible, elle se fera à gauche du noeud
            if (arbreGauche == null) {

                // le sous-arbre gauche est vide : création d'un nouveau noeud
                arbreGauche = new Noeud<>(aInserer);
                return true;
            } else {

                // appel récursif pour insérer à gauche
                return arbreGauche.inserer(aInserer);
            }
        } else if (aInserer.compareTo(valeur) > 0) {

            // si insertion possible, elle se fera à droite du noeud
            if (arbreDroit == null) {

                // le sous-arbre droit est vide : création d'un nouveau noeud
                arbreDroit = new Noeud<>(aInserer);
                return true;
            } else {

                // appel récursif pour insérer à droite
                return arbreDroit.inserer(aInserer);
            }
        } else {

            // la valeur à insérer est égale à la valeur du noeud courant
            return false; // insertion impossible
        }
    }

    /**
     * Détermine si la valeur argument est présente dans l'arbre débutant au
     * noeud courant
     * @param aChercher paramètre contenant la valeur à chercher
     * @return un booléan égal à vrai ssi la valeur a été trouvée
     */
    public boolean estPresente(T aChercher) {
        if (aChercher.compareTo(valeur) == 0) {

            // la valeur du noeud courant est égale à celle recherchée
            return true;
        }
        if (aChercher.compareTo(valeur) < 0) {

            // il faut chercher dans le sous-arbre gauche
            return arbreGauche != null && arbreGauche.estPresente(aChercher);
        }

        /*
         * else : on a aChercher > valeur
         * il faut chercher dans le sous-arbre droit
         */
        return arbreDroit != null && arbreDroit.estPresente(aChercher);
    }


    /**
     * Affiche les valeurs des noeuds, à partir du noeud courant,
     * dans l'ordre croissant
     */
    public void afficheOrdreCroissant() {

        // on affiche si possible les valeurs situées à gauche
        if (arbreGauche != null) {
            arbreGauche.afficheOrdreCroissant();
        }

        // on affiche la valeur du noeud courant
        System.out.println(valeur + "  ");

        // on affiche si possible les valeurs situées à droit
        if (arbreDroit != null) {
            arbreDroit.afficheOrdreCroissant();
        }
    }



    /**
     * Affiche les valeurs contenues dans l'arbre débutant au noeud argument
     * Chaque fois que l'on descend d'un niveau dans l'arbre, les valeurs des
     * noeuds sont affichées (en colonne) à droite des précédentes.
     * @param niveau niveau de profondeur du noeud courant. Cette valeur sert à calculer
     *               sur quelle colonne il faut effectuer l'affichage
     */
    public void afficheArbreNiveau(int niveau) {

        /*
         * on affiche d'abord le sous-arbre gauche, avec un niveau de
         * profondeur égal à niveau+1
         */
        if (arbreGauche != null) {
            arbreGauche.afficheArbreNiveau(niveau + 1);
        }

        // on laisse des espaces avant d'afficher le noeud courant
        for (int i = 0; i < niveau * DECALAGE; i++) {
            System.out.print(' ');
        }
        System.out.println(valeur);

        /*
         * on affiche ensuite le sous-arbre droit, avec un niveau de
         * profondeur égal à niveau+1
         */
        if (arbreDroit != null) {
            arbreDroit.afficheArbreNiveau(niveau + 1);
        }
    }



}