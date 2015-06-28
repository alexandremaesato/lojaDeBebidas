/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote;

import java.sql.Timestamp;

/**
 *
 * @author Ina
 */
public class Datalog {
    private Timestamp datalogin;
    private Timestamp datalogout;

    public Timestamp getDatalogin() {
        return datalogin;
    }

    public void setDatalogin(Timestamp datalogin) {
        this.datalogin = datalogin;
    }

    public Timestamp getDatalogout() {
        return datalogout;
    }

    public void setDatalogout(Timestamp datalogout) {
        this.datalogout = datalogout;
    }
    
    
}
