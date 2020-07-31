import clienti.Client;
import clienti.ClientInexistentException;
import produse.Laptop;
import produse.Produs;
import produse.Telefon;
import produse.Televizor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Magazin {

    private List<Client> listaClientiMagazin;
    private List<Produs> produseInStoc;
    private static Magazin instantaMagazin;
    private Map<List<Client>, List<Produs>> produseByClient;


    private Magazin() {
        this.listaClientiMagazin = new ArrayList<>();
        this.produseInStoc = new ArrayList<>();
        this.produseByClient = new HashMap<>();
    }

    public static Magazin getInstance() {
        if (instantaMagazin == null) {
            instantaMagazin = new Magazin();
        }
        return instantaMagazin;
    }



    public Client intoarceClientdupaNume(String nume) {
        for (Client client : listaClientiMagazin) {
            if (client.getNume().equals(nume)) {
                return client;
            }
        }
        return null;
    }



    public void afisareClienti() {
        if (listaClientiMagazin.isEmpty()) {
            System.out.println("Lista de clienti este goala");
        }
        listaClientiMagazin.sort((c1, c2) -> c1.getNume().compareTo(c2.getNume()));
        for (Client client : listaClientiMagazin) {
            System.out.println(client);
        }
    }

    public void afisareCompleta() {
        if (listaClientiMagazin.isEmpty()) {
            System.out.println("Lista de clienti este goala");
        }
        listaClientiMagazin.sort((c1, c2) -> c1.getNume().compareTo(c2.getNume()));
        for (Client client : listaClientiMagazin) {
            System.out.println(client.getNume()+"inregistrat in anul "+client.getAnInregistrare()+"cu produsele:");
            client.afisareCos();
        }
    }


    public void adaugaClient(String nume, int anInregistrare) {
        Client client = new Client(nume, anInregistrare);
        for (Client clientDeIterat : listaClientiMagazin) {
            if (clientDeIterat.getNume().equals(client.getNume())) {
                System.out.println("clientul deja exista");
            }
        }
        if (!listaClientiMagazin.contains(client)) {
            listaClientiMagazin.add(client);
            System.out.println("clientul a fost adaugat");
        }
    }

    public void verificareClient(String numeClient) throws ClientInexistentException {
        if (!listaClientiMagazin.contains(new Client(numeClient, 0))) {
            throw new ClientInexistentException("client inexistent");
        }

    }

    public void adaugaProdusInStoculMagazinului(Produs produs) {
        produseInStoc.add(produs);
    }


    public Produs intoarceProdusDupaTipSiProducator(String tip, String producator) {
        Produs produss = null;
        switch (tip) {
            case "laptop":
                 produss = produseInStoc.stream()
                        .filter(p -> p instanceof Laptop && p.getProducator().equals(producator))
                        .findFirst().orElse(null);
                 break;
            case "televizor":
                produss = produseInStoc.stream()
                        .filter(p -> p instanceof Televizor && p.getProducator().equals(producator))
                        .findFirst().orElse(null);
                break;
            case "telefon":
                produss = produseInStoc.stream()
                        .filter(p -> p instanceof Telefon && p.getProducator().equals(producator))
                        .findFirst().orElse(null);
                break;
        }
        return produss;
    }

    public void afisareProduseInStoc(){
        for(Produs produs : produseInStoc){
            System.out.println(produs.getProducator() + " stoc: "+produs.getStocActual());
        }
    }


}
