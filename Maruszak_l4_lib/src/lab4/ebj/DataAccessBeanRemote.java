/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.ebj;

import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author student
 */
@Remote
public interface DataAccessBeanRemote {

    String getOstatnieDane();

    void setOstatnieDane(String dane, Date data);
    
}
