package produse;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produs produs = (Produs) o;
        return Objects.equals(producator, produs.producator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producator);
    }
}
