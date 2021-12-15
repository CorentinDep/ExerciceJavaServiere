/*
 * Classe qui représente un arbre binaire générique            12/17
 * ArbreBinaire.java
 */

package info2.recurs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe qui représente un arbre binaire de recherche qui contient des valeurs
 * d'un type T. L'arbre ne peut pas contenir de valeur en double. Il peut être
 * vide.
 * @param <T> type paramètre de généricité : le type des éléments de l'arbre. Les
 *            objets de ce type doivent être "comparables" (utilisation de la
 *            méthode compareTo)
 * @author INFO2
 */
public class ArbreBinaire<T extends Comparable<T>> implements Serializable {



    /**
     * Noeud racine de l'arbre binaire (peut être égal à null)
     */
    private Noeud<T> racine;

    /**
     * Constructeur par défaut : l'arbre binaire est vide
     */
    public ArbreBinaire() {
        racine = null;          // pas de noeud racine
    }

    /**
     * Insère la valeur argument dans l'arbre courant
     * @param aInserer entier à insérer
     * @return un booléan égal à vrai ssi l'insertion est possible, c'est-à-dire
     *         si la valeur à insérer n'est pas déjà présente
     */
    public boolean inserer(T aInserer) {
        if (racine == null) {

            // l'arbre est vide : insertion sur un nouveau noeud
            racine = new Noeud<T>(aInserer);
            return true;
        }

        // sinon : insertion à partir de la racine
        return racine.inserer(aInserer);
    }

    /**
     * Détermine si la valeur argument est présente dans l'arbre binaire
     * @param aChercher valeur à rechercher dans l'arbre
     * @return un booléen égal à vrai ssi la valeur est présente dans l'arbre
     */
    public boolean estPresente(T aChercher) {
        if (racine == null) {

            // l'arbre est vide : la valeur n'est pas présente
            return false;
        }

        // sinon : recherche à partir du noeud racine
        return racine.estPresente(aChercher);
    }


    /**
     * Affiche les valeurs contenues dans l'arbre dans l'ordre croissant
     */
    public void afficheOrdreCroissant() {
        if (racine == null) {
            System.out.println("L'arbre est vide.");
        } else {

            /*
             * appel à afficheOrdreCroissant sur la racine pour lancer les appels
             * récursifs
             */
            racine.afficheOrdreCroissant();
        }
    }


    /**
     * Affiche les valeurs contenues dans l'arbre binaire. La racine est
     * affichée sur la colonne de gauche, les valeurs des noeuds enfants sont
     * affichées sur la colonne suivante et ainsi de suite. Le nombre d'espaces
     * de séparation entre les colonnes est égal à DECALAGE.
     */
    public void afficheArbreNiveau() {
        if (racine == null) {
            System.out.println("L'arbre est vide.");
        } else {

            /*
             * appel à afficheCroissant sur la racine pour lancer les appels
             * récursifs : la racine sera affichée à gauche de l'écran
             */
            racine.afficheArbreNiveau(0);
        }
    }



}





















// /**
// * Supprime la valeur argument si elle est présente et située sur une
// * feuille
// * @param valeur à supprimer
// * @return un booléen égal à vrai ssi la suppression a été effectuée
// */
// public boolean supprimeSiFeuille ( T valeur ) {
// if ( racine == null ) {
// return false ;
// }
// if ( racine.getValeur() == valeur ) {
// if ( racine.getArbreDroit() == null && racine.getArbreGauche() == null )
// {
// // la valeur est présente sur une feuill
// racine = null ;
// return true ;
// } else {
// // valeur présente mais pas sur une feuille
// return false ;
// }
// }
// return supprimeSiFeuille ( racine , valeur ) ;
// }

// private boolean supprimeSiFeuille ( Noeud<T> parent , T valeur ) {
// if ( valeur.compareTo(parent.getValeur()) <0 ) {
// if ( parent.getArbreGauche().getValeur() == valeur ) {
// if ( parent.getArbreGauche().getArbreGauche() == null &&
// parent.getArbreGauche().getArbreDroit() == null ) {
// // valeur sur une feuill
// parent.
// }
// }
// }
