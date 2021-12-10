
/*
 * Test des expressions régulières utilisées dans les méthodes permettant
 * de vérifier qu'un fichier Excel est bien dans le format attendu
 * (un fichier contenant une liste d'étudiants et des notes)
 * TestRegexFormatFichierExcel.java                                 10/17
 */
package info2.ExpressionReguliere;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Ce programme permet de tester 2 expressions régulières.
 * La première correspond à une chaîne de caractère contenant le nom et le prénom
 * d'une personne dans un format simplifié.
 * La deuxième corresond à une note comprise entre 0 et 20
 * @author INFO2
 * @version 1.0
 */
public class TestRegexFormatFichierExcel {


    /* Expression régulière qui correspond au contenu valide pour la première
     * colonne du fichier Excel, supposée contenir le nom et éventuellement prénom
     * d'une personne.
     * La colonne peut débuter par un ou plusieurs espaces (facultatif)
     * Ensuite on doit trouver une lettre majusucle
     * Puis ensuite, éventuellement, doivent se succéder des lettres (minuscules
     * ou majuscules, des traits d'union, des apostrophes. Ces caractères peuvent
     * être séparés par un ou plusieurs espaces.
     */
    private static final String REGEX_COLONNE_NOM = " *[A-Z][a-z]*(( *|-|')([A-z]?[a-z]*))*";


    /*
     * Expression régulière qui correspond à une note : entier compris entre 0 et 20
     */
    private static final String REGEX_COLONNE_NOTE = " *((1?[\\d])|20) *";

    /*
     * Expression régulière qui correspond à une ligne contenant le mot "Nom"
     * sous différente forme
     */
    private static final String REGEX_LIGNE_NOM = ".*([nN][Oo][Mm]).*";

    /* Regex REGEX_COLONNE_NOM :  Jeu de tests avec des chaînes correctes */
    private static final String[] CHAINE_CORRECTE_COLONNE_NOM =
            { " Dupont", " Dupont Jacques ", "  De    Saint-Andre  " , "Cyprien d'Arc",
                    " De la Motte Saint-Pierre Marie-Amelie ", "Arthemis Dupont-Durand                       ", "A"};

    /* Regex REGEX_COLONNE_NOM : Jeu de tests avec des chaînes incorrectes */
    private static final String[] CHAINE_INCORRECTE_COLONNE_NOM =
            { "  dupont", "      ", " Dupont3             ", "Dupont * ", " Dupont Jacques  789"};

    /* Regex REGEX_COLONNE_NOTE :  Jeu de tests avec des chaînes correctes */
    private static final String[] CHAINE_CORRECTE_COLONNE_NOTE =
            { "0", "20", "16", "   1     ", " 3", "4  ", "    16", "14  ", " 18  ", "0"};

    /* Regex REGEX_COLONNE_NOTE :  Jeu de tests avec des chaînes incorrectes */
    private static final String[] CHAINE_INCORRECTE_COLONNE_NOTE =
            { "", " ", "665", "   1  4     ", " 13   15", " 4  Z", "  A+ 10", "  A+  ",
                    "66", "09", "21", "26"};

    /* Regex REGEX_LIGNE_NOM : Jeu de tests avec des chaînes correctes */
    private static final String[] CHAINE_CORRECTE_LIGNE_NOM =
            {"NOms" ,"NomS" ,"Nom", "   Noms des eleves   ", " la liste des noms", "liste des nom des personnes", "liste des Noms    "};

    /* Regex REGEX_LIGNE_NOM : Jeu de tests avec des chaînes incorrectes */
    private static final String[] CHAINE_INCORRECTE_LIGNE_NOM =
            {"La liste", "    ", "", "La liste des ", " des personnes   ", "no"};

