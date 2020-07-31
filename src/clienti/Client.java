package clienti;

import produse.Produs;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Client  {

    private String nume;
    private int anInregistrare;
    private Map<Produs,Integer> cosCumparaturiClient;




    public Client(String nume, int anInregistrare) {
        this.nume = nume;
        this.anInregistrare = anInregistrare;
        this.cosCumparaturiClient = new HashMap<>();
    }

    public void adaugaProdusInCos(Produs produs, int cantitate) {
        cosCumparaturiClient.put(produs,cantitate);
        produs.setStocActual(produs.getStocActual()-cantitate);
        this.afisareCos();

    }

   public void stergeProdusDinCos(Produs produsDeSters, int cantitateDeSters){
       cosCumparaturiClient.remove(produsDeSters, cantitateDeSters);

   }

   public void stergeTotCosul(){
        cosCumparaturiClient.clear();
       System.out.println("toate produsele au fost sterse");
   }

    public void afisareCos() {
        System.out.println("se afiseaza cosul clientului " + this.nume);
        Set<Map.Entry<Produs, Integer>> entries = cosCumparaturiClient.entrySet();
        double pretFinal=0;
        for(Map.Entry<Produs, Integer> pereche : entries){
            Produs p = pereche.getKey();
            Integer nrProdus = pereche.getValue();
            System.out.println("\t avem "+ nrProdus + " x "+p);
            if(this.anInregistrare<2018){
                pretFinal += p.getPret()*0.9*nrProdus;
                System.out.println("Cost total cu discount de vechime: "+ pretFinal);
            }else{
                pretFinal =+ p.getPret()*nrProdus;
                System.out.println("Cost total: "+ pretFinal);
            }

        }
    }


    public String getNume() {
        return nume;
    }



    public int getAnInregistrare() {
        return anInregistrare;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nume='" + nume + '\'' +
                ", anInregistrare=" + anInregistrare +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(nume, client.nume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume);
    }

    public void afisareTotalPlata() {
        if (this.anInregistrare < 2018) {

        }
    }
}
