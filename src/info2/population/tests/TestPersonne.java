/* Classe de test de la classe Personne
 * Personne.java                                               09/09/14
 */
package info2.population.tests;

import info2.population.Individu;
import info2.population.Personne;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 *
 * @author INFO2
 * @version 1.0
 */

public class TestPersonne {

    /** Déclaration d'un objet Scanner pour effectuer les saisies */
    private static Scanner entree = new Scanner(System.in);

    private static final String[] EXEMPLE_MAIL_VALIDE = {
        "Julien.picard@iut-rodez.fr",
        "Corentin@deprecq.af",
        "ludovic.dupond@acd.com",
        "azerty.mpof@a.eu",
        "a@a.aa",
        "_@_.fr"
    };

    private static final String[] EXEMPLE_MAIL_INVALIDE = {
        "iut@rodez.france",
        " @deprecq.af",
        "aze@ezde@iu.comsfz",
        "azerty.mpofa.eu",
        "a@a.a"
    };

    public static void testMailValide() {

        /* Test des mail valide */
        System.out.println("Test des mails valide \n");
        for (String s : EXEMPLE_MAIL_VALIDE) {

            try {
                new Personne("test", "test", "0603236468", s);
                System.out.println("Test OK");
                /* Test OK */
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur de test !");
            }

        }

        /* Test des mail invalide */
        System.out.println("Test des mails invalide \n");

        for (String s : EXEMPLE_MAIL_INVALIDE) {

            try {
                new Personne("test", "test", "0603236468", s);
                System.out.println("Erreur de test !");
            } catch (IllegalArgumentException e) {
                System.out.println("Test Ok");
                /* Test OK */
            }

        }
    }

    private static int saisieEntier() {

        int nb;
        boolean saisieOk;

        do {
            System.out.print("Saisir 1 pour créer une un Individu et 2 pour" +
                    " créer une Personne : ");
            nb = entree.hasNextInt() ? entree.nextInt() : -1;

            saisieOk = (nb == 1) || (nb == 2);
            if (!saisieOk) {
                System.out.println("Saisir un nombre ");
            }
            entree.nextLine();

        } while (!saisieOk);

        return nb;
    }

    /**
     * Saisie des informations de la personne en regardant si la personne
     * n'existe pas déjà
     * @param liste liste polymorphisme d'individu et de personne
     * @param i paramètre de la boucle
     */
    private static void saisir(Individu[] liste, int i) {

        boolean testDePersonne; // Test de si une personne existe deja

        testDePersonne = true;


        do {
            liste[i].saisir();
            for (int j = 0; j < i; j++) {
                testDePersonne = !liste[i].getNom().equals(liste[j].getNom())
                        || !liste[i].getPrenom().equals(liste[j].getPrenom());
            }
        } while (!testDePersonne);
    }


    /**
     * Lancement des tests
     * @param args non utilisés
     */
    public static void main(String[] args) {

        /* Tableau de polymorphisme avec des individus et des Personnes */
        Individu[] liste = new Individu[5];

        int test; // Variable pour tester la saisie de l'utilisateur


        for (int i = 0; i < liste.length; i++) {

            /* Saisie du choix entre créer un Individu ou une Personne */
            test = saisieEntier();

            /* Création d'un Individu ou une personne */
            if (test == 1) {
                liste[i] = new Individu(); // Créer un Individu

            } else if (test == 2) {
                liste[i] = new Personne(); // Créer une Personne
            }

            /* Saisie des informations de l'individu ou de la personne crée */
            saisir(liste, i);
        }

        /* Affichage du tableau polymorphisme crée */
        System.out.println(Arrays.toString(liste));

        /* Différentes création et affichage d'une personne */

        /* Personne initialisé avec les valeurs par défaut  */
        Personne eleve1 = new Personne();
        System.out.println("Personne initialisé avec les valeurs par défaut : \n"
                           + eleve1.information());

        /* Personne initialisé avec le prénom et le nom */
        Personne eleve2 = new Personne("Laderoute", "Florence ");
        System.out.println("\nPersonne initialisé avec le nom et le prénom : ");
        eleve2.afficher();

        /* Personne initialisé avec tout les arguments */
        Personne eleve3 = new Personne("Picard", "Julien", "0625458532", "julien.picard@iut-rodez.fr");
        System.out.println("\nPersonne initialisé avec tout les attributs : \n"
               + eleve3.information());

        /* Saisie et affichage des informations pour le premier élève */
        eleve1.saisir();
        System.out.println("L'élève 1 est maintenant \n" + eleve1.information());

        /* Lancement des méthodes de tests */
        System.out.println("\nTest de la méthode mailValide : \n");
        testMailValide();

    }



}
