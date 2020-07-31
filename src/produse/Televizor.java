package produse;

public class Televizor extends Produs {

    private double diagonalaEcran;
    private boolean esteSmart;

    public Televizor(double pret, int stocActual, String producator, double diagonalaEcran, boolean esteSmart) {
        super(pret, stocActual, producator);
        this.diagonalaEcran = diagonalaEcran;
        this.esteSmart = esteSmart;
    }

    public double getDiagonalaEcran() {
        return diagonalaEcran;
    }

    public boolean isEsteSmart() {
        return esteSmart;
    }

    @Override
    public String toString() {
        return "Televizor{" +
                "diagonalaEcran=" + diagonalaEcran +
                ", esteSmart=" + esteSmart +
                "} " + super.toString();
    }
}
