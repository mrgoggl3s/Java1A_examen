package produse;

public class Laptop extends Produs {

   private int nrProcesoare;
   private   boolean areTouchScreen;

    public Laptop(double pret, int stocActual, String producator, int nrProcesoare, boolean areTouchScreen) {
        super(pret, stocActual, producator);
        this.nrProcesoare = nrProcesoare;
        this.areTouchScreen = areTouchScreen;
    }

    public int getNrProcesoare() {
        return nrProcesoare;
    }

    public void setNrProcesoare(int nrProcesoare) {
        this.nrProcesoare = nrProcesoare;
    }

    public boolean isAreTouchScreen() {
        return areTouchScreen;
    }

    public void setAreTouchScreen(boolean areTouchScreen) {
        this.areTouchScreen = areTouchScreen;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "nrProcesoare=" + nrProcesoare +
                ", areTouchScreen=" + areTouchScreen +
                "} " + super.toString();
    }




}
