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
public class NhanVien extends Q1_canbo{
    public  String congviec;

    public NhanVien() {
    }

    public NhanVien(String congviec, String name, int age, String address) {
        super(name, age, address);
        this.congviec = congviec;
    }
    
    
}