    /* Méthode de test d'une expression régulière
     * Les tests sont effectués avec des chaînes correctes et d'autres incorrectes.
     * Un rapport de test est affiché sur la console
     * @param message   message affiché avant les tests (il doit préciser quelle
     *                  expression régulière est testée)
     * @param regex     expression régulière à tester
     * @param donneeCorrecte   tableau contenant des chaînes supposées respecter le
     *                         format de la regex
     * @param donneeIncorrecte   tableau contenant des chaînes supposées ne pas respecter
     *                           le format de la regex
     */
    private static void testRegex(String message, String regex,
                                  String[] donneeCorrecte, String[] donneeIncorrecte) {
        int nbTestOk;       // nombre de tests corrects

        System.out.println("\n" + message +  " : \n");

        // on vérifie que les chaînes correctes sont bien évaluées à correct
        nbTestOk = 0;
        for (String value : donneeCorrecte) {
            if (!value.matches(regex)) {
                System.out.println("ERREUR : La chaîne " + value
                        + " a été évaluée comme incorrecte.");
            } else {
                nbTestOk++;
            }
        }

        // on affiche un résumé des tests
        System.out.print("Résumé des tests avec chaînes correctes => ");
        if (nbTestOk == donneeCorrecte.length) {
            System.out.println("Tous tests sont OK");
        } else {
            System.out.println("Seulement " + nbTestOk
                    + " sont corrects sur un total de "
                    + donneeCorrecte.length);
        }

        // on vérifie que les chaînes incorrectes sont bien évaluées à incorrect
        nbTestOk = 0;
        for (String s : donneeIncorrecte) {
            if (s.matches(regex)) {
                System.out.println("ERREUR : La chaîne " + s
                        + " a été évaluée comme correcte.");
            } else {
                nbTestOk++;
            }
        }

        // on affiche un résumé des tests
        System.out.print("Résumé des tests avec chaînes incorrectes => ");
        if (nbTestOk == donneeIncorrecte.length) {
            System.out.println("Tous tests sont OK");
        } else {
            System.out.println("Seulement " + nbTestOk
                    + " sont corrects sur un total de "
                    + donneeIncorrecte.length  );
        }
    }

    /**
     *
     */
    public static class ErreurFormatFichierExcel extends Exception {

        /**
         * @param message message d'erreur
         */
        public ErreurFormatFichierExcel(String message) {
            super(message);
        }
    }

    /**
     * Exception levée si le fichier ne contient pas les lignes d'entetes
     * attendues
     */
    public static class ErreurEnteteVide extends ErreurFormatFichierExcel {

        private static final String MESSAGE_ERREUR = "Le fichier Excel ne contient pas les " +
                "%d lignes d'en-tête attendues";
        /**
         * @param numLigne numéro de la ligne en erreur
         */
        public ErreurEnteteVide(int numLigne) {
            super(String.format(MESSAGE_ERREUR, numLigne));
        }
    }

    /**
     * Exception levée si la ligne de titre ne contient pas le mot "Nom"
     */
    public static class ErreurLigneTitre extends ErreurFormatFichierExcel {

        private static final String MESSAGE_ERREUR = "" +
                "La ligne de titre %d ne contient pas le mot \"Nom\"";
        /**
         * @param numLigne Numéro de la ligne de titre
         */
        public ErreurLigneTitre(int numLigne) {
            super(String.format(MESSAGE_ERREUR, numLigne));
        }
    }

    /**
     * Exception levée si la ligne contient moins de deux colonnes
     */
    public static class ErreurLigneMoinsDeuxColonnes extends ErreurFormatFichierExcel {

        private static final String MESSAGE_ERREUR = "La ligne significative " +
                "%d contient moins de deux colonnes";
        /**
         * @param numLigne numéro de la ligne d'erreur
         */
        public ErreurLigneMoinsDeuxColonnes(int numLigne) {
            super(String.format(MESSAGE_ERREUR, numLigne));
        }
    }

    /**
     * Exception levée si la première colonne ne contient pas de nom
     */
    public static class ErreurLigneSansNom extends ErreurFormatFichierExcel {

