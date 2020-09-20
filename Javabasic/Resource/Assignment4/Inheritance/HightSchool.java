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
public class HightSchool extends Student{
    public  String clazz;
    public  String desiredUniversity;
    public HightSchool(int id, String name) {
        super(id, name);
    }

    public HightSchool(String desiredUniversity,String clazz, int id, String name) {
        super(id, name);
        this.id =1;
        this.name = "Nam";
        this.clazz = "Chuyên Văn";
        this.desiredUniversity = "Đại học công nghệ";
    }
   
}
