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
public class CongNhan extends Q1_canbo{
    public int[] lever = {1,2,3,4,5,6,7,8,9,10};

    public CongNhan(int[] bac, String name, int age, String address) {
        super(name, age, address);
        this.lever = bac;
    }

    public CongNhan() {
    }

    
    
}
