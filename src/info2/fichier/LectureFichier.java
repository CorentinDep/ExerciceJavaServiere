package info2.fichier;

import java.io.*;
import java.util.SimpleTimeZone;
import info2.population.*;

public class LectureFichier {
    /**
     * Exercice 1
     */
    public static void afficheNumLigne(String fichier) {

        String ligne;
        int i;

        try {
            BufferedReader file = new BufferedReader(new FileReader(fichier));
            i = 1;
            while ((ligne = file.readLine()) != null) {
                System.out.println(i + " - " + ligne);
                i++;
            }

            file.close();

        } catch (IOException e) {
            System.out.println("Problème d'accés au fichier !");
        }
    }

    public static void copieFichier(String source, String desti) {

        String ligneLue;

        try {
            BufferedReader fichierSource = new BufferedReader(new FileReader(source));
            PrintWriter fichierdesti = new PrintWriter(new FileWriter(desti));

            while ((ligneLue = fichierSource.readLine()) != null) {
                if(ligneLue.length() != 0) {
                    fichierdesti.println(ligneLue);
                }

            }

            fichierSource.close();
            fichierdesti.close();
        } catch (IOException e) {
            System.out.println("probleme d'acces au fichier lolilol ");
        }

    }

    public static boolean estTrieLexico(String fichier) {

        String ligneStock;
        String ligne;
        boolean ok;

        ok = true;
        try {
            BufferedReader fichierLu = new BufferedReader(new FileReader(fichier));

           if ((ligneStock = fichierLu.readLine()) == null) {
               return false;
           }
//            do {
//
//                ligneStock = fichierLu.readLine();
//            } while ( ligneStock.length() == 0);

            while ((ligne = fichierLu.readLine()) != null) {
                if (ligneStock.compareTo(ligne) > 0) {
                    ok = false;
                    break;
                }
                ligneStock = ligne;
            }

        } catch (IOException e) {
            System.out.println("Probleme d'acces au fichier");
        }

        return ok;
    }


    public static void newDico(String source1, String source2, String destination) {

        String ligne1;
        String ligne2;
        try {
            BufferedReader fichS1 = new BufferedReader(new FileReader(source1));
            BufferedReader FichS2 = new BufferedReader(new FileReader(source2));

            PrintWriter destinatio = new PrintWriter(new FileWriter(destination));


            ligne1 = fichS1.readLine();
            ligne2 = FichS2.readLine();


            while (ligne1 != null && ligne2 != null) {


                if (ligne1.compareTo(ligne2) < 0) {
                   destinatio.println(ligne1);
                   ligne1 = fichS1.readLine();
                } else {
                    destinatio.println(ligne2);
                    ligne2 = FichS2.readLine();
                }

            }

            if (ligne2 != null) {
                while (ligne2 != null) {
                    while (ligne2.length() == 0) {
                        ligne2 = FichS2.readLine();
                    }
                    destinatio.println(ligne2);
                    ligne2 = FichS2.readLine();
                }
            }

            if (ligne1 != null) {
                while (ligne1 != null) {
                    while (ligne1.length() == 0) {
                        ligne1 = fichS1.readLine();
                    }
                    destinatio.println(ligne1);
                    ligne1 = fichS1.readLine();
                }
            }

            destinatio.close();
            fichS1.close();
            FichS2.close();

        } catch (IOException e) {
            System.out.println("probleme de lecture de fichier");
        }

    }

    /**
     * Numéro de version de la classe
     */
    private static final long serialVersionIUD = 1L;

    public static void serialisation(String nomFichier) throws IOException {

        Personne[] jeuxDeCarte = {
                new Personne("Jean", "Al"),
                new Personne("Jean", "Bon"),
                new Personne("yhk", "jjskdlf"),
                new Personne("skdj", "nice"),
                new Personne("Corentin", "DEPRECQ"),
                new Personne("Albert", "DuCon")
        };

        try {
            ObjectOutputStream fichier = new ObjectOutputStream(new FileOutputStream(nomFichier));

            for (Personne personne : jeuxDeCarte) {
                fichier.writeObject(personne);
            }

            fichier.close();

        } catch(FileNotFoundException ex) {
            System.out.println("Problème avec l'ouverture du fichier");
        } catch (IOException e) {
            System.out.println("Probleme d'acces fichier");
        }
    }

    public static void deserialisation(String nomFichier) {

        Personne[] table = new Personne[6];

        try {
            ObjectInputStream fichier = new ObjectInputStream(new FileInputStream(nomFichier));

            for (int i = 0; i < table.length; i++) {
                table[i] = (Personne) fichier.readObject();
            }

            for (Personne personne : table) {
                System.out.println(personne);
            }

            fichier.close();
        } catch (IOException ex) {
            System.out.println("Erreru acces fichier");
        } catch (ClassNotFoundException ex) {
            System.out.println("Probleme de lecture du fichier !");
        }
    }

    public static void main(String[] args) throws IOException {
        //afficheNumLigne("nom.txt");
        //copieFichier("nom.txt", "nom2.txt");
        //System.out.println(estTrieLexico("nom.txt"));
        //newDico("nom.txt", "nom2.txt", "fichierDest.txt");
        serialisation("fichierlivre.bin");
        deserialisation("fichierlivre.bin");
    }
}






























