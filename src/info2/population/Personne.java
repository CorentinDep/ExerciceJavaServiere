/*
 * Classe qui représente une personne.
 * Personne.java                                                        09/09/21
 */

package info2.population;
import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.*;

/**
 * Classe décrivant une personne avec comme caractéristiques : 
 *    un nom et un prénom hérités de la classe Individu 
 *    un numéro de téléphone 
 *    une adresse électronique
 *
 * @author Corentin DEPRECQ
 * @version 2.0
 */
public class Personne extends Individu implements Serializable {


    /** Déclaration d'un objet Scanner pour effectuer les saisies */
    private static Scanner entree = new Scanner(System.in);


    /** constante pour l'adresse électronique par défaut  */
    private static final String MAIL_DEFAUT = "inconnu@inconnu";



    /** Attribut adresse électronique */
    private String email;

    /** Attribut numéro de téléphone */
    private Telephone tel;


    /**
     * Constructeur qui initialise tous les attributs avec des valeurs par
     * défaut
     */
    public Personne() {
        super();
        this.tel = new Telephone();
        this.email = MAIL_DEFAUT;
    }

    /**
     * Constructeur avec en paramètre le nom et le prénom. Le téléphone et
     * l'adresse mail sont initialisés par défaut
     * @param leNom le nom de la personne
     * @param lePrenom le prénom de la personne
     */
    public Personne(String leNom, String lePrenom) {
        super(leNom, lePrenom);         // appel au constructeur de Individu
        tel = new Telephone();          // création du numéro de téléphone
        // (initialisé avec la valeur par défaut)
        email = MAIL_DEFAUT;            // affectation du mail par défaut
    }

    /**
     * Constructeur avec tout les attribus en paramètre
     * @param leNom le nom de la personne
     * @param lePrenom le prénom de la personne
     * @param tel le numéro de la personne
     * @param addresse l'adresse électronique de la personne
     */
    public Personne(String leNom, String lePrenom, String tel, String addresse) {

        super(leNom, lePrenom);
        this.tel = new Telephone(tel);

        /* test de l'adresse mail */
        if (!mailValide(addresse)) {
            throw new IllegalArgumentException("Addresse mail incorrecte !");
        }
        this.email = addresse;
    }

    /**
     * affiche les informations connues sur une personne
     */
    public void afficher() {
        System.out.println(super.toString() + "\n"
                           + this.tel.getNumero() + "\n" + this.email);
    }



    /**
     * Effectue la saisie des caractéristiques de la personne.
     * La saisie du numéro de téléphone et de l'adresse électronique 
     * est recommencée en cas d'erreur
     */
    @Override
    public void saisir() {
        super.saisir();         // saisie du nom et du prénom

        // saisie de l'adresse mail
        do {            // on recommence la saisie si erreur
            System.out.print("email ............: ");
            email = entree.nextLine();
        } while (!mailValide(email));

        tel.saisir(); // saisie du numéro de téléphone
    }
   
   
   
   
    /* La méthode de vérification du mail n'est pas obligatoire pour le travail
	   à rendre pour la semaine prochaine. Elle sera à coder pour la semaine suivante.
	   Vous pouvez éventuellement vous avancer */


    /**
     * Détermine si la chaîne argument contient une adresse mail valide : 
     *   des lettres, des chiffres, l'un des caractères '-' '_' '.' 
     *   le symbole '@' 
     *   des lettres, des chiffres, l'un des caractères '-' '_' 
     *   un point '.' 
     *   puis 2 ou 3 lettres
     * @param chaine à tester
     * @return vrai ssi la chaîne contient une adresse valide
     */
    private static boolean mailValide(String chaine) {

        Pattern mail = Pattern.compile("[a-z0-9A-Z_.-]+@[a-z0-9A-Z-_]+.[a-z]{2,3}");
        Matcher p = mail.matcher(chaine);

        return p.matches();
    }

    /**
     * Renverra sous la forme d'une chaîne de caractères toutes les
     * informations connues sur la personne, présentées de la manière suivante
     * (les retours à la ligne seront respectés) :
     *  Nom Prénom
     *  numéro de téléphone
     *  adresse électronique
     * @return chaine de caractère
     */
    public String information() {
        return super.toString() + "\n" + this.tel.getNumero() + "\n" + this.email;
    }



}


