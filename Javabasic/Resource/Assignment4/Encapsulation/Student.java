/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assignment5.Encapsulation;

/**
 *
 * @author admin
 */
public class Student {
    private int id;
    private String name;
    private String hometown;
    private float diem;

    public Student(String name, String hometown, float diem) {
        this.name = name;
        this.hometown = hometown;
        this.diem = 0;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }
    public float congdiem(float m) {
        return diem+m;
    }
    public void in(){
        System.out.println("Name: "+this.name);
        if(diem <4.0){
            System.out.println("Yeu");
        }else if(diem>4.0 && diem<6.0){
            System.out.println("Kem");
        }else if(diem>6.0 && diem<8.0){
            System.out.println("Kha");
        }else if(diem>8.0 ){
            System.out.println("Gioi");
        }
    }
    
}
