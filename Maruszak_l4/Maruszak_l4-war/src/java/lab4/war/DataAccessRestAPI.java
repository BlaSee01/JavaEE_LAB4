/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.war;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import lab4.ebj.DataAccessBean;
import lab4.ebj.MedianCalculatorBeanRemote;

/**
 * REST Web Service
 *
 * @author student
 */
@Path("{data}")
public class DataAccessRestAPI {

    @EJB(beanName = "DataAccessBean")
    DataAccessBean bean;

    @EJB(beanName = "MedianCalculatorBean")
    MedianCalculatorBeanRemote medianCalculator;
    @Context
    private UriInfo context;

    public DataAccessRestAPI() {
    }

    @POST
    @Path("/oblicz")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String Oblicz(@FormParam("value1") int value1,
                         @FormParam("value2") int value2,
                         @FormParam("value3") int value3,
                         @FormParam("value4") int value4,
                         @FormParam("value5") int value5) {

        
        if (!czyWszystkieLiczbyCalkowite(value1, value2, value3, value4, value5)) {
            return "Błąd: Wprowadź poprawne wartości całkowite.";
        }

        int[] values = {value1, value2, value3, value4, value5};
        int median = medianCalculator.obliczMediane(values);    // użycie funkcji do oblcizenai mediany

        medianCalculator.zapiszDoHistorii(median);

        return "Mediana: " + median;    // print 1
    }

    @GET
    @Path("/historia")
    @Produces(MediaType.TEXT_PLAIN)
    public String Historia() {
        ArrayList<Integer> historia = medianCalculator.pobierzHistorie();

        if (historia.isEmpty()) {
            return "Brak historii obliczeń.";
        }

        String historiaString = "Historia obliczeń:\n";
        for (int wynik : historia) {
            historiaString += wynik + '\n';
        }
        return historiaString;
    }

    private boolean czyWszystkieLiczbyCalkowite(int value1, int value2, int value3, int value4, int value5) {
        
        int[] values = {value1, value2, value3, value4, value5};
        for (int i = 0; i < values.length; i++) {
            if (values[i] != (int) values[i]) {
                return false; 
            }
        }
        return true;
    }
}
