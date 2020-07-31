package produse;

public class Produs {

    private double pret;
    private int stocActual;
    private String producator;

    public Produs(double pret, int stocActual, String producator) {
        this.pret = pret;
        this.stocActual = stocActual;
        this.producator = producator;
    }

    public double getPret() {
        return pret;
    }

    public int getStocActual() {
        return stocActual;
    }

    public String getProducator() {
        return producator;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public void setStocActual(int stocActual) {
        this.stocActual = stocActual;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "pret=" + pret +
                ", stocActual=" + stocActual +
                ", producator='" + producator + '\'' +
                '}';
    }


}
