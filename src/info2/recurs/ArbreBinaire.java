package info2.recurs;

public class ArbreBinaire {

    private Noeud noeudRacine;

    public ArbreBinaire() {
        this.noeudRacine = null;
    }

    public boolean estVide() {
        return this.noeudRacine == null;
    }
}
