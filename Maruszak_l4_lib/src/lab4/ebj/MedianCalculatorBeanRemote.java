/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.ebj;

import java.awt.List;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author student
 */
@Remote
public interface MedianCalculatorBeanRemote {

    int obliczMediane(int[] values);

    void zapiszDoHistorii(int wynik);

     ArrayList<Integer> pobierzHistorie();

}
