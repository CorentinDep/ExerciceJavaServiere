package info2.recurs;

public class Noeud <T extends Comparable<T>> {

    /* Valeur du Noeud */
    private T valeur;

    /* Référence vers le noeud racine vers le sous arbre gauche */
    private Noeud<T> refGauche;

    /* Référence vers le noeud racine vers le sous arbre droit */
    private Noeud<T> refDroit;

    /**
     * Initialise un noeud avec des valeurs des sous arbres non définis
     * @param valeur valeur du noeud
     */
    public Noeud(T valeur) {
        this.valeur = valeur;
        this.refDroit = null;
        this.refGauche = null;
    }

    /**
     * Méthode qui détermine si la valeur argument est présente dans l'arbre
     * @param valeur valeur a rechercher
     * @return false si n'existe pas et true si elle existe
     */
    public boolean estPresente(T valeur) {

        if (valeur.compareTo(this.valeur) == 0) {
            return true;
        }

        if (valeur.compareTo(this.valeur) > 0 && this.refDroit != null) {
            return this.refDroit.estPresente(valeur);
        }

        if (valeur.compareTo(this.valeur) < 0 && this.refGauche != null) {
            return this.refGauche.estPresente(valeur);
        }

        return false;
    }

    /**
     * Insère une valeur dans l'arbre
     * @param valeur valeur à insérer
     * @return true si ajouté et false sinon
     */
    public boolean inserer(T valeur) {

        if (valeur.compareTo(this.valeur) > 0 && this.refDroit == null) {
            this.refDroit = new Noeud<>(valeur);
            return true;
        }

        if (valeur.compareTo(this.valeur) > 0 && this.refDroit != null) {
            return this.refDroit.inserer(valeur);
        }

        if (valeur.compareTo(this.valeur) < 0 && this.refGauche == null) {
            this.refDroit = new Noeud<>(valeur);
            return true;
        }

        if (valeur.compareTo(this.valeur) < 0 && this.refGauche != null) {
            return this.refGauche.inserer(valeur);
        }

        return false;
    }

    /**
     * @return Renvoie la valeur du noeud courant
     */
    public T getValeur() {
        return valeur;
    }

    /**
     * @return Renvoie la valeur du noeud Gauche
     */
    public Noeud<T> getRefGauche() {
        return refGauche;
    }

    /**
     * @return Renvoie la valeur du noeud Droite
     */
    public Noeud<T> getRefDroit() {
        return refDroit;
    }

    public void afficher() {

        if (this.refGauche != null) {
            this.refGauche.afficher();
        }

        if (this.refDroit != null) {
            this.refDroit.afficher();
        }

        System.out.print(this.valeur);
    }

    public String prefixe() {

        if (this.refGauche != null) {
            return this.refGauche.prefixe();
        } else if (this.refDroit != null) {
            return  this.refDroit.prefixe();
        } else {
            return  this.valeur + "  ";
        }
    }

    public String infixe() {
        if (this.refGauche != null) {
            return
        }
    }


}
