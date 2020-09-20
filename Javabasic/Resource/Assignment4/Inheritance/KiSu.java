/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assignment5.Inheritance;

/**
 *
 * @author admin
 */
public class KiSu extends Q1_canbo{
    public String Nganh;

    public KiSu(String Nganh, String name, int age, String address) {
        super(name, age, address);
        this.Nganh = Nganh;
    }

    public KiSu() {
    }
    
}
