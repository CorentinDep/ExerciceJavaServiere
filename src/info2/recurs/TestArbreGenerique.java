/*
 * Test des classes implémentant les arbres binaires
 * TestArbre.java											12/20
 */
package info2.recurs;
import java.util.Scanner;

/**
 * Test des méthodes des classes gérant les arbres binaires
 * @author INFO2
 */
public class TestArbreGenerique {


    private static Scanner entree = new Scanner(System.in);


    /**
     * Valeurs présentes dans l'arbre de l'énoncé
     */
    private static final int[] ARBRE_ENONCE = {47, 25, 77, 65, 93, 68,
            25, 11, 43, 7, 17, 31, 44};


    /**
     * Valeurs utilisées pour construire un 2ème arbre de test
     */
    private static final int[] ARBRE_DEUX = {59, 50, 30, 53,7, 38, 35, 33,
            37, 58, 77, 65, 63, 68, 95, 103};


    /**
     * Méthode qui construit et renvoie un arbre binaire.
     * Les valeurs de l'arbre sont celles du tableau argument
     * @param valeursAInserer  entiers à insérer dans l'arbre
     * @return l'arbre donné dans l'énoncé
     */
//    public static ArbreBinaire<Integer>  creerArbreTest(int[] valeursAInserer) {
//        ArbreBinaire<Integer> arbre = new ArbreBinaire<>();
//
//        for (int aInserer : valeursAInserer) {
//            arbre.inserer(aInserer);
//        }
//        return arbre;
//    }


    /**
     * Méthode de test pour tester conjointement estPresente et inserer
     */
    public static void testInsererEstPresente() {
        Noeud<Integer> noeud = new Noeud<>(47);
        noeud.inserer(25);
        noeud.inserer(77);
        noeud.inserer(11);

        // test de présence
        if (noeud.estPresente(47) && noeud.estPresente(25)
                && noeud.estPresente(77) && noeud.estPresente(11)) {
            System.out.println("Test presence ok");
        } else {
            System.out.println("Test presence NOK");
        }

        // test d'absence
        if (! noeud.estPresente(147) && ! noeud.estPresente(5)
                && ! noeud.estPresente(7) && ! noeud.estPresente(111)) {
            System.out.println("Test absence ok");
        } else {
            System.out.println("Test absence NOK");
        }
    }


    /**
     * Test avec un arbre construit (en partie) aléatoirement 
     * Test de inserer et estPresente
     */
//    public static void testArbreEntier() {
//        int valeur;
//        ArbreBinaire<Integer> arbre = new ArbreBinaire<>();
//        arbre.afficheCroissant();
//
//        arbre.inserer(39);
//        System.out.println("Les valeurs suivantes sont insérées :");
//        for (int i = 0; i < 10; i++) {
//            valeur = (int) (Math.random() * 100);
//            if (arbre.inserer(valeur)) {
//                System.out.print(valeur + "  ");
//            }
//        }
//        if (arbre.inserer(39)) {
//            System.out.println("probleme insertion ! ");
//        }
//
//        if (arbre.estPresente(39)) {
//            System.out.println("La valeur 39 est présente.");
//        }
//
//        if (!arbre.estPresente(-1)) {
//            System.out.println("La valeur -1 n'est pas présente.");
//        }
//        System.out.println("\nArbre obtenu = ");
//
//        arbre.afficheOrdreCroissant();
//        System.out.println("\n\n");
//
//        //arbre.afficheArbre();
//    }

    /**
     * Méthode de test pour tester estPresente (test incomplet)
     */
    public static void testEstPresente() {
        Noeud<Integer> noeud = new Noeud<>(47);


        // test de présence
        if (noeud.estPresente(47) ) {
            System.out.println("Test presence ok");
        } else {
            System.out.println("Test presence NOK");
        }

        // test d'absence
        if (! noeud.estPresente(147) && ! noeud.estPresente(5)
                && ! noeud.estPresente(7) && ! noeud.estPresente(111)) {
            System.out.println("Test absence ok");
        } else {
            System.out.println("Test absence NOK");
        }
    }
    /**
     * @param args argument non utilisé
     */
    public static void main(String[] args) {
        //testEstPresente();
        testInsererEstPresente();
    }



}