/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.ebj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author student
 */
@Stateful
public class MedianCalculatorBean implements MedianCalculatorBeanRemote {
     
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private ArrayList<Integer> historiaWynikow;

    public MedianCalculatorBean() {
            historiaWynikow = new ArrayList<>();
    }

    public int obliczMediane(int[] values) {
         List<Integer> listaWartosci = new ArrayList<>();
        for (int value : values) {
            listaWartosci.add(value);
        }

        Collections.sort(listaWartosci);

        int mid = listaWartosci.size() / 2;
        if (listaWartosci.size() % 2 == 0) {
            return (listaWartosci.get(mid - 1) + listaWartosci.get(mid)) / 2;
        } else {
            return listaWartosci.get(mid);
        }
    }

    public void zapiszDoHistorii(int wynik) {
        historiaWynikow.add(wynik);
    }

   public ArrayList<Integer> pobierzHistorie() {
        return historiaWynikow;
    }
    
}
