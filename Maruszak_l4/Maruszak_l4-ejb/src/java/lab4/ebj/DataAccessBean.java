/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.ebj;

import java.util.Date;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateful;

@Stateless
public class DataAccessBean implements DataAccessBeanRemote {

    private String OstatnieDane;
    private Date OstatniDostep;

    @Override
    public String getOstatnieDane() {
        return OstatniDostep + "\n" + OstatnieDane;
    }

    @Override
    public void setOstatnieDane(String dane, Date data) {
        OstatnieDane = dane;
        OstatniDostep = data;
    }
    
}
