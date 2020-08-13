import clienti.Client;
import clienti.ClientInexistentException;
import produse.Laptop;
import produse.Produs;
import produse.Telefon;
import produse.Televizor;

import java.util.Scanner;
    public class Application_var02 {
        private static Scanner scanner;

        public static void main(String[] args) {

            Laptop laptopApple = new Laptop(1000, 5, "apple", 4, false);
            Laptop laptopSamsung = new Laptop(1200, 10, "samsung", 8, true);
            Telefon telefonHuawei = new Telefon(350, 15, "huawei", 1800, 12);
            Televizor tvSony = new Televizor(750, 4, "sony", 108, true);


            Magazin.getInstance().adaugaProdusInStoculMagazinului(laptopApple);
            Magazin.getInstance().adaugaProdusInStoculMagazinului(laptopSamsung);
            Magazin.getInstance().adaugaProdusInStoculMagazinului(telefonHuawei);
            Magazin.getInstance().adaugaProdusInStoculMagazinului(tvSony);
            Magazin.getInstance().afisareProduseInStoc();


            scanner = new Scanner(System.in);
            String comanda = scanner.next();
            while ( comanda.equalsIgnoreCase("start") == false ) {
                System.out.println(" Te rog introdu comanda start");
                comanda = scanner.next();
            }
            System.out.println("Introdu o comanda:\n" +
                    "ADAUGA_CLIENT, \n" +
                    "STERGE_PRODUS,\n" +
                    "STERGE_TOATE_PRODUSELE,\n" +
                    "AFISARE_CLIENTI,\n" +
                    "AFISARE_COS,\n" +
                    "AFISARE_COMPLETA.\n");
            comanda = scanner.next();

            while ( comanda.equalsIgnoreCase("exit") == false ) {

                switch (comanda) {
                    case "adauga_client":
                        System.out.println("introdu numele tau/clientului");
                        String nume = scanner.next();
                        System.out.println("introdu an inregistrare tau/clientului");
                        int anInregistrare = scanner.nextInt();
                        Magazin.getInstance().adaugaClient(nume, anInregistrare);
                        break;
                    case "adauga_produs":
                        System.out.println("Introdu numele clientului:");
                        String numeClient = scanner.next();
                        try{
                            Magazin.getInstance().verificareClient(numeClient);
                        }catch (ClientInexistentException e){
                            System.out.println("INTRODU CORECT NUMELE CLIENTULUI");
                        }
                        Client client1 = Magazin.getInstance().intoarceClientdupaNume(numeClient);
                        System.out.println("Introdu tipul produsului dorit");
                        String tip = scanner.next();
                        System.out.println("Alege producatorul produsului");
                        String producator = scanner.next();
                        Produs produs = Magazin.getInstance().intoarceProdusDupaTipSiProducator(tip, producator);
                        System.out.println("ce cantitate doresti?");
                        Integer cantitate =  scanner.nextInt();
                        client1.adaugaProdusInCos(produs,cantitate);
                        Magazin.getInstance().afisareProduseInStoc();
                        break;
                    case "sterge_produs":
                        System.out.println("Introdu numele clientului:");
                        String clientNume = scanner.next();
                        try{
                            Magazin.getInstance().verificareClient(clientNume);
                        }catch (ClientInexistentException e){
                            System.out.println("INTRODU CORECT NUMELE CLIENTULUI");
                        }
                        Client client2 = Magazin.getInstance().intoarceClientdupaNume(clientNume);
                        client2.afisareCos();

                        System.out.println("Introdu tipul produsului pe care doresti sa il stergi");
                        String tipSters = scanner.next();
                        System.out.println("Alege producatorul produsului pe care doresti sa il stergi");
                        String producatorSters = scanner.next();
                        Produs produsDeSters = Magazin.getInstance().intoarceProdusDupaTipSiProducator(tipSters, producatorSters);
                        System.out.println("ce cantitate doresti sa stergi?");
                        Integer cantitateDeSters = scanner.nextInt();
                        client2.stergeProdusDinCos(produsDeSters, cantitateDeSters);
                        produsDeSters.setStocActual(produsDeSters.getStocActual()+ cantitateDeSters);
                        Magazin.getInstance().afisareProduseInStoc();
                        break;
                    case "sterge_toate_produsele":
                        System.out.println("Introdu numele clientului:");
                        String clientNumeStergeTot = scanner.next();
                        try{
                            Magazin.getInstance().verificareClient(clientNumeStergeTot);
                        }catch (ClientInexistentException e){
                            System.out.println("INTRODU CORECT NUMELE CLIENTULUI");
                        }
                        Client client3 = Magazin.getInstance().intoarceClientdupaNume(clientNumeStergeTot);
                        client3.afisareCos();

                        client3.stergeTotCosul();
                        break;
                    case "afisare_clienti":
                        Magazin.getInstance().afisareClienti();
                        break;
                    case "afisare_cos":
                        System.out.println("introdu numele clientului");
                        String numeClientCos = scanner.next();
                        Client client = Magazin.getInstance().intoarceClientdupaNume(numeClientCos);
                        client.afisareCos();

                        break;
                    case "afisare_completa":
                        Magazin.getInstance().afisareCompleta();
                        break;
                    default:
                        System.out.println("Alege una din variantele de mai sus");
                        break;
                }
                comanda = scanner.next();
            }
            System.out.println("aplicatia s-a oprit");
        }
    }





