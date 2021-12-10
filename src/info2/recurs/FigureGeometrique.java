package info2.recurs;

import java.util.Arrays;

public class FigureGeometrique {

    public static void etoile(int n) {
        if (n > 0) {
            System.out.println("*");
            etoile(n - 1);
        }
    }

    public static void blanc(int n) {
        if (n > 0) {
            System.out.println(' ');
            blanc(n - 1);
        }
    }

    public static void initialiserAvecValeur(int[] t, int valeur, int deb) {
        if (deb != t.length) {
            t[deb] = valeur;
            initialiserAvecValeur(t, valeur, deb + 1);
        }
    }

    public static boolean exist(int[] t, int valeur, int deb) {
        if (deb != t.length) {
            if (t[deb] == valeur) {
                return true;

            } else {
                return exist(t, valeur, deb +1);
            }

        }
        return false;
    }



    public static void main(String[] args) {
        int[] tab = {45, 12, 4, 5, 84, 56, 65, 75, 45};
        System.out.println(Arrays.toString(tab));
        System.out.println(exist(tab, 84, 0));
        initialiserAvecValeur(tab, 45, 0);
        System.out.println(Arrays.toString(tab));

    }
}
