/*
 * Classe qui représente un libre auquel des mots-clés sont associés
 * LivreMotCle.java                                                 11/20
 */

package info2.livre;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.util.* ;

/**
 * Cette classe représente un livre décrit par un titre, un auteur, une année
 * de parution et une liste de mots-clés
 * @author INFO2
 * @version 1.0
 */
public class LivreMotCle extends Livre  {
 

    
    /**
     * Exception levée si problème d'accès au fichier lors de la 
     * sérialisation ou restauration d'une instance de type LivreMotCle
     */
    public static class EchecSerialisationRestauration extends Exception {
        
        /**
         * Constructeur avec en argument un message décrivant l'erreur
         * @param message  un texte expliquant la cause précise de l'erreur
         */
        public EchecSerialisationRestauration(String message) {
            super(message);
        }
    }
    
    /**
     * Liste des mots-clés associés au livre
     */
    private ArrayList<String> lesMotsCles ;


    /**
     * Constructeur par défaut : la liste des mots-clés est vide
     */
    public LivreMotCle() {
        lesMotsCles = new ArrayList<>() ;  
    }

    /**
     * Constructeur avec argument pour initialiser le titre, l'auteur et
     * l'année de parution du livre. La liste des mots-clés sera vide
     * @param leTitre   le titre du livre
     * @param lAuteur	l'auteur du livre
     * @param anneeParution l'année de parution du livre
     */
     public LivreMotCle(String leTitre, String lAuteur, int anneeParution) {
         super(leTitre, lAuteur, anneeParution);
         lesMotsCles = new ArrayList<>() ;
     }

     /**
      * Renvoie les mots-clés
      * @return une chaîne de caractères contenant les mot-clés
      */

    public String getMotsCles ( ) {
        // chaîne qui contiendra les mots-clés
        StringBuilder resultat = new StringBuilder() ;
        
        for(String mot : lesMotsCles) {
            resultat.append(mot).append("  | ");
        }
        
        // on renvoie la chaîne contenant les mots-clés
        return resultat.toString() ;
    }

    /**
     * Affiche toutes les informations connues sur le livre
     */
    public void afficher ( ) {
        System.out.println(super.toString() + "\n" + getMotsCles()) ;
    }

    /**
     * Détermine si le mot-clé argument fait partie de ceux du livre
     * (pas de distinction entre minuscule et majuscule)
     * @param mot  mot à rechercher dans la liste des mots-clés
     * @return un booléen égal à vrai ssi le mot-clé figure dans la liste
     */
    public boolean aLeMotCle(String mot) {
        int i;          // indice de parcours de la liste des mots-clés
        for(i = 0; i < lesMotsCles.size() 
                   && ! mot.equalsIgnoreCase(lesMotsCles.get(i)); i++);
        return i < lesMotsCles.size()  ;
    }

    /**
     * Ajoute le mot-clé argument s'il n'est pas déjà présent
     * @param mot	le mot-clé à ajouter
     * @return un booléen égal à vrai ssi le mot-clé a pu être ajouté
     */
     public boolean ajouteMotCle(String mot) {
        if (aLeMotCle(mot)) { // le mot-clé est déjà présent
            return false ;
        }
        
        // sinon on ajoute le mot-clé en fin de liste
        lesMotsCles.add(mot) ;
        return true ;	// ajout possible
     }

    /**
     * Cette méthode crée des objet de type Livre et LivreMotCle
     * @param nomDuFichier une chaine contenant le nom du fichier
     */
    public void serialiser(String nomDuFichier) throws EchecSerialisationRestauration {

        try {
            ObjectOutputStream fluxEcriture = new ObjectOutputStream(new FileOutputStream(nomDuFichier));

            fluxEcriture.writeObject(this);

            fluxEcriture.close();
        } catch (IOException e) {
            throw new EchecSerialisationRestauration("Problème d'accés au fichier " + nomDuFichier);
        }
    }

    public void restaurer(String nomDuFichier) throws EchecSerialisationRestauration {

        LivreMotCle tampon;
        String[] listeMotCleS;

        try {
            ObjectInputStream fluxLecture = new ObjectInputStream(new FileInputStream(nomDuFichier));


            tampon = (LivreMotCle) fluxLecture.readObject();

            this.recopier(tampon);


            listeMotCleS = tampon.getMotsCles().split("( {2})\\| ");

            for (String cle : listeMotCleS) {
                this.ajouteMotCle(cle);
            }


            fluxLecture.close();
        } catch (IOException e) {
            throw new EchecSerialisationRestauration("Problème d'accés au fichier : " + nomDuFichier);
        } catch (ClassNotFoundException e) {
            throw new EchecSerialisationRestauration("Problème lors de la lecture du fichier : " + nomDuFichier);
        }
    }
     
     
}
