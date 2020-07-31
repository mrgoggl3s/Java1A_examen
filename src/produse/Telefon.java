package produse;

public class Telefon extends Produs {

   private int dimensiuneBaterie;
   private double megaPixeliCamera;

    public Telefon(double pret, int stocActual, String producator, int dimensiuneBaterie, double megaPixeliCamera) {
        super(pret, stocActual, producator);
        this.dimensiuneBaterie = dimensiuneBaterie;
        this.megaPixeliCamera = megaPixeliCamera;
    }

    public int getDimensiuneBaterie() {
        return dimensiuneBaterie;
    }

    public double getMegaPixeliCamera() {
        return megaPixeliCamera;
    }

    @Override
    public String toString() {
        return "Telefon{" +
                "dimensiuneBaterie=" + dimensiuneBaterie +
                ", megaPixeliCamera=" + megaPixeliCamera +
                "} " + super.toString();
    }
}
