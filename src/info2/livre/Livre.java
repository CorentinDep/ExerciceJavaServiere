/*
 * Classe qui représente un livre
 * Livre.java                                                  11/20
 */
package info2.livre;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Classe représentant un livre avec titre du livre, nom de son auteur,
 * et année de parution
 * @author INFO2
 * @version 1.0
 */
public class Livre implements Serializable {

    /**
     * Numéro de version pour la classe. C'est une clé de hachage
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constante pour la valeur par défaut des chaînes de caractères
     */
    private static final String CHAINE_DEFAUT = "Information inconnue";
    
    /**
     * Constante pour la valeur par défaut de l'année de parution
     */
    private static final int PARUTION_DEFAUT = 9999;

    
    /** Titre du livre */
    private String titre;
    
    /** Auteur du livre */
    private String auteur; 
    
    /** Année de parution du livre */
    private int parution; 

    
    /**
     * Constructeur par défaut
     */
    public Livre() {
        titre = auteur = CHAINE_DEFAUT;
        parution = PARUTION_DEFAUT;
    }

    /**
     * Constructeur avec argument pour initialiser les 3 attributs. Si un
     * argument est invalide, c'est la valeur par défaut qui est utilisée
     * @param leTitre       le titre du livre
     * @param lAuteur       l'auteur du livre
     * @param anneeParution l'année de parution du livre
     */
    public Livre(String leTitre, String lAuteur, int anneeParution) {
        titre = (leTitre == null || leTitre.length() == 0 ? CHAINE_DEFAUT
                                                          : leTitre);
        auteur = (lAuteur == null || lAuteur.length() == 0 ? CHAINE_DEFAUT
                                                           : lAuteur);
        parution = (anneeParution <= 0 ? PARUTION_DEFAUT : anneeParution);
    }

    /**
     * Accesseur sur le titre
     * @return une chaîne contenant le titre du livre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Accesseur sur l'auteur du livre
     * @return une chaîne contenant l'auteur
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * Accesseur sur l'année de parution
     * @return un entier contenant l'année de parution
     */
    public int getParution() {
        return parution;
    }

    /**
     * Modifie le titre du livre courant avec l'argument.
     * Si le nouveau titre est invalide, c'est le titre par défaut qui est
     * attribué
     * @param nouveauTitre   nouveau titre pour le livre
     */
    public void setTitre(String nouveauTitre) {
        titre = (nouveauTitre == null || nouveauTitre.length() == 0 ? CHAINE_DEFAUT
                : nouveauTitre);
    }
    
    /**
     * Modifie l'auteur du livre courant avec l'argument.
     * Si le nouvel auteur est invalide, c'est l'auteur par défaut qui est
     * attribué
     * @param nouvelAuteur   nouvel auteur pour le livre
     */
    public void setAuteur(String nouvelAuteur) {
        auteur = (nouvelAuteur == null || nouvelAuteur.length() == 0 ? CHAINE_DEFAUT
                : nouvelAuteur);
    }
    
    /**
     * Modifie l'année de parution du livre courant avec l'argument.
     * Si la nouvelle année de parution est invalide, 
     * c'est l'année par défaut qui est attribuée
     * @param nouvelleParution  nouvelle année de parution du livre
     */
    public void setParution(int nouvelleParution) {
        parution = (nouvelleParution <= 0 ? PARUTION_DEFAUT : nouvelleParution);
    }
    
    /**
     * Renvoie la description complète du livre
     * @return une chaîne contenant le titre, l'auteur et l'année de parution
     */
    public String toString() {
        return titre + " - " + auteur + "  (paru en" + parution + ")";
    }
    
  
    
    /**
     * Recopie les attributs du livre argument dans l'instance courante
     * @param aRecopier  livre à recopier dans l'instance courante
     */
    void recopier(Livre aRecopier) {
        this.setTitre(aRecopier.getTitre());
        this.setAuteur(aRecopier.getAuteur());
        this.setParution(aRecopier.getParution());
    }
    


}
