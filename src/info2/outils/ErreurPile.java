/* ErreurPile.java                          10 oct 2021
 * Aucun droit d'auteur
 */
package info2.outils;

/**
 * Class de gestion des erreurs liées avec l'object Pile
 * @version 1
 * @author Corentin DEPRECQ
 */
public class ErreurPile {

    private static final String ERREUR_CAPACITE_INCORRECTE_TEXTE = "Impossible de créer une pile avec la capacité invalide ";

    /**
     * Exception levée si la capacité entrée par l'utilisateur est invalide
     */
    public static class ErreurCapaciteInvalide extends Exception {

        public ErreurCapaciteInvalide(int capaciteInvalide) {
            super(ERREUR_CAPACITE_INCORRECTE_TEXTE + capaciteInvalide + ".");
        }
    }

    /**
     * Exception levée si lorsque la pile est vide l'utilisateur essaye de
     * dépiler un entier
     */
    public static class ErreurPileVide extends Exception {

        public ErreurPileVide(String message) {
            super(message);
        }
    }

    /**
     * Exception levée si lorsque la pile est pleine l'utilisateur essaye de
     * piler un nouvelle entier
     */
    public static class ErreurPilePleine extends Exception {
        /* Corps vide pour le moment */
        public ErreurPilePleine(String message) {
            super(message);
        }
    }
}
