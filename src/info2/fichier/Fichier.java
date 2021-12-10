/* Fichier.java                         08-10-2021
 * aucun droit d'auteur
 */
package info2.fichier;

import java.io.*;

/**
 *
 */
public class Fichier {

    public static void lectureFichier(String nomFichier) {

        String ligne;
        int compteur;

        compteur = 0;

        try {

            BufferedReader fichier = new BufferedReader(new FileReader(nomFichier));

            do {
                compteur++;
                ligne = fichier.readLine();
                if (ligne != null) {
                    System.out.println(compteur + " - " + ligne);
                }
            } while (ligne != null);

            fichier.close();

        } catch (IOException ex) {
            System.out.println("Problèmes d'accés au fichier !");
        }
    }

    public static void copieFichier(String fichierCopie, String fichierDestination) {

        String ligne;

        try {

            BufferedReader fichier = new BufferedReader(new FileReader(fichierCopie));

            try {

                PrintWriter fichierEcrit = new PrintWriter(new FileWriter(fichierDestination));

                while ((ligne = fichier.readLine()) != null) {

                    if (!ligne.equals("")) {
                        fichierEcrit.println(ligne);
                    }

                }

                fichier.close();
                fichierEcrit.close();

            } catch (IOException ez) {
                System.out.println("Problème d'accés au fichier !");
            }

        } catch (IOException az) {
            System.out.println("Problème d'accés au fichier !");
        }

    }

    public static boolean testLexixo(String nomFichier) {

        String ligne;
        String ligneStock;

        try {
            BufferedReader fichier = new BufferedReader(new FileReader(nomFichier));

            ligneStock = fichier.readLine();

            while ((ligne = fichier.readLine()) != null) {



                if (ligneStock.compareTo(ligne) >= 0) {
                    fichier.close();
                    return false;
                }

                ligneStock = ligne;
            }

            fichier.close();

        } catch (IOException ez) {
            System.out.println("Probème d'acces au fichier !");
        }

        return true;
    }

    public static void concat(String nomFichier1, String nomFichier2, String nomFichierResult) {

        String ligneStock1;
        String ligneStock2;


        try {
            BufferedReader fichier1 = new BufferedReader(new FileReader(nomFichier1));

            try {
                BufferedReader fichier2 = new BufferedReader(new FileReader(nomFichier2));

                try {

                    PrintWriter fichierScript = new PrintWriter(new FileWriter(nomFichierResult));

                    ligneStock1 = fichier1.readLine();
                    ligneStock2 = fichier2.readLine();

                    while (ligneStock1 != null && ligneStock2 != null) {
                        if (ligneStock1.compareTo(ligneStock2) <= 0) {
                            fichierScript.println(ligneStock1);
                            ligneStock1 = fichier1.readLine();
                        } else {
                            fichierScript.println(ligneStock2);
                            ligneStock2 = fichier2.readLine();
                        }
                    }

                    if (ligneStock1 != null) {
                        fichierScript.println(ligneStock1);
                    }
                    if (ligneStock2 != null) {
                        fichierScript.println(ligneStock2);
                    }
                    fichier1.close();
                    fichier2.close();
                    fichierScript.close();

                } catch (IOException ez) {
                    System.out.println("Problème d'accés au fichier !");
                }
            } catch (IOException ez) {
                System.out.println("Problème d'accés au fichier !");
            }
        } catch (IOException ez) {
            System.out.println("Problème d'accés au fichier !");
        }

    }


    public static void main(String[] args) {
        //lectureFichier("testFichier.txt");
        //copieFichier("testFichier.txt", "fichierDest.txt");
        //System.out.println(testLexixo("fichierDest.txt"));
        concat("nom.txt", "nom2.txt", "fichierDest.txt");
    }
}
