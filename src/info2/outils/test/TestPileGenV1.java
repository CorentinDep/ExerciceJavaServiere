package info2.outils.test;

import info2.outils.ErreurPile;
import info2.outils.PileGenerique;
import info2.population.Telephone;

public class TestPileGenV1 {

    public static void main(String[] args) throws ErreurPile.ErreurCapaciteInvalide, ErreurPile.ErreurPilePleine, ErreurPile.ErreurPileVide {

        /* Test avec le type String */
        PileGenerique<String> pileString = new PileGenerique<String>(10);

        pileString.empiler("Corentin");
        pileString.empiler("Lucas");
        pileString.empiler("Paul");

        System.out.println(pileString.toString());

        /* Test pour le type int */
        PileGenerique<Telephone> pileInt = new PileGenerique<Telephone>(2);

        pileInt.empiler(new Telephone("644554"));
        pileInt.empiler(new Telephone("644554"));

        System.out.println(pileInt.toString());

        /* Test pour le type double */
        PileGenerique<Double> pileDouble = new PileGenerique<Double>(10);

        pileDouble.empiler(15.5);
        pileDouble.empiler(75.65);
        pileDouble.empiler(751.3466);

        System.out.println(pileDouble.toString());



    }
}
