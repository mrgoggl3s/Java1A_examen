package produse;

import java.util.HashMap;
import java.util.Map;

public class StocMagazin {

    private Map<Produs, Integer> stockByProdus = new HashMap<>();

    public void adaugaProdusInStoc(Produs produs) {
        Integer stoc = stockByProdus.get(produs);
        if (stoc == null) {
            stockByProdus.put(produs, 1);
        }else{
            stockByProdus.put(produs, ++stoc);
        }

    }

}