        private static final String MESSAGE_ERREUR = "La ligne significative " +
                "%d ne contient pas un nom en première colonne";
        /**
         * @param numLigne numéro de la ligne d'erreur
         */
        public ErreurLigneSansNom(int numLigne) {
            super(String.format(MESSAGE_ERREUR, numLigne));
        }
    }

    /**
     * Exception levée si la deuxième colonne ne contient pas de note
     */
    public static class ErreurLigneSansNote extends ErreurFormatFichierExcel {

        private static final String MESSAGE_ERREUR = "La ligne significative " +
                "%d ne contient pas une note en deuxième colonne";
        /**
         * @param numLigne numéro de la ligne d'erreur
         */
        public ErreurLigneSansNote(int numLigne) {
            super(String.format(MESSAGE_ERREUR, numLigne));
        }
    }
    /**
     *
     */
    public static int analyseCSV(String nomFichier, int numLigne) throws ErreurLigneMoinsDeuxColonnes, ErreurLigneSansNom, ErreurLigneSansNote, ErreurLigneTitre {

        /* Le séparateur dans le fichier csv */
        final String SEPARATEUR = ";";

        try {
            BufferedReader fichier = new BufferedReader(new FileReader(nomFichier));

            String ligne;
            String[] result;
            int conteur;
            int numLigneActuel;


            conteur = 0;
            for (int i = 0; i < numLigne - 1; i++) {
                fichier.readLine();
            }
            numLigneActuel = numLigne;

            if ((ligne = fichier.readLine()).matches(REGEX_LIGNE_NOM)) {

                while ((ligne = fichier.readLine()) != null) {

                    if (!ligne.equals(";")) {
                        Pattern chaine = Pattern.compile(SEPARATEUR);
                        if ((result = chaine.split(ligne)).length >= 2) {

                            if (result[0].matches(REGEX_COLONNE_NOM)) {
                                if (result[1].matches(REGEX_COLONNE_NOTE)) {
                                    conteur++;
                                } else {
                                    throw new ErreurLigneSansNote(numLigneActuel + 1);
                                }
                            } else {
                                throw new ErreurLigneSansNom(numLigneActuel + 1);
                            }

                        } else {
                            throw new ErreurLigneMoinsDeuxColonnes(numLigneActuel + 1);
                        }
                    }
                    numLigneActuel++;
                }
            } else {
                throw new ErreurLigneTitre(numLigne);
            }

            return conteur;

        } catch (IOException ez) {
            System.out.println("Erreur d'accès au fichier !");
        }

        return 0;
    }


    /**
     * Programme principal permettant de lancer les tests
     * @param args argument non utilisé
     */
    public static void main(String[] args) throws ErreurLigneSansNom, ErreurLigneMoinsDeuxColonnes, ErreurLigneSansNote, ErreurLigneTitre {
//        testRegex("Vérification regex  colonne contenant le nom", REGEX_COLONNE_NOM,
//                CHAINE_CORRECTE_COLONNE_NOM, CHAINE_INCORRECTE_COLONNE_NOM);
//        System.out.println();
//        testRegex("Vérification regex  colonne contenant la note", REGEX_COLONNE_NOTE,
//                CHAINE_CORRECTE_COLONNE_NOTE, CHAINE_INCORRECTE_COLONNE_NOTE);
//        System.out.println();
//        testRegex("Vérification regex  ligne contenant au minimum le mot nom ", REGEX_LIGNE_NOM,
//                CHAINE_CORRECTE_LIGNE_NOM, CHAINE_INCORRECTE_LIGNE_NOM);
        System.out.println(analyseCSV("test1.csv", 7));
        System.out.println(analyseCSV("test2.csv", 1));
        System.out.println(analyseCSV("test3.csv", 7));
        System.out.println(analyseCSV("test4.csv", 7));



    }
}